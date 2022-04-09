package com.example.visitefacile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.visitefacile.Database.FlightDao;
import com.example.visitefacile.Database.FlightDatabase;
import com.example.visitefacile.Database.UserDao;
import com.example.visitefacile.Database.UserDatabase;
import com.example.visitefacile.adapter.FlightEntity;
import com.example.visitefacile.adapter.UserEntity;
import com.example.visitefacile.databinding.ActivityFlightBookingBinding;

import java.util.Calendar;

public class flight_booking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        FlightEntity flightEntity = new FlightEntity();
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

            if (edtTextFrom.getText().toString().isEmpty()) {
                Toast.makeText(this, "Kindly fill departing place", Toast.LENGTH_SHORT).show();
            } else if (edtTextTo.getText().toString().isEmpty()) {
                Toast.makeText(this, "Kindly fill Destination place", Toast.LENGTH_SHORT).show();
            } else if (edtNumBags.getText().toString().isEmpty()) {
                Toast.makeText(this, "Kindly fill number of bags", Toast.LENGTH_SHORT).show();
            } else if (edtNumBags.getText().toString().isEmpty()) {
                Toast.makeText(this, "Kindly fill number of bags", Toast.LENGTH_SHORT).show();
            } else {

                Bundle bundle = new Bundle();
                bundle.putString("from", edtTextFrom.getText().toString());
                bundle.putString("to", edtTextTo.getText().toString());
                bundle.putString("bags", edtNumBags.getText().toString());
                bundle.putString("adults", spinnerAdult.getSelectedItem().toString());
                bundle.putString("children", spinnerchild.getSelectedItem().toString());

                double price = (Integer.parseInt(spinnerAdult.getSelectedItem().toString()) * 300) + (Integer.parseInt(spinnerchild.getSelectedItem().toString()) * 100) + (Integer.parseInt(edtNumBags.getText().toString())*20.5);

                @SuppressLint("WrongConstant") SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("UserProfileSP",MODE_APPEND);

                flightEntity.setUserId(sharedPref.getString("userId",""));
                flightEntity.setFrom(edtTextFrom.getText().toString());
                flightEntity.setTo(edtTextTo.getText().toString());
                flightEntity.setPrice(price);
                bundle.putDouble("price", price);
                FlightDatabase flightDatabase = FlightDatabase.getFlightDatabase(getApplicationContext());
                FlightDao flightDao = flightDatabase.flightDao();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        flightDao.bookFlight(flightEntity);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), "Flight data stored!", Toast.LENGTH_SHORT).show();

                            }

                        });
                    }

                }).start();

                Intent intent = new Intent(flight_booking.this, Ticket_QR.class);

                intent.putExtras(bundle);

                startActivity(intent);

            }
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