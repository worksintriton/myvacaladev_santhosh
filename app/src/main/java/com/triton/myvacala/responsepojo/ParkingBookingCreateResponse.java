package com.triton.myvacala.responsepojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ParkingBookingCreateResponse {
    /**
     * Status : Success
     * Message : Parking Booking Added successfully
     * Data : {"_id":"601bf6b09458852299b603e7","Booking_Id":"R82ZWS","Slot_Details":"","Extra_Charge":"","Extra_Time":"","Parkingdetails_Id":"5fead15d0a9e9b7d0b949c5e","Vehicle_Type_Id":"5f0c0cfc2f857d66950cf25f","Vehicle_Id":"5fa53c8b5a88ad2f2cb74e3e","Booking_Start_Date":"2021-01-04","Booking_End_Date":"2021-01-04","Booking_Start_Time":"3:30 PM","Booking_End_Time":"5:30 PM","Customer_Id":"5fa5365b5a88ad2f2cb74e2a","Total_Amount":"4","Pricing_Type":"Hourly","Hourly_Count":2,"Month_Count":0,"Days_Count":0,"Booking_Status":"","Check_In_Date":"2021-02-04T13:29:20.222Z","Check_Out_Date":"2021-02-04T13:29:20.222Z","parking_shop_name":"Bapatla College Of Polytechnic","parking_shop_address":"test Add","parking_shop_address_link":"https://www.google.co.in/maps/place/Bapatla+College+Of+Polytechnic/@15.896212,80.4532584,16.3z/data=!4m12!1m6!3m5!1s0x3a4a408f042c3c75:0x3aa398870aa48578!2sBapatla+Engineering+College!8m2!3d15.8902495!4d80.442041!3m4!1s0x0:0x12d883e29788f0fe!8m2!3d15.8949513!4d80.4554893?hl=en&authuser=0","Vehicle_details":[{"_id":"5fa53c8b5a88ad2f2cb74e3e","Customer_id":"5fa5365b5a88ad2f2cb74e2a","Vehicle_Image":"https://myvacala.com/api/uploads/7d90d967-f0ac-4c8c-8843-0b288e1b55a6.jpg","Vehicletype_id":"5f0c0cfc2f857d66950cf25f","Vehicletype_Name":"Four Wheeler","Vehicle_Brand_id":"5f29314a13a663621cf01f97","Vehicle_Brand_Name":"maruti","Vehicle_Name_id":"5f8559707fb27e622d58efcd","Vehicle_Name":"Four - 3","Year_of_Manufacture":"1923","Vehicle_No":"ap12df1234","Fuel_Type_id":"5f2bfc783634306aac046825","Fuel_Type_Name":"gr","Fuel_Type_Background_Color":"#008000","Vehicle_Model_id":"5f1af06ede7bf45b602f8bb2","Vehicle_Model_Name":"SADAN","Status":"Default","updatedAt":"2020-11-06T12:07:39.684Z","createdAt":"2020-11-06T12:07:39.684Z","__v":0}],"Booking_Hours_cost":0,"Parking_Hours_count":0,"Booking_Days":2,"Parking_Day_Cost":100,"Booking_Months":0,"Parking_Monthly_Price":0,"distance":"8.3 hrs","Kms":"331.96 kms","duration_date":"04 Feb, 03:30 PM to 04 Feb, 04:30 PM(1 Hours)","couponcode":"MOJH","couponcode_amount":"100"}
     * Code : 200
     */

    private String Status;
    private String Message;
    /**
     * _id : 601bf6b09458852299b603e7
     * Booking_Id : R82ZWS
     * Slot_Details :
     * Extra_Charge :
     * Extra_Time :
     * Parkingdetails_Id : 5fead15d0a9e9b7d0b949c5e
     * Vehicle_Type_Id : 5f0c0cfc2f857d66950cf25f
     * Vehicle_Id : 5fa53c8b5a88ad2f2cb74e3e
     * Booking_Start_Date : 2021-01-04
     * Booking_End_Date : 2021-01-04
     * Booking_Start_Time : 3:30 PM
     * Booking_End_Time : 5:30 PM
     * Customer_Id : 5fa5365b5a88ad2f2cb74e2a
     * Total_Amount : 4
     * Pricing_Type : Hourly
     * Hourly_Count : 2
     * Month_Count : 0
     * Days_Count : 0
     * Booking_Status :
     * Check_In_Date : 2021-02-04T13:29:20.222Z
     * Check_Out_Date : 2021-02-04T13:29:20.222Z
     * parking_shop_name : Bapatla College Of Polytechnic
     * parking_shop_address : test Add
     * parking_shop_address_link : https://www.google.co.in/maps/place/Bapatla+College+Of+Polytechnic/@15.896212,80.4532584,16.3z/data=!4m12!1m6!3m5!1s0x3a4a408f042c3c75:0x3aa398870aa48578!2sBapatla+Engineering+College!8m2!3d15.8902495!4d80.442041!3m4!1s0x0:0x12d883e29788f0fe!8m2!3d15.8949513!4d80.4554893?hl=en&authuser=0
     * Vehicle_details : [{"_id":"5fa53c8b5a88ad2f2cb74e3e","Customer_id":"5fa5365b5a88ad2f2cb74e2a","Vehicle_Image":"https://myvacala.com/api/uploads/7d90d967-f0ac-4c8c-8843-0b288e1b55a6.jpg","Vehicletype_id":"5f0c0cfc2f857d66950cf25f","Vehicletype_Name":"Four Wheeler","Vehicle_Brand_id":"5f29314a13a663621cf01f97","Vehicle_Brand_Name":"maruti","Vehicle_Name_id":"5f8559707fb27e622d58efcd","Vehicle_Name":"Four - 3","Year_of_Manufacture":"1923","Vehicle_No":"ap12df1234","Fuel_Type_id":"5f2bfc783634306aac046825","Fuel_Type_Name":"gr","Fuel_Type_Background_Color":"#008000","Vehicle_Model_id":"5f1af06ede7bf45b602f8bb2","Vehicle_Model_Name":"SADAN","Status":"Default","updatedAt":"2020-11-06T12:07:39.684Z","createdAt":"2020-11-06T12:07:39.684Z","__v":0}]
     * Booking_Hours_cost : 0
     * Parking_Hours_count : 0
     * Booking_Days : 2
     * Parking_Day_Cost : 100
     * Booking_Months : 0
     * Parking_Monthly_Price : 0
     * distance : 8.3 hrs
     * Kms : 331.96 kms
     * duration_date : 04 Feb, 03:30 PM to 04 Feb, 04:30 PM(1 Hours)
     * couponcode : MOJH
     * couponcode_amount : 100
     */

    private DataBean Data;
    private int Code;

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

    public DataBean getData() {
        return Data;
    }

    public void setData(DataBean Data) {
        this.Data = Data;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int Code) {
        this.Code = Code;
    }

    public static class DataBean {
        private String _id;
        private String Booking_Id;
        private String Slot_Details;
        private String Extra_Charge;
        private String Extra_Time;
        private String Parkingdetails_Id;
        private String Vehicle_Type_Id;
        private String Vehicle_Id;
        private String Booking_Start_Date;
        private String Booking_End_Date;
        private String Booking_Start_Time;
        private String Booking_End_Time;
        private String Customer_Id;
        private String Total_Amount;
        private String Pricing_Type;
        private int Hourly_Count;
        private int Month_Count;
        private int Days_Count;
        private String Booking_Status;
        private String Check_In_Date;
        private String Check_Out_Date;
        private String parking_shop_name;
        private String parking_shop_address;
        private String parking_shop_address_link;
        private int Booking_Hours_cost;
        private int Parking_Hours_count;
        private int Booking_Days;
        private int Parking_Day_Cost;
        private int Booking_Months;
        private int Parking_Monthly_Price;
        private String distance;
        private String Kms;
        private String duration_date;
        private String couponcode;
        private String couponcode_amount;
        /**
         * _id : 5fa53c8b5a88ad2f2cb74e3e
         * Customer_id : 5fa5365b5a88ad2f2cb74e2a
         * Vehicle_Image : https://myvacala.com/api/uploads/7d90d967-f0ac-4c8c-8843-0b288e1b55a6.jpg
         * Vehicletype_id : 5f0c0cfc2f857d66950cf25f
         * Vehicletype_Name : Four Wheeler
         * Vehicle_Brand_id : 5f29314a13a663621cf01f97
         * Vehicle_Brand_Name : maruti
         * Vehicle_Name_id : 5f8559707fb27e622d58efcd
         * Vehicle_Name : Four - 3
         * Year_of_Manufacture : 1923
         * Vehicle_No : ap12df1234
         * Fuel_Type_id : 5f2bfc783634306aac046825
         * Fuel_Type_Name : gr
         * Fuel_Type_Background_Color : #008000
         * Vehicle_Model_id : 5f1af06ede7bf45b602f8bb2
         * Vehicle_Model_Name : SADAN
         * Status : Default
         * updatedAt : 2020-11-06T12:07:39.684Z
         * createdAt : 2020-11-06T12:07:39.684Z
         * __v : 0
         */

        private ArrayList<VehicleDetailsBean> Vehicle_details;

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

        public String getSlot_Details() {
            return Slot_Details;
        }

        public void setSlot_Details(String Slot_Details) {
            this.Slot_Details = Slot_Details;
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

        public String getParkingdetails_Id() {
            return Parkingdetails_Id;
        }

        public void setParkingdetails_Id(String Parkingdetails_Id) {
            this.Parkingdetails_Id = Parkingdetails_Id;
        }

        public String getVehicle_Type_Id() {
            return Vehicle_Type_Id;
        }

        public void setVehicle_Type_Id(String Vehicle_Type_Id) {
            this.Vehicle_Type_Id = Vehicle_Type_Id;
        }

        public String getVehicle_Id() {
            return Vehicle_Id;
        }

        public void setVehicle_Id(String Vehicle_Id) {
            this.Vehicle_Id = Vehicle_Id;
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

        public String getTotal_Amount() {
            return Total_Amount;
        }

        public void setTotal_Amount(String Total_Amount) {
            this.Total_Amount = Total_Amount;
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

        public int getDays_Count() {
            return Days_Count;
        }

        public void setDays_Count(int Days_Count) {
            this.Days_Count = Days_Count;
        }

        public String getBooking_Status() {
            return Booking_Status;
        }

        public void setBooking_Status(String Booking_Status) {
            this.Booking_Status = Booking_Status;
        }

        public String getCheck_In_Date() {
            return Check_In_Date;
        }

        public void setCheck_In_Date(String Check_In_Date) {
            this.Check_In_Date = Check_In_Date;
        }

        public String getCheck_Out_Date() {
            return Check_Out_Date;
        }

        public void setCheck_Out_Date(String Check_Out_Date) {
            this.Check_Out_Date = Check_Out_Date;
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
            private String Vehicle_Model_id;
            private String Vehicle_Model_Name;
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

            public String getVehicle_Model_id() {
                return Vehicle_Model_id;
            }

            public void setVehicle_Model_id(String Vehicle_Model_id) {
                this.Vehicle_Model_id = Vehicle_Model_id;
            }

            public String getVehicle_Model_Name() {
                return Vehicle_Model_Name;
            }

            public void setVehicle_Model_Name(String Vehicle_Model_Name) {
                this.Vehicle_Model_Name = Vehicle_Model_Name;
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
     * Message : Parking Booking Added successfully
     * Data : {"parking_shop_name":"Sakshi Towers","parking_shop_address":"20 algappa road, perambur, chennai -112","parking_shop_address_link":"https://www.google.com/maps/","Booking_id":"Book-111212","Vehicle_details":[{"_id":"5f33c5a423ab6d5fa01b191d","Customer_id":"5f1fc277cfb5c741551e1793","Vehicle_Image":"http://3.101.31.129:3000/api/uploads/bajaj-pulsar.png","Vehicletype_id":"5f0c0d092f857d66950cf260","Vehicletype_Name":"Two Wheeler","Vehicle_Brand_id":"5f1e70539f12a81b3dd708a1","Vehicle_Brand_Name":"Bajaj","Vehicle_Name_id":"5f1e70539f12a81b3dd708a1","Vehicle_Name":"Pulsar","Year_of_Manufacture":"2020","Vehicle_No":"1234","Fuel_Type_id":"5f29167113a663621cf01f94","Fuel_Type_Name":"Nature Gas","Fuel_Type_Background_Color":"#802A2A","Vehicle_Model_id":"5f1af089de7bf45b602f8bb3","Vehicle_Model_Name":"Standard","Status":"Default","updatedAt":"2020-08-12T10:34:12.814Z","createdAt":"2020-08-12T10:34:12.814Z","__v":0}],"amount":"200","floor":"2","block":"B2","slot":"2","Booking_start_date":"2020-09-03","Booking_start_time":"16","Booking_end_date":"2020-09-03","Booking_end_time":"17","Total_hours":"3 Hours","distance":"130.78","Kms":"130.78"}
     * Code : 200
     */




}
