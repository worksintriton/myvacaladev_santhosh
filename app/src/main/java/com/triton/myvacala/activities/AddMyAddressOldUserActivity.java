package com.triton.myvacala.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.triton.myvacala.R;
import com.triton.myvacala.api.APIClient;
import com.triton.myvacala.api.RestApiInterface;
import com.triton.myvacala.fragment.CartFragment;
import com.triton.myvacala.requestpojo.AddLocationRequest;
import com.triton.myvacala.responsepojo.AddLocationResponse;
import com.triton.myvacala.sessionmanager.SessionManager;
import com.triton.myvacala.utils.ConnectionDetector;
import com.triton.myvacala.utils.RestUtils;
import com.wang.avi.AVLoadingIndicatorView;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddMyAddressOldUserActivity extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener, View.OnClickListener {

    @BindView(R.id.toolbar_title)
    TextView toolbar_title;

    @BindView(R.id.imgBack)
    ImageView imgBack;


    @BindView(R.id.txt_cityname)
    TextView txt_cityname;

    @BindView(R.id.txt_address)
    TextView txt_address;

    @BindView(R.id.btn_change)
    Button btn_change;

    @BindView(R.id.edt_floatandbuildingno)
    EditText edt_floatandbuildingno;

    @BindView(R.id.edt_nearbylandmark)
    EditText edt_nearbylandmark;

    @BindView(R.id.edt_pickname)
    EditText edt_pickname;

    @BindView(R.id.btn_savelocation)
    Button btn_savelocation;

    @BindView(R.id.ll_home)
    LinearLayout ll_home;

    @BindView(R.id.ll_work)
    LinearLayout ll_work;

    @BindView(R.id.ll_others)
    LinearLayout ll_others;

    @BindView(R.id.txt_home)
    TextView txt_home;

    @BindView(R.id.txt_work)
    TextView txt_work;

    @BindView(R.id.txt_others)
    TextView txt_others;

    @BindView(R.id.ivhome)
    ImageView ivhome;

    @BindView(R.id.ivwork)
    ImageView ivwork;

    @BindView(R.id.ivothers)
    ImageView ivothers;


    String latlng = "";

    double latitude = 0, longtitude =0;

    Marker mCurrLocationMarker;

    String CityName = "", AddressLine = "";

    @BindView(R.id.avi_indicator)
    ImageView avi_indicator;

    String TAG = "AddMyAddressOldUserActivity";

    String customerid = "",state = "",country = "",postalcode = "",street = "";

    SessionManager session;

    String name = "", emailID = "",  mobile = "", type = "";

    AlertDialog.Builder alertDialogBuilder;
    AlertDialog alertDialog;

    String LocationType = "Home";

    @BindView(R.id.bottom_navigation_view)
    BottomNavigationView bottom_navigation_view;
    private String fromactivity,fromscreen,bookingdateandtime,BookingDate,BookingTime;;
    String city ,street_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_my_address_old_user);

        Log.w(TAG,"onCreate-->");

        ButterKnife.bind(this);

        session = new SessionManager(getApplicationContext());
        HashMap<String, String> user = session.getUserDetails();
        name = user.get(SessionManager.KEY_NAME);
        emailID = user.get(SessionManager.KEY_EMAIL_ID);
        mobile = user.get(SessionManager.KEY_MOBILE);
        type = user.get(SessionManager.KEY_TYPE);
        customerid = user.get(SessionManager.KEY_ID);

        Log.w(TAG,"customerid--->"+customerid);


        toolbar_title.setText(getResources().getString(R.string.addmyaddress));
        avi_indicator.setVisibility(View.GONE);

        Glide.with(this).asGif().load(R.drawable.loader).into(avi_indicator);

        imgBack.setOnClickListener(this);
        btn_change.setOnClickListener(this);
        btn_savelocation.setOnClickListener(this);

        ll_home.setOnClickListener(this);
        ll_work.setOnClickListener(this);
        ll_others.setOnClickListener(this);

        ivhome.setOnClickListener(this);
        ivwork.setOnClickListener(this);
        ivothers.setOnClickListener(this);



        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            latlng = String.valueOf(getIntent().getSerializableExtra("latlng"));
           Log.w(TAG,"latlng-->"+getIntent().getSerializableExtra("latlng"));

             String newString = latlng.replace("lat/lng:", "");
            Log.w(TAG,"latlng=="+newString);

            String latlngs = newString.trim().replaceAll("\\(", "").replaceAll("\\)","").trim();
            Log.w(TAG,"latlngs=="+latlngs);

            String[] separated = latlngs.split(",");
            String lat = separated[0];
            String lon = separated[1];

            latitude = Double.parseDouble(lat);
            longtitude = Double.parseDouble(lon);

            getAddress(latitude,longtitude);

            Log.w(TAG,"lat"+lat+" "+"lon :"+lon);

            CityName = extras.getString("cityname");

            fromscreen = extras.getString("fromscreen1");

            bookingdateandtime= extras.getString("bookingdateandtime1");

            BookingDate= extras.getString("BookingDate1");

           BookingTime = extras.getString("BookingTime1");

            city = extras.getString("city1");

            street_name = extras.getString("street1");

            Log.w(TAG,"Navigation"+"fromscreen put : "+fromscreen);

            Log.w(TAG,"Navigation"+"bookingdateandtime put : "+bookingdateandtime);

            Log.w(TAG,"Navigation"+"BookingDate put : "+BookingDate);

            Log.w(TAG,"Navigation"+"BookingTime put : "+BookingTime);

            Log.w(TAG,"Navigation"+"city put : "+city);

            Log.w(TAG,"Navigation"+"street put : "+street_name);

            AddressLine = extras.getString("address");

            txt_cityname.setText(CityName);
            txt_address.setText(AddressLine);

            fromactivity = extras.getString("fromactivity");
            Log.w(TAG,"fromactivity : "+fromactivity);




        }
        if(fromactivity == null){
            fromactivity =TAG;
            Log.w(TAG,"fromactivity if : "+fromactivity);

        }



        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        assert mapFragment != null;
        mapFragment.getMapAsync(this);

        bottom_navigation_view.setSelectedItemId(R.id.account);
        bottom_navigation_view.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }//end of oncreate

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.home:
                    //active = homeFragment;
                    String active_tag = "1";
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
        }


    };
    public void callDirections(String tag){
        Intent intent = new Intent(AddMyAddressOldUserActivity.this,DashboardActivity.class);
        intent.putExtra("tag",tag);
        startActivity(intent);
        finish();

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker.remove();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.clear();
        LatLng latLng = new LatLng(latitude,longtitude);

        //  mMap.addMarker(new MarkerOptions().position(place.getLatLng()).title(place.getName().toString()));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12.0f));
        MarkerOptions markerOptions = new MarkerOptions().position(Objects.requireNonNull(latLng)).title("");
        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin));
        googleMap.addMarker(markerOptions);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgBack:
                onBackPressed();
                break;
            case R.id.btn_change:
                onBackPressed();
                break;
            case R.id.btn_savelocation:
              saveLocationValidator();
                break;
            case R.id.ll_home:
                changeBackgroundHome();
                break;
            case R.id.ll_work:
                changeBackgroundWork();
                break;
            case R.id.ll_others:
                changeBackgroundOthers();
                break;

            case R.id.ivhome:
                changeBackgroundHome();
                break;
            case R.id.ivwork:
                changeBackgroundWork();
                break;
            case R.id.ivothers:
                changeBackgroundOthers();
                break;


        }

    }

    private void changeBackgroundHome() {
        LocationType = "Home";
        Log.w(TAG,"LocationType-->"+LocationType);
        ll_home.setBackgroundResource(R.drawable.button_background);
        ll_work.setBackgroundResource(R.drawable.layout_bg);
        ll_others.setBackgroundResource(R.drawable.layout_bg);
        txt_home.setTextColor(getResources().getColor(R.color.white));
        txt_work.setTextColor(getResources().getColor(R.color.dark_gray));
        txt_others.setTextColor(getResources().getColor(R.color.dark_gray));
        ivhome.setBackground(getResources().getDrawable(R.drawable.ic_home_white));
        ivwork.setBackground(getResources().getDrawable(R.drawable.ic_work));
        ivothers.setBackground(getResources().getDrawable(R.drawable.ic_marker_color));


    }
    private void changeBackgroundWork() {
        LocationType = "Work";
        Log.w(TAG,"LocationType-->"+LocationType);
        ll_home.setBackgroundResource(R.drawable.layout_bg);
        ll_work.setBackgroundResource(R.drawable.button_background);
        ll_others.setBackgroundResource(R.drawable.layout_bg);
        txt_home.setTextColor(getResources().getColor(R.color.dark_gray));
        txt_work.setTextColor(getResources().getColor(R.color.white));
        txt_others.setTextColor(getResources().getColor(R.color.dark_gray));
        ivhome.setBackground(getResources().getDrawable(R.drawable.ic_home_color));
        ivwork.setBackground(getResources().getDrawable(R.drawable.ic_work_white));
        ivothers.setBackground(getResources().getDrawable(R.drawable.ic_marker_color));

    }
    private void changeBackgroundOthers() {
        LocationType = "Others";
        Log.w(TAG,"LocationType-->"+LocationType);
        ll_work.setBackgroundResource(R.drawable.layout_bg);
        ll_home.setBackgroundResource(R.drawable.layout_bg);
        ll_others.setBackgroundResource(R.drawable.button_background);
        txt_home.setTextColor(getResources().getColor(R.color.dark_gray));
        txt_work.setTextColor(getResources().getColor(R.color.dark_gray));
        txt_others.setTextColor(getResources().getColor(R.color.white));
        ivhome.setBackground(getResources().getDrawable(R.drawable.ic_home_color));
        ivwork.setBackground(getResources().getDrawable(R.drawable.ic_work));
        ivothers.setBackground(getResources().getDrawable(R.drawable.ic_marker_white));


    }

    public void saveLocationValidator() {
        boolean can_proceed = true;
        if (edt_floatandbuildingno.getText().toString().trim().equals("")) {
             edt_floatandbuildingno.setError("Please enter building number");
             edt_floatandbuildingno.requestFocus();
            can_proceed = false;
        } else if (edt_pickname.getText().toString().trim().equals("")) {
             edt_pickname.setError("Please enter pick a nick Name for this location");
             edt_pickname.requestFocus();
            can_proceed = false;
        }

        if (can_proceed) {
            if (new ConnectionDetector(AddMyAddressOldUserActivity.this).isNetworkAvailable(AddMyAddressOldUserActivity.this)) {
                addLocationResponseCall();
                }


            }

        }

    public void addLocationResponseCall(){
        avi_indicator.setVisibility(View.VISIBLE);
        //avi_indicator.smoothToShow();
        //Creating an object of our api interface
        RestApiInterface apiInterface = APIClient.getClient().create(RestApiInterface.class);
        Call<AddLocationResponse> call = apiInterface.addLocationResponseCall(RestUtils.getContentType(),addLocationRequest());
        Log.w(TAG,"url  :%s"+" "+ call.request().url().toString());

        call.enqueue(new Callback<AddLocationResponse>() {
            @Override
            public void onResponse(@NotNull Call<AddLocationResponse> call, @NotNull Response<AddLocationResponse> response) {
                avi_indicator.setVisibility(View.GONE);

                Log.w(TAG, "AddLocationResponse" + new Gson().toJson(response.body()));

                Log.w(TAG, "Navigation"+"locationID" + response.body().getData().get_id());


                if (response.body() != null) {

                    if(response.body().getCode() == 200){
                        Log.w(TAG, "fromscreen final" + fromscreen);
                        if (fromscreen.equals("choose_address")){
                            Log.w(TAG,"Navigation Calling CartActivity");
                            Intent intent = new Intent(getApplicationContext(),CartActivity.class);
                            intent.putExtra("fromactivity",fromactivity);
                            intent.putExtra("locationid",response.body().getData().get_id());
                            intent.putExtra("bookingdateandtime",bookingdateandtime);
                            intent.putExtra("BookingDate",BookingDate);
                            intent.putExtra("BookingTime",BookingTime);
//                            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(AddMyAddressOldUserActivity.this);
//                            SharedPreferences.Editor editor = preferences.edit();
//                            editor.putString("cityf",city);
//                            editor.putString("streetf",street);
//                            editor.apply();
                            intent.putExtra("city",city);
                            intent.putExtra("street",street_name);

                            startActivity(intent);
                        }
                        else if (fromscreen.equals("choose_address_bottomcart")){
                            Log.w("Calling DashBoard","calling dashboard");
                            Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                            intent.putExtra("tag","4");
                            intent.putExtra("fromactivity","AddMyAddressOldUserActivity");
                            intent.putExtra("locationID",response.body().getData().get_id());
                            intent.putExtra("bookingdateandtime",bookingdateandtime);
                            intent.putExtra("BookingDate",BookingDate);
                            intent.putExtra("BookingTime",BookingTime);
                            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(AddMyAddressOldUserActivity.this);
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString("city",city);
                            editor.putString("street",street_name);
                            editor.apply();
                            Log.w(TAG+"shared_preference","city"+city+"street"+street);
                            startActivity(intent);
                        }
                        else {
                            Intent intent = new Intent(AddMyAddressOldUserActivity.this,LocationListActivity.class);
                            intent.putExtra("fromactivity",fromactivity);
                            startActivity(intent);
                        }


                    }else{
                        if(response.body().getMessage() !=null){
                            showErrorLoading(response.body().getMessage());
                        }

                    }
                }else{
                    if (response.body() != null)
                    if(response.body().getMessage() !=null){
                        showErrorLoading(response.body().getMessage());
                    }
                }

            }






            @Override
            public void onFailure(@NotNull Call<AddLocationResponse> call, @NotNull Throwable t) {
                avi_indicator.setVisibility(View.GONE);
                Log.w(TAG,"AddLocationResponseflr"+t.getMessage());
            }
        });

    }
    private AddLocationRequest addLocationRequest() {
        /*
          Customer_id : 5f05d8fef3090625a91f40c6
          City : Chennai
          State : TamilNadu
          Country : India
          Pincode : 600100
          Street : Koil street
          lat : 15.2345
          long : 70.546
          NearBy_LandMark : Pooja stores
          Location_NickName : MGM
          Flat_No : 24-f
          Location_type : Office
         */

        AddLocationRequest addLocationRequest = new AddLocationRequest();
        addLocationRequest.setCustomer_id(customerid);
        addLocationRequest.setCity(CityName);
        addLocationRequest.setState(state);
        addLocationRequest.setCountry(country);
        addLocationRequest.setPincode(postalcode);
        addLocationRequest.setStreet(AddressLine);
        addLocationRequest.setLat(latitude);
        addLocationRequest.setLongX(longtitude);
        addLocationRequest.setNearBy_LandMark(edt_nearbylandmark.getText().toString());
        addLocationRequest.setLocation_NickName(edt_pickname.getText().toString());
        addLocationRequest.setFlat_No(edt_floatandbuildingno.getText().toString());
        addLocationRequest.setLocation_type(LocationType);

        Log.w(TAG," addLocationRequest"+ new Gson().toJson(addLocationRequest));
        return addLocationRequest;
    }
    private void getAddress(double latitude, double longitude) {
        StringBuilder result = new StringBuilder();
        try {
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            List<Address> listAddresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (null != listAddresses && listAddresses.size() > 0) {
                Address address = listAddresses.get(0);
                result.append(address.getLocality()).append("\n");
                result.append(address.getCountryName());
                Log.w(TAG,"getAddress-->"+result.toString());

                 state = listAddresses.get(0).getAdminArea();
                 country = listAddresses.get(0).getCountryName();
                String subLocality = listAddresses.get(0).getSubLocality();
                 postalcode = listAddresses.get(0).getPostalCode();
                AddressLine = listAddresses.get(0).getAddressLine(0);
                CityName = listAddresses.get(0).getLocality();


                // Thoroughfare seems to be the street name without numbers
                 street = address.getThoroughfare();

                Log.w(TAG,"AddressLine :"+AddressLine+"CityName :"+CityName+"street :"+street);

                Log.w(TAG,"state :"+state+" "+"country :"+country+"subLocality :"+subLocality+"postalcode :"+postalcode);
            }
        } catch (IOException e) {
            Log.e("tag", Objects.requireNonNull(e.getMessage()));
        }

        result.toString();
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


}

