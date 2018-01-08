package com.example.tysonlove.newgear;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class StoreActivity extends AppCompatActivity {
    ListViewAdapter lva= null;
    ListView lv = null;
    DBSqlLight db= null;
    ArrayList<ProductsActivity> var = null;

Button addProdButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        db= new DBSqlLight(this);

        var=db.getData();
        lva= new ListViewAdapter(this,R.layout.listviewlayout,var);

        lv = (ListView) findViewById(R.id.lvid);
        lv.setAdapter(lva);

        final Button btnSubmitLogOut = findViewById(R.id.btnLogOut);
        final Button btnContactUs = (findViewById(R.id.btnContactUsEmail));
        final Button btnSms = (findViewById(R.id.btnTextPhone));


        btnSubmitLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent logInIntent = new Intent(StoreActivity.this, MainActivity.class);

                StoreActivity.this.startActivity(logInIntent);
                Toast.makeText(getApplicationContext(), "logout success", Toast.LENGTH_LONG).show();

            }

        });
        addProdButton= (Button) findViewById(R.id.btnAddProducts);
        addProdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AddProductPageIntent = new Intent(StoreActivity.this, AddProductsActivity.class);

                startActivity(AddProductPageIntent);
                

            }
        });

        btnContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "Lchavez9669@conestogac.on.ca", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subjet");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Email Body");
                startActivity(Intent.createChooser(emailIntent, "Send email"));

            }
        });


        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("sms", "1234567", null));

                startActivity(smsIntent);

            }
        });


    }
}
