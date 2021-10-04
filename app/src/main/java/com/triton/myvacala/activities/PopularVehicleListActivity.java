package com.triton.myvacala.activities;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.triton.myvacala.R;
import com.triton.myvacala.adapter.PopularVehicleListAdapter;
import com.triton.myvacala.api.APIClient;
import com.triton.myvacala.api.RestApiInterface;
import com.triton.myvacala.appUtils.Constants;
import com.triton.myvacala.appUtils.KeyboardUtils;
import com.triton.myvacala.requestpojo.PopularVehicleListRequest;
import com.triton.myvacala.responsepojo.PopularVehicleListResponse;
import com.triton.myvacala.responsepojo.VehicleTypeGetListResponse;
import com.triton.myvacala.utils.ConnectionDetector;
import com.triton.myvacala.utils.RestUtils;
import com.wang.avi.AVLoadingIndicatorView;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopularVehicleListActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.avi_indicator)
    ImageView avi_indicator;

    @BindView(R.id.togglebutton)
    ToggleButton toggleButton;


   @BindView(R.id.rv_popularvehiclelist)
    RecyclerView rv_popularvehiclelist;


    @BindView(R.id.tv_norecords)
    TextView tv_norecords;

    @BindView(R.id.txt_popularvehicletype)
    TextView txt_popularvehicletype;

    @BindView(R.id.cardview_findvehicle)
    CardView cardview_findvehicle;


    @BindView(R.id.imgBack)
    ImageView imgBack;

    @BindView(R.id.img_clear)
    ImageView img_clear;

    @BindView(R.id.img_search)
    ImageView img_search;

    @BindView(R.id.edt_selectbymodelorbrand)
    EditText edt_selectbymodelorbrand;

    String searchString = "";
    String selectedVehicleTypeId;




    private String TAG = "PopularVehicleListActivity";

    private List<VehicleTypeGetListResponse.DataBean> vehicleTypeGetListResponseList = null;




    String twowheelervehicleid = "",fourwheelervehicleid ="";


    String vehicle_type = "Car";


    private List<PopularVehicleListResponse.DataBean> popularVehicleListResponseList = new ArrayList<>();
    private List<PopularVehicleListResponse.DataBean.VehicleDetailsBean> vehicleDetailsBeanList = new ArrayList<>();
    PopularVehicleListAdapter popularVehicleListAdapter;
    private SharedPreferences preferences;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_vehicle_list);
        ButterKnife.bind(this);

        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());



        avi_indicator.setVisibility(View.GONE);

        Glide.with(this).asGif().load(R.drawable.loader).into(avi_indicator);

        img_clear.setVisibility(View.GONE);
        img_search.setVisibility(View.GONE);
        img_search.setOnClickListener(this);
        img_clear.setOnClickListener(this);
        imgBack.setOnClickListener(this);

        toggleButton.setOnClickListener(v -> {

            if(toggleButton.isChecked()){
                //Button is ON
                vehicle_type = "Car";
                Log.w(TAG,"Car");
                txt_popularvehicletype.setText("Popular Cars");
                selectedVehicleTypeId = fourwheelervehicleid;
                popularVehicleListResponseCall(fourwheelervehicleid, searchString);
                Log.w(TAG,"four wheeler clicked :"+fourwheelervehicleid);
                toggleButton.setBackgroundResource(R.drawable.ic_toggle_car);

            }
            else{
                //Button is OFF

                vehicle_type = "Bikes";
                Log.w(TAG,"Bikes");
                txt_popularvehicletype.setText("Popular Bikes");
                Log.w(TAG,"Two wheeler clicked :"+twowheelervehicleid);
                selectedVehicleTypeId = twowheelervehicleid;
                popularVehicleListResponseCall(twowheelervehicleid, searchString);
                toggleButton.setBackgroundResource(R.drawable.ic_toggle_bike);

            }

        });

        cardview_findvehicle.setOnClickListener(this);
        if (new ConnectionDetector(PopularVehicleListActivity.this).isNetworkAvailable(PopularVehicleListActivity.this)) {

            vehicleTypeGetListResponseCall();
        }


        edt_selectbymodelorbrand.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                Log.w(TAG,"beforeTextChanged-->"+s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.w(TAG,"onTextChanged-->"+s.toString());
                searchString = s.toString();
                if(!searchString.isEmpty()){
                    img_search.setVisibility(View.VISIBLE);
                    img_clear.setVisibility(View.VISIBLE);

                }else{
                    img_search.setVisibility(View.GONE);
                    img_clear.setVisibility(View.GONE);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.w(TAG,"afterTextChanged-->"+s.toString());

            }
        });


    }

    public void vehicleTypeGetListResponseCall(){
        avi_indicator.setVisibility(View.VISIBLE);
        //avi_indicator.smoothToShow();
        //Creating an object of our api interface
        RestApiInterface apiInterface = APIClient.getClient().create(RestApiInterface.class);
        Call<VehicleTypeGetListResponse> call = apiInterface.vehicleTypeGetListResponseCall(RestUtils.getContentType());
        Log.w(TAG,"url  :%s"+ call.request().url().toString());

        call.enqueue(new Callback<VehicleTypeGetListResponse>() {
            @Override
            public void onResponse(@NonNull Call<VehicleTypeGetListResponse> call, @NonNull Response<VehicleTypeGetListResponse> response) {
                avi_indicator.setVisibility(View.GONE);


                if (response.body() != null) {
                    Log.w(TAG,"VehicleTypeGetListResponse" + new Gson().toJson(response.body()));

                    vehicleTypeGetListResponseList = response.body().getData();
                    if(!vehicleTypeGetListResponseList.isEmpty()){
                        for(int i =0; i<vehicleTypeGetListResponseList.size();i++){
                            String vehicletype = response.body().getData().get(i).getVehicle_Type();
                            String id = response.body().getData().get(i).get_id();
                            Log.w(TAG,"vehicletype :"+vehicletype+" "+"id :"+id);
                            if(vehicletype.equalsIgnoreCase("Two Wheeler")){
                                 twowheelervehicleid = response.body().getData().get(i).get_id();
                                Log.w(TAG,"twowheelervehicleid"+twowheelervehicleid);
                            }else if(vehicletype.equalsIgnoreCase("Four Wheeler")){
                                 fourwheelervehicleid = response.body().getData().get(i).get_id();
                                selectedVehicleTypeId = fourwheelervehicleid;
                                popularVehicleListResponseCall(selectedVehicleTypeId, searchString);

                                Log.w(TAG,"fourwheelervehicleid"+fourwheelervehicleid);
                            }


                        }



                    }

                }








            }


            @Override
            public void onFailure(@NonNull Call<VehicleTypeGetListResponse> call,@NonNull  Throwable t) {
                avi_indicator.setVisibility(View.GONE);

                Log.w(TAG,"VehicleTypeGetListResponseflr"+t.getMessage());
            }
        });

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.cardview_findvehicle:
                //Create the bundle
                Bundle bundle = new Bundle();
                //Add your data from getFactualResults method to bundle
                bundle.putString("vehicle_typef", vehicle_type);
                Log.w(TAG,"vehicle_type"+vehicle_type);
                //Add the bundle to the intent
                Intent i = new Intent(PopularVehicleListActivity.this, VehicleBrandListActivity.class);
                i.putExtras(bundle);
                startActivity(i);
                //startActivity(new Intent(PopularVehicleListActivity.this, VehicleBrandListActivity.class));
                break;
            case R.id.imgBack:
                onBackPressed();
                break;

            case R.id.img_search:
                popularVehicleListResponseCall(selectedVehicleTypeId, searchString);
                KeyboardUtils.hideKeyboard(PopularVehicleListActivity.this);
                break;

            case R.id.img_clear:
                edt_selectbymodelorbrand.setText("");
                popularVehicleListResponseCall(selectedVehicleTypeId, "");
                KeyboardUtils.hideKeyboard(PopularVehicleListActivity.this);
                break;


        }


    }


    public void popularVehicleListResponseCall(String selectedVehicleTypeId, String searchString){
        avi_indicator.setVisibility(View.VISIBLE);
        //avi_indicator.smoothToShow();
        //Creating an object of our api interface
        RestApiInterface apiInterface = APIClient.getClient().create(RestApiInterface.class);
        Call<PopularVehicleListResponse> call = apiInterface.popularVehicleListResponseCall(RestUtils.getContentType(),popularVehicleListRequest(selectedVehicleTypeId,searchString));
        Log.w(TAG,"url  :%s"+" "+ call.request().url().toString());

        call.enqueue(new Callback<PopularVehicleListResponse>() {
            @Override
            public void onResponse(@NotNull Call<PopularVehicleListResponse> call, @NotNull Response<PopularVehicleListResponse> response) {
                avi_indicator.setVisibility(View.GONE);


                Log.w(TAG, "PopularVehicleListResponse" + new Gson().toJson(response.body()));


                if (response.body() != null) {
                    if (response.body().getCode() == 200) {
                        popularVehicleListResponseList.clear();
                        vehicleDetailsBeanList.clear();
                        popularVehicleListResponseList = response.body().getData();
                        if (popularVehicleListResponseList.size() > 0) {
                            for (int i = 0; i < popularVehicleListResponseList.size(); i++) {
                                vehicleDetailsBeanList = popularVehicleListResponseList.get(i).getVehicle_Details();
                            }
                        }

                        if (response.body().getData().isEmpty()) {
                            tv_norecords.setVisibility(View.VISIBLE);
                            rv_popularvehiclelist.setVisibility(View.GONE);
                        } else {
                            tv_norecords.setVisibility(View.GONE);
                            rv_popularvehiclelist.setVisibility(View.VISIBLE);
                            setView();
                        }

                    } else {
                        popularVehicleListResponseList.clear();
                        vehicleDetailsBeanList.clear();
                        tv_norecords.setVisibility(View.VISIBLE);
                        rv_popularvehiclelist.setVisibility(View.GONE);


                    }
                }


            }






            @Override
            public void onFailure(@NotNull Call<PopularVehicleListResponse> call, @NotNull Throwable t) {
                avi_indicator.setVisibility(View.GONE);
                Log.w(TAG,"PopularVehicleListResponseflr"+t.getMessage());
            }
        });

    }
    private PopularVehicleListRequest popularVehicleListRequest(String selectedVehicleTypeId, String searchString) {
        /*
         * Vehicle_Type_id : 5f0c0d092f857d66950cf260
         * search_string : bajaj
         */

        PopularVehicleListRequest popularVehicleListRequest = new PopularVehicleListRequest();
        popularVehicleListRequest.setVehicle_Type_id(selectedVehicleTypeId);
        popularVehicleListRequest.setSearch_string(searchString);

        Log.w(TAG," popularVehicleListRequest"+ new Gson().toJson(popularVehicleListRequest));
        return popularVehicleListRequest;
    }

    private void setView() {

        rv_popularvehiclelist.setLayoutManager(new LinearLayoutManager(this));
        rv_popularvehiclelist.setItemAnimator(new DefaultItemAnimator());
        popularVehicleListAdapter = new PopularVehicleListAdapter(getApplicationContext(),popularVehicleListResponseList , rv_popularvehiclelist);
        rv_popularvehiclelist.setAdapter(popularVehicleListAdapter);

        popularVehicleListAdapter.setOnLoadMoreListener(() -> {
            if (preferences.getInt(Constants.INBOX_TOTAL, 0) > popularVehicleListResponseList.size()) {
                Log.e("haint", "Load More");
            }


        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(PopularVehicleListActivity.this,PickUpLocationActivity.class));
        finish();
    }
}