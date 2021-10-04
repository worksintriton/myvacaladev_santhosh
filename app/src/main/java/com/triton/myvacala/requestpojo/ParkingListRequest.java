package com.triton.myvacala.requestpojo;

import com.google.gson.annotations.SerializedName;

public class ParkingListRequest {
    /**
     * lat : 12.94
     * long : 77.52
     * Vehicle_Type : 5f0c0cfc2f857d66950cf25f
     * Pricing_Type : Hourly
     * Hours : 5
     * Day_Count : 0
     * Month_Count : 0
     * Booking_Start_Time : 10:00 PM
     * Booking_Start_Date : 2020-09-11
     */

    private double lat;
    @SerializedName("long")
    private double longX;
    private String Vehicle_Type;
    private String Pricing_Type;
    private String Hours;
    private int Day_Count;
    private int Month_Count;
    private String Booking_Start_Time;
    private String Booking_Start_Date;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLongX() {
        return longX;
    }

    public void setLongX(double longX) {
        this.longX = longX;
    }

    public String getVehicle_Type() {
        return Vehicle_Type;
    }

    public void setVehicle_Type(String Vehicle_Type) {
        this.Vehicle_Type = Vehicle_Type;
    }

    public String getPricing_Type() {
        return Pricing_Type;
    }

    public void setPricing_Type(String Pricing_Type) {
        this.Pricing_Type = Pricing_Type;
    }

    public String getHours() {
        return Hours;
    }

    public void setHours(String Hours) {
        this.Hours = Hours;
    }

    public int getDay_Count() {
        return Day_Count;
    }

    public void setDay_Count(int Day_Count) {
        this.Day_Count = Day_Count;
    }

    public int getMonth_Count() {
        return Month_Count;
    }

    public void setMonth_Count(int Month_Count) {
        this.Month_Count = Month_Count;
    }

    public String getBooking_Start_Time() {
        return Booking_Start_Time;
    }

    public void setBooking_Start_Time(String Booking_Start_Time) {
        this.Booking_Start_Time = Booking_Start_Time;
    }

    public String getBooking_Start_Date() {
        return Booking_Start_Date;
    }

    public void setBooking_Start_Date(String Booking_Start_Date) {
        this.Booking_Start_Date = Booking_Start_Date;
    }

/////////////////////////// Old Request ///////////////////////////////////////

//    /**
//     * Location_lat : 13.133130
//     * Location_long : 80.245290
//     * Vehicletype_id : 5f0c0d092f857d66950cf260
//     * start_dates : 2020-08-16
//     * end_dates : 2020-08-16
//     * start_itme : 09
//     * end_time : 10
//     */


}
