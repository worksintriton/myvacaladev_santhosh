package com.triton.myvacala.activities;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.gson.Gson;
import com.triton.myvacala.R;
import com.triton.myvacala.adapter.ChooseYourAddressListBottomCartAdapter;
import com.triton.myvacala.api.APIClient;
import com.triton.myvacala.api.RestApiInterface;
import com.triton.myvacala.appUtils.Constants;
import com.triton.myvacala.fragment.CartFragment;
import com.triton.myvacala.interfaces.LocationIdListener;
import com.triton.myvacala.listeners.OnLoadMoreListener;
import com.triton.myvacala.requestpojo.LocationListRequest;
import com.triton.myvacala.responsepojo.GetCardDetailsResponse;
import com.triton.myvacala.responsepojo.LocationListResponse;
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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChooseYourAddressBottomCartActivity extends AppCompatActivity implements LocationIdListener {


    @BindView(R.id.avi_indicator)
    ImageView avi_indicator;

    @BindView(R.id.toolbar_title)
    TextView toolbar_title;

    @BindView(R.id.imgBack)
    ImageView imgBack;

    private String TAG = "ChooseYourAddressBottomCartActivity";

    SessionManager session;
    String name = "", customerid ="";

    AlertDialog.Builder alertDialogBuilder;
    AlertDialog alertDialog;

    @BindView(R.id.iv_addlocation)
    ImageView iv_addlocation;

    @BindView(R.id.rv_locationlist)
    RecyclerView rv_locationlist;

    @BindView(R.id.tv_norecords)
    TextView tv_norecords;

    String fromactivity;

    String city ,street;

    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout ;

    private List<LocationListResponse.DataBean> locationListResponseList = null;

    private ArrayList<GetCardDetailsResponse.LocationAvailableBean> locationAvailableBeanArrayList;

    ChooseYourAddressListBottomCartAdapter chooseYourAddressListAdapter;
    private SharedPreferences preferences;

    private String bookingdateandtime,BookingDate,BookingTime;

    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_your_address);

        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        ButterKnife.bind(this);

        toolbar_title.setText(getResources().getString(R.string.chooseyourlocation));
        avi_indicator.setVisibility(View.GONE);

        session = new SessionManager(ChooseYourAddressBottomCartActivity.this);
        HashMap<String, String> user = session.getUserDetails();
        name = user.get(SessionManager.KEY_NAME);
        customerid = user.get(SessionManager.KEY_ID);

        Log.w(TAG, "customerid :" + customerid);



        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            fromactivity = extras.getString("fromactivity");
            bookingdateandtime = extras.getString("bookingdateandtime");
            BookingDate = extras.getString("BookingDate");
            BookingTime = extras.getString("BookingTime");
            Log.w(TAG,"fromactivity: "+fromactivity);
            city= extras.getString("city");

            street = extras.getString("street");
            Log.w(TAG,"street : "+street);
            Log.w(TAG,"city : "+city);

            BookingDate = extras.getString("BookingDate");
            BookingTime = extras.getString("BookingTime");


        }

        iv_addlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseYourAddressBottomCartActivity.this, AddAddressMapsActivity.class);
                intent.putExtra("fromactivity",fromactivity);
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ChooseYourAddressBottomCartActivity.this);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("fromscreen","choose_address_bottomcart");
                //editor.putString("locationID",locationID);
                editor.putString("bookingdateandtime",bookingdateandtime);
                editor.putString("BookingDate",BookingDate);
                editor.putString("BookingTime",BookingTime);
                editor.apply();
                startActivity(intent);
            }
        });

        if (new ConnectionDetector(ChooseYourAddressBottomCartActivity.this).isNetworkAvailable(ChooseYourAddressBottomCartActivity.this)) {
            locationListResponseCall();
        }

        //locationAvailableBeanArrayList = CartFragment.locationAvailableBeanArrayList;

//        if(locationAvailableBeanArrayList != null && locationAvailableBeanArrayList.size()>0){
//            Log.w(TAG,"locationAvailableBeanArrayList : "+new Gson().toJson(locationAvailableBeanArrayList));
//            setView();
//        }

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }

    public void locationListResponseCall() {
        avi_indicator.setVisibility(View.VISIBLE);
        //Creating an object of our api interface
        RestApiInterface apiInterface = APIClient.getClient().create(RestApiInterface.class);
        Call<LocationListResponse> call = apiInterface.locationListResponseCall(RestUtils.getContentType(), locationListRequest());
        Log.w(TAG, "url  :%s" + " " + call.request().url().toString());

        call.enqueue(new Callback<LocationListResponse>() {
            @Override
            public void onResponse(@NotNull Call<LocationListResponse> call, @NotNull Response<LocationListResponse> response) {
                avi_indicator.setVisibility(View.GONE);

                Log.w(TAG, "LocationListResponse" + new Gson().toJson(response.body()));


                if (response.body() != null) {

                    if (response.body().getCode() == 200) {
                        locationListResponseList = response.body().getData();
                        Log.w(TAG, "Size--->" + locationListResponseList.size());

                        if (response.body().getData().isEmpty()) {
                            tv_norecords.setVisibility(View.VISIBLE);
                            rv_locationlist.setVisibility(View.GONE);
                        } else {
                            tv_norecords.setVisibility(View.GONE);
                            rv_locationlist.setVisibility(View.VISIBLE);
                            setView();

                        }

                    }
                } else {
                    assert response.body() != null;
                    showErrorLoading(response.body().getMessage());
                }

            }


            @Override
            public void onFailure(@NotNull Call<LocationListResponse> call, @NotNull Throwable t) {
                avi_indicator.setVisibility(View.GONE);
                Log.w(TAG, "LocationListResponseflr" + t.getMessage());
            }
        });
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


    @Override
    public void onItemCheck(String locationID) {

        if(locationID != null && !locationID.isEmpty()){
            Log.w(TAG,"locationID : "+locationID);
            callDirections(locationID);
        }

    }

    public void callDirections(String locationID){
        Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);
        intent.putExtra("tag","4");
        intent.putExtra("locationID",locationID);
        intent.putExtra("city",city);
        intent.putExtra("street",street);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("city",city);
        editor.putString("street",street);
        editor.apply();
        intent.putExtra("bookingdateandtime",bookingdateandtime);
        intent.putExtra("BookingDate",BookingDate);
        intent.putExtra("BookingTime",BookingTime);
        Log.w(TAG,"street : "+street);
        Log.w(TAG,"city : "+city);
        startActivity(intent);
        finish();
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

    private LocationListRequest locationListRequest() {
        /*
          Customer_id : 5f05d8fef3090625a91f40c6

         */

        LocationListRequest locationListRequest = new LocationListRequest();
        locationListRequest.setCustomer_id(customerid);

        Log.w(TAG," locationListRequest"+ new Gson().toJson(locationListRequest));
        return locationListRequest;
    }
}