package com.triton.myvacala.activities.payment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.payu.base.models.ErrorResponse;
import com.payu.base.models.PayUPaymentParams;
import com.payu.checkoutpro.PayUCheckoutPro;
import com.payu.ui.model.listeners.PayUCheckoutProListener;
import com.payu.ui.model.listeners.PayUHashGenerationListener;
import com.triton.myvacala.R;
import com.triton.myvacala.activities.parking.DashboardParkingActivity;
import com.triton.myvacala.activities.parking.ParkingConfirmActivity;
import com.triton.myvacala.activities.parking.Parking_Options_Activity;
import com.triton.myvacala.api.APIClient;
import com.triton.myvacala.api.RestApiInterface;
import com.triton.myvacala.requestpojo.CheckTimesRequest;
import com.triton.myvacala.requestpojo.ParkingBookingCreateRequest;
import com.triton.myvacala.responsepojo.CheckTimesResponse;
import com.triton.myvacala.responsepojo.ParkingBookingCreateResponse;
import com.triton.myvacala.sessionmanager.SessionManager;
import com.triton.myvacala.utils.ConnectionDetector;
import com.triton.myvacala.utils.RestUtils;
import com.wang.avi.AVLoadingIndicatorView;

import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentMethodActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "PaymentMethodActivity";

    @BindView(R.id.avi_indicator)
    AVLoadingIndicatorView avi_indicator;

    @BindView(R.id.bottom_navigation_parking)
    BottomNavigationView bottom_navigation_parking;

    @BindView(R.id.toolbar_title)
    TextView toolbar_title;

    @BindView(R.id.imgBack)
    ImageView imgBack;

    @BindView(R.id.llpayu)
    LinearLayout llpayu;

    @BindView(R.id.llrazorpay)
    LinearLayout llrazorpay;

    @BindView(R.id.llpaytm)
    LinearLayout llpaytm;

    @BindView(R.id.txt_totalamout)
    TextView txt_totalamout;

    private String customerid;
    String customername,customeremail,customerphone ;

    private String parkingid,vehicletypeid,vehicleid,resstartdate,resenddate,resstarttime,resendtime,totalhrs;
    private int totalamount;

    private String reachtime, parkingdistance;
    private String strdays;
    String slotDetails;
    private String couponcode = "",couponcodeamount = "",originalamount = "";
    private int days,hours,min;
    private String Transaction_id;
    private String saltkey,merchantkey;
    private boolean isproduction;
    String pricing_type;
    int hrscount;
    int dayscount;
    int monthcount;
    int  Booking_Hours_cost,Parking_Hours_count,Booking_Days,Parking_Day_Cost,Booking_Months,Parking_Monthly_Price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);
        ButterKnife.bind(this);
        avi_indicator.setVisibility(View.GONE);

        toolbar_title.setText(getResources().getString(R.string.paymentmethod));
        imgBack.setOnClickListener(this);

        llpayu.setOnClickListener(this);
        llrazorpay.setOnClickListener(this);
        llpaytm.setOnClickListener(this);

        SessionManager session = new SessionManager(this);
        HashMap<String, String> user = session.getUserDetails();
        customerid =  user.get(SessionManager.KEY_ID);
        customername =  user.get(SessionManager.KEY_NAME);
        customerphone =  user.get(SessionManager.KEY_MOBILE);
        customeremail =  user.get(SessionManager.KEY_EMAIL_ID);


        HashMap<String, String> userParking = session.getParkingSlotDetails();
        String area = userParking.get(SessionManager.KEY_PARKING_AREA);
        String floor = userParking.get(SessionManager.KEY_PARKING_FLOOR);
        String slot = userParking.get(SessionManager.KEY_PARKING_SLOT);
         slotDetails = floor+"/"+area+"/"+slot;

        SessionManager sessionPayu = new SessionManager(this);
        HashMap<String, String> payu = sessionPayu.getPayuDetails();
