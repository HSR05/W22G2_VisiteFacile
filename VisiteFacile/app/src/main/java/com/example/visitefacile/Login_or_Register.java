package com.example.visitefacile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.visitefacile.databinding.ActivityLoginOrRegisterBinding;

public class Login_or_Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login_or_register);

        ActivityLoginOrRegisterBinding binding = ActivityLoginOrRegisterBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        Button loginBtn = binding.btnLoginApp;
        Button registerBtn = binding.btnRegisterApp;

        loginBtn.setOnClickListener((View view) -> {

            Intent intent = new Intent(Login_or_Register.this,LoginActivity.class);
            startActivity(intent);

        });

        registerBtn.setOnClickListener((View view) -> {

            Intent intent = new Intent(Login_or_Register.this,RegisterActivity.class);
            startActivity(intent);

        });


    }
}