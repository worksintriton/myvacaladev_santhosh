package com.triton.myvacala.responsepojo;

import java.util.List;

public class ParkingListResponse {
    /**
     * Status : Success
     * Message : Parking Details Retrived successfully
     * Data : [{"Parking_Vendor_Id":"5fead15d0a9e9b7d0b949c5e","parking_prices":10,"Booking_Start_Time":"10:00 PM","Booking_Start_Date":"2020-09-11","Booking_End_Date":"2020-09-12","Booking_End_Time":"3:00 AM","Hours":"5","Month_Count":0,"Day_Count":0,"parking_reach_time":"11.40 hrs","Pricing_Type":"Hourly","parking_distance":"455.87 kms","Vehicle_Type":"5f0c0cfc2f857d66950cf25f","Parking_Hours":[{"From_hr":4,"To_hr":6,"pay":10}],"parking_details_slots_count_Bike":6,"parking_details_slots_count_Car":5,"parking_details_name":"Bapatla College Of Polytechnic","parking_details_address":"test Add","parking_details_lat":15.896212,"parking_details_long":80.4532584,"parking_details_maplink":"https://www.google.co.in/maps/place/Bapatla+College+Of+Polytechnic/@15.896212,80.4532584,16.3z/data=!4m12!1m6!3m5!1s0x3a4a408f042c3c75:0x3aa398870aa48578!2sBapatla+Engineering+College!8m2!3d15.8902495!4d80.442041!3m4!1s0x0:0x12d883e29788f0fe!8m2!3d15.8949513!4d80.4554893?hl=en&authuser=0"},{"Parking_Vendor_Id":"5fead0300a9e9b7d0b949c5c","parking_prices":10,"Booking_Start_Time":"10:00 PM","Booking_Start_Date":"2020-09-11","Booking_End_Date":"2020-09-12","Booking_End_Time":"3:00 AM","Hours":"5","Month_Count":0,"Day_Count":0,"parking_reach_time":"7.36 hrs","Pricing_Type":"Hourly","parking_distance":"294.28 kms","Vehicle_Type":"5f0c0cfc2f857d66950cf25f","Parking_Hours":[{"From_hr":4,"To_hr":6,"pay":10}],"parking_details_slots_count_Bike":5,"parking_details_slots_count_Car":5,"parking_details_name":"Sivan Park","parking_details_address":"test add2","parking_details_lat":13.0498733,"parking_details_long":80.2337479,"parking_details_maplink":"https://www.google.com/maps/place/Sivan+Park/@13.0498733,80.2337479,13.28z/data=!4m13!1m7!3m6!1s0x3a5265ea4f7d3361:0x6e61a70b6863d433!2sChennai,+Tamil+Nadu!3b1!8m2!3d13.0826802!4d80.2707184!3m4!1s0x3a5266dc6e42ad33:0xba351b6c7992c8ee!8m2!3d13.0413937!4d80.2051306"}]
     * Booking_Date : {"Booking_Start_Time":"10:00 PM","Booking_Start_Date":"2020-09-11","Booking_End_Time":"3:00 AM","Booking_End_Date":"2020-09-12"}
     * Code : 200
     */

    private String Status;
    private String Message;
    /**
     * Booking_Start_Time : 10:00 PM
     * Booking_Start_Date : 2020-09-11
     * Booking_End_Time : 3:00 AM
     * Booking_End_Date : 2020-09-12
     */

