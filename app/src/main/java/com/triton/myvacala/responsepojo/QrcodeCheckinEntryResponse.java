package com.triton.myvacala.responsepojo;

public class QrcodeCheckinEntryResponse {
    /**
     * Status : Success
     * Message : Checked In successfullys
     * Data : {"_id":"601bf6b09458852299b603e7","Booking_Id":"R82ZWS","Slot_Details":"","Extra_Charge":"","Extra_Time":"","Parkingdetails_Id":"5fead15d0a9e9b7d0b949c5e","Vehicle_Type_Id":"5f0c0cfc2f857d66950cf25f","Vehicle_Id":"5fa53c8b5a88ad2f2cb74e3e","Booking_Start_Date":"2021-01-04","Booking_End_Date":"2021-01-04","Booking_Start_Time":"3:30 PM","Booking_End_Time":"5:30 PM","Customer_Id":"5fa5365b5a88ad2f2cb74e2a","Total_Amount":4,"Pricing_Type":"Hourly","Booking_Status":"Check-in","Check_In_Date":"2021-02-04T13:29:20.148Z","Check_Out_Date":"2021-02-04T13:29:20.148Z","slot_details":"flot / . 1/ 23023","distance":"8.3 hrs","Kms":"331.96 kms","duration_date":"04 Feb, 03:30 PM to 04 Feb, 04:30 PM(1 Hours)","couponcode":"MOJH","couponcode_amount":"100","Booked_Date_and_Time":"2021-01-04 15:30","additional_booking_hrs":"","additonal_booking_amount":"","Overall_time_duraion":"","Overall_amount_paid":"","Checking_date":"","Checking_time":"","Checkout_date":"","Checkout_time":"","total_checking_duration":"04 Feb, 03:30 PM to 04 Feb, 04:30 PM(1 Hours)","attach_pic":"","Original_amount":"","admin_status_update_time":"","last_admin_update_status":"Upcoming","parking_shop_name":"","parking_shop_address":"","parking_shop_address_link":"","amount":"4","Booking_Hours_cost":0,"Parking_Hours_count":0,"Booking_Days":2,"Parking_Day_Cost":100,"Booking_Months":0,"Parking_Monthly_Price":0}
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
     * Booking_Status : Check-in
     * Check_In_Date : 2021-02-04T13:29:20.148Z
     * Check_Out_Date : 2021-02-04T13:29:20.148Z
     * slot_details : flot / . 1/ 23023
     * distance : 8.3 hrs
     * Kms : 331.96 kms
     * duration_date : 04 Feb, 03:30 PM to 04 Feb, 04:30 PM(1 Hours)
     * couponcode : MOJH
     * couponcode_amount : 100
     * Booked_Date_and_Time : 2021-01-04 15:30
     * additional_booking_hrs :
     * additonal_booking_amount :
     * Overall_time_duraion :
     * Overall_amount_paid :
     * Checking_date :
     * Checking_time :
     * Checkout_date :
     * Checkout_time :
     * total_checking_duration : 04 Feb, 03:30 PM to 04 Feb, 04:30 PM(1 Hours)
     * attach_pic :
     * Original_amount :
     * admin_status_update_time :
     * last_admin_update_status : Upcoming
     * parking_shop_name :
     * parking_shop_address :
     * parking_shop_address_link :
     * amount : 4
     * Booking_Hours_cost : 0
     * Parking_Hours_count : 0
     * Booking_Days : 2
     * Parking_Day_Cost : 100
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
        private int Total_Amount;
        private String Pricing_Type;
        private String Booking_Status;
        private String Check_In_Date;
        private String Check_Out_Date;
        private String slot_details;
        private String distance;
        private String Kms;
        private String duration_date;
        private String couponcode;
        private String couponcode_amount;
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
        private String Original_amount;
        private String admin_status_update_time;
        private String last_admin_update_status;
        private String parking_shop_name;
        private String parking_shop_address;
        private String parking_shop_address_link;
        private String amount;
        private int Booking_Hours_cost;
        private int Parking_Hours_count;
        private int Booking_Days;
        private int Parking_Day_Cost;
        private int Booking_Months;
        private int Parking_Monthly_Price;

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

        public String getSlot_details() {
            return slot_details;
        }

        public void setSlot_details(String slot_details) {
            this.slot_details = slot_details;
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
    }

    /**
     * Status : Success
     * Message : Available
     * time_extancsion : true
     * Data : {"Price_Details":[{"date":"Monday","start_time":"1","end_time":"23","prices":100},{"date":"Monday","start_time":"1","end_time":"23","prices":100}],"total_price":200,"final_total":300,"already_pay":100,"booking_id":"5f563536bf564b1d5592d53c","additional_booking_hrs":2,"additonal_booking_amount":200,"Overall_time_duraion":3,"Overall_amount_paid":300,"extra_time":2}
     * Code : 200
     */


}
