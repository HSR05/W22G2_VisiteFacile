package com.example.visitefacile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;

public class flight_booking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        EditText date;
        final DatePickerDialog[] datePickerDialog = new DatePickerDialog[1];

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_booking);

        date = (EditText) findViewById(R.id.deptDate);
        // perform click event on edit text
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog[0] = new DatePickerDialog(flight_booking.this,
                        (view, year, monthOfYear, dayOfMonth) -> {
                            // set day of month , month and year value in the edit text
                            date.setText(dayOfMonth + "/"
                                    + (monthOfYear + 1) + "/" + year);

                        }, mYear, mMonth, mDay);
                datePickerDialog[0].show();
            }
        });

    }

    public void confirmOnClick(View view) {
    }
}