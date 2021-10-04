package com.triton.myvacala.responsepojo;

import java.util.List;

public class ParkingSlotCheckAvailableResponse {
    /**
     * Status : Success
     * Message : Parking Details Retrived successfully
     * Data : {"Parking_Prices":5,"Booking_Start_Time":"11:30 AM","Booking_Start_Date":"2021-01-04","Booking_End_Time":"12:30 PM","Booking_End_Date":"2021-01-04","parking_reach_time":"11.40 hrs","Pricing_Type":"Hourly","parking_distance":"455.87","Vehicle_Type":"5f0c0cfc2f857d66950cf25f","parking_details_slots_count_Bike":6,"parking_details_slots_count_Car":-3,"parking_details_name":"Bapatla College Of Polytechnic","parking_details_address":"test Add","parking_details_lat":15.896212,"parking_details_long":80.4532584,"parking_details_maplink":"https://www.google.co.in/maps/place/Bapatla+College+Of+Polytechnic/@15.896212,80.4532584,16.3z/data=!4m12!1m6!3m5!1s0x3a4a408f042c3c75:0x3aa398870aa48578!2sBapatla+Engineering+College!8m2!3d15.8902495!4d80.442041!3m4!1s0x0:0x12d883e29788f0fe!8m2!3d15.8949513!4d80.4554893?hl=en&authuser=0","Booking_Hours_cost":5,"Booking_Hours_details":{"Parking_Hours":[{"From_hr":0,"To_hr":3,"pay":5}]},"Parking_Hours_count":1,"Booking_Days":0,"Parking_Day_Cost":0,"Booking_Months":0,"Parking_Monthly_Price":0}
     * Code : 200
     */

    private String Status;
    private String Message;
    /**
     * Parking_Prices : 5
     * Booking_Start_Time : 11:30 AM
     * Booking_Start_Date : 2021-01-04
     * Booking_End_Time : 12:30 PM
     * Booking_End_Date : 2021-01-04
     * parking_reach_time : 11.40 hrs
     * Pricing_Type : Hourly
     * parking_distance : 455.87
     * Vehicle_Type : 5f0c0cfc2f857d66950cf25f
     * parking_details_slots_count_Bike : 6
     * parking_details_slots_count_Car : -3
     * parking_details_name : Bapatla College Of Polytechnic
     * parking_details_address : test Add
     * parking_details_lat : 15.896212
     * parking_details_long : 80.4532584
     * parking_details_maplink : https://www.google.co.in/maps/place/Bapatla+College+Of+Polytechnic/@15.896212,80.4532584,16.3z/data=!4m12!1m6!3m5!1s0x3a4a408f042c3c75:0x3aa398870aa48578!2sBapatla+Engineering+College!8m2!3d15.8902495!4d80.442041!3m4!1s0x0:0x12d883e29788f0fe!8m2!3d15.8949513!4d80.4554893?hl=en&authuser=0
     * Booking_Hours_cost : 5
     * Booking_Hours_details : {"Parking_Hours":[{"From_hr":0,"To_hr":3,"pay":5}]}
     * Parking_Hours_count : 1
     * Booking_Days : 0
     * Parking_Day_Cost : 0
     * Booking_Months : 0
     * Parking_Monthly_Price : 0
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
        private int Parking_Prices;
        private String Booking_Start_Time;
        private String Booking_Start_Date;
        private String Booking_End_Time;
        private String Booking_End_Date;
        private String parking_reach_time;
        private String Pricing_Type;
        private String parking_distance;
        private String Vehicle_Type;
        private int parking_details_slots_count_Bike;
        private int parking_details_slots_count_Car;
        private String parking_details_name;
        private String parking_details_address;
        private double parking_details_lat;
        private double parking_details_long;
        private String parking_details_maplink;
        private int Booking_Hours_cost;
        private BookingHoursDetailsBean Booking_Hours_details;
        private int Parking_Hours_count;
        private int Booking_Days;
        private int Parking_Day_Cost;
        private int Booking_Months;
        private int Parking_Monthly_Price;

        public int getParking_Prices() {
            return Parking_Prices;
        }

        public void setParking_Prices(int Parking_Prices) {
            this.Parking_Prices = Parking_Prices;
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

        public String getBooking_End_Time() {
            return Booking_End_Time;
        }

        public void setBooking_End_Time(String Booking_End_Time) {
            this.Booking_End_Time = Booking_End_Time;
        }

        public String getBooking_End_Date() {
            return Booking_End_Date;
        }

        public void setBooking_End_Date(String Booking_End_Date) {
            this.Booking_End_Date = Booking_End_Date;
        }

        public String getParking_reach_time() {
            return parking_reach_time;
        }

        public void setParking_reach_time(String parking_reach_time) {
            this.parking_reach_time = parking_reach_time;
        }

        public String getPricing_Type() {
            return Pricing_Type;
        }

        public void setPricing_Type(String Pricing_Type) {
            this.Pricing_Type = Pricing_Type;
        }

        public String getParking_distance() {
            return parking_distance;
        }

        public void setParking_distance(String parking_distance) {
            this.parking_distance = parking_distance;
        }

        public String getVehicle_Type() {
            return Vehicle_Type;
        }

        public void setVehicle_Type(String Vehicle_Type) {
            this.Vehicle_Type = Vehicle_Type;
        }

        public int getParking_details_slots_count_Bike() {
            return parking_details_slots_count_Bike;
        }

        public void setParking_details_slots_count_Bike(int parking_details_slots_count_Bike) {
            this.parking_details_slots_count_Bike = parking_details_slots_count_Bike;
        }

        public int getParking_details_slots_count_Car() {
            return parking_details_slots_count_Car;
        }

        public void setParking_details_slots_count_Car(int parking_details_slots_count_Car) {
            this.parking_details_slots_count_Car = parking_details_slots_count_Car;
        }

        public String getParking_details_name() {
            return parking_details_name;
        }

        public void setParking_details_name(String parking_details_name) {
            this.parking_details_name = parking_details_name;
        }

        public String getParking_details_address() {
            return parking_details_address;
        }

        public void setParking_details_address(String parking_details_address) {
            this.parking_details_address = parking_details_address;
        }

        public double getParking_details_lat() {
            return parking_details_lat;
        }

        public void setParking_details_lat(double parking_details_lat) {
            this.parking_details_lat = parking_details_lat;
        }

        public double getParking_details_long() {
            return parking_details_long;
        }

        public void setParking_details_long(double parking_details_long) {
            this.parking_details_long = parking_details_long;
        }

        public String getParking_details_maplink() {
            return parking_details_maplink;
        }

        public void setParking_details_maplink(String parking_details_maplink) {
            this.parking_details_maplink = parking_details_maplink;
        }

        public int getBooking_Hours_cost() {
            return Booking_Hours_cost;
        }

        public void setBooking_Hours_cost(int Booking_Hours_cost) {
            this.Booking_Hours_cost = Booking_Hours_cost;
        }

        public BookingHoursDetailsBean getBooking_Hours_details() {
            return Booking_Hours_details;
        }

        public void setBooking_Hours_details(BookingHoursDetailsBean Booking_Hours_details) {
            this.Booking_Hours_details = Booking_Hours_details;
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

        public static class BookingHoursDetailsBean {
            /**
             * From_hr : 0
             * To_hr : 3
             * pay : 5
             */

            private List<ParkingHoursBean> Parking_Hours;

            public List<ParkingHoursBean> getParking_Hours() {
                return Parking_Hours;
            }

            public void setParking_Hours(List<ParkingHoursBean> Parking_Hours) {
                this.Parking_Hours = Parking_Hours;
            }

            public static class ParkingHoursBean {
                private int From_hr;
                private int To_hr;
                private int pay;

                public int getFrom_hr() {
                    return From_hr;
                }

                public void setFrom_hr(int From_hr) {
                    this.From_hr = From_hr;
                }

                public int getTo_hr() {
                    return To_hr;
                }

                public void setTo_hr(int To_hr) {
                    this.To_hr = To_hr;
                }

                public int getPay() {
                    return pay;
                }

                public void setPay(int pay) {
                    this.pay = pay;
                }
            }
        }
    }





    /* Old Response
     * Status : Success
     * Message : Available Slot Details
     * Data : {"area":"Block-1","floor":"Floor-1","slot":"1","status":"enable"}
     * Code : 200
     */



}
