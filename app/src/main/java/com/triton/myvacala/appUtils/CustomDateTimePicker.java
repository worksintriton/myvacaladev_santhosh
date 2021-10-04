package com.triton.myvacala.appUtils;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ViewSwitcher;
import android.widget.ArrayAdapter;


import androidx.appcompat.widget.AppCompatButton;


import com.triton.myvacala.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

import es.dmoral.toasty.Toasty;

public class CustomDateTimePicker implements View.OnClickListener {
    private Calendar calendar_date = null;
    private ViewSwitcher viewSwitcher;
    private DatePicker datePicker;
 //   private TimePicker timePicker;
    private Spinner sprtime;
    private AppCompatButton btnDate, btnTime;

    private ICustomDateTimeListener iCustomDateTimeListener = null;

    private Dialog dialog;

    private boolean is24HourView = true, isAutoDismiss = true;

    private int selectedHour, selectedMinute;
    private Context mContext;
    String timeslot = "";

    String TAG = "CustomDateTimePicker";

    public CustomDateTimePicker(Context context,
                                ICustomDateTimeListener customDateTimeListener) {
        iCustomDateTimeListener = customDateTimeListener;

        mContext = context;

        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.date_time_picker);
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                resetData();
            }
        });
    }

    private void setView() {
        btnDate = dialog.findViewById(R.id.btn_date);
        btnTime = dialog.findViewById(R.id.btn_time);
        dialog.findViewById(R.id.btn_set).setOnClickListener(this);
        dialog.findViewById(R.id.btn_cancel).setOnClickListener(this);
        viewSwitcher = dialog.findViewById(R.id.view_switcher);
        datePicker = dialog.findViewById(R.id.date_picker);
        long now = System.currentTimeMillis() - 1000;
        datePicker.setMinDate(now);
        datePicker.setMaxDate(now+(1000*60*60*24*15)); //After 15 Days from Now


        //timePicker = dialog.findViewById(R.id.time_picker);
        sprtime = dialog.findViewById(R.id.spr_time);

        btnDate.setOnClickListener(this);
        btnTime.setOnClickListener(this);

       // timePicker.setIs24HourView(is24HourView);
       // timePicker.setCurrentHour(selectedHour);
      //  timePicker.setCurrentMinute(selectedMinute);

        datePicker.updateDate(calendar_date.get(Calendar.YEAR),
                calendar_date.get(Calendar.MONTH),
                calendar_date.get(Calendar.DATE));

        btnDate.performClick();
    }

    public void showDialog() {
        if (!dialog.isShowing()) {
            if (calendar_date == null)
                calendar_date = Calendar.getInstance();

            selectedHour = calendar_date.get(Calendar.HOUR_OF_DAY);
            selectedMinute = calendar_date.get(Calendar.MINUTE);

            dialog.show();

            setView();
        }
    }

    public CustomDateTimePicker setAutoDismiss(boolean isAutoDismiss) {
        this.isAutoDismiss = isAutoDismiss;
        return this;
    }

    public CustomDateTimePicker dismissDialog() {
        if (!dialog.isShowing())
            dialog.dismiss();

        return this;
    }

    public CustomDateTimePicker setDate(Calendar calendar) {
        if (calendar != null)
            calendar_date = calendar;
        return this;
    }

    public CustomDateTimePicker setDate(Date date) {
        if (date != null) {
            calendar_date = Calendar.getInstance();
            calendar_date.setTime(date);
        }
        return this;
    }

    public CustomDateTimePicker setDate(int year, int month, int day) {
        if (month < 12 && month >= 0 && day < 32 && day >= 0 && year > 100
                && year < 3000) {
            calendar_date = Calendar.getInstance();
            calendar_date.set(year, month, day);
        }
        return this;
    }

    public CustomDateTimePicker setTimeIn24HourFormat(int hourIn24Format, int minute) {
        if (hourIn24Format < 24 && hourIn24Format >= 0 && minute >= 0
                && minute < 60) {
            if (calendar_date == null)
                calendar_date = Calendar.getInstance();

            calendar_date.set(calendar_date.get(Calendar.YEAR),
                    calendar_date.get(Calendar.MONTH),
                    calendar_date.get(Calendar.DAY_OF_MONTH), hourIn24Format,
                    minute);

            is24HourView = true;
        }
        return this;
    }

    public CustomDateTimePicker setTimeIn12HourFormat(int hourIn12Format, int minute,
                                                      boolean isAM) {
        if (hourIn12Format < 13 && hourIn12Format > 0 && minute >= 0
                && minute < 60) {
            if (hourIn12Format == 12)
                hourIn12Format = 0;

            int hourIn24Format = hourIn12Format;

            if (!isAM)
                hourIn24Format += 12;

            if (calendar_date == null)
                calendar_date = Calendar.getInstance();

            calendar_date.set(calendar_date.get(Calendar.YEAR),
                    calendar_date.get(Calendar.MONTH),
                    calendar_date.get(Calendar.DAY_OF_MONTH), hourIn24Format,
                    minute);

            is24HourView = false;
        }
        return this;
    }

    public CustomDateTimePicker set24HourFormat(boolean is24HourFormat) {
        is24HourView = is24HourFormat;
        return this;
    }

    public interface ICustomDateTimeListener {
        void onSet(Dialog dialog, Calendar calendarSelected,
                   Date dateSelected, int year, String monthFullName,
                   String monthShortName, int monthNumber, int day,
                   String weekDayFullName, String weekDayShortName, int hour24,
                   int hour12, int min, int sec, String AM_PM,String timeslot);
        void onCancel();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_date:
                btnTime.setEnabled(true);
                btnDate.setEnabled(false);

                if (viewSwitcher.getCurrentView() != datePicker) {
                    viewSwitcher.showPrevious();
                }
                break;

            case R.id.btn_time:
                Log.w(TAG,"btn_time : "+calendar_date.get(Calendar.YEAR)+" "+calendar_date.get(Calendar.MONTH)+" "+calendar_date.get(Calendar.DAY_OF_MONTH));

                btnTime.setEnabled(false);
                btnDate.setEnabled(true);
                if (viewSwitcher.getCurrentView() == datePicker) {
                    viewSwitcher.showNext();

                    setTimeSlot();

                }
                break;


            case R.id.btn_set:
                Log.w(TAG,"Timeslot--->"+timeslot);

                if(validateInputs()){
                    if (iCustomDateTimeListener != null) {
                        int month = datePicker.getMonth();
                        int year = datePicker.getYear();
                        int day = datePicker.getDayOfMonth();
                        calendar_date.set(year, month, day, selectedHour,
                                selectedMinute);
                        iCustomDateTimeListener.onSet(dialog, calendar_date,
                                calendar_date.getTime(), calendar_date.get(Calendar.YEAR),
                                getMonthFullName(calendar_date.get(Calendar.MONTH)),
                                getMonthShortName(calendar_date.get(Calendar.MONTH)),
                                calendar_date.get(Calendar.MONTH), calendar_date.get(Calendar.DAY_OF_MONTH),
                                getWeekDayFullName(calendar_date.get(Calendar.DAY_OF_WEEK)),
                                getWeekDayShortName(calendar_date.get(Calendar.DAY_OF_WEEK)),
                                calendar_date.get(Calendar.HOUR_OF_DAY),
                                getHourIn12Format(calendar_date.get(Calendar.HOUR_OF_DAY)),
                                calendar_date.get(Calendar.MINUTE),
                                calendar_date.get(Calendar.SECOND),
                                getAMPM(calendar_date), timeslot);


                        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                        String currentDateandTime = sdf.format(new Date());
                        String checkinDate = year+"-"+month+"-"+day;
                        String currentdate =  currentDateandTime.substring(0, currentDateandTime.indexOf(' '));


                        int month1 =(month + 1);
                        String strMonth = "";
                        if(month1 == 9 || month1 <9){
                            strMonth = "0"+month1;
                        }else{
                            strMonth = String.valueOf(month1);

                        }
                        String strdayOfMonth ="";
                        if(day == 9 || day <9){
                            strdayOfMonth = "0"+day;

                        }else{
                            strdayOfMonth = String.valueOf(day);

                        }
                        checkinDate = year+"-"+strMonth+"-"+strdayOfMonth;

                        if (!timeslot.equalsIgnoreCase("Please select...")){
                            String timeslot1 = timeslot.substring(timeslot.indexOf(' ') + 1);
                            String timeslot2 =  timeslot.substring(0, timeslot.indexOf(' '));
                            Log.w(TAG,"timeslot1 : "+timeslot1+" timeslot2 : "+timeslot2);
                            String checkinTime = timeslot1.replace("-","");
                            String checkindateandtime = checkinDate+" "+checkinTime.trim();



                            try{
                                Date dateCurrent = sdf.parse(currentDateandTime);
                                Date dateCheckin = sdf.parse(checkindateandtime);
                                Log.w(TAG,"currentDateandTime : "+currentDateandTime+" checkindateandtime : "+checkindateandtime);

                                Log.w(TAG,"dateCurrent : "+dateCurrent+" dateCheckin : "+dateCheckin);
                                Log.w(TAG,"currentdate : "+currentdate+" checkinDate : "+checkinDate+" Condition : "+currentdate.equalsIgnoreCase(checkinDate));

                                if(currentdate.equalsIgnoreCase(checkinDate)) {
                                    if (dateCurrent.after(dateCheckin)) {
                                        Log.w(TAG, "Date1 is after Date2");
                                        Toasty.warning(mContext, " Date and time has already passed.Please select valid date and time.", Toast.LENGTH_SHORT, true).show();
                                        return;

                                    }else {
                                        if (dialog.isShowing() && isAutoDismiss)
                                            dialog.dismiss();
                                    }
                                }else {
                                    if (dialog.isShowing() && isAutoDismiss)
                                        dialog.dismiss();
                                }


                            }catch (ParseException ignored){}

                        }






                    }

                }


                break;

            case R.id.btn_cancel:
                if (iCustomDateTimeListener != null)
                    iCustomDateTimeListener.onCancel();
                if (dialog.isShowing())
                    dialog.dismiss();
                break;
        }
    }

    private void setTimeSlot() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Please select...");
        arrayList.add("00:00 - 01:00");
        arrayList.add("01:00 - 02:00");
        arrayList.add("02:00 - 03:00");
        arrayList.add("03:00 - 04:00");
        arrayList.add("04:00 - 05:00");
        arrayList.add("05:00 - 06:00");
        arrayList.add("06:00 - 07:00");
        arrayList.add("07:00 - 08:00");
        arrayList.add("08:00 - 09:00");
        arrayList.add("09:00 - 10:00");
        arrayList.add("10:00 - 11:00");
        arrayList.add("11:00 - 12:00");
        arrayList.add("12:00 - 13:00");
        arrayList.add("13:00 - 14:00");
        arrayList.add("14:00 - 15:00");
        arrayList.add("15:00 - 16:00");
        arrayList.add("16:00 - 17:00");
        arrayList.add("17:00 - 18:00");
        arrayList.add("18:00 - 19:00");
        arrayList.add("19:00 - 20:00");
        arrayList.add("20:00 - 21:00");
        arrayList.add("21:00 - 22:00");
        arrayList.add("22:00 - 23:00");
        arrayList.add("23:00 - 24:00");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(mContext, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sprtime.setAdapter(arrayAdapter);
        sprtime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                timeslot = parent.getItemAtPosition(position).toString();
                Log.w(TAG,"onItemSelected : "+timeslot);
                // Toast.makeText(parent.getContext(), "Selected: " + strRelationName,          Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });

    }

    /**
     * @param date       date in String
     * @param fromFormat format of your <b>date</b> eg: if your date is 2011-07-07
     *                   09:09:09 then your format will be <b>yyyy-MM-dd hh:mm:ss</b>
     * @param toFormat   format to which you want to convert your <b>date</b> eg: if
     *                   required format is 31 July 2011 then the toFormat should be
     *                   <b>d MMMM yyyy</b>
     * @return formatted date
     */
    public static String convertDate(String date, String fromFormat,
                                     String toFormat) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(fromFormat, Locale.getDefault());
            Date d = simpleDateFormat.parse(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(d);

            simpleDateFormat = new SimpleDateFormat(toFormat, Locale.getDefault());
            simpleDateFormat.setCalendar(calendar);
            date = simpleDateFormat.format(calendar.getTime());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return date;
    }

    private String getMonthFullName(int monthNumber) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, monthNumber);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM", Locale.getDefault());
        simpleDateFormat.setCalendar(calendar);

        return simpleDateFormat.format(calendar.getTime());
    }

    private String getMonthShortName(int monthNumber) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, monthNumber);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM", Locale.getDefault());
        simpleDateFormat.setCalendar(calendar);

        return simpleDateFormat.format(calendar.getTime());
    }

    private String getWeekDayFullName(int weekDayNumber) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, weekDayNumber);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE", Locale.getDefault());
        simpleDateFormat.setCalendar(calendar);

        return simpleDateFormat.format(calendar.getTime());
    }

    private String getWeekDayShortName(int weekDayNumber) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, weekDayNumber);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EE", Locale.getDefault());
        simpleDateFormat.setCalendar(calendar);

        return simpleDateFormat.format(calendar.getTime());
    }

    private int getHourIn12Format(int hour24) {
        int hourIn12Format = 0;

        if (hour24 == 0)
            hourIn12Format = 12;
        else if (hour24 <= 12)
            hourIn12Format = hour24;
        else
            hourIn12Format = hour24 - 12;

        return hourIn12Format;
    }

    private String getAMPM(Calendar calendar) {
        return (calendar.get(Calendar.AM_PM) == (Calendar.AM)) ? "AM"
                : "PM";
    }

    private CustomDateTimePicker resetData() {
        calendar_date = null;
        is24HourView = true;
        return this;
    }

    public static String pad(int integerToPad) {
        if (integerToPad >= 10 || integerToPad < 0)
            return String.valueOf(integerToPad);
        else
            return "0" + String.valueOf(integerToPad);
    }



    private boolean validateInputs() {
        if (timeslot.equalsIgnoreCase("")) {
            Toasty.warning(mContext,"Please select time" , Toast.LENGTH_SHORT, true).show();
            return false;
        }
        else if (timeslot.equalsIgnoreCase("Please select...")) {
            Toasty.warning(mContext,"Please select time slot" , Toast.LENGTH_SHORT, true).show();
            return false;
        }
        return true;
    }


}
