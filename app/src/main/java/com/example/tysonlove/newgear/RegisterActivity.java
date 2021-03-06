package com.example.tysonlove.newgear;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
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
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        openHelper = new DBSqlLight(this);

        final CheckBox checkBox = findViewById(R.id.chBox);
        checkBox.setChecked(false);
        final EditText fName = findViewById(R.id.txtFirstName);
        final EditText lName = findViewById(R.id.txtLastName);
        final EditText pWord = findViewById(R.id.txtPassword);
        final EditText phNum = findViewById(R.id.txtPhoneNumber);
        final EditText eMail = findViewById(R.id.txtEmailAddress);


        Button btnSubmit = findViewById(R.id.btnRegisterSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (validateMethRegClass()) {

                    db = openHelper.getWritableDatabase();
                    String fNameDb = fName.getText().toString();
                    String lNameDb = lName.getText().toString();
                    String pWordDb = pWord.getText().toString();
                    String eMailDb = eMail.getText().toString();
                    String phNumDb = phNum.getText().toString();
                    insertData(fNameDb, lNameDb, pWordDb, eMailDb, phNumDb);
                    Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_LONG).show();

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

                }
                if (lName.getText().toString().trim().isEmpty()) {
                    lName.setError("last name must not be blank");
                    counter++;

                }
                if (pWord.getText().toString().trim().isEmpty()) {
                    pWord.setError("Password must not be blank");
                    counter++;

                }
                if (phNum.getText().toString().trim().isEmpty()) {
                    phNum.setError("Name must not be blank");
                    counter++;

                }
                if (eMail.getText().toString().trim().isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(eMail.getText().toString().trim()).matches()) {
                    eMail.setError("Format must be something@something.something");
                    counter++;

                }
                if (!checkBox.isChecked()) {
                    // Toast.makeText(getApplicationContext(), "Come back when you are over 18", Toast.LENGTH_LONG).show();
                    //  Intent btnSubmitIntent = new Intent(RegisterActivity.this, StoreActivity.class);
                    counter++;


                }
                return counter <= 0;

            }
        });

    }

    public void insertData(String fNameDb, String lNameDb, String pWordDb, String eMailDb, String phNumDb) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(DBSqlLight.COL_2, fNameDb);
        contentValues.put(DBSqlLight.COL_3, lNameDb);
        contentValues.put(DBSqlLight.COL_4, pWordDb);
        contentValues.put(DBSqlLight.COL_5, eMailDb);
        contentValues.put(DBSqlLight.COL_6, phNumDb);

        long id = db.insert(DBSqlLight.TABLE_REGISTER, null, contentValues);

    }


}