    private BookingDateBean Booking_Date;
    private int Code;
    /**
     * Parking_Vendor_Id : 5fead15d0a9e9b7d0b949c5e
     * parking_prices : 10
     * Booking_Start_Time : 10:00 PM
     * Booking_Start_Date : 2020-09-11
     * Booking_End_Date : 2020-09-12
     * Booking_End_Time : 3:00 AM
     * Hours : 5
     * Month_Count : 0
     * Day_Count : 0
     * parking_reach_time : 11.40 hrs
     * Pricing_Type : Hourly
     * parking_distance : 455.87 kms
     * Vehicle_Type : 5f0c0cfc2f857d66950cf25f
     * Parking_Hours : [{"From_hr":4,"To_hr":6,"pay":10}]
     * parking_details_slots_count_Bike : 6
     * parking_details_slots_count_Car : 5
     * parking_details_name : Bapatla College Of Polytechnic
     * parking_details_address : test Add
     * parking_details_lat : 15.896212
     * parking_details_long : 80.4532584
     * parking_details_maplink : https://www.google.co.in/maps/place/Bapatla+College+Of+Polytechnic/@15.896212,80.4532584,16.3z/data=!4m12!1m6!3m5!1s0x3a4a408f042c3c75:0x3aa398870aa48578!2sBapatla+Engineering+College!8m2!3d15.8902495!4d80.442041!3m4!1s0x0:0x12d883e29788f0fe!8m2!3d15.8949513!4d80.4554893?hl=en&authuser=0
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

    public BookingDateBean getBooking_Date() {
        return Booking_Date;
    }

    public void setBooking_Date(BookingDateBean Booking_Date) {
        this.Booking_Date = Booking_Date;
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

    public static class BookingDateBean {
        private String Booking_Start_Time;
        private String Booking_Start_Date;
        private String Booking_End_Time;
        private String Booking_End_Date;

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
    }

    public static class DataBean {
        private String Parking_Vendor_Id;
        private int parking_prices;
        private String Booking_Start_Time;
        private String Booking_Start_Date;
        private String Booking_End_Date;
        private String Booking_End_Time;
        private String Hours;
        private int Month_Count;
        private int Day_Count;
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
        /**
         * From_hr : 4
         * To_hr : 6
         * pay : 10
         */

        private List<ParkingHoursBean> Parking_Hours;

        public String getParking_Vendor_Id() {
            return Parking_Vendor_Id;
        }

        public void setParking_Vendor_Id(String Parking_Vendor_Id) {
            this.Parking_Vendor_Id = Parking_Vendor_Id;
        }

        public int getParking_prices() {
            return parking_prices;
        }

