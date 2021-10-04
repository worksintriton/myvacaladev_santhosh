package com.triton.myvacala.requestpojo;

import com.google.gson.annotations.SerializedName;

public class ParkingSlotCheckAvailableRequest {
    /**
     * lat : 12.94
     * long : 77.52
     * Vehicle_Type : 5f0c0cfc2f857d66950cf25f
     * Parking_VendorDetails_Id : 5fead15d0a9e9b7d0b949c5e
     * Pricing_Type : Hourly
     * Hourly_Count : 2
     * Month_Count : 0
     * Day_Count : 2
     * Booking_Start_Date : 2021-01-04
     * Booking_Start_Time : 11:30 AM
     */

    private double lat;
    @SerializedName("long")
    private double longX;
    private String Vehicle_Type;
    private String Parking_VendorDetails_Id;
    private String Pricing_Type;
    private int Hourly_Count;
    private int Month_Count;
    private int Day_Count;
    private String Booking_Start_Date;
    private String Booking_Start_Time;

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

    public String getParking_VendorDetails_Id() {
        return Parking_VendorDetails_Id;
    }

    public void setParking_VendorDetails_Id(String Parking_VendorDetails_Id) {
        this.Parking_VendorDetails_Id = Parking_VendorDetails_Id;
    }

    public String getPricing_Type() {
        return Pricing_Type;
    }

    public void setPricing_Type(String Pricing_Type) {
        this.Pricing_Type = Pricing_Type;
    }

    public int getHourly_Count() {
        return Hourly_Count;
    }

    public void setHourly_Count(int Hourly_Count) {
        this.Hourly_Count = Hourly_Count;
    }

    public int getMonth_Count() {
        return Month_Count;
    }

    public void setMonth_Count(int Month_Count) {
        this.Month_Count = Month_Count;
    }

    public int getDay_Count() {
        return Day_Count;
    }

    public void setDay_Count(int Day_Count) {
        this.Day_Count = Day_Count;
    }

    public String getBooking_Start_Date() {
        return Booking_Start_Date;
    }

    public void setBooking_Start_Date(String Booking_Start_Date) {
        this.Booking_Start_Date = Booking_Start_Date;
    }

    public String getBooking_Start_Time() {
        return Booking_Start_Time;
    }

    public void setBooking_Start_Time(String Booking_Start_Time) {
        this.Booking_Start_Time = Booking_Start_Time;
    }


    // old response
    /**
     * start_date : 2020-08-20
     * end_date : 2020-08-18
     * start_time : 2
     * end_time : 10
     * parking_vendor_id : 5f4c902d9d6fd85aedb4d79d
     * vehicle_type_id : 5f0c0d092f857d66950cf260
     */


}