//        saltkey =  payu.get(SessionManager.KEY_PAYU_SALTKEY);
//        merchantkey =  payu.get(SessionManager.KEY_PAYU_MERCHANT_KEY);
//        String production =  payu.get(SessionManager.KEY_PAYU_PRODUCTION);
//        if(production != null){
//            if(production.equalsIgnoreCase("true")){
//                isproduction = true;
//            }else{
//                isproduction = false;
//            }
//        }

        saltkey = "eCwWELxi" ;// Test key

        merchantkey = "gtKFFx";  // Test Key

        isproduction = false;


        getData();

       /* isproduction = true;
        saltkey = "g0nGFe03";
        merchantkey = "3TnMpV";
        totalamount = 1;*/

        bottom_navigation_parking.setSelectedItemId(R.id.home);
        bottom_navigation_parking.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.home:
                    String active_tag = "1";
                    callDirections(active_tag);
                    break;


                case R.id.bookinghistory:
                    active_tag = "2";
                    callDirections(active_tag);
                    break;


                case R.id.myvehicle:
                    active_tag = "3";
                    callDirections(active_tag);
                    break;

                case R.id.account:
                    active_tag = "4";
                    callDirections(active_tag);
                    break;

            }
            return true;
        }


    };
    public void callDirections(String tag){
        Intent intent = new Intent(PaymentMethodActivity.this, DashboardParkingActivity.class);
        intent.putExtra("tag",tag);
        startActivity(intent);
        finish();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgBack:
                onBackPressed();
                break;

                case R.id.llpayu:
                    if (new ConnectionDetector(PaymentMethodActivity.this).isNetworkAvailable(PaymentMethodActivity.this)) {
                        gotoPayUPayment();

                    }
                break;

                case R.id.llrazorpay:
                   /* if (new ConnectionDetector(PaymentMethodActivity.this).isNetworkAvailable(PaymentMethodActivity.this)) {
                        parkingBookingCreateResponseCall();
                    }*/
                break;

                case R.id.llpaytm:
                   /* if (new ConnectionDetector(PaymentMethodActivity.this).isNetworkAvailable(PaymentMethodActivity.this)) {
                        parkingBookingCreateResponseCall();
                    }*/
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @SuppressLint("SetTextI18n")
    private void getData() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {



            parkingid = extras.getString("parkingid");
            vehicletypeid = extras.getString("vehicletypeid");
            vehicleid = extras.getString("vehicleid");
            resstartdate = extras.getString("resstartdate");
            resenddate = extras.getString("resenddate");
            resstarttime = extras.getString("resstarttime");
            resendtime = extras.getString("resendtime");
            //Todo: Get Price from API End
            totalamount = extras.getInt("totalamount");
            //totalamount=1;
            totalhrs = extras.getString("totalhrs");
            reachtime = extras.getString("reachtime");
            parkingdistance = extras.getString("parkingdistance");
            strdays = extras.getString("strdays");

            txt_totalamout.setText("\u20A8"+"."+totalamount);

            couponcode = extras.getString("couponcode");
            couponcodeamount = extras.getString("couponcodeamount");
            originalamount = extras.getString("originalamount");


            Log.w(TAG,"totalhrs-->"+totalhrs+ "couponcodeamount : "+couponcodeamount);

            days = extras.getInt("days");
            hours = extras.getInt("hours");
            min = extras.getInt("min");

            pricing_type = extras.getString("pricing_type");
            hrscount = extras.getInt("hours_count");
            dayscount = extras.getInt("days_count");
            monthcount = extras.getInt("month_count");

            Booking_Hours_cost= extras.getInt("Booking_Hours_cost");
            Parking_Hours_count=extras.getInt("Parking_Hours_count");
            Booking_Days=extras.getInt("Booking_Days");
            Parking_Day_Cost=extras.getInt("Parking_Day_Cost");
            Booking_Months= extras.getInt("Booking_Months");
            Parking_Monthly_Price=extras.getInt("Parking_Monthly_Price");

            Log.w(TAG,"getData--->"+"resstartdate : "+resstartdate+" resstarttime : "+resstarttime+" resenddate : "+resenddate+" resendtime : "+resendtime+" totalhrs : "+totalhrs);


            Log.w(TAG,"days-->"+days+" hours "+hours+"min : "+min);

           // checkTimesResponseCall(resstarttime,resendtime,resstartdate,resenddate);






        }

    }

    private void checkTimesResponseCall(String  checkinhours, String checkouthours, String requestCheckinDate, String requestCheckoutDate) {

        avi_indicator.setVisibility(View.VISIBLE);
        avi_indicator.smoothToShow();
        //Creating an object of our api interface
        RestApiInterface apiInterface = APIClient.getClient().create(RestApiInterface.class);
        Call<CheckTimesResponse> call = apiInterface.checkTimesResponseCall(RestUtils.getContentType(), checkTimesRequest(checkinhours,checkouthours,requestCheckinDate,requestCheckoutDate));
        Log.w(TAG, "url  :%s" + " " + call.request().url().toString());

        call.enqueue(new Callback<CheckTimesResponse>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(@NotNull Call<CheckTimesResponse> call, @NotNull Response<CheckTimesResponse> response) {
                avi_indicator.smoothToHide();
                Log.w(TAG, "CheckTimesResponse" + new Gson().toJson(response.body()));

                if (response.body() != null) {


                    if (200 == response.body().getCode()) {
                        if(response.body().getData() != null){
                            days = response.body().getData().getDays();
                            strdays = String.valueOf(days);
                            hours = response.body().getData().getHours();
                            min = response.body().getData().getMin();
                            totalhrs = response.body().getData().getTotal_hrs();


                        }





                    }



                }
            }

            @Override
            public void onFailure(@NotNull Call<CheckTimesResponse> call, @NotNull Throwable t) {
                avi_indicator.smoothToHide();
                Log.w(TAG, "CheckTimesResponse flr" + t.getMessage());
            }
        });

    }
    @SuppressLint("LongLogTag")
    private CheckTimesRequest checkTimesRequest(String checkin_time, String checkout_time, String requestCheckinDate, String requestCheckoutDate) {
        CheckTimesRequest checkTimesRequest = new CheckTimesRequest();
        checkTimesRequest.setCheckin_date(requestCheckinDate);
        checkTimesRequest.setCheckout_date(requestCheckoutDate);
        checkTimesRequest.setCheckin_time(checkin_time);
        checkTimesRequest.setCheckout_time(checkout_time);
        Log.w(TAG, "checkTimesRequest" + new Gson().toJson(checkTimesRequest));
        return checkTimesRequest;
    }



    public void parkingBookingCreateResponseCall(){
        avi_indicator.setVisibility(View.VISIBLE);
        avi_indicator.smoothToShow();
        //Creating an object of our api interface
        RestApiInterface apiInterface = APIClient.getParkingClient().create(RestApiInterface.class);
        Call<ParkingBookingCreateResponse> call = apiInterface.parkingBookingCreateResponseCall(RestUtils.getContentType(),parkingBookingCreateRequest());
        Log.w(TAG,"url  :%s"+" "+ call.request().url().toString());

        call.enqueue(new Callback<ParkingBookingCreateResponse>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(@NotNull Call<ParkingBookingCreateResponse> call, @NotNull Response<ParkingBookingCreateResponse> response) {
                avi_indicator.smoothToHide();
                Log.w(TAG, "ParkingBookingCreateResponse" + new Gson().toJson(response.body()));
                assert response.body() != null;

                if (response.body().getData() != null) {
                    if (200 == response.body().getCode()) {
                        Toasty.success(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT, true).show();
                        Intent intent = new Intent(PaymentMethodActivity.this, ParkingConfirmActivity.class);
                        intent.putExtra("buildingname",response.body().getData().getParking_shop_name());
                        intent.putExtra("address",response.body().getData().getParking_shop_address());
                        intent.putExtra("sharelink",response.body().getData().getParking_shop_address_link());
                        intent.putExtra("amount",response.body().getData().getTotal_Amount());
                        intent.putExtra("bookingid",response.body().getData().getBooking_Id());
                        intent.putExtra("slotdetails",response.body().getData().getSlot_Details());
                        intent.putExtra("startdate",response.body().getData().getBooking_Start_Date());
                        intent.putExtra("starttime",response.body().getData().getBooking_Start_Time());
                        intent.putExtra("enddate",response.body().getData().getBooking_End_Date());
                        intent.putExtra("endtime",response.body().getData().getBooking_End_Time());
                        intent.putExtra("totalhours",response.body().getData().getHourly_Count());
                        intent.putExtra("totaldays",response.body().getData().getDays_Count());
                        intent.putExtra("totalmonths",response.body().getData().getMonth_Count());
                        intent.putExtra("pricing_type",response.body().getData().getPricing_Type());
                        intent.putExtra("vehicleDetailsBeanArrayList",response.body().getData().getVehicle_details());
                        intent.putExtra("reachtime",response.body().getData().getDistance());
                        intent.putExtra("distance",response.body().getData().getKms());
                        intent.putExtra("parkingdetailsid",parkingid);
                        intent.putExtra("id",response.body().getData().get_id());
                        intent.putExtra("couponcodeamount",response.body().getData().getCouponcode_amount());
                        intent.putExtra("fromactivity",TAG);
                        intent.putExtra("visibilty_mode","false");
                        startActivity(intent);
                        Log.w(TAG,"parkingdetailsid--->"+parkingid+"totalhours : "+response.body().getData().getHourly_Count()+" reachtime :"+response.body().getData().getDistance()+" distance :"+response.body().getData().getKms());




                    }else{
                        Toasty.error(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT, true).show();

                    }


                }
            }

            @Override
            public void onFailure(@NotNull Call<ParkingBookingCreateResponse> call, @NotNull Throwable t) {
                avi_indicator.smoothToHide();
                Log.w(TAG,"CouponsCodeValidationResponseflr"+t.getMessage());
            }
        });

    }
    private ParkingBookingCreateRequest parkingBookingCreateRequest() {
        /**
         * slot_details :
         * parkingdetails_id : 5f4798fc99c5a35d06ad04f2
         * Vehicle_type_id : 5f0c0d092f857d66950cf260
         * Vehicle_id : 5f1e70539f12a81b3dd708a1
         * booking_start_date : 2020-08-10
         * booking_end_date : 2020-08-10
         * booking_start_time : 12:00
         * booking_end_time : 13:00
         * total_amount : 100
         * total_hrs : 1
         * Booked_Date_and_Time : 2020-08-10T01:20:09
         * Customer_id : 5f1fc277cfb5c741551e1793
         * distance
         * Kms
         * duration_date
         * couponcode
         * couponcode_amount
         * Original_amount
         */

        //String[] splited = totalhrs.split("\\s+");
        // String hours= splited[0];


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String currentDateandTime = sdf.format(new Date());



        @SuppressLint("SimpleDateFormat") DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        @SuppressLint("SimpleDateFormat") DateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        @SuppressLint("SimpleDateFormat") DateFormat outputFormatextension = new SimpleDateFormat("dd MMM");
        String inputDateStartDate = resstartdate;
        String inputDateEndDate = resenddate;
        Date startdate, enddate;
        Date enddate_ex;

        String outputDateStartDate, outputDateEndDate;

        String durationDates = null;
        String outputDateEndDateex;

        try {
            startdate = inputFormat.parse(inputDateStartDate);
            enddate = inputFormat.parse(inputDateEndDate);
            enddate_ex = inputFormat.parse(inputDateEndDate);

            String startDateformat = "",endDateformat = "";

            if (startdate != null) {
                outputDateStartDate = outputFormat.format(startdate);
                startDateformat = outputFormatextension.format(startdate);

            }
            if (enddate != null) {
                outputDateEndDate = outputFormat.format(enddate);
                endDateformat = outputFormatextension.format(enddate);
            }

            if (enddate_ex != null) {
                outputDateEndDateex = outputFormatextension.format(enddate_ex);
                Log.w(TAG, "outputDateEndDateex-->" + outputDateEndDateex);
            }
            Log.w(TAG, "totalhours :" + hours);


            Log.w(TAG,"Endtime-->"+resendtime);

            int count;

            String msg;

            if(pricing_type.equals("Hourly")){

                count = hrscount;


                if(count >1){

                    msg = "Hours";
                }

                else {

                    msg = "Hour";

                }

            }

            else if(pricing_type.equals("Daily")){

                count=dayscount;

                if(count >1){

                    msg = "Days";
                }

                else {

                    msg = "Day";

                }

            }

            else {

                count= monthcount;

                if(count >1){

                    msg = "Months";
                }

                else {

                    msg = "Month";

                }


            }
            durationDates = startDateformat+", "+resstarttime+" to "+endDateformat+", "+resendtime+"("+count+" "+ msg+")";
            // txt_bookingslotwindow.setText(outputDateStartDate + " at " + starttime + " to " + outputDateEndDate + " at " + endtime + "(" + totalhours+" Hours" + ")");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ParkingBookingCreateRequest parkingBookingCreateRequest = new ParkingBookingCreateRequest();
        parkingBookingCreateRequest.setSlot_details("flot / . 1/ 23023");
        parkingBookingCreateRequest.setSlot_Details("flot / . 1/ 23023");
        parkingBookingCreateRequest.setParking_VendorDetails_Id(parkingid);
        parkingBookingCreateRequest.setVehicle_Type_Id(vehicletypeid);
        parkingBookingCreateRequest.setVehicle_Id(vehicleid);
        parkingBookingCreateRequest.setBooking_Start_Date(resstartdate);
        //parkingBookingCreateRequest.setBooking_end_date(resenddate);
        parkingBookingCreateRequest.setBooking_Start_Time(resstarttime);
        //parkingBookingCreateRequest.setBooking_end_time(resendtime);
        parkingBookingCreateRequest.setTotal_Amount(String.valueOf(totalamount));
        //parkingBookingCreateRequest.setTotal_hrs(totalhrs);
       // parkingBookingCreateRequest.setBooked_Date_and_Time(currentDateandTime);
        parkingBookingCreateRequest.setCustomer_Id(customerid);
        parkingBookingCreateRequest.setDistance(String.valueOf(reachtime));
        parkingBookingCreateRequest.setKms(String.valueOf(parkingdistance));
        parkingBookingCreateRequest.setDuration_date(durationDates);
        parkingBookingCreateRequest.setCouponcode(couponcode);
        parkingBookingCreateRequest.setCouponcode_amount(couponcodeamount);
        parkingBookingCreateRequest.setPricing_Type(pricing_type);
        parkingBookingCreateRequest.setHourly_Count(hrscount);
        parkingBookingCreateRequest.setDay_Count(dayscount);
        parkingBookingCreateRequest.setMonth_Count(monthcount);

        parkingBookingCreateRequest.setBooking_Hours_cost(Booking_Hours_cost);
        parkingBookingCreateRequest.setParking_Hours_count(Parking_Hours_count);
        parkingBookingCreateRequest.setBooking_Days(Booking_Days);
        parkingBookingCreateRequest.setParking_Day_Cost(Parking_Day_Cost);
        parkingBookingCreateRequest.setBooking_Months(Booking_Months);
        parkingBookingCreateRequest.setParking_Monthly_Price(Parking_Monthly_Price);

        //parkingBookingCreateRequest.setOriginal_amount(originalamount);
        Log.w(TAG,"ParkingBookingCreateRequest"+ new Gson().toJson(parkingBookingCreateRequest));
        return parkingBookingCreateRequest;
    }




    @SuppressLint("LongLogTag")
    private void gotoPayUPayment() {
        Log.w(TAG,"gotoPayUPayment");
        PayUPaymentParams.Builder builder = new PayUPaymentParams.Builder();
        Transaction_id = customerid+System.currentTimeMillis();
        builder.setAmount(String.valueOf(totalamount))
                .setIsProduction(isproduction)
                .setProductInfo("Book Parking")
                .setKey(merchantkey)
                .setPhone(customerphone)
                .setTransactionId(Transaction_id)
                .setFirstName(customername)
                .setEmail(customeremail)
                .setSurl("https://payuresponse.firebaseapp.com/success")
                .setFurl("https://payuresponse.firebaseapp.com/failure")
                .setUserCredential(merchantkey+":"+customeremail);
        PayUPaymentParams payUPaymentParams = builder.build();
        Log.w(TAG,"payUPaymentParams : "+new Gson().toJson(payUPaymentParams));




        PayUCheckoutPro.open(this, payUPaymentParams, new PayUCheckoutProListener() {
            @Override
            public void onPaymentSuccess(@NotNull Object response) {
                Log.w(TAG,"onPaymentSuccess : "+new Gson().toJson(response));

                if (new ConnectionDetector(PaymentMethodActivity.this).isNetworkAvailable(PaymentMethodActivity.this)) {
                    parkingBookingCreateResponseCall();
                }
                //Cast response object to HashMap
                // HashMap<String,Object> result = (HashMap<String, Object>) response
                // String payuResponse = result.get(PayUCheckoutProConstants.CP_PAYU_RESPONSE);
                //String merchantResponse = result.get(PayUCheckoutProConstants.CP_MERCHANT_RESPONSE));
            }

            @Override
            public void onPaymentFailure(@NotNull Object response) {
                Log.w(TAG,"onPaymentFailure : "+new Gson().toJson(response));
                //Cast response object to HashMap
                       /* HashMap<String,Object> result = (HashMap<String, Object>) response
                        String payuResponse = result.get(PayUCheckoutProConstants.CP_PAYU_RESPONSE);
                        String merchantResponse = result.get(PayUCheckoutProConstants.CP_MERCHANT_RESPONSE));*/
            }

            @Override
            public void onPaymentCancel(boolean isTxnInitiated) {
            }

            @Override
            public void onError(@NotNull ErrorResponse errorResponse) {

                String errorMessage = errorResponse.getErrorMessage();
                Log.w(TAG,"ErrorResponse  : "+errorMessage);

            }

            @Override
            public void generateHash(@NotNull HashMap<String, String> valueMap, @NotNull PayUHashGenerationListener hashGenerationListener) {
                String hashName = valueMap.get("hashName");
                //strHashName = hashName;
                String hashData = valueMap.get("hashString");

                Log.w(TAG," hashName : "+hashName+" hashData : "+hashData);


                if (!TextUtils.isEmpty(hashName) && !TextUtils.isEmpty(hashData)) {
                    String generatedSHA512 = null;
                    String toReturn = null;
                    try {
                        toReturn = hashData+saltkey;
                        MessageDigest digest = MessageDigest.getInstance("SHA-512");
                        digest.reset();
                        digest.update(toReturn.getBytes("utf8"));
                        generatedSHA512 = String.format("%0128x", new BigInteger(1, digest.digest()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    //Generate Hash from your backend here
                    // String hash = HashGenerationUtils.INSTANCE.generateHashFromSDK(hashData, testSalt);
                    Log.w(TAG,"  hashName : "+hashName+" generatedSHA512 : "+generatedSHA512);

                    HashMap<String, String> dataMap = new HashMap<>();
                    dataMap.put(hashName, generatedSHA512);
                    Log.w(TAG,"datamap  "+dataMap);
                    hashGenerationListener.onHashGenerated(dataMap);
                }



            }
        });













    }
}