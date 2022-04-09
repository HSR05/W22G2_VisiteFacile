package com.example.visitefacile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.visitefacile.Database.UserDao;
import com.example.visitefacile.Database.UserDatabase;
import com.example.visitefacile.adapter.UserEntity;

public class LoginActivity extends AppCompatActivity {

    EditText userId , password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    userId = findViewById(R.id.editTxtLoginId);
    password = findViewById(R.id.editTxtPassword);
    login = findViewById(R.id.btnLogin);

    login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        String userIdText = userId.getText().toString();
        String passwordText = password.getText().toString();
        if (userIdText.isEmpty() || passwordText.isEmpty()){
            Toast.makeText(LoginActivity.this, "Please fill all Fields!", Toast.LENGTH_SHORT).show();
        }else {
            UserDatabase db = UserDatabase.getUserDatabase(getApplicationContext());
            UserDao userDao = db.userDao();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    UserEntity userEntity = userDao.login(userIdText,passwordText);
                    if (userEntity == null) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(LoginActivity.this, "Invalid Credentials!", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }else {
                        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("UserProfileSP",MODE_PRIVATE);
                        SharedPreferences.Editor myEditor = sharedPreferences.edit();
                        myEditor.putString("userId", userEntity.getUserId());
                        myEditor.putString("name", userEntity.getName());
                        myEditor.commit();
                     String name = userEntity.getName();
                     startActivity(new Intent(LoginActivity.this,MainActivity.class).putExtra("name",name));
                    }
                }
            }).start();
        }
        }
    });

    }
}