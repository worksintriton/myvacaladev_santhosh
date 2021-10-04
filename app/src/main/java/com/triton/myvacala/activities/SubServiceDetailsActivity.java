package com.triton.myvacala.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.triton.myvacala.R;
import com.triton.myvacala.adapter.SubServiceDetailsAdapter;
import com.triton.myvacala.adapter.SubServiceOptionAdapter;
import com.triton.myvacala.adapter.SubServicesPageAdapter;
import com.triton.myvacala.adapter.ViewPagerSubServiceAdapter;
import com.triton.myvacala.api.APIClient;
import com.triton.myvacala.api.RestApiInterface;
import com.triton.myvacala.appUtils.Constants;
import com.triton.myvacala.requestpojo.AddingCartRequest;
import com.triton.myvacala.requestpojo.RemovingCartRequest;
import com.triton.myvacala.responsepojo.AddingCartResponse;
import com.triton.myvacala.responsepojo.MainServiceGetListResponse;
import com.triton.myvacala.responsepojo.MasterServiceGetlistResponse;
import com.triton.myvacala.responsepojo.RemovingCartResponse;
import com.triton.myvacala.responsepojo.SubServiceListResponse;
import com.triton.myvacala.sessionmanager.SessionManager;
import com.triton.myvacala.utils.ConnectionDetector;
import com.triton.myvacala.utils.RestUtils;
import com.wang.avi.AVLoadingIndicatorView;


import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;
import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubServiceDetailsActivity extends AppCompatActivity implements Serializable {

    @BindView(R.id.cv_vehicleimage)
    ImageView cv_vehicleimage;

    @BindView(R.id.txt_vehiclename)
    TextView txt_vehiclename;

    @BindView(R.id.btn_vehiclefueltype)
    Button btn_vehiclefueltype;

    @BindView(R.id.txt_location)
    TextView txt_location;

    @BindView(R.id.txt_address)
    TextView txt_address;

    @BindView(R.id.btn_addtocart)
    Button btn_addtocart;

    @BindView(R.id.toolbar_title)
    TextView toolbar_title;

    @BindView(R.id.imgBack)
    ImageView imgBack;

    @BindView(R.id.rv_subserdetails_itmems)
    RecyclerView rv_subserdetails_itmems;

    @BindView(R.id.tv_norecords)
    TextView tv_norecords;

    @BindView(R.id.rv_subsersev_option)
    RecyclerView rv_subsersev_option;

    @BindView(R.id.tv_nosubservopt)
    TextView tv_nosubservopt;

    @BindView(R.id.txt_subservices_originalamount)
    TextView txt_subservices_originalamount;

    @BindView(R.id.txt_subservices_discountamount)
    TextView txt_subservices_discountamount;

    String TAG = "SubServiceDetailsActivity";

    String subservicetitle,subserviceimage,subserdisplayimg,discountprice;

    @BindView(R.id.bottom_navigation_view)
    BottomNavigationView bottom_navigation_view;
    String active_tag = "1";


    @BindView(R.id.avi_indicator)
    ImageView avi_indicator;


//    @BindView(R.id.txt_subservicestitle)
//    TextView txt_subservicestitle;


//    @BindView(R.id.iv_subserviceimage)
//    ImageView iv_subserviceimage;

    @BindView(R.id.iv_subservicedisplayimage)
    ImageView iv_subservicedisplayimage;

   @BindView(R.id.btn_discountprice)
   Button btn_discountprice;

   @BindView(R.id.ll_multipleadd)
   LinearLayout ll_multipleadd;

    @BindView(R.id.ll_price)
    LinearLayout ll_price;


   @BindView(R.id.txt_decrease)
   TextView txt_decrease;

    @BindView(R.id.txt_increase)
    TextView txt_increase;

    @BindView(R.id.txt_count_number)
    TextView txt_count_number;

    Button btn_closes;


    @BindView(R.id.pager)
    ViewPager viewPager;

    @BindView(R.id.tabDots)
    TabLayout tabLayout;

    ViewPagerSubServiceAdapter viewPagerSubServiceAdapter;

    String city = "",street = "";
    String vehicleImage,vehicleName, vehicleModelName,fuelType;

    private ArrayList<SubServiceListResponse.DataBean.ItemListBean> itemListBeanList = new ArrayList<>();


    boolean cartstatus,counttype;
    int cartcount;

    SessionManager session;
    String customerid ="", subservicepagedetid ="";

    private ArrayList<SubServiceListResponse.CustomerVehicleDataBean> customerVehicleDataBeanList = null;


    String twowheelervehicleid = null,fourwheelervehicleid = null,masterserviceid = null;
    String vehicletypeid,serviceid,servicename,masterservicename,vehicletypename ;


    private Context mContext;
    private SharedPreferences preferences;

    ArrayList<String> subservicedisplayimageList;

    String selectedVehicleType, selectedVehicleId;

    private String _id;
    private String Customer_id;
    private String Vehicle_Image;
    private String Vehicletype_id;
    private String Vehicletype_Name;
    private String Vehicle_Brand_id;
    private String Vehicle_Brand_Name;
    private String Vehicle_Name_id;
    private String Vehicle_Name;
    private String Year_of_Manufacture;
    private String Vehicle_No;
    private String Fuel_Type_id;
    private String Fuel_Type_Name;
    private String Fuel_Type_Background_Color;
    private String Vehicle_Model_id;
    private String Vehicle_Model_Name;
    private String Status;
    private String updatedAt;
    private String createdAt;
    private int __v;

    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000;

    String headerVehicleimg,headerVehicleName,headerVehicleBrandName,headerVehicleFuelTypeName,headerVehicleFuelTypeBackgroundcolor,discount_price,original_price;
    ArrayList<String> subservicespecList;

    private static final StrikethroughSpan STRIKE_THROUGH_SPAN = new StrikethroughSpan();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_service_details);

        ButterKnife.bind(this);
        Log.w(TAG,"onCreate-->");

        mContext = SubServiceDetailsActivity.this;
        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        avi_indicator.setVisibility(View.GONE);


        session = new SessionManager(getApplicationContext());
        session.checkLogin();

        HashMap<String, String> user = session.getUserDetails();
        customerid = user.get(SessionManager.KEY_ID);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            city = extras.getString("city");
            street = extras.getString("street");
            vehicleImage = extras.getString("vehicleImage");
            vehicleName = extras.getString("vehicleName");
            vehicleModelName = extras.getString("vehicleModelName");
            fuelType = extras.getString("fuelType");
            Log.w(TAG,"vehicleImage : "+vehicleImage+" "+"vehicleName : "+vehicleName+" "+"vehicleModelName : "+vehicleModelName+" "+"fuelType : "+fuelType);

            setHeaderData();

            subservicetitle = extras.getString("subservicetitle");
            subserviceimage = extras.getString("subserviceimage");
            discountprice = extras.getString("discountprice");
            cartstatus = extras.getBoolean("cartstatus");
            counttype = extras.getBoolean("counttype");
            cartcount = extras.getInt("cartcount");
            subservicepagedetid = extras.getString("subservicepagedetid");

            original_price = extras.getString("originalprice");

            Log.w(TAG,"originalprice---->"+original_price);

            discount_price = extras.getString("discountprice");

            toolbar_title.setText(subservicetitle);

            itemListBeanList = (ArrayList<SubServiceListResponse.DataBean.ItemListBean>) getIntent().getSerializableExtra("itemlist");

            //Log.w(TAG,"itemlist Size---->"+itemListBeanList.size());
            subservicedisplayimageList = (ArrayList<String>) getIntent().getSerializableExtra("subservicedisplayimage");

            subservicespecList = (ArrayList<String>) getIntent().getSerializableExtra("subservicespecList");

           // Log.w(TAG,"subservicetitle : "+subservicetitle+" "+"subserviceimage : "+subserviceimage+" itemListBeanList :"+itemListBeanList+" "+"subservicedisplayimageList : "+subservicedisplayimageList);

            if(subservicedisplayimageList != null) {
                for (int i = 0; i < subservicedisplayimageList.size(); i++) {
                    subserdisplayimg = subservicedisplayimageList.get(i);
                }
                Log.w(TAG,"subserdisplayimg-->"+subserdisplayimg);
            }

            setData();

            viewpageData(subservicedisplayimageList);

            vehicletypeid = extras.getString("vehicletypeid");
            serviceid = extras.getString("serviceid");
            servicename = extras.getString("servicename");
            masterservicename = extras.getString("masterservicename");

            vehicletypename = extras.getString("vehicletypename");
            customerVehicleDataBeanList = (ArrayList<SubServiceListResponse.CustomerVehicleDataBean>) getIntent().getSerializableExtra("customervehicledatabeanlist");

            twowheelervehicleid = extras.getString("twowheelervehicleid");
            fourwheelervehicleid = extras.getString("fourwheelervehicleid");
            masterserviceid = extras.getString("masterserviceid");


            selectedVehicleType = extras.getString("selectedVehicleType");
            selectedVehicleId = extras.getString("selectedVehicleId");
            if(selectedVehicleId != null){
                getVehicleData(selectedVehicleId);
            }

            Log.w(TAG,"selectedVehicleId--->"+selectedVehicleId);
            if(customerVehicleDataBeanList != null){
                for(int i=0;i<customerVehicleDataBeanList.size();i++){
                    if(selectedVehicleId.equalsIgnoreCase(customerVehicleDataBeanList.get(i).getVehicletype_id())){
                        _id = customerVehicleDataBeanList.get(i).get_id();
                        Customer_id = customerVehicleDataBeanList.get(i).getCustomer_id();
                        Vehicle_Image = customerVehicleDataBeanList.get(i).getVehicle_Image();
                        Vehicletype_id = customerVehicleDataBeanList.get(i).getVehicletype_id();
                        Vehicletype_Name = customerVehicleDataBeanList.get(i).getVehicletype_Name();
                        Vehicle_Brand_id = customerVehicleDataBeanList.get(i).getVehicle_Brand_id();
                        Vehicle_Brand_Name = customerVehicleDataBeanList.get(i).getVehicle_Brand_Name();
                        Vehicle_Name_id = customerVehicleDataBeanList.get(i).getVehicle_Name_id();
                        Vehicle_Name = customerVehicleDataBeanList.get(i).getVehicle_Name();
                        Year_of_Manufacture = customerVehicleDataBeanList.get(i).getYear_of_Manufacture();
                        Vehicle_No = customerVehicleDataBeanList.get(i).getVehicle_No();
                        Fuel_Type_id = customerVehicleDataBeanList.get(i).getFuel_Type_id();
                        Fuel_Type_Name = customerVehicleDataBeanList.get(i).getFuel_Type_Name();
                        Fuel_Type_Background_Color = customerVehicleDataBeanList.get(i).getFuel_Type_Background_Color();
                        Vehicle_Model_id = customerVehicleDataBeanList.get(i).getVehicle_Model_id();
                        Vehicle_Model_Name = customerVehicleDataBeanList.get(i).getVehicle_Model_Name();
                        Status = customerVehicleDataBeanList.get(i).getStatus();
                        updatedAt  = customerVehicleDataBeanList.get(i).getUpdatedAt();
                        createdAt  = customerVehicleDataBeanList.get(i).getCreatedAt();
                        __v  = customerVehicleDataBeanList.get(i).get__v();

                        Log.w(TAG,"Vehicletype_Name----->"+Vehicletype_Name+"Vehicletype_id---->"+Vehicletype_id);

                    }
                }
            }

        }

        btn_addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String buttonstatus =  btn_addtocart.getText().toString();
              if(buttonstatus.equalsIgnoreCase(getResources().getString(R.string.addtocart))){
                  addingCartResponseCall(subservicepagedetid);
              }else{
                  removingCartResponseCall(subservicepagedetid);
              }
            }
        });

        txt_decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(cartcount==1){

                    showWarn(subservicepagedetid);

                }

                else if (cartcount > 0) {
                    if (new ConnectionDetector(getApplicationContext()).isNetworkAvailable(getApplicationContext()))
                        removingCartResponseCall(subservicepagedetid);

                }
            }
        });

        txt_increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(counttype){

                    Toasty.warning(SubServiceDetailsActivity.this,getApplicationContext().getResources().getString(R.string.single_service_warn), Toast.LENGTH_SHORT, true).show();

                }

                else {

                    if (new ConnectionDetector(getApplicationContext()).isNetworkAvailable(getApplicationContext()))
                        addingCartResponseCall(subservicepagedetid);

                }

            }
        });


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        bottom_navigation_view.setSelectedItemId(R.id.home);
        bottom_navigation_view.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    void showWarn(String id){

        new SweetAlertDialog(SubServiceDetailsActivity.this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Confirmation Required")
                .setContentText("Are you want to delete this product from cart")
                .setConfirmText("Ok")
                .setConfirmClickListener(sDialog -> {

                    sDialog.dismissWithAnimation();

                    if (new ConnectionDetector(SubServiceDetailsActivity.this).isNetworkAvailable(SubServiceDetailsActivity.this))
                        removingCartResponseCall(id);
                })
                .setCancelButton("Cancel", new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.dismissWithAnimation();

                    }
                })
                .show();

    }

   public void hidePrice(View view){

        //btn_closes = view.findViewById(R.id.btn_close);

        ll_price.setVisibility(View.GONE);
    }

    private void getVehicleData(String selectedVehicleId) {
        if(customerVehicleDataBeanList != null && customerVehicleDataBeanList.size()>0) {
            for (int i = 0; i < customerVehicleDataBeanList.size(); i++) {
                String vehicletype = customerVehicleDataBeanList.get(i).getVehicletype_Name();
                String id = customerVehicleDataBeanList.get(i).getVehicletype_id();
                Log.w(TAG, "vehicletype :" + vehicletype + " " + "id :" + id);
                if (selectedVehicleId.equalsIgnoreCase(id)) {
                    headerVehicleimg = customerVehicleDataBeanList.get(i).getVehicle_Image();
                    headerVehicleName = customerVehicleDataBeanList.get(i).getVehicle_Name();
                    headerVehicleBrandName = customerVehicleDataBeanList.get(i).getVehicle_Brand_Name();
                    headerVehicleFuelTypeName = customerVehicleDataBeanList.get(i).getFuel_Type_Name();
                    headerVehicleFuelTypeBackgroundcolor = customerVehicleDataBeanList.get(i).getFuel_Type_Background_Color();
                    Log.w(TAG, "headerVehicleimg :" + headerVehicleimg + " " + "headerVehicleName : " + headerVehicleName + " " + "headerVehicleFuelTypeName : " + headerVehicleFuelTypeName);
                }

            }
        }
        setHeaderVehicleData();
    }
    private void setHeaderVehicleData() {

        if (headerVehicleimg != null && !headerVehicleimg.isEmpty()) {

            Glide.with(SubServiceDetailsActivity.this)
                    .load(headerVehicleimg)
                    .into(cv_vehicleimage);

        }
        else{
            Glide.with(SubServiceDetailsActivity.this)
                    .load(R.drawable.logo)
                    .into(cv_vehicleimage);

        }
        if(headerVehicleName != null){
            txt_vehiclename.setText(headerVehicleName);
        }else{
            txt_vehiclename.setText("");
        }
        if(headerVehicleFuelTypeName != null){
            btn_vehiclefueltype.setText(headerVehicleFuelTypeName);
        }else{
            btn_vehiclefueltype.setText("");
        }

        if(headerVehicleFuelTypeBackgroundcolor != null){
            btn_vehiclefueltype.setBackgroundColor(Color.parseColor("#D3D3D3"));
            btn_vehiclefueltype.setBackgroundResource(R.drawable.tags_rounded_corners);
            GradientDrawable gd = (GradientDrawable) btn_vehiclefueltype.getBackground();
            gd.setColor(Color.parseColor("#D3D3D3"));
            gd.setCornerRadius(10);
            gd.setStroke(4, Color.WHITE);

        }

    }

    private void setHeaderData() {

        if(city != null){
            txt_location.setText(city);
        }else{
            txt_location.setText("");
        }
        if(street != null){
            txt_address.setText(street);
        }else{
            txt_address.setText("");
        }

        /*if (vehicleImage != null && !vehicleImage.isEmpty()) {

            Glide.with(SubServiceDetailsActivity.this)
                    .load(vehicleImage)
                    .into(cv_vehicleimage);

        }
        else{
            Glide.with(SubServiceDetailsActivity.this)
                    .load(R.drawable.logo)
                    .into(cv_vehicleimage);

        }
        if(vehicleName != null){
            txt_vehiclename.setText(vehicleName);
        }else{
            txt_vehiclename.setText("");
        }
        if(fuelType != null){
            btn_vehiclefueltype.setText(fuelType);
        }else{
            btn_vehiclefueltype.setText("");
        }*/

    }

    private void viewpageData(ArrayList<String> subservicedisplayimageList) {
        tabLayout.setupWithViewPager(viewPager, true);

        viewPagerSubServiceAdapter = new ViewPagerSubServiceAdapter(mContext, subservicedisplayimageList);
        viewPager.setAdapter(viewPagerSubServiceAdapter);
        /*After setting the adapter use the timer */
        final Handler handler = new Handler();
        final Runnable Update = () -> {
            if (currentPage == subservicedisplayimageList.size()) {
                currentPage = 0;
            }
            viewPager.setCurrentItem(currentPage++, false);
        };

        timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);

    }

    private void setData() {
//        if(subservicetitle != null){
//            txt_subservicestitle.setText(subservicetitle);
//        }
        if(discountprice != null){
          btn_discountprice.setText("\u20B9"+" "+discountprice);
          txt_subservices_discountamount.setText("\u20B9"+" "+discountprice);

        }

        if(original_price != null){
            txt_subservices_originalamount.setText("\u20B9"+" "+original_price,TextView.BufferType.SPANNABLE);
            Spannable spannable = (Spannable) txt_subservices_originalamount.getText();
            spannable.setSpan(STRIKE_THROUGH_SPAN, 0,original_price.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        }


//        if (subserviceimage != null && !subserviceimage.isEmpty()) {
//
//            Glide.with(SubServiceDetailsActivity.this)
//                    .load(subserviceimage)
//                    .into(iv_subserviceimage);
//
//        }
//        else{
//            Glide.with(SubServiceDetailsActivity.this)
//                    .load(R.drawable.myvacalalogo)
//                    .into(iv_subserviceimage);
//
//        }

//        if (subserdisplayimg != null && !subserdisplayimg.isEmpty()) {
//
//            Glide.with(SubServiceDetailsActivity.this)
//                    .load(subserdisplayimg)
//                    .into(iv_subservicedisplayimage);
//
//        }
//        else{
//            Glide.with(SubServiceDetailsActivity.this)
//                    .load(R.drawable.myvacalalogo)
//                    .into(iv_subservicedisplayimage);
//
//        }

        ll_multipleadd.setVisibility(View.GONE);
        btn_addtocart.setVisibility(View.GONE);

//        if(cartcount == 0)
//        {
//            btn_addtocart.setVisibility(View.VISIBLE);
//
//            ll_multipleadd.setVisibility(View.GONE);
//        }
//
//        else
//        {
//            btn_addtocart.setVisibility(View.GONE);
//
//            ll_multipleadd.setVisibility(View.VISIBLE);
//
//            txt_count_number.setText(String.valueOf(cartcount));
//
//        }

        if(counttype){
            btn_addtocart.setVisibility(View.VISIBLE);
            ll_multipleadd.setVisibility(View.GONE);
            if(cartcount>0){
                btn_addtocart.setText(getResources().getString(R.string.removefromcart));

            }else{
                btn_addtocart.setText(getResources().getString(R.string.addtocart));
            }
        }
        else{
            btn_addtocart.setVisibility(View.GONE);
            ll_multipleadd.setVisibility(View.VISIBLE);
            txt_count_number.setText(String.valueOf(cartcount));
            if(cartcount == 0){
                txt_decrease.setVisibility(View.INVISIBLE);
            }else {
                txt_decrease.setVisibility(View.VISIBLE);

            }
        }

        if(itemListBeanList != null && itemListBeanList.size()>0){

            setViewSubServiceDetails();

        }

        if(subservicespecList != null && subservicespecList.size()>0){

            setViewSubServiceSpec();

        }
    }

    private void setViewSubServiceSpec() {

        rv_subsersev_option.setLayoutManager(new LinearLayoutManager(this));
        rv_subsersev_option.setItemAnimator(new DefaultItemAnimator());

        SubServiceOptionAdapter subServiceOptionAdapter = new SubServiceOptionAdapter(mContext, subservicespecList, rv_subsersev_option);
        rv_subsersev_option.setAdapter(subServiceOptionAdapter);

        subServiceOptionAdapter.setOnLoadMoreListener(() -> {
            if (preferences.getInt(Constants.INBOX_TOTAL, 0) > itemListBeanList.size()) {
                Log.e("haint", "Load More");
            }


        });

    }


    private void setViewSubServiceDetails() {
        rv_subserdetails_itmems.setLayoutManager(new LinearLayoutManager(this));
        rv_subserdetails_itmems.setItemAnimator(new DefaultItemAnimator());

        SubServiceDetailsAdapter subServiceDetailsAdapter = new SubServiceDetailsAdapter(mContext, itemListBeanList, rv_subserdetails_itmems);
        rv_subserdetails_itmems.setAdapter(subServiceDetailsAdapter);

        subServiceDetailsAdapter.setOnLoadMoreListener(() -> {
            if (preferences.getInt(Constants.INBOX_TOTAL, 0) > itemListBeanList.size()) {
                Log.e("haint", "Load More");
            }


        });

    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = item -> {

        switch (item.getItemId()) {
            case R.id.home:
                //active = homeFragment;
                active_tag = "1";
                callDirections(active_tag);
                break;


            case R.id.search:
                //active = searchFragment;
                active_tag = "2";
                callDirections(active_tag);
                break;


            case R.id.myvehicle:
                //active = myVehicleFragment;
                active_tag = "3";
                callDirections(active_tag);
                break;
            case R.id.cart:
                //active = cartFragment;
                active_tag = "4";
                callDirections(active_tag);
                break;
            case R.id.account:
                //active = accountFragment;
                active_tag = "5";
                callDirections(active_tag);
                break;

        }




        return true;
    };
    public void callDirections(String tag){
        Intent intent = new Intent(SubServiceDetailsActivity.this,DashboardActivity.class);
        intent.putExtra("tag",tag);
        startActivity(intent);
        finish();

    }


    private void addingCartResponseCall(String subserviceid) {
        avi_indicator.setVisibility(View.VISIBLE);
        //avi_indicator.smoothToShow();
        RestApiInterface apiInterface = APIClient.getClient().create(RestApiInterface.class);
        Call<AddingCartResponse> call = apiInterface.addingCartResponseCall(RestUtils.getContentType(),addingCartRequest(subserviceid));

        Log.w(TAG,"url  :%s"+call.request().url().toString());

        call.enqueue(new Callback<AddingCartResponse>() {
            @Override
            public void onResponse(@NotNull Call<AddingCartResponse> call, @NotNull Response<AddingCartResponse> response) {
                Log.w(TAG,"AddingCartResponse"+ "--->" + new Gson().toJson(response.body()));
               // avi_indicator.smoothToHide();
                avi_indicator.setVisibility(View.GONE);
                if (response.body() != null) {
                    if(response.body().getCode() == 200){
                        Toasty.success(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT, true).show();
                        btn_addtocart.setText(getResources().getString(R.string.removefromcart));
                        cartcount++;
                        txt_count_number.setText(String.valueOf(cartcount));
                        if(cartcount == 0){
                            txt_decrease.setVisibility(View.INVISIBLE);
                        }else {
                            txt_decrease.setVisibility(View.VISIBLE);

                        }
                        if (new ConnectionDetector(SubServiceDetailsActivity.this).isNetworkAvailable(SubServiceDetailsActivity.this)) {
                            //subServiceListResponseCall();
                        }
                    }
                }



            }

            @Override
            public void onFailure(@NotNull Call<AddingCartResponse> call, @NotNull Throwable t) {
                //avi_indicator.smoothToHide();
                avi_indicator.setVisibility(View.GONE);
                Log.w(TAG,"AddingCartResponseflr"+"--->" + t.getMessage());
            }
        });

    }
    private AddingCartRequest addingCartRequest(String subserviceid) {

        AddingCartRequest addingCartRequest = new AddingCartRequest();
        addingCartRequest.setSub_service_id(subserviceid);
        addingCartRequest.setCustomer_id(customerid);
        addingCartRequest.setVehicletype_id(selectedVehicleId);
        List<AddingCartRequest.VehicleDetailsBean> Vehicle_details = new ArrayList<>();
        AddingCartRequest.VehicleDetailsBean vehicleDetailsBean = new AddingCartRequest.VehicleDetailsBean();
        vehicleDetailsBean.set_id(_id);
        vehicleDetailsBean.setCustomer_id(Customer_id);
        vehicleDetailsBean.setVehicle_Image(Vehicle_Image);
        vehicleDetailsBean.setVehicletype_id(Vehicletype_id);
        vehicleDetailsBean.setVehicletype_Name(Vehicletype_Name);
        vehicleDetailsBean.setVehicle_Brand_id(Vehicle_Brand_id);
        vehicleDetailsBean.setVehicle_Brand_Name(Vehicle_Brand_Name);
        vehicleDetailsBean.setVehicle_Name_id(Vehicle_Name_id);
        vehicleDetailsBean.setVehicle_Name(Vehicle_Name);
        vehicleDetailsBean.setYear_of_Manufacture(Year_of_Manufacture);
        vehicleDetailsBean.setVehicle_No(Vehicle_No);
        vehicleDetailsBean.setFuel_Type_id(Fuel_Type_id);
        vehicleDetailsBean.setFuel_Type_Name(Fuel_Type_Name);
        vehicleDetailsBean.setFuel_Type_Background_Color(Fuel_Type_Background_Color);
        vehicleDetailsBean.setFuel_Type_Background_Color(Fuel_Type_Background_Color);
        vehicleDetailsBean.setVehicle_Model_id(Vehicle_Model_id);
        vehicleDetailsBean.setVehicle_Model_Name(Vehicle_Model_Name);
        vehicleDetailsBean.setStatus(Status);
        vehicleDetailsBean.setUpdatedAt(updatedAt);
        vehicleDetailsBean.setCreatedAt(createdAt);
        vehicleDetailsBean.set__v(__v);
        Vehicle_details.add(vehicleDetailsBean);
        addingCartRequest.setVehicle_details(Vehicle_details);
        Log.w(TAG,"AddingCartRequest"+ "--->" + new Gson().toJson(addingCartRequest));
        return addingCartRequest;
    }



    private void removingCartResponseCall(String subserviceid) {
        avi_indicator.setVisibility(View.VISIBLE);
        //avi_indicator.smoothToShow();
        RestApiInterface apiInterface = APIClient.getClient().create(RestApiInterface.class);
        Call<RemovingCartResponse> call = apiInterface.removingCartResponseCall(RestUtils.getContentType(),removingCartRequest(subserviceid));

        Log.w(TAG,"url  :%s"+call.request().url().toString());

        call.enqueue(new Callback<RemovingCartResponse>() {
            @Override
            public void onResponse(@NotNull Call<RemovingCartResponse> call, @NotNull Response<RemovingCartResponse> response) {
                Log.w(TAG,"RemovingCartResponse"+ "--->" + new Gson().toJson(response.body()));
          //      avi_indicator.smoothToHide();
                avi_indicator.setVisibility(View.GONE);
                if (response.body() != null) {
                    if(response.body().getCode() == 200){
                        btn_addtocart.setText(getResources().getString(R.string.addtocart));
                        cartcount--;
                        txt_count_number.setText(String.valueOf(cartcount));
                        if(cartcount == 0){
                            txt_decrease.setVisibility(View.INVISIBLE);
                        }else {
                            txt_decrease.setVisibility(View.VISIBLE);

                        }
                        if (new ConnectionDetector(SubServiceDetailsActivity.this).isNetworkAvailable(SubServiceDetailsActivity.this)) {
                           // subServiceListResponseCall();
                        }

                    }
                }



            }

            @Override
            public void onFailure(@NotNull Call<RemovingCartResponse> call, @NotNull Throwable t) {
            //    avi_indicator.smoothToHide();
                avi_indicator.setVisibility(View.GONE);
                Log.w(TAG,"RemovingCartResponseflr"+"--->" + t.getMessage());
            }
        });

    }
    private RemovingCartRequest removingCartRequest(String subserviceid) {
        /*
         * Service_id : 5f1eaf8cab6576455baf5f72
         * Customer_id : 5f181fbc609f4e233fe26106
         */
        RemovingCartRequest removingCartRequest = new RemovingCartRequest();
        removingCartRequest.setService_id(subserviceid);
        removingCartRequest.setCustomer_id(customerid);
        Log.w(TAG,"RemovingCartRequest"+ "--->" + new Gson().toJson(removingCartRequest));
        return removingCartRequest;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(SubServiceDetailsActivity.this,SubServicesActivity.class);
        intent.putExtra("vehicletypeid",vehicletypeid);
        intent.putExtra("serviceid",serviceid);
        intent.putExtra("city",city);
        intent.putExtra("street",street);
        intent.putExtra("vehicleImage", vehicleImage);
        intent.putExtra("vehicleName", vehicleName);
        intent.putExtra("vehicleModelName", vehicleModelName);
        intent.putExtra("fuelType", fuelType);
        intent.putExtra("servicename", servicename);
        intent.putExtra("masterservicename", masterservicename);
        intent.putExtra("vehicletypename", vehicletypename);
        intent.putExtra("customervehicledatabeanlist", customerVehicleDataBeanList);
        intent.putExtra("twowheelervehicleid",twowheelervehicleid);
        intent.putExtra("fourwheelervehicleid",fourwheelervehicleid);
        intent.putExtra("masterserviceid",masterserviceid);
        intent.putExtra("selectedVehicleType",selectedVehicleType);
        intent.putExtra("selectedVehicleId",selectedVehicleId);
        startActivity(intent);
        finish();
    }
}