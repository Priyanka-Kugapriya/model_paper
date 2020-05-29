package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class ProfileManagement extends AppCompatActivity {

    EditText username, dob, password ;
    Button add, update;
    RadioButton male, female;
    String gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_management);

        username = findViewById(R.id.editN);
        dob = findViewById(R.id.editD);
        password = findViewById(R.id.editP);
        add = findViewById(R.id.add_btn);
        male = findViewById(R.id.radioButton);
        female = findViewById(R.id.radioButton2);
        update = findViewById(R.id.upd_btn);

        buttonClickActivity();

    }

    private void buttonClickActivity() {
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EditProfile.class);
                startActivity(intent);
            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (male.isChecked()){
                    gender = "Male";
                }
                else {
                    gender = "Female";
                }

                DBHelper dbHandler = new DBHelper(getApplicationContext());
                long newID = dbHandler.addInfo(username.getText().toString(),dob.getText().toString(),password.getText().toString(),gender);
                Toast.makeText(ProfileManagement.this, "User Added. User ID: "+ newID, Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(),EditProfile.class);
                startActivity(i);
                username.setText(null);
                dob.setText(null);
                password.setText(null);
                male.setChecked(true);
                female.setChecked(false);


            }
        });



    }
}