        public void setParking_prices(int parking_prices) {
            this.parking_prices = parking_prices;
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

        public String getBooking_End_Date() {
            return Booking_End_Date;
        }

        public void setBooking_End_Date(String Booking_End_Date) {
            this.Booking_End_Date = Booking_End_Date;
        }

        public String getBooking_End_Time() {
            return Booking_End_Time;
        }

        public void setBooking_End_Time(String Booking_End_Time) {
            this.Booking_End_Time = Booking_End_Time;
        }

        public String getHours() {
            return Hours;
        }

        public void setHours(String Hours) {
            this.Hours = Hours;
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

    /**Old response
     * Status : Success
     * Message : List Parking
     * Data : [{"parking_details_slots_Bike_details":[{"area":"Block1","floor":"Floor3","slot":"8","status":"enable"},{"area":"","floor":"","slot":"","status":"enable"},{"area":"","floor":"","slot":"","status":"enable"},{"area":"","floor":"","slot":"","status":"enable"}],"parking_details_slots_Car_details":[{"area":"","floor":"","slot":"","status":"enable"},{"area":"","floor":"","slot":"","status":"enable"},{"area":"","floor":"","slot":"","status":"enable"}],"parking_details_bike_price_day":[{"Title":"Monday","Timings":[{"Start_time":"17:40","End_time":"02:02","Price":200}]},{"Title":"Tuesday","Timings":[{"Start_time":"01:01","End_time":"02:02","Price":200}]},{"Title":"Wednesday","Timings":[{"Start_time":"02:02","End_time":"04:03","Price":500}]},{"Title":"Thursday","Timings":[{"Start_time":"04:04","End_time":"05:05","Price":600}]},{"Title":"Friday","Timings":[{"Start_time":"04:04","End_time":"06:06","Price":700}]},{"Title":"Saturday","Timings":[{"Start_time":"20:05","End_time":"20:05","Price":800}]},{"Title":"Sunday","Timings":[{"Start_time":"22:28","End_time":"23:02","Price":700}]}],"parking_details_bike_price_spe_day":[{"dates":"2020-08-30","Start_time":"20:44","End_time":"22:46","Price":950}],"parking_details_car_price_day":[{"Title":"Monday","Timings":[]},{"Title":"Tuesday","Timings":[]},{"Title":"Wednesday","Timings":[]},{"Title":"Thursday","Timings":[]},{"Title":"Friday","Timings":[]},{"Title":"Saturday","Timings":[]},{"Title":"Sunday","Timings":[]}],"parking_details_car_price_spe_day":[],"_id":"5f4793beb12e0b5507b79f74","parking_owner_id":"5f4793beb12e0b5507b79f73","parking_details_update_status":"Updated","parking_details_name":"Mohamad-01 Parking","parking_details_address":"Test add","parking_details_gstaddress":"Gst Add","parking_details_gstdoc":"http://3.101.31.129:3000/api/uploads/8e033739-76d3-43e4-95fc-26bce0d84549.pdf","parking_details_gstno":"Gst No","parking_details_maplink":"https://www.google.com/maps/place/Vellore,+Tamil+Nadu/@12.8992994,79.0483023,12z/data=!3m1!4b1!4m5!3m4!1s0x3bad38e61fa68ffb:0xbedda6917d262b5e!8m2!3d12.9162295!4d79.1331482","parking_details_lat":12.8992994,"parking_details_long":79.1331482,"parking_details_pocemail":"test","parking_details_slots_count_Bike":4,"parking_details_slots_count_Car":3,"parking_prices":0,"parking_distance":131.15,"parking_reach_time":36.43,"parking_details_price_bike_type":true,"parking_details_price_car_type":false,"parking_details_price_both_type":false,"updatedAt":"2020-08-27T14:53:59.658Z","createdAt":"2020-08-27T11:06:38.192Z","__v":0},{"parking_details_slots_Bike_details":[{"area":"","floor":"","slot":"","status":"enable"},{"area":"","floor":"","slot":"","status":"enable"}],"parking_details_slots_Car_details":[{"area":"Block1","floor":"floor9","slot":"5","status":"enable"},{"area":"","floor":"","slot":"","status":"enable"},{"area":"","floor":"","slot":"","status":"enable"}],"parking_details_bike_price_day":[{"Title":"Monday","Timings":[]},{"Title":"Tuesday","Timings":[]},{"Title":"Wednesday","Timings":[]},{"Title":"Thursday","Timings":[]},{"Title":"Friday","Timings":[]},{"Title":"Saturday","Timings":[]},{"Title":"Sunday","Timings":[]}],"parking_details_bike_price_spe_day":[],"parking_details_car_price_day":[{"Title":"Monday","Timings":[{"Start_time":"17:45","End_time":"20:48","Price":100}]},{"Title":"Tuesday","Timings":[{"Start_time":"20:48","End_time":"22:50","Price":500}]},{"Title":"Wednesday","Timings":[{"Start_time":"17:45","End_time":"19:44","Price":522}]},{"Title":"Thursday","Timings":[{"Start_time":"21:49","End_time":"22:50","Price":1587}]},{"Title":"Friday","Timings":[{"Start_time":"20:47","End_time":"21:49","Price":258}]},{"Title":"Saturday","Timings":[{"Start_time":"18:46","End_time":"22:50","Price":2540}]},{"Title":"Sunday","Timings":[{"Start_time":"17:45","End_time":"19:48","Price":500}]}],"parking_details_car_price_spe_day":[{"dates":"2020-08-28","Start_time":"16:51","End_time":"21:45","Price":2000}],"_id":"5f479522673f4956894c6708","parking_owner_id":"5f479522673f4956894c6707","parking_details_update_status":"Updated","parking_details_name":"p[rking-09","parking_details_address":"test add","parking_details_gstaddress":"Gst add7","parking_details_gstdoc":"http://3.101.31.129:3000/api/uploads/545d50c5-418d-4a73-97e3-7a53af172bbf.pdf","parking_details_gstno":"gst 1","parking_details_maplink":"https://www.google.com/maps/place/Vellore,+Tamil+Nadu/@12.8992994,79.0483023,12z/data=!3m1!4b1!4m5!3m4!1s0x3bad38e61fa68ffb:0xbedda6917d262b5e!8m2!3d12.9162295!4d79.1331482","parking_details_lat":12.8992994,"parking_details_long":79.8992994,"parking_details_pocemail":"test","parking_details_slots_count_Bike":2,"parking_details_slots_count_Car":3,"parking_prices":0,"parking_distance":152.88,"parking_reach_time":42.47,"parking_details_price_bike_type":false,"parking_details_price_car_type":true,"parking_details_price_both_type":false,"updatedAt":"2020-08-28T05:24:55.141Z","createdAt":"2020-08-27T11:12:34.655Z","__v":0},{"parking_details_slots_Bike_details":[{"area":"block1","floor":"floor2","slot":"5","status":"enable"},{"area":"block1","floor":"block1","slot":"block1","status":"enable"},{"area":"block1","floor":"block1","slot":"block1","status":"enable"},{"area":"block1","floor":"block1","slot":"block1","status":"enable"}],"parking_details_slots_Car_details":[{"area":"blovk2","floor":"floor5","slot":"7","status":"enable"},{"area":"block1","floor":"block1","slot":"block1","status":"enable"},{"area":"block1","floor":"block1","slot":"block1","status":"enable"},{"area":"block1block1","floor":"block1","slot":"block1","status":"enable"}],"parking_details_bike_price_day":[{"Timings":[{"Start_time":"3","End_time":"4","Price":5425}],"Title":"Tuesday"},{"Timings":[{"Start_time":"2","End_time":"4","Price":100},{"Start_time":"6","End_time":"7","Price":200}],"Title":"Wednesday"},{"Timings":[{"Start_time":"1","End_time":"3","Price":522},{"Start_time":"5","End_time":"6","Price":204}],"Title":"Thursday"},{"Timings":[{"Start_time":"8","End_time":"9","Price":2054}],"Title":"Friday"},{"Timings":[{"Start_time":"3","End_time":"6","Price":4204}],"Title":"Saturday"},{"Timings":[{"Start_time":"3","End_time":"20","Price":452}],"Title":"Sunday"},{"Timings":[{"Start_time":"2","End_time":"4","Price":425}],"Title":"Monday"}],"parking_details_bike_price_spe_day":[{"dates":"2020-08-30","Start_time":"16","End_time":"22","Price":5423}],"parking_details_car_price_day":[{"Timings":[{"Start_time":"3","End_time":"4","Price":5425}],"Title":"Tuesday"},{"Timings":[{"Start_time":"2","End_time":"4","Price":100},{"Start_time":"6","End_time":"7","Price":200}],"Title":"Wednesday"},{"Timings":[{"Start_time":"1","End_time":"3","Price":522},{"Start_time":"5","End_time":"6","Price":204}],"Title":"Thursday"},{"Timings":[{"Start_time":"8","End_time":"9","Price":2054}],"Title":"Friday"},{"Timings":[{"Start_time":"3","End_time":"6","Price":4204}],"Title":"Saturday"},{"Timings":[{"Start_time":"3","End_time":"20","Price":452}],"Title":"Sunday"},{"Timings":[{"Start_time":"2","End_time":"4","Price":425}],"Title":"Monday"}],"parking_details_car_price_spe_day":[{"dates":"2020-08-30","Start_time":"16","End_time":"22","Price":5423}],"_id":"5f4798fc99c5a35d06ad04f2","parking_owner_id":"5f4798fc99c5a35d06ad04f1","parking_details_update_status":"Updated","parking_details_name":"par-09","parking_details_address":"test asd","parking_details_gstaddress":"gst add","parking_details_gstdoc":"http://3.101.31.129:3000/api/uploads/2676942a-403e-4668-a946-df1149d9d413.pdf","parking_details_gstno":"gst no","parking_details_maplink":"https://www.google.com/maps/place/Vellore,+Tamil+Nadu/@12.8992994,79.0483023,12z/data=!3m1!4b1!4m5!3m4!1s0x3bad38e61fa68ffb:0xbedda6917d262b5e!8m2!3d12.9162295!4d79.1331482","parking_details_lat":12.8992994,"parking_details_long":79.0483023,"parking_details_pocemail":"tedt","parking_details_slots_count_Bike":4,"parking_details_slots_count_Car":4,"parking_prices":0,"parking_distance":129.79,"parking_reach_time":36.05,"parking_details_price_bike_type":false,"parking_details_price_car_type":false,"parking_details_price_both_type":true,"updatedAt":"2020-08-28T15:12:05.974Z","createdAt":"2020-08-27T11:29:00.301Z","__v":0},{"parking_details_slots_Bike_details":[{"area":"Block-1","floor":"Floor-1","slot":"5","status":"enable"}],"parking_details_slots_Car_details":[{"area":"Block-1","floor":"Floor-1","slot":"6","status":"enable"}],"parking_details_bike_price_day":[{"Timings":[{"Start_time":"8","End_time":"12","Price":585}],"Title":"Sunday"},{"Timings":[{"Start_time":"1","End_time":"2","Price":250}],"Title":"Monday"},{"Timings":[{"Start_time":"2","End_time":"5","Price":258}],"Title":"Tuesday"},{"Timings":[{"Start_time":"2","End_time":"3","Price":950}],"Title":"Wednesday"},{"Timings":[{"Start_time":"3","End_time":"5","Price":650}],"Title":"Thursday"},{"Timings":[{"Start_time":"3","End_time":"8","Price":750}],"Title":"Friday"},{"Timings":[{"Start_time":"10","End_time":"16","Price":750}],"Title":"Saturday"}],"parking_details_bike_price_spe_day":[{"dates":"2020-09-01","Start_time":"2","End_time":"5","Price":785}],"parking_details_car_price_day":[{"Timings":[{"Start_time":"8","End_time":"12","Price":585}],"Title":"Sunday"},{"Timings":[{"Start_time":"1","End_time":"2","Price":250}],"Title":"Monday"},{"Timings":[{"Start_time":"2","End_time":"5","Price":258}],"Title":"Tuesday"},{"Timings":[{"Start_time":"2","End_time":"3","Price":950}],"Title":"Wednesday"},{"Timings":[{"Start_time":"3","End_time":"5","Price":650}],"Title":"Thursday"},{"Timings":[{"Start_time":"3","End_time":"8","Price":750}],"Title":"Friday"},{"Timings":[{"Start_time":"10","End_time":"16","Price":750}],"Title":"Saturday"}],"parking_details_car_price_spe_day":[{"dates":"2020-09-01","Start_time":"2","End_time":"5","Price":785}],"_id":"5f4c902d9d6fd85aedb4d79d","parking_owner_id":"5f4c902d9d6fd85aedb4d79c","parking_details_update_status":"Updated","parking_details_name":"Sriram IOS parking","parking_details_address":"36, Easwari Nagar 3rd St, Zamin Pallavaram, Easwari Nagar, Pallavaram, Chennai, Tamil Nadu 600043, India","parking_details_gstaddress":"36, Easwari Nagar 3rd St, Zamin Pallavaram, Easwari Nagar, Pallavaram, Chennai, Tamil Nadu 600043, India","parking_details_gstdoc":"http://3.101.31.129:3000/api/uploads/e1c87a2b-c1a5-47ac-8db8-1bbfbffa0ad2.pdf","parking_details_gstno":"QWERTYUISDFGHJK","parking_details_maplink":"https://www.google.com/maps/place/12%C2%B058'09.3%22N+80%C2%B009'18.0%22E/@12.9692597,80.1528105,17z/data=!3m1!4b1!4m5!3m4!1s0x0:0x0!8m2!3d12.9692597!4d80.1549992","parking_details_lat":12.969259731945822,"parking_details_long":80.154999170696,"parking_details_pocemail":"test@gamail.com","parking_details_slots_count_Bike":1,"parking_details_slots_count_Car":1,"parking_prices":0,"parking_distance":166.95,"parking_reach_time":46.37,"parking_details_price_bike_type":false,"parking_details_price_car_type":false,"parking_details_price_both_type":true,"updatedAt":"2020-09-01T08:04:02.406Z","createdAt":"2020-08-31T05:52:45.202Z","__v":0}]
     * booking_data : {"start_date":"2020-09-02","end_date":"2020-09-02","start_time":"15","end_time":"16"}
     * Code : 200
     */


}