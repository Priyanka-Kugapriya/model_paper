package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class EditProfile extends AppCompatActivity {

    Button ser,del,edit;
    EditText name,pass,date;
    RadioButton male, female;
    String gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        name = findViewById(R.id.editName);
        date = findViewById(R.id.editDate);
        pass = findViewById(R.id.editPass);
        edit = findViewById(R.id.edit_btn);
        del = findViewById(R.id.del_btn);
        ser = findViewById(R.id.ser_btn);
        male = findViewById(R.id.radioButton3);
        female = findViewById(R.id.radioButton4);

        ser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBHelper dbHandler = new DBHelper(getApplicationContext());
                List user = dbHandler.readAllInfo(name.getText().toString());

                if (user.isEmpty()){
                    Toast.makeText(EditProfile.this, "No User", Toast.LENGTH_SHORT).show();
                    name.setText(null);
                }
                else {

                    Toast.makeText(EditProfile.this, "User Found! User: "+user.get(0).toString(), Toast.LENGTH_SHORT).show();
                    name.setText(user.get(0).toString());
                    date.setText(user.get(1).toString());
                    pass.setText(user.get(2).toString());
                    if (user.get(3).toString().equals("Male")){
                        male.setChecked(true);
                    }
                    else {
                        female.setChecked(true);
                    }


                }

            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (male.isChecked()){
                    gender = "Male";
                }
                else {
                    gender = "Female";
                }
                DBHelper dbHandler = new DBHelper(getApplicationContext());

                Boolean status = dbHandler.updateInfo(name.getText().toString(),date.getText().toString(),pass.getText().toString(),gender);
                if (status){
                    Toast.makeText(EditProfile.this, "User Updated", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(EditProfile.this, "Update Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBHelper dbHandler = new DBHelper(getApplicationContext());
                dbHandler.deleteInfo(name.getText().toString());

                Toast.makeText(EditProfile.this, "User Deleted", Toast.LENGTH_SHORT).show();

                name.setText(null);
                date.setText(null);
                pass.setText(null);
                male.setChecked(false);
                female.setChecked(false);
            }
        });

    }

}
