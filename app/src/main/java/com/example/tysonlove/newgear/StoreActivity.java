package com.example.tysonlove.newgear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        final Button btnSubmitLogOut = findViewById(R.id.btnLogOut);


        btnSubmitLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent logInIntent = new Intent(StoreActivity.this, MainActivity.class);

                StoreActivity.this.startActivity(logInIntent);
                Toast.makeText(getApplicationContext(), "logout success", Toast.LENGTH_LONG).show();

            }

        });

    }
}
