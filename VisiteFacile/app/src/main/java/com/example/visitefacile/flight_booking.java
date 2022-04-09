package com.example.visitefacile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.visitefacile.databinding.ActivityFlightBookingBinding;

import java.util.Calendar;

public class flight_booking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        EditText date;
        final DatePickerDialog[] datePickerDialog = new DatePickerDialog[1];

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_flight_booking);

        ActivityFlightBookingBinding binding = ActivityFlightBookingBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        Button btnConfirm = binding.btnConfirm;
        EditText edtTextFrom = binding.editTxtFrom;
        EditText edtTextTo = binding.editTxtTo;
        EditText edtNumBags = binding.editTxtNumBags;
        Spinner spinnerAdult = binding.spinnerAdult;
        Spinner spinnerchild = binding.spinnerChild;

        btnConfirm.setOnClickListener((View view) -> {

            if(edtTextFrom.getText().toString().isEmpty()){
                Toast.makeText(this, "Kindly fill departing place", Toast.LENGTH_SHORT).show();
            }

            Bundle bundle = new Bundle();
            bundle.putString("from",edtTextFrom.getText().toString());
            bundle.putString("to",edtTextTo.getText().toString());
            bundle.putString("bags",edtNumBags.getText().toString());
            bundle.putString("adults",spinnerAdult.getSelectedItem().toString());
            bundle.putString("children",spinnerchild.getSelectedItem().toString());

            Intent intent = new Intent(flight_booking.this,Ticket_QR.class);

            intent.putExtras(bundle);

            startActivity(intent);


        });

        date = (EditText) findViewById(R.id.datePickerDept);
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