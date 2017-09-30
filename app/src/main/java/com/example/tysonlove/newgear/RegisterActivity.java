package com.example.tysonlove.newgear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.view.View;
import android.widget.Toast;


public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final CheckBox checkBox = (CheckBox) findViewById(R.id.chBox);
        checkBox.setChecked(false);
        boolean checkBoxState = checkBox.isChecked();


        Button btnSubmit = (Button) findViewById(R.id.btnRegisterSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (checkBox.isChecked())
                    Toast.makeText(getApplicationContext(), "You have successfully registered", Toast.LENGTH_LONG).show();


                Intent btnSubmitIntent = new Intent(RegisterActivity.this, StoreActivity.class);


                RegisterActivity.this.startActivity(btnSubmitIntent);


            }
        });


    }
}
