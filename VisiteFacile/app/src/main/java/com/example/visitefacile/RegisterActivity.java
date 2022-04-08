package com.example.visitefacile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.visitefacile.Database.UserDao;
import com.example.visitefacile.Database.UserDatabase;
import com.example.visitefacile.adapter.UserEntity;

public class RegisterActivity extends AppCompatActivity {

    EditText userId,password,name;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userId = findViewById(R.id.editTxtRegister);
        password = findViewById(R.id.editTxtRegisterPassword);
        name = findViewById(R.id.editTxtName);
        register = findViewById(R.id.btnRegister);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserEntity userEntity = new UserEntity();
                userEntity.setUserId(userId.getText().toString());
                userEntity.setPassword(password.getText().toString());
                userEntity.setName(name.getText().toString());
                if (validateInput(userEntity)){
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    UserDao userDao = userDatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                         userDao.registerUser(userEntity);
                         runOnUiThread(new Runnable() {
                             @Override
                             public void run() {
                                 Toast.makeText(getApplicationContext(), "User Registered!", Toast.LENGTH_SHORT).show();


                             }

                         });
                        }

                    }).start();
                    startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                }else {
                    Toast.makeText(getApplicationContext(), "Please fill all Fields!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private Boolean validateInput(UserEntity userEntity){
        if (userEntity.getName().isEmpty() || userEntity.getPassword().isEmpty() || userEntity.getName().isEmpty()){
        return false;
        }
        return true;
    }
}