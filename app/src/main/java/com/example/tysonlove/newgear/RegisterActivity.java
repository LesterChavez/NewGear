package com.example.tysonlove.newgear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.widget.Button;
import android.widget.CheckBox;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class RegisterActivity extends AppCompatActivity {
    private final static String Tag = "validateMethRegClass";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final CheckBox checkBox = (CheckBox) findViewById(R.id.chBox);
        checkBox.setChecked(false);
        final EditText fName = (EditText) findViewById(R.id.txtFirstName);
        final EditText lName = (EditText) findViewById(R.id.txtLastName);
        final EditText pWord = (EditText) findViewById(R.id.txtPassword);
        final EditText phNum = (EditText) findViewById(R.id.txtPhoneNumber);
        final EditText eMail = (EditText) findViewById(R.id.txtEmailAddress);


        final boolean checkBoxState = checkBox.isChecked();


        Button btnSubmit = (Button) findViewById(R.id.btnRegisterSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validateMethRegClass()) {
                    Log.d(Tag, "meth on call if true?? ");

                    Intent logInIntent = new Intent(RegisterActivity.this, StoreActivity.class);

                    RegisterActivity.this.startActivity(logInIntent);
                } else {
                    Toast.makeText(getApplicationContext(), "Error all fields must be entered", Toast.LENGTH_LONG).show();

                }

            }

            private boolean validateMethRegClass() {
                int counter = 0;
                if (fName.getText().toString().trim().isEmpty()) {

                    fName.setError("fist name must not be blank");
                    counter++;
                    Log.d(Tag, "fname blank " + counter);

                }
                if (lName.getText().toString().trim().isEmpty()) {
                    lName.setError("last name must not be blank");
                    counter++;
                    Log.d(Tag, "lname blank " + counter);

                }
                if (pWord.getText().toString().trim().isEmpty()) {
                    pWord.setError("Password must not be blank");
                    counter++;
                    Log.d(Tag, "pWord blank " + counter);

                }
                if (phNum.getText().toString().trim().isEmpty()) {
                    phNum.setError("Name must not be blank");
                    counter++;
                    Log.d(Tag, "ph# blank " + counter);

                }
                if (eMail.getText().toString().trim().isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(eMail.getText().toString().trim()).matches()) {
                    eMail.setError("Format must be something@something.something");
                    counter++;
                    Log.d(Tag, "Email blank " + counter);

                }
                if (!checkBox.isChecked()) {
                    // Toast.makeText(getApplicationContext(), "Come back when you are over 18", Toast.LENGTH_LONG).show();
                    //  Intent btnSubmitIntent = new Intent(RegisterActivity.this, StoreActivity.class);
                    counter++;
                    Log.d(Tag, "ch Box blank " + counter);


                }
                if (counter > 0) {
                    return false;
                } else {
                    return true;

                }

            }
        });


    }


}
