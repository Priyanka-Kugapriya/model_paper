package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    Button register,login;
    TextView userName, password;
    EditText user,pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        register = findViewById(R.id.reg_btn);
        login = findViewById(R.id.lgn_btn);
        userName = findViewById(R.id.userText);
        password = findViewById(R.id.textPassword);
        user = findViewById(R.id.textUser);
        pass = findViewById(R.id.textPass);



        buttonClickActivity();

    }

    private void buttonClickActivity() {
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ProfileManagement.class);
                startActivity(intent);
            }
        });



    }

}
