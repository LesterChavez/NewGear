package com.example.tysonlove.newgear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;


public class LogInActivity extends AppCompatActivity {
    //    final Button btnSubmitLogIn = (Button) findViewById(R.id.btnLogIn);
//    final EditText txtEmailAddress = (EditText) findViewById(R.id.txtEmailLogIn);
//    final EditText txtPasswordLogIn = (EditText) findViewById(R.id.txtPasswordLogIn);
    // public int counter = 0;
    private final static String Tag = "validateMeth";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        final Button btnSubmitLogIn = (Button) findViewById(R.id.btnLogIn);
        final EditText txtEmailAddress = (EditText) findViewById(R.id.txtEmailLogIn);
        final EditText txtPasswordLogIn = (EditText) findViewById(R.id.txtPasswordLogIn);


        btnSubmitLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // validateMeth();
                if (validateMeth()) {
                    Log.d(Tag, "meth on call if true?? ");

                    Intent logInIntent = new Intent(LogInActivity.this, StoreActivity.class);

                    LogInActivity.this.startActivity(logInIntent);
                } else {
                    Log.d(Tag, "meth on call if false?? ");

                    Toast.makeText(getApplicationContext(), "Error all fields must be entered", Toast.LENGTH_LONG).show();


//
                }


            }

            private boolean validateMeth() {
                int counter = 0;
                if (txtEmailAddress.getText().toString().trim().length() < 0 || !Patterns.EMAIL_ADDRESS.matcher(txtEmailAddress.getText().toString().trim()).matches()) {
                    txtEmailAddress.setError("Format must be something@something.something");

                    counter++;
                    Log.d(Tag, "counter in email is " + counter);
                }

                if (txtPasswordLogIn.getText().toString().length() == 0) {
                    txtPasswordLogIn.setError("Password must not be blank");
                    counter++;
                    Log.d(Tag, "counter in pass is " + counter);

                    //  btnSubmitLogIn.setEnabled(false);
                    //  btnSubmitLogIn.setEnabled(false);
                }
                if (counter > 0) {
                    Log.d(Tag, "returned false, counter is  " + counter);

                    return false;


                } else {

                    counter = 0;
                    Log.d(Tag, "returned true, counter is  " + counter);

                    return true;
                }


            }

        });


    }

//    private boolean validateMeth() {
//
//        if (txtEmailAddress.getText().toString().trim().length() < 0 || !Patterns.EMAIL_ADDRESS.matcher(txtEmailAddress.getText().toString().trim()).matches()) {
//            txtEmailAddress.setError("Format must be something@something.something");
//            counter = 0;
//            counter++;
//        }
//
//        if (txtPasswordLogIn.getText().toString().length() == 0) {
//            txtPasswordLogIn.setError("Password must not be blank");
//            counter++;
//            //  btnSubmitLogIn.setEnabled(false);
//            //  btnSubmitLogIn.setEnabled(false);
//        }
//        if (counter >= 1) {
//            return false;
//        } else {
//            return true;
//        }
//
//
//    }
}


