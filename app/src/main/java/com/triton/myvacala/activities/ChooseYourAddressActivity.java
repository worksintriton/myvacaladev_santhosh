package com.triton.myvacala.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.triton.myvacala.R;
import com.triton.myvacala.adapter.ChooseYourAddressListAdapter;
import com.triton.myvacala.adapter.ChooseYourAddressListBottomCartAdapter;
import com.triton.myvacala.adapter.LocationListAdapter;
import com.triton.myvacala.api.APIClient;
import com.triton.myvacala.api.RestApiInterface;
import com.triton.myvacala.appUtils.Constants;
import com.triton.myvacala.fragment.CartFragment;
import com.triton.myvacala.interfaces.LocationDeleteListener;
import com.triton.myvacala.interfaces.LocationIdListener;
import com.triton.myvacala.listeners.OnLoadMoreListener;
import com.triton.myvacala.requestpojo.LocationDeleteRequest;
import com.triton.myvacala.requestpojo.LocationListRequest;
import com.triton.myvacala.responsepojo.GetCardDetailsResponse;
import com.triton.myvacala.responsepojo.LocationDeleteResponse;
import com.triton.myvacala.responsepojo.LocationListResponse;
import com.triton.myvacala.responsepojo.SubServiceListResponse;
import com.triton.myvacala.sessionmanager.SessionManager;
import com.triton.myvacala.utils.ConnectionDetector;
import com.triton.myvacala.utils.RestUtils;
import com.wang.avi.AVLoadingIndicatorView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChooseYourAddressActivity extends AppCompatActivity implements LocationIdListener  {


    @BindView(R.id.avi_indicator)
    ImageView avi_indicator;

    @BindView(R.id.toolbar_title)
    TextView toolbar_title;

    @BindView(R.id.imgBack)
    ImageView imgBack;

    private String TAG = "ChooseYourAddressActivity";

    SessionManager session;
    String name = "", customerid ="";

    AlertDialog.Builder alertDialogBuilder;
    AlertDialog alertDialog;


    @BindView(R.id.rv_locationlist)
    RecyclerView rv_locationlist;

    @BindView(R.id.tv_norecords)
    TextView tv_norecords;

    @BindView(R.id.iv_addlocation)
    ImageView iv_addlocation;

    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout ;

    private List<LocationListResponse.DataBean> locationListResponseList = null;
    LocationListAdapter locationListAdapter;
    private SharedPreferences preferences;
    private String fromactivity;
    private Dialog dialog;
    ChooseYourAddressListBottomCartAdapter chooseYourAddressListAdapter;
    String city ,street;
    String BookingDate ="",BookingTime = "";
    private String bookingdateandtime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_your_address);

        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());


        ButterKnife.bind(this);

        session = new SessionManager(ChooseYourAddressActivity.this);
        HashMap<String, String> user = session.getUserDetails();
        name = user.get(SessionManager.KEY_NAME);
        customerid = user.get(SessionManager.KEY_ID);

        Log.w(TAG, "customerid :" + customerid);


        toolbar_title.setText(getResources().getString(R.string.chooseyourlocation));
        avi_indicator.setVisibility(View.GONE);

        Glide.with(this).asGif().load(R.drawable.loader).into(avi_indicator);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            fromactivity = extras.getString("fromactivity");

            city= extras.getString("city");

            street = extras.getString("street");

            BookingDate = extras.getString("BookingDate");
            BookingTime = extras.getString("BookingTime");
            bookingdateandtime = extras.getString("bookingdateandtime");
            Log.w(TAG,"fromactivity : "+fromactivity);
            Log.w(TAG,"bookingdateandtime : "+bookingdateandtime);
            Log.w(TAG,"BookingDate : "+BookingDate);
            Log.w(TAG,"BookingTime : "+BookingTime);
            Log.w(TAG,"city : "+city);
            Log.w(TAG,"street : "+street);


        }else{
            fromactivity  = TAG;
        }

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



        iv_addlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseYourAddressActivity.this, AddAddressMapsActivity.class);
                intent.putExtra("fromactivity",fromactivity);
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ChooseYourAddressActivity.this);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("fromscreen","choose_address");
                editor.putString("city",city);
                editor.putString("street",street);
                editor.putString("BookingDate",BookingDate);
                editor.putString("BookingTime",BookingTime);
                editor.putString("bookingdateandtime",bookingdateandtime);
                editor.apply();
                startActivity(intent);
            }
        });

        if (new ConnectionDetector(ChooseYourAddressActivity.this).isNetworkAvailable(ChooseYourAddressActivity.this)) {
            locationListResponseCall();
        }

        swipeRefreshLayout.setOnRefreshListener(() -> {
            // cancel the Visual indication of a refresh
            swipeRefreshLayout.setRefreshing(false);
            if (new ConnectionDetector(ChooseYourAddressActivity.this).isNetworkAvailable(ChooseYourAddressActivity.this)) {
                locationListResponseCall();
            }

        });



    }


    public void locationListResponseCall(){
        avi_indicator.setVisibility(View.VISIBLE);
       // avi_indicator.smoothToShow();
        //Creating an object of our api interface
        RestApiInterface apiInterface = APIClient.getClient().create(RestApiInterface.class);
        Call<LocationListResponse> call = apiInterface.locationListResponseCall(RestUtils.getContentType(),locationListRequest());
        Log.w(TAG,"url  :%s"+" "+ call.request().url().toString());

        call.enqueue(new Callback<LocationListResponse>() {
            @Override
            public void onResponse(@NotNull Call<LocationListResponse> call, @NotNull Response<LocationListResponse> response) {
                avi_indicator.setVisibility(View.GONE);

                Log.w(TAG, "LocationListResponse" + new Gson().toJson(response.body()));


                if (response.body() != null) {

                    if(response.body().getCode() == 200){
                        locationListResponseList = response.body().getData();
                        Log.w(TAG,"Size--->"+locationListResponseList.size());

                        if(response.body().getData().isEmpty()){
                            tv_norecords.setVisibility(View.VISIBLE);
                            rv_locationlist.setVisibility(View.GONE);
                        }else{
                            tv_norecords.setVisibility(View.GONE);
                            rv_locationlist.setVisibility(View.VISIBLE);
                            setView();
                        }

                    }
                }else{
                    assert response.body() != null;
                    showErrorLoading(response.body().getMessage());
                }

            }






            @Override
            public void onFailure(@NotNull Call<LocationListResponse> call, @NotNull Throwable t) {
                avi_indicator.setVisibility(View.GONE);
                Log.w(TAG,"LocationListResponseflr"+t.getMessage());
            }
        });

    }
    private LocationListRequest locationListRequest() {
        /*
          Customer_id : 5f05d8fef3090625a91f40c6

         */

        LocationListRequest locationListRequest = new LocationListRequest();
        locationListRequest.setCustomer_id(customerid);

        Log.w(TAG," locationListRequest"+ new Gson().toJson(locationListRequest));
        return locationListRequest;
    }

    private void setView() {
        //rv_locationlist.setLayoutManager(new GridLayoutManager(this, 3));

        rv_locationlist.setLayoutManager(new LinearLayoutManager(this));
        rv_locationlist.setItemAnimator(new DefaultItemAnimator());
        chooseYourAddressListAdapter = new ChooseYourAddressListBottomCartAdapter(getApplicationContext(),locationListResponseList , rv_locationlist,fromactivity,this);
        rv_locationlist.setAdapter(chooseYourAddressListAdapter);

        chooseYourAddressListAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                if (preferences.getInt(Constants.INBOX_TOTAL, 0) > locationListResponseList.size()) {
                    Log.e("haint", "Load More");
                }


            }


        });
    }

    public void showErrorLoading(String errormesage){
        alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(errormesage);
        alertDialogBuilder.setPositiveButton("ok",
                (arg0, arg1) -> hideLoading());



        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    public void hideLoading(){
        try {
            alertDialog.dismiss();
        }catch (Exception ignored){

        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();

    }

    @Override
    public void onItemCheck(String locationID) {

        if(locationID != null && !locationID.isEmpty()){
            Log.w(TAG,"Navigation locationID : "+locationID);
            callDirections(locationID);
        }

    }

    public void callDirections(String locationID){
        Intent intent = new Intent(getApplicationContext(),CartActivity.class);
        intent.putExtra("locationid",locationID);
        intent.putExtra("city",city);
        intent.putExtra("street",street);
        intent.putExtra("BookingDate",BookingDate);
        intent.putExtra("BookingTime",BookingTime);
        intent.putExtra("bookingdateandtime",bookingdateandtime);
        startActivity(intent);
        finish();
    }
   // @Override
//    public void locationDeleteListener(String status, String locationid) {
//        Log.w(TAG,"locationDeleteListener : "+" status : "+status+" locationid : "+locationid);
//
//        if(status != null && !status.trim().equalsIgnoreCase("Default".trim())){
//            showStatusAlert(locationid);
//        }else{
//            Toasty.warning(getApplicationContext(), "Default location cannot be deleted.", Toast.LENGTH_SHORT, true).show();
//
//
//        }
//
//    }
//

//
//    private void showStatusAlert(final String locationid) {
//
//        try {
//
//            dialog = new Dialog(ChooseYourAddressActivity.this);
//            dialog.setContentView(R.layout.alert_approve_reject_layout);
//            TextView tvheader = (TextView)dialog.findViewById(R.id.tvInternetNotConnected);
//            tvheader.setText(R.string.deletemsg);
//            Button dialogButtonApprove = (Button) dialog.findViewById(R.id.btnApprove);
//            dialogButtonApprove.setText("Yes");
//            Button dialogButtonRejected = (Button) dialog.findViewById(R.id.btnReject);
//            dialogButtonRejected.setText("No");
//
//            dialogButtonApprove.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    dialog.dismiss();
//                    final ProgressDialog dialog = new ProgressDialog(view.getContext());
//                    dialog.setMessage("Please wait.....");
//                    dialog.show();
//                    locationDeleteResponseCall(dialog,locationid);
//
//
//                }
//            });
//            dialogButtonRejected.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    // Toasty.info(context, "Rejected Successfully", Toast.LENGTH_SHORT, true).show();
//                    dialog.dismiss();
//
//
//
//
//                }
//            });
//            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//            dialog.show();
//
//        } catch (WindowManager.BadTokenException e) {
//            e.printStackTrace();
//        }
//
//
//
//
//    }
//    private void locationDeleteResponseCall(final ProgressDialog dialog, String locationid) {
//        dialog.show();
//        RestApiInterface apiInterface = APIClient.getClient().create(RestApiInterface.class);
//        Call<LocationDeleteResponse> call = apiInterface.locationDeleteResponseCall(RestUtils.getContentType(),locationDeleteRequest(locationid));
//
//        Log.w(TAG,"url  :%s"+call.request().url().toString());
//
//        call.enqueue(new Callback<LocationDeleteResponse>() {
//            @Override
//            public void onResponse(@NotNull Call<LocationDeleteResponse> call, @NotNull Response<LocationDeleteResponse> response) {
//                dialog.dismiss();
//                Log.w(TAG,"LocationDeleteResponse"+ "--->" + new Gson().toJson(response.body()));
//
//                if (response.body() != null) {
//                    if(response.body().getCode() == 200){
//                        Toasty.success(getApplicationContext(), "Address Removed Successfully", Toast.LENGTH_SHORT, true).show();
//                       /* Intent i = new Intent(ChooseYourAddressActivity.this, ChooseYourAddressActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        startActivity(i);*/
//                        finish();
//                        overridePendingTransition( 0, 0);
//                        startActivity(getIntent());
//                        overridePendingTransition( 0, 0);
//
//                    }
//                }
//
//
//
//            }
//
//            @Override
//            public void onFailure(@NotNull Call<LocationDeleteResponse> call, @NotNull Throwable t) {
//                dialog.dismiss();
//
//                Log.w(TAG,"LocationDeleteResponseflr"+"--->" + t.getMessage());
//            }
//        });
//
//    }
//    private LocationDeleteRequest locationDeleteRequest(String locationid) {
//
//        /*
//          Location_id : 5f05d911f3090625a91f40c7
//         */
//        LocationDeleteRequest locationDeleteRequest = new LocationDeleteRequest();
//        locationDeleteRequest.setLocation_id(locationid);
//        Log.w(TAG,"locationDeleteRequest"+ "--->" + new Gson().toJson(locationDeleteRequest));
//        return locationDeleteRequest;
//    }

}