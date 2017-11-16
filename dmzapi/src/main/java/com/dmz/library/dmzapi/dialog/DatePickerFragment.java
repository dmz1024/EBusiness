package com.dmz.library.dmzapi.dialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by dengmingzhi on 16/5/22.
 */
public class DatePickerFragment extends DialogFragment implements
        DatePickerDialog.OnDateSetListener {
    private DateListener dateListener;

    public static DatePickerFragment getInstance(String date) {
        Bundle bundle = new Bundle();
        if (TextUtils.isEmpty(date)) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH) + 1;
            int day = c.get(Calendar.DAY_OF_MONTH);
            bundle.putString("date", year + "-" + month + "-" + day);
        } else {
            bundle.putString("date", date);
        }
        DatePickerFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.setArguments(bundle);
        return datePickerFragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        String[] dates = bundle.getString("date").split("-");
        int year = Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]) - 1;
        int day = Integer.parseInt(dates[2]);
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        if (dateListener != null) {
            dateListener.date(year, month + 1, day);
        }

    }

    public DatePickerFragment setDateListener(DateListener dateListener) {
        this.dateListener = dateListener;
        return this;
    }

    public interface DateListener {
        void date(int year, int month, int day);
    }

}
