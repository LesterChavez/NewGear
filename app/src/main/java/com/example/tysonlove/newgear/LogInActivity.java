package com.example.tysonlove.newgear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        Button btnSubmitLogIn = (Button)findViewById(R.id.btnLogIn);
        final EditText txtEmailAddress = (EditText)findViewById(R.id.txtEmailLogIn);

        btnSubmitLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               if (txtEmailAddress.getText().length() > 0)
               {
                   Toast.makeText(getApplicationContext(), "You have successfully registered", Toast.LENGTH_LONG).show();
               }



                Intent logInIntent = new Intent(LogInActivity.this,StoreActivity.class);

                LogInActivity.this.startActivity(logInIntent);
            }
        });

    }
}
