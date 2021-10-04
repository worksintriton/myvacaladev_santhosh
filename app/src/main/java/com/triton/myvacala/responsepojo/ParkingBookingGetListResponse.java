package com.triton.myvacala.responsepojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ParkingBookingGetListResponse {
    /**
     * Status : Success
     * Message : Booking History
     * Data : [{"Vehicle_details":[{"_id":"5fec64b6cf54573c8bb49deb","Customer_id":"5fe5a2f021e7df536a3b47a4","Vehicle_Image":"https://myvacala.com/api/uploads/bd581539-ae61-41ba-b92c-8766ded48781.jpg","Vehicletype_id":"5f0c0d092f857d66950cf260","Vehicletype_Name":"Four Wheeler","Vehicle_Brand_id":"5f2916c913a663621cf01f96","Vehicle_Brand_Name":"yamaha","Vehicle_Name_id":"5f8559de7fb27e622d58efd0","Vehicle_Name":"Two - 2","Year_of_Manufacture":"1929","Vehicle_No":"TN30 BB 6767","Fuel_Type_id":"5f2bfc783634306aac046825","Fuel_Type_Name":"gr","Fuel_Type_Background_Color":"#008000","Status":"Default","updatedAt":"2021-01-04T11:18:45.349Z","createdAt":"2020-12-30T11:29:58.434Z","__v":0}],"Booked_Date_and_Time":"2021-02-05","additional_booking_hrs":"","additonal_booking_amount":"","Overall_time_duraion":"","Overall_amount_paid":"","Checking_date":"","Checking_time":"","Checkout_date":"","Checkout_time":"","total_checking_duration":"0","attach_pic":"","duration_date":"05 Feb, 11:40 AM to 05 Feb, 12:40 PM(1 Hours)","couponcode":"","couponcode_amount":"","Original_amount":"","admin_status_update_time":"","last_admin_update_status":"Expired","distance":"8.26 hrs","Kms":"330.43 kms","Parkingdetails_Id":"5fead15d0a9e9b7d0b949c5e","parking_shop_name":"Bapatla College Of Polytechnic","parking_shop_address":"test Add","parking_shop_address_link":"https://www.google.co.in/maps/place/Bapatla+College+Of+Polytechnic/@15.896212,80.4532584,16.3z/data=!4m12!1m6!3m5!1s0x3a4a408f042c3c75:0x3aa398870aa48578!2sBapatla+Engineering+College!8m2!3d15.8902495!4d80.442041!3m4!1s0x0:0x12d883e29788f0fe!8m2!3d15.8949513!4d80.4554893?hl=en&authuser=0","amount":"100","floor":"//","Slot_Details":"","_id":"601ce16908698934208fc6c0","Booking_Id":"TAICYR","Extra_Charge":"","Extra_Time":"","Vehicle_Type_Id":"5f0c0d092f857d66950cf260","Booking_Start_Date":"2021-02-05","Booking_End_Date":"2021-02-05","Booking_Start_Time":"11:40 AM","Booking_End_Time":"12:40 PM","Customer_Id":"5fe5a2f021e7df536a3b47a4","Total_Amount":1,"Pricing_Type":"Hourly","Booking_Status":"Expired","Booking_Hours_cost":5,"Parking_Hours_count":1,"Booking_Days":0,"Parking_Day_Cost":0,"Booking_Months":0,"Parking_Monthly_Price":0},{"Vehicle_details":[{"_id":"5fec64b6cf54573c8bb49deb","Customer_id":"5fe5a2f021e7df536a3b47a4","Vehicle_Image":"https://myvacala.com/api/uploads/bd581539-ae61-41ba-b92c-8766ded48781.jpg","Vehicletype_id":"5f0c0d092f857d66950cf260","Vehicletype_Name":"Four Wheeler","Vehicle_Brand_id":"5f2916c913a663621cf01f96","Vehicle_Brand_Name":"yamaha","Vehicle_Name_id":"5f8559de7fb27e622d58efd0","Vehicle_Name":"Two - 2","Year_of_Manufacture":"1929","Vehicle_No":"TN30 BB 6767","Fuel_Type_id":"5f2bfc783634306aac046825","Fuel_Type_Name":"gr","Fuel_Type_Background_Color":"#008000","Status":"Default","updatedAt":"2021-01-04T11:18:45.349Z","createdAt":"2020-12-30T11:29:58.434Z","__v":0}],"Booked_Date_and_Time":"2021-02-05","additional_booking_hrs":"","additonal_booking_amount":"","Overall_time_duraion":"","Overall_amount_paid":"","Checking_date":"","Checking_time":"","Checkout_date":"","Checkout_time":"","total_checking_duration":"0","attach_pic":"","duration_date":"05 Feb, 12:10 PM to 05 Feb, 1:10 PM(1 Hours)","couponcode":"","couponcode_amount":"","Original_amount":"","admin_status_update_time":"","last_admin_update_status":"Expired","distance":"8.26 hrs","Kms":"330.43 kms","Parkingdetails_Id":"5fead15d0a9e9b7d0b949c5e","parking_shop_name":"Bapatla College Of Polytechnic","parking_shop_address":"test Add","parking_shop_address_link":"https://www.google.co.in/maps/place/Bapatla+College+Of+Polytechnic/@15.896212,80.4532584,16.3z/data=!4m12!1m6!3m5!1s0x3a4a408f042c3c75:0x3aa398870aa48578!2sBapatla+Engineering+College!8m2!3d15.8902495!4d80.442041!3m4!1s0x0:0x12d883e29788f0fe!8m2!3d15.8949513!4d80.4554893?hl=en&authuser=0","amount":"100","floor":"//","Slot_Details":"","_id":"601ce79a08698934208fc6c1","Booking_Id":"2AFS6H","Extra_Charge":"","Extra_Time":"","Vehicle_Type_Id":"5f0c0d092f857d66950cf260","Booking_Start_Date":"2021-02-05","Booking_End_Date":"2021-02-05","Booking_Start_Time":"12:10 PM","Booking_End_Time":"1:10 PM","Customer_Id":"5fe5a2f021e7df536a3b47a4","Total_Amount":1,"Pricing_Type":"Hourly","Booking_Status":"Expired","Booking_Hours_cost":5,"Parking_Hours_count":1,"Booking_Days":0,"Parking_Day_Cost":0,"Booking_Months":0,"Parking_Monthly_Price":0},{"Vehicle_details":[{"_id":"5fec64b6cf54573c8bb49deb","Customer_id":"5fe5a2f021e7df536a3b47a4","Vehicle_Image":"https://myvacala.com/api/uploads/bd581539-ae61-41ba-b92c-8766ded48781.jpg","Vehicletype_id":"5f0c0d092f857d66950cf260","Vehicletype_Name":"Four Wheeler","Vehicle_Brand_id":"5f2916c913a663621cf01f96","Vehicle_Brand_Name":"yamaha","Vehicle_Name_id":"5f8559de7fb27e622d58efd0","Vehicle_Name":"Two - 2","Year_of_Manufacture":"1929","Vehicle_No":"TN30 BB 6767","Fuel_Type_id":"5f2bfc783634306aac046825","Fuel_Type_Name":"gr","Fuel_Type_Background_Color":"#008000","Status":"Default","updatedAt":"2021-01-04T11:18:45.349Z","createdAt":"2020-12-30T11:29:58.434Z","__v":0}],"Booked_Date_and_Time":"2021-02-05","additional_booking_hrs":"","additonal_booking_amount":"","Overall_time_duraion":"","Overall_amount_paid":"","Checking_date":"","Checking_time":"","Checkout_date":"","Checkout_time":"","total_checking_duration":"0","attach_pic":"","duration_date":"05 Feb, 12:10 PM to 05 Feb, 1:10 PM(1 Hours)","couponcode":"","couponcode_amount":"","Original_amount":"","admin_status_update_time":"","last_admin_update_status":"Expired","distance":"8.26 hrs","Kms":"330.43 kms","Parkingdetails_Id":"5fead15d0a9e9b7d0b949c5e","parking_shop_name":"Bapatla College Of Polytechnic","parking_shop_address":"test Add","parking_shop_address_link":"https://www.google.co.in/maps/place/Bapatla+College+Of+Polytechnic/@15.896212,80.4532584,16.3z/data=!4m12!1m6!3m5!1s0x3a4a408f042c3c75:0x3aa398870aa48578!2sBapatla+Engineering+College!8m2!3d15.8902495!4d80.442041!3m4!1s0x0:0x12d883e29788f0fe!8m2!3d15.8949513!4d80.4554893?hl=en&authuser=0","amount":"100","floor":"//","Slot_Details":"","_id":"601ce82608698934208fc6c3","Booking_Id":"0P2WMI","Extra_Charge":"","Extra_Time":"","Vehicle_Type_Id":"5f0c0d092f857d66950cf260","Booking_Start_Date":"2021-02-05","Booking_End_Date":"2021-02-05","Booking_Start_Time":"12:10 PM","Booking_End_Time":"12:26 PM","Customer_Id":"5fe5a2f021e7df536a3b47a4","Total_Amount":1,"Pricing_Type":"Hourly","Booking_Status":"Expired","Booking_Hours_cost":5,"Parking_Hours_count":1,"Booking_Days":0,"Parking_Day_Cost":0,"Booking_Months":0,"Parking_Monthly_Price":0},{"Vehicle_details":[{"_id":"5fec64b6cf54573c8bb49deb","Customer_id":"5fe5a2f021e7df536a3b47a4","Vehicle_Image":"https://myvacala.com/api/uploads/bd581539-ae61-41ba-b92c-8766ded48781.jpg","Vehicletype_id":"5f0c0d092f857d66950cf260","Vehicletype_Name":"Four Wheeler","Vehicle_Brand_id":"5f2916c913a663621cf01f96","Vehicle_Brand_Name":"yamaha","Vehicle_Name_id":"5f8559de7fb27e622d58efd0","Vehicle_Name":"Two - 2","Year_of_Manufacture":"1929","Vehicle_No":"TN30 BB 6767","Fuel_Type_id":"5f2bfc783634306aac046825","Fuel_Type_Name":"gr","Fuel_Type_Background_Color":"#008000","Status":"Default","updatedAt":"2021-01-04T11:18:45.349Z","createdAt":"2020-12-30T11:29:58.434Z","__v":0}],"Booked_Date_and_Time":"2021-02-05","additional_booking_hrs":"","additonal_booking_amount":"","Overall_time_duraion":"","Overall_amount_paid":"","Checking_date":"","Checking_time":"","Checkout_date":"","Checkout_time":"","total_checking_duration":"0","attach_pic":"","duration_date":"05 Feb, 12:30 PM to 05 Feb, 1:30 PM(1 Hours)","couponcode":"","couponcode_amount":"","Original_amount":"","admin_status_update_time":"","last_admin_update_status":"Expired","distance":"8.26 hrs","Kms":"330.43 kms","Parkingdetails_Id":"5fead15d0a9e9b7d0b949c5e","parking_shop_name":"Bapatla College Of Polytechnic","parking_shop_address":"test Add","parking_shop_address_link":"https://www.google.co.in/maps/place/Bapatla+College+Of+Polytechnic/@15.896212,80.4532584,16.3z/data=!4m12!1m6!3m5!1s0x3a4a408f042c3c75:0x3aa398870aa48578!2sBapatla+Engineering+College!8m2!3d15.8902495!4d80.442041!3m4!1s0x0:0x12d883e29788f0fe!8m2!3d15.8949513!4d80.4554893?hl=en&authuser=0","amount":"100","floor":"//","Slot_Details":"","_id":"601ceccd08698934208fc6c6","Booking_Id":"XGY4v9","Extra_Charge":"","Extra_Time":"","Vehicle_Type_Id":"5f0c0d092f857d66950cf260","Booking_Start_Date":"2021-02-05","Booking_End_Date":"2021-02-05","Booking_Start_Time":"12:30 PM","Booking_End_Time":"1:30 PM","Customer_Id":"5fe5a2f021e7df536a3b47a4","Total_Amount":1,"Pricing_Type":"Hourly","Booking_Status":"Expired","Booking_Hours_cost":5,"Parking_Hours_count":1,"Booking_Days":0,"Parking_Day_Cost":0,"Booking_Months":0,"Parking_Monthly_Price":0},{"Vehicle_details":[{"_id":"5fec64b6cf54573c8bb49deb","Customer_id":"5fe5a2f021e7df536a3b47a4","Vehicle_Image":"https://myvacala.com/api/uploads/bd581539-ae61-41ba-b92c-8766ded48781.jpg","Vehicletype_id":"5f0c0d092f857d66950cf260","Vehicletype_Name":"Four Wheeler","Vehicle_Brand_id":"5f2916c913a663621cf01f96","Vehicle_Brand_Name":"yamaha","Vehicle_Name_id":"5f8559de7fb27e622d58efd0","Vehicle_Name":"Two - 2","Year_of_Manufacture":"1929","Vehicle_No":"TN30 BB 6767","Fuel_Type_id":"5f2bfc783634306aac046825","Fuel_Type_Name":"gr","Fuel_Type_Background_Color":"#008000","Status":"Default","updatedAt":"2021-01-04T11:18:45.349Z","createdAt":"2020-12-30T11:29:58.434Z","__v":0}],"Booked_Date_and_Time":"2021-02-05","additional_booking_hrs":"","additonal_booking_amount":"","Overall_time_duraion":"","Overall_amount_paid":"","Checking_date":"","Checking_time":"","Checkout_date":"","Checkout_time":"","total_checking_duration":"0","attach_pic":"","duration_date":"05 Feb, 07:00 PM to 05 Feb, 8:00 PM(1 Hours)","couponcode":"","couponcode_amount":"","Original_amount":"","admin_status_update_time":"","last_admin_update_status":"Expired","distance":"0.35 hrs","Kms":"13.93 kms","Parkingdetails_Id":"5fead0300a9e9b7d0b949c5c","parking_shop_name":"Sivan Park","parking_shop_address":"test add2","parking_shop_address_link":"https://www.google.com/maps/place/Sivan+Park/@13.0498733,80.2337479,13.28z/data=!4m13!1m7!3m6!1s0x3a5265ea4f7d3361:0x6e61a70b6863d433!2sChennai,+Tamil+Nadu!3b1!8m2!3d13.0826802!4d80.2707184!3m4!1s0x3a5266dc6e42ad33:0xba351b6c7992c8ee!8m2!3d13.0413937!4d80.2051306","amount":"100","floor":"//","Slot_Details":"","_id":"601d484c1212e13f76317649","Booking_Id":"HvWBW6","Extra_Charge":"","Extra_Time":"","Vehicle_Type_Id":"5f0c0d092f857d66950cf260","Booking_Start_Date":"2021-02-05","Booking_End_Date":"2021-02-05","Booking_Start_Time":"7:00 PM","Booking_End_Time":"7:05 PM","Customer_Id":"5fe5a2f021e7df536a3b47a4","Total_Amount":5,"Pricing_Type":"Hourly","Booking_Status":"Expired","Booking_Hours_cost":5,"Parking_Hours_count":1,"Booking_Days":0,"Parking_Day_Cost":0,"Booking_Months":0,"Parking_Monthly_Price":0},{"Vehicle_details":[{"_id":"5fec64b6cf54573c8bb49deb","Customer_id":"5fe5a2f021e7df536a3b47a4","Vehicle_Image":"https://myvacala.com/api/uploads/bd581539-ae61-41ba-b92c-8766ded48781.jpg","Vehicletype_id":"5f0c0d092f857d66950cf260","Vehicletype_Name":"Four Wheeler","Vehicle_Brand_id":"5f2916c913a663621cf01f96","Vehicle_Brand_Name":"yamaha","Vehicle_Name_id":"5f8559de7fb27e622d58efd0","Vehicle_Name":"Two - 2","Year_of_Manufacture":"1929","Vehicle_No":"TN30 BB 6767","Fuel_Type_id":"5f2bfc783634306aac046825","Fuel_Type_Name":"gr","Fuel_Type_Background_Color":"#008000","Status":"Default","updatedAt":"2021-01-04T11:18:45.349Z","createdAt":"2020-12-30T11:29:58.434Z","__v":0}],"Booked_Date_and_Time":"2021-02-05","additional_booking_hrs":"","additonal_booking_amount":"","Overall_time_duraion":"","Overall_amount_paid":"","Checking_date":"","Checking_time":"","Checkout_date":"","Checkout_time":"","total_checking_duration":"0","attach_pic":"","duration_date":"05 Feb, 07:30 PM to 05 Feb, 8:30 PM(1 Hours)","couponcode":"","couponcode_amount":"","Original_amount":"","admin_status_update_time":"","last_admin_update_status":"Check-in","distance":"0.35 hrs","Kms":"13.93 kms","Parkingdetails_Id":"5fead0300a9e9b7d0b949c5c","parking_shop_name":"Sivan Park","parking_shop_address":"test add2","parking_shop_address_link":"https://www.google.com/maps/place/Sivan+Park/@13.0498733,80.2337479,13.28z/data=!4m13!1m7!3m6!1s0x3a5265ea4f7d3361:0x6e61a70b6863d433!2sChennai,+Tamil+Nadu!3b1!8m2!3d13.0826802!4d80.2707184!3m4!1s0x3a5266dc6e42ad33:0xba351b6c7992c8ee!8m2!3d13.0413937!4d80.2051306","amount":"100","floor":"flot","block":"/","slot":".","Slot_Details":"","_id":"601d4ef41212e13f7631764c","Booking_Id":"S0HA5R","Extra_Charge":"","Extra_Time":"","Vehicle_Type_Id":"5f0c0d092f857d66950cf260","Booking_Start_Date":"2021-02-05","Booking_End_Date":"2021-02-05","Booking_Start_Time":"7:30 PM","Booking_End_Time":"8:30 PM","Customer_Id":"5fe5a2f021e7df536a3b47a4","Total_Amount":5,"Pricing_Type":"Hourly","Booking_Status":"Check-in","Booking_Hours_cost":5,"Parking_Hours_count":1,"Booking_Days":0,"Parking_Day_Cost":0,"Booking_Months":0,"Parking_Monthly_Price":0}]
     * Code : 200
     */

    private String Status;
    private String Message;
    private int Code;
    /**
     * Vehicle_details : [{"_id":"5fec64b6cf54573c8bb49deb","Customer_id":"5fe5a2f021e7df536a3b47a4","Vehicle_Image":"https://myvacala.com/api/uploads/bd581539-ae61-41ba-b92c-8766ded48781.jpg","Vehicletype_id":"5f0c0d092f857d66950cf260","Vehicletype_Name":"Four Wheeler","Vehicle_Brand_id":"5f2916c913a663621cf01f96","Vehicle_Brand_Name":"yamaha","Vehicle_Name_id":"5f8559de7fb27e622d58efd0","Vehicle_Name":"Two - 2","Year_of_Manufacture":"1929","Vehicle_No":"TN30 BB 6767","Fuel_Type_id":"5f2bfc783634306aac046825","Fuel_Type_Name":"gr","Fuel_Type_Background_Color":"#008000","Status":"Default","updatedAt":"2021-01-04T11:18:45.349Z","createdAt":"2020-12-30T11:29:58.434Z","__v":0}]
     * Booked_Date_and_Time : 2021-02-05
     * additional_booking_hrs :
     * additonal_booking_amount :
     * Overall_time_duraion :
     * Overall_amount_paid :
     * Checking_date :
     * Checking_time :
     * Checkout_date :
     * Checkout_time :
     * total_checking_duration : 0
     * attach_pic :
     * duration_date : 05 Feb, 11:40 AM to 05 Feb, 12:40 PM(1 Hours)
     * couponcode :
     * couponcode_amount :
     * Original_amount :
     * admin_status_update_time :
     * last_admin_update_status : Expired
     * distance : 8.26 hrs
     * Kms : 330.43 kms
     * Parkingdetails_Id : 5fead15d0a9e9b7d0b949c5e
     * parking_shop_name : Bapatla College Of Polytechnic
     * parking_shop_address : test Add
     * parking_shop_address_link : https://www.google.co.in/maps/place/Bapatla+College+Of+Polytechnic/@15.896212,80.4532584,16.3z/data=!4m12!1m6!3m5!1s0x3a4a408f042c3c75:0x3aa398870aa48578!2sBapatla+Engineering+College!8m2!3d15.8902495!4d80.442041!3m4!1s0x0:0x12d883e29788f0fe!8m2!3d15.8949513!4d80.4554893?hl=en&authuser=0
     * amount : 100
     * floor : //
     * Slot_Details :
     * _id : 601ce16908698934208fc6c0
     * Booking_Id : TAICYR
     * Extra_Charge :
     * Extra_Time :
     * Vehicle_Type_Id : 5f0c0d092f857d66950cf260
     * Booking_Start_Date : 2021-02-05
     * Booking_End_Date : 2021-02-05
     * Booking_Start_Time : 11:40 AM
     * Booking_End_Time : 12:40 PM
     * Customer_Id : 5fe5a2f021e7df536a3b47a4
     * Total_Amount : 1
     * Pricing_Type : Hourly
     * Booking_Status : Expired
     * Booking_Hours_cost : 5
     * Parking_Hours_count : 1
     * Booking_Days : 0
     * Parking_Day_Cost : 0
     * Booking_Months : 0
     * Parking_Monthly_Price : 0
     */

    private List<DataBean> Data;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int Code) {
        this.Code = Code;
    }

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }

    public static class DataBean {
        private String Booked_Date_and_Time;
        private String additional_booking_hrs;
        private String additonal_booking_amount;
        private String Overall_time_duraion;
        private String Overall_amount_paid;
        private String Checking_date;
        private String Checking_time;
        private String Checkout_date;
        private String Checkout_time;
        private String total_checking_duration;
        private String attach_pic;
        private String duration_date;
        private String couponcode;
        private String couponcode_amount;
        private String Original_amount;
        private String admin_status_update_time;
        private String last_admin_update_status;
        private String distance;
        private String Kms;
        private String Parkingdetails_Id;
        private String parking_shop_name;
        private String parking_shop_address;
        private String parking_shop_address_link;
        private String amount;
        private String floor;
        private String Slot_Details;
        private String _id;
        private String Booking_Id;
        private String Extra_Charge;
        private String Extra_Time;
        private String Vehicle_Type_Id;
        private String Booking_Start_Date;
        private String Booking_End_Date;
        private String Booking_Start_Time;
        private String Booking_End_Time;
        private String Customer_Id;
        private int Total_Amount;
        private String Pricing_Type;
        private String Booking_Status;
        private int Booking_Hours_cost;
        private int Parking_Hours_count;
        private int Booking_Days;
        private int Parking_Day_Cost;
        private int Booking_Months;
        private int Parking_Monthly_Price;
        /**
         * _id : 5fec64b6cf54573c8bb49deb
         * Customer_id : 5fe5a2f021e7df536a3b47a4
         * Vehicle_Image : https://myvacala.com/api/uploads/bd581539-ae61-41ba-b92c-8766ded48781.jpg
         * Vehicletype_id : 5f0c0d092f857d66950cf260
         * Vehicletype_Name : Four Wheeler
         * Vehicle_Brand_id : 5f2916c913a663621cf01f96
         * Vehicle_Brand_Name : yamaha
         * Vehicle_Name_id : 5f8559de7fb27e622d58efd0
         * Vehicle_Name : Two - 2
         * Year_of_Manufacture : 1929
         * Vehicle_No : TN30 BB 6767
         * Fuel_Type_id : 5f2bfc783634306aac046825
         * Fuel_Type_Name : gr
         * Fuel_Type_Background_Color : #008000
         * Status : Default
         * updatedAt : 2021-01-04T11:18:45.349Z
         * createdAt : 2020-12-30T11:29:58.434Z
         * __v : 0
         */

        private ArrayList<VehicleDetailsBean> Vehicle_details;

        public String getBooked_Date_and_Time() {
            return Booked_Date_and_Time;
        }

        public void setBooked_Date_and_Time(String Booked_Date_and_Time) {
            this.Booked_Date_and_Time = Booked_Date_and_Time;
        }

        public String getAdditional_booking_hrs() {
            return additional_booking_hrs;
        }

        public void setAdditional_booking_hrs(String additional_booking_hrs) {
            this.additional_booking_hrs = additional_booking_hrs;
        }

        public String getAdditonal_booking_amount() {
            return additonal_booking_amount;
        }

        public void setAdditonal_booking_amount(String additonal_booking_amount) {
            this.additonal_booking_amount = additonal_booking_amount;
        }

        public String getOverall_time_duraion() {
            return Overall_time_duraion;
        }

        public void setOverall_time_duraion(String Overall_time_duraion) {
            this.Overall_time_duraion = Overall_time_duraion;
        }

        public String getOverall_amount_paid() {
            return Overall_amount_paid;
        }

        public void setOverall_amount_paid(String Overall_amount_paid) {
            this.Overall_amount_paid = Overall_amount_paid;
        }

        public String getChecking_date() {
            return Checking_date;
        }

        public void setChecking_date(String Checking_date) {
            this.Checking_date = Checking_date;
        }

        public String getChecking_time() {
            return Checking_time;
        }

        public void setChecking_time(String Checking_time) {
            this.Checking_time = Checking_time;
        }

        public String getCheckout_date() {
            return Checkout_date;
        }

        public void setCheckout_date(String Checkout_date) {
            this.Checkout_date = Checkout_date;
        }

        public String getCheckout_time() {
            return Checkout_time;
        }

        public void setCheckout_time(String Checkout_time) {
            this.Checkout_time = Checkout_time;
        }

        public String getTotal_checking_duration() {
            return total_checking_duration;
        }

        public void setTotal_checking_duration(String total_checking_duration) {
            this.total_checking_duration = total_checking_duration;
        }

        public String getAttach_pic() {
            return attach_pic;
        }

        public void setAttach_pic(String attach_pic) {
            this.attach_pic = attach_pic;
        }

        public String getDuration_date() {
            return duration_date;
        }

        public void setDuration_date(String duration_date) {
            this.duration_date = duration_date;
        }

        public String getCouponcode() {
            return couponcode;
        }

        public void setCouponcode(String couponcode) {
            this.couponcode = couponcode;
        }

        public String getCouponcode_amount() {
            return couponcode_amount;
        }

        public void setCouponcode_amount(String couponcode_amount) {
            this.couponcode_amount = couponcode_amount;
        }

        public String getOriginal_amount() {
            return Original_amount;
        }

        public void setOriginal_amount(String Original_amount) {
            this.Original_amount = Original_amount;
        }

        public String getAdmin_status_update_time() {
            return admin_status_update_time;
        }

        public void setAdmin_status_update_time(String admin_status_update_time) {
            this.admin_status_update_time = admin_status_update_time;
        }

        public String getLast_admin_update_status() {
            return last_admin_update_status;
        }

        public void setLast_admin_update_status(String last_admin_update_status) {
            this.last_admin_update_status = last_admin_update_status;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getKms() {
            return Kms;
        }

        public void setKms(String Kms) {
            this.Kms = Kms;
        }

        public String getParkingdetails_Id() {
            return Parkingdetails_Id;
        }

        public void setParkingdetails_Id(String Parkingdetails_Id) {
            this.Parkingdetails_Id = Parkingdetails_Id;
        }

        public String getParking_shop_name() {
            return parking_shop_name;
        }

        public void setParking_shop_name(String parking_shop_name) {
            this.parking_shop_name = parking_shop_name;
        }

        public String getParking_shop_address() {
            return parking_shop_address;
        }

        public void setParking_shop_address(String parking_shop_address) {
            this.parking_shop_address = parking_shop_address;
        }

        public String getParking_shop_address_link() {
            return parking_shop_address_link;
        }

        public void setParking_shop_address_link(String parking_shop_address_link) {
            this.parking_shop_address_link = parking_shop_address_link;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getFloor() {
            return floor;
        }

        public void setFloor(String floor) {
            this.floor = floor;
        }

        public String getSlot_Details() {
            return Slot_Details;
        }

        public void setSlot_Details(String Slot_Details) {
            this.Slot_Details = Slot_Details;
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getBooking_Id() {
            return Booking_Id;
        }

        public void setBooking_Id(String Booking_Id) {
            this.Booking_Id = Booking_Id;
        }

        public String getExtra_Charge() {
            return Extra_Charge;
        }

        public void setExtra_Charge(String Extra_Charge) {
            this.Extra_Charge = Extra_Charge;
        }

        public String getExtra_Time() {
            return Extra_Time;
        }

        public void setExtra_Time(String Extra_Time) {
            this.Extra_Time = Extra_Time;
        }

        public String getVehicle_Type_Id() {
            return Vehicle_Type_Id;
        }

        public void setVehicle_Type_Id(String Vehicle_Type_Id) {
            this.Vehicle_Type_Id = Vehicle_Type_Id;
        }

        public String getBooking_Start_Date() {
            return Booking_Start_Date;
        }

        public void setBooking_Start_Date(String Booking_Start_Date) {
            this.Booking_Start_Date = Booking_Start_Date;
        }

        public String getBooking_End_Date() {
            return Booking_End_Date;
        }

        public void setBooking_End_Date(String Booking_End_Date) {
            this.Booking_End_Date = Booking_End_Date;
        }

        public String getBooking_Start_Time() {
            return Booking_Start_Time;
        }

        public void setBooking_Start_Time(String Booking_Start_Time) {
            this.Booking_Start_Time = Booking_Start_Time;
        }

        public String getBooking_End_Time() {
            return Booking_End_Time;
        }

        public void setBooking_End_Time(String Booking_End_Time) {
            this.Booking_End_Time = Booking_End_Time;
        }

        public String getCustomer_Id() {
            return Customer_Id;
        }

        public void setCustomer_Id(String Customer_Id) {
            this.Customer_Id = Customer_Id;
        }

        public int getTotal_Amount() {
            return Total_Amount;
        }

        public void setTotal_Amount(int Total_Amount) {
            this.Total_Amount = Total_Amount;
        }

        public String getPricing_Type() {
            return Pricing_Type;
        }

        public void setPricing_Type(String Pricing_Type) {
            this.Pricing_Type = Pricing_Type;
        }

        public String getBooking_Status() {
            return Booking_Status;
        }

        public void setBooking_Status(String Booking_Status) {
            this.Booking_Status = Booking_Status;
        }

        public int getBooking_Hours_cost() {
            return Booking_Hours_cost;
        }

        public void setBooking_Hours_cost(int Booking_Hours_cost) {
            this.Booking_Hours_cost = Booking_Hours_cost;
        }

        public int getParking_Hours_count() {
            return Parking_Hours_count;
        }

        public void setParking_Hours_count(int Parking_Hours_count) {
            this.Parking_Hours_count = Parking_Hours_count;
        }

        public int getBooking_Days() {
            return Booking_Days;
        }

        public void setBooking_Days(int Booking_Days) {
            this.Booking_Days = Booking_Days;
        }

        public int getParking_Day_Cost() {
            return Parking_Day_Cost;
        }

        public void setParking_Day_Cost(int Parking_Day_Cost) {
            this.Parking_Day_Cost = Parking_Day_Cost;
        }

        public int getBooking_Months() {
            return Booking_Months;
        }

        public void setBooking_Months(int Booking_Months) {
            this.Booking_Months = Booking_Months;
        }

        public int getParking_Monthly_Price() {
            return Parking_Monthly_Price;
        }

        public void setParking_Monthly_Price(int Parking_Monthly_Price) {
            this.Parking_Monthly_Price = Parking_Monthly_Price;
        }

        public ArrayList<VehicleDetailsBean> getVehicle_details() {
            return Vehicle_details;
        }

        public void setVehicle_details(ArrayList<VehicleDetailsBean> Vehicle_details) {
            this.Vehicle_details = Vehicle_details;
        }

        public static class VehicleDetailsBean implements Serializable {
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
            private String Status;
            private String updatedAt;
            private String createdAt;
            private int __v;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCustomer_id() {
                return Customer_id;
            }

            public void setCustomer_id(String Customer_id) {
                this.Customer_id = Customer_id;
            }

            public String getVehicle_Image() {
                return Vehicle_Image;
            }

            public void setVehicle_Image(String Vehicle_Image) {
                this.Vehicle_Image = Vehicle_Image;
            }

            public String getVehicletype_id() {
                return Vehicletype_id;
            }

            public void setVehicletype_id(String Vehicletype_id) {
                this.Vehicletype_id = Vehicletype_id;
            }

            public String getVehicletype_Name() {
                return Vehicletype_Name;
            }

            public void setVehicletype_Name(String Vehicletype_Name) {
                this.Vehicletype_Name = Vehicletype_Name;
            }

            public String getVehicle_Brand_id() {
                return Vehicle_Brand_id;
            }

            public void setVehicle_Brand_id(String Vehicle_Brand_id) {
                this.Vehicle_Brand_id = Vehicle_Brand_id;
            }

            public String getVehicle_Brand_Name() {
                return Vehicle_Brand_Name;
            }

            public void setVehicle_Brand_Name(String Vehicle_Brand_Name) {
                this.Vehicle_Brand_Name = Vehicle_Brand_Name;
            }

            public String getVehicle_Name_id() {
                return Vehicle_Name_id;
            }

            public void setVehicle_Name_id(String Vehicle_Name_id) {
                this.Vehicle_Name_id = Vehicle_Name_id;
            }

            public String getVehicle_Name() {
                return Vehicle_Name;
            }

            public void setVehicle_Name(String Vehicle_Name) {
                this.Vehicle_Name = Vehicle_Name;
            }

            public String getYear_of_Manufacture() {
                return Year_of_Manufacture;
            }

            public void setYear_of_Manufacture(String Year_of_Manufacture) {
                this.Year_of_Manufacture = Year_of_Manufacture;
            }

            public String getVehicle_No() {
                return Vehicle_No;
            }

            public void setVehicle_No(String Vehicle_No) {
                this.Vehicle_No = Vehicle_No;
            }

            public String getFuel_Type_id() {
                return Fuel_Type_id;
            }

            public void setFuel_Type_id(String Fuel_Type_id) {
                this.Fuel_Type_id = Fuel_Type_id;
            }

            public String getFuel_Type_Name() {
                return Fuel_Type_Name;
            }

            public void setFuel_Type_Name(String Fuel_Type_Name) {
                this.Fuel_Type_Name = Fuel_Type_Name;
            }

            public String getFuel_Type_Background_Color() {
                return Fuel_Type_Background_Color;
            }

            public void setFuel_Type_Background_Color(String Fuel_Type_Background_Color) {
                this.Fuel_Type_Background_Color = Fuel_Type_Background_Color;
            }

            public String getStatus() {
                return Status;
            }

            public void setStatus(String Status) {
                this.Status = Status;
            }

            public String getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public int get__v() {
                return __v;
            }

            public void set__v(int __v) {
                this.__v = __v;
            }
        }
    }


    /**
     * Status : Success
     * Message : Parking Booking List
     * Data : [{"Vehicle_details":[{"_id":"5f212eecc497960c531f1f01","Customer_id":"5f1fae9bbcd5650a5ab130e8","Vehicle_Image":"http://3.101.31.129:3000/api/uploads/e1e00e57-d3e7-42dc-99d9-6ccd7b780617.jpg","Vehicletype_id":"5f0c0cfc2f857d66950cf25f","Vehicletype_Name":"Four Wheeler","Vehicle_Brand_id":"5f1a842467024c39a738e821","Vehicle_Brand_Name":"AUDI","Vehicle_Name_id":"5f1ee402e649907a21e1a84f","Vehicle_Name":"AUDI A6","Year_of_Manufacture":"2016","Vehicle_No":"TN 56 FG 6865","Fuel_Type_id":"5f1e692a9f12a81b3dd70890","Fuel_Type_Name":"Petrol","Fuel_Type_Background_Color":"#802A2A","Vehicle_Model_id":"5f1af058de7bf45b602f8bb1","Vehicle_Model_Name":"Hatchbact","Status":"Default","updatedAt":"2020-08-24T14:29:06.945Z","createdAt":"2020-07-29T08:10:20.318Z","__v":0}],"_id":"5f51d2c7d76f8843e533b1d9","parkingdetails":"5f4c902d9d6fd85aedb4d79d","slot_details":"","parkingdetails_id":"5f4c902d9d6fd85aedb4d79d","Vehicle_type_id":"5f0c0cfc2f857d66950cf25f","Vehicle_id":"5f212eecc497960c531f1f01","booking_start_date":"2020-09-05","booking_end_date":"2020-09-05","booking_start_time":"20","booking_end_time":"22","total_amount":0,"total_hrs":"0","Booked_Date_and_Time":"2020-09-04 11:08:09","Customer_id":"5f1fae9bbcd5650a5ab130e8","Booking_id":"Bk-7SC5BK","additional_booking_hrs":"","additonal_booking_amount":"","Overall_time_duraion":"","Overall_amount_paid":"","Booking_status":"Upcoming","Checking_date":"","Checking_time":"","Checkout_date":"","Checkout_time":"","total_checking_duration":"0","attach_pic":"","distance":"","Kms":"","parking_shop_name":"Sriram IOS parking","parking_shop_address":"36, Easwari Nagar 3rd St, Zamin Pallavaram, Easwari Nagar, Pallavaram, Chennai, Tamil Nadu 600043, India","parking_shop_address_link":"https://www.google.com/maps/place/12%C2%B058'09.3%22N+80%C2%B009'18.0%22E/@12.9692597,80.1528105,17z/data=!3m1!4b1!4m5!3m4!1s0x0:0x0!8m2!3d12.9692597!4d80.1549992","amount":"0","floor":"","block":"","slot":"","updatedAt":"2020-09-04T05:38:15.735Z","createdAt":"2020-09-04T05:38:15.735Z","__v":0},{"Vehicle_details":[{"_id":"5f212eecc497960c531f1f01","Customer_id":"5f1fae9bbcd5650a5ab130e8","Vehicle_Image":"http://3.101.31.129:3000/api/uploads/e1e00e57-d3e7-42dc-99d9-6ccd7b780617.jpg","Vehicletype_id":"5f0c0cfc2f857d66950cf25f","Vehicletype_Name":"Four Wheeler","Vehicle_Brand_id":"5f1a842467024c39a738e821","Vehicle_Brand_Name":"AUDI","Vehicle_Name_id":"5f1ee402e649907a21e1a84f","Vehicle_Name":"AUDI A6","Year_of_Manufacture":"2016","Vehicle_No":"TN 56 FG 6865","Fuel_Type_id":"5f1e692a9f12a81b3dd70890","Fuel_Type_Name":"Petrol","Fuel_Type_Background_Color":"#802A2A","Vehicle_Model_id":"5f1af058de7bf45b602f8bb1","Vehicle_Model_Name":"Hatchbact","Status":"Default","updatedAt":"2020-08-24T14:29:06.945Z","createdAt":"2020-07-29T08:10:20.318Z","__v":0}],"_id":"5f52138bf3095356d2a791c3","parkingdetails":"5f4798fc99c5a35d06ad04f2","slot_details":"block1/floor15","parkingdetails_id":"5f4798fc99c5a35d06ad04f2","Vehicle_type_id":"5f0c0cfc2f857d66950cf25f","Vehicle_id":"5f212eecc497960c531f1f01","booking_start_date":"2020-09-04","booking_end_date":"2020-09-04","booking_start_time":"15","booking_end_time":"18","total_amount":0,"total_hrs":"0","Booked_Date_and_Time":"2020-09-04 15:44:35","Customer_id":"5f1fae9bbcd5650a5ab130e8","Booking_id":"Bk-PD2T0I","additional_booking_hrs":"","additonal_booking_amount":"","Overall_time_duraion":"","Overall_amount_paid":"","Booking_status":"Upcoming","Checking_date":"","Checking_time":"","Checkout_date":"","Checkout_time":"","total_checking_duration":"0","attach_pic":"","duration_date":"0","distance":"","Kms":"","parking_shop_name":"par-09","parking_shop_address":"test asd","parking_shop_address_link":"https://www.google.com/maps/place/Vellore,+Tamil+Nadu/@12.8992994,79.0483023,12z/data=!3m1!4b1!4m5!3m4!1s0x3bad38e61fa68ffb:0xbedda6917d262b5e!8m2!3d12.9162295!4d79.1331482","amount":"0","floor":"","block":"","slot":"","updatedAt":"2020-09-04T10:14:35.693Z","createdAt":"2020-09-04T10:14:35.693Z","__v":0},{"Vehicle_details":[{"_id":"5f212eecc497960c531f1f01","Customer_id":"5f1fae9bbcd5650a5ab130e8","Vehicle_Image":"http://3.101.31.129:3000/api/uploads/e1e00e57-d3e7-42dc-99d9-6ccd7b780617.jpg","Vehicletype_id":"5f0c0cfc2f857d66950cf25f","Vehicletype_Name":"Four Wheeler","Vehicle_Brand_id":"5f1a842467024c39a738e821","Vehicle_Brand_Name":"AUDI","Vehicle_Name_id":"5f1ee402e649907a21e1a84f","Vehicle_Name":"AUDI A6","Year_of_Manufacture":"2016","Vehicle_No":"TN 56 FG 6865","Fuel_Type_id":"5f1e692a9f12a81b3dd70890","Fuel_Type_Name":"Petrol","Fuel_Type_Background_Color":"#802A2A","Vehicle_Model_id":"5f1af058de7bf45b602f8bb1","Vehicle_Model_Name":"Hatchbact","Status":"Default","updatedAt":"2020-08-24T14:29:06.945Z","createdAt":"2020-07-29T08:10:20.318Z","__v":0}],"_id":"5f5214acf3095356d2a791c4","parkingdetails":"5f4798fc99c5a35d06ad04f2","slot_details":"block1/floor1/5","parkingdetails_id":"5f4798fc99c5a35d06ad04f2","Vehicle_type_id":"5f0c0cfc2f857d66950cf25f","Vehicle_id":"5f212eecc497960c531f1f01","booking_start_date":"2020-09-04","booking_end_date":"2020-09-04","booking_start_time":"15","booking_end_time":"19","total_amount":0,"total_hrs":"0","Booked_Date_and_Time":"2020-09-04 15:49:24","Customer_id":"5f1fae9bbcd5650a5ab130e8","Booking_id":"Bk-1HU7Q7","additional_booking_hrs":"","additonal_booking_amount":"","Overall_time_duraion":"","Overall_amount_paid":"","Booking_status":"Upcoming","Checking_date":"","Checking_time":"","Checkout_date":"","Checkout_time":"","total_checking_duration":"0","attach_pic":"","duration_date":"0","distance":"","Kms":"","parking_shop_name":"par-09","parking_shop_address":"test asd","parking_shop_address_link":"https://www.google.com/maps/place/Vellore,+Tamil+Nadu/@12.8992994,79.0483023,12z/data=!3m1!4b1!4m5!3m4!1s0x3bad38e61fa68ffb:0xbedda6917d262b5e!8m2!3d12.9162295!4d79.1331482","amount":"0","floor":"","block":"","slot":"","updatedAt":"2020-09-04T10:19:24.783Z","createdAt":"2020-09-04T10:19:24.783Z","__v":0},{"Vehicle_details":[{"_id":"5f212eecc497960c531f1f01","Customer_id":"5f1fae9bbcd5650a5ab130e8","Vehicle_Image":"http://3.101.31.129:3000/api/uploads/e1e00e57-d3e7-42dc-99d9-6ccd7b780617.jpg","Vehicletype_id":"5f0c0cfc2f857d66950cf25f","Vehicletype_Name":"Four Wheeler","Vehicle_Brand_id":"5f1a842467024c39a738e821","Vehicle_Brand_Name":"AUDI","Vehicle_Name_id":"5f1ee402e649907a21e1a84f","Vehicle_Name":"AUDI A6","Year_of_Manufacture":"2016","Vehicle_No":"TN 56 FG 6865","Fuel_Type_id":"5f1e692a9f12a81b3dd70890","Fuel_Type_Name":"Petrol","Fuel_Type_Background_Color":"#802A2A","Vehicle_Model_id":"5f1af058de7bf45b602f8bb1","Vehicle_Model_Name":"Hatchbact","Status":"Default","updatedAt":"2020-08-24T14:29:06.945Z","createdAt":"2020-07-29T08:10:20.318Z","__v":0}],"_id":"5f52183b850fbc582200ebfa","parkingdetails":"5f4793beb12e0b5507b79f74","slot_details":"Floor1/Block1/1","parkingdetails_id":"5f4793beb12e0b5507b79f74","Vehicle_type_id":"5f0c0cfc2f857d66950cf25f","Vehicle_id":"5f212eecc497960c531f1f01","booking_start_date":"2020-09-04","booking_end_date":"2020-09-04","booking_start_time":"16","booking_end_time":"17","total_amount":0,"total_hrs":"0","Booked_Date_and_Time":"2020-09-04 16:04:34","Customer_id":"5f1fae9bbcd5650a5ab130e8","Booking_id":"Bk-F0ITFu","additional_booking_hrs":"","additonal_booking_amount":"","Overall_time_duraion":"","Overall_amount_paid":"","Booking_status":"Upcoming","Checking_date":"","Checking_time":"","Checkout_date":"","Checkout_time":"","total_checking_duration":"0","attach_pic":"","duration_date":"0","distance":"","Kms":"","parking_shop_name":"Mohamad-01 Parking","parking_shop_address":"Test add","parking_shop_address_link":"https://www.google.com/maps/place/Vellore,+Tamil+Nadu/@12.8992994,79.0483023,12z/data=!3m1!4b1!4m5!3m4!1s0x3bad38e61fa68ffb:0xbedda6917d262b5e!8m2!3d12.9162295!4d79.1331482","amount":"0","floor":"Floor1","block":"Block1","slot":"1","updatedAt":"2020-09-04T10:34:35.176Z","createdAt":"2020-09-04T10:34:35.176Z","__v":0}]
     * Code : 200
     */

}