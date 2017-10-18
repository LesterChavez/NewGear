package com.example.tysonlove.newgear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class LogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        Button btnSubmitLogIn = (Button) findViewById(R.id.btnLogIn);
        final EditText txtEmailAddress = (EditText) findViewById(R.id.txtEmailLogIn);
        final EditText txtPasswordLogIn = (EditText) findViewById(R.id.txtPasswordLogIn);

        btnSubmitLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtEmailAddress.getText().toString().length() < 0 || !Patterns.EMAIL_ADDRESS.matcher(txtEmailAddress.getText().toString()).matches()) {

                    txtEmailAddress.setError("Format must be something@something.something");
                }


                if (txtPasswordLogIn.getText().toString().length() == 0) {
                    txtPasswordLogIn.setError("Password must not be blank");
                } else {
                    Intent logInIntent = new Intent(LogInActivity.this, StoreActivity.class);

                    LogInActivity.this.startActivity(logInIntent);
                }


            }
        });

    }
}
