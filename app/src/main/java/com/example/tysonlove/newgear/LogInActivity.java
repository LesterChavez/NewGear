package com.example.tysonlove.newgear;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
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


    private final static String Tag = "validateMeth";
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Cursor cursor;
    DBSqlLight dbProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        openHelper = new DBSqlLight(this);

        final Button btnSubmitLogIn = findViewById(R.id.btnLogIn);
        final EditText txtEmailAddress = findViewById(R.id.txtEmailLogIn);
        final EditText txtPassword = findViewById(R.id.txtPasswordLogIn);


        btnSubmitLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (validateMeth()) {
                    db = openHelper.getReadableDatabase();

                    String email = txtEmailAddress.getText().toString();
                    String passWord = txtPassword.getText().toString();
                    Log.d(Tag, "Pre cursor ");

                    cursor = db.rawQuery("SELECT * FROM " + DBSqlLight.TABLE_REGISTER + "  WHERE " + DBSqlLight.COL_4 + "=? AND " + DBSqlLight.COL_5 + "=?", new String[]{passWord, email});
                    Log.d(Tag, "post cursor");

                    if (cursor != null) {
                        Log.d(Tag, "1sy if cursor not null ");

                        if (cursor.getCount() > 0) {
                            cursor.moveToNext();
                            Log.d(Tag, "2nd if cursor.getCount is greater than 0  ");
                            Intent logInIntent = new Intent(LogInActivity.this, StoreActivity.class);

                            LogInActivity.this.startActivity(logInIntent);
                            Toast.makeText(getApplicationContext(), "login success", Toast.LENGTH_LONG).show();
                        } else {
                            Log.d(Tag, "3rd if error ");

                            Toast.makeText(getApplicationContext(), "ooops", Toast.LENGTH_LONG).show();
                        }


                    }

                }


            }

            private boolean validateMeth() {
                int counter = 0;
                if (txtEmailAddress.getText().toString().trim().length() < 0 || !Patterns.EMAIL_ADDRESS.matcher(txtEmailAddress.getText().toString().trim()).matches()) {
                    txtEmailAddress.setError("Format must be something@something.something");

                    counter++;
                    Log.d(Tag, "counter in email is " + counter);
                }

                if (txtPassword.getText().toString().length() == 0) {
                    txtPassword.setError("Password must not be blank");
                    counter++;
                    Log.d(Tag, "counter in pass is " + counter);

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

        dbProducts = new DBSqlLight(LogInActivity.this);
        dbProducts.AddProducts(new ProductsActivity("rodeOne", "reelOne", "lureOne"));


    }


}


