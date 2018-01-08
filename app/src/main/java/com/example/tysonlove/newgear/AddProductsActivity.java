package com.example.tysonlove.newgear;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddProductsActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_products);

        openHelper = new DBSqlLight(this);

        final Button btnAddProduct = findViewById(R.id.btnSubmitProduct);
        final EditText txtRod = findViewById(R.id.txtAddRod);
        final EditText txtReel = findViewById(R.id.txtAddReel);
        final EditText txtLure = findViewById(R.id.txtAddLure);

        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db = openHelper.getWritableDatabase();
                String addRoddb = txtRod.getText().toString();
                String addReeldb = txtReel.getText().toString();
                String addLuredb = txtLure.getText().toString();

                insertData(addRoddb, addReeldb, addLuredb);
                Toast.makeText(getApplicationContext(), "Added products successfully", Toast.LENGTH_LONG).show();

                Intent addProductsIntent = new Intent(AddProductsActivity.this, StoreActivity.class);

                AddProductsActivity.this.startActivity(addProductsIntent);

                }
        });

    }
    public void insertData(String addRoddb, String addReeldb, String addLuredb) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(DBSqlLight.COL_2, addRoddb);
        contentValues.put(DBSqlLight.COL_3, addReeldb);
        contentValues.put(DBSqlLight.COL_4, addLuredb);


        long id = db.insert(DBSqlLight.TABLE_PRODUCTS, null, contentValues);

    }

        //dbProducts = new DBSqlLight(AddProductsActivity.this);
        //dbProducts.AddProducts(new ProductsActivity(txtRod.getText().toString(), txtReel.getText().toString(), txtLure.getText().toString()));

    }

