package com.navgurukul.hisaab.Expense;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;

public class LandingFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    public LandingFragment (){
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this,year,month,day);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int date) {

        LandingPage activity=(LandingPage) getActivity();
        activity.rate(year,month,date);


    }
}
