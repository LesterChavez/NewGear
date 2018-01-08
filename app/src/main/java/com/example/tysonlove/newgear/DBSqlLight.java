package com.example.tysonlove.newgear;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by TysonLove on 10/26/2017.
 */


public class DBSqlLight extends SQLiteOpenHelper {
    // SQLiteDatabase db;
    public static final String DATABASE_REGISTER3 = "register3.db";
   // public static final String DATABASE_REGISTER2 = "register2.db";
    //public static final String DATABASE_PRODUCTS = "products.db";
    //  public static final String DATABASE_PRICE = "price.db";

    public static final int DATABASE_VERSION = 1;

//sdfadf
    public static final String TABLE_REGISTER = "register";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "FirstName";
    public static final String COL_3 = "LastName";
    public static final String COL_4 = "Password";
    public static final String COL_5 = "Email";
    public static final String COL_6 = "Phone";


    public static final String TABLE_PRODUCTS = "Products";
    public static final String COL_1_products = "ID";
    public static final String COL_2_products = "Rod";
    public static final String COL_3_products = "Reel";
    public static final String COL_4_products = "Lures";

    public static final String TABLE_PRICE = "Price";
    public static final String COL_1_price = "ID";
    public static final String COL_2_price = "Price";


    // add the above agin

    public DBSqlLight(Context context) {
        super(context, DATABASE_REGISTER3, null, DATABASE_VERSION);
    }
    // super(context, DATABASE_NAME1, null, DATABASE_VERSION);}
    //this.context = context}
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REGISTER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRICE);


        onCreate(db);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_REGISTER + "(ID INTEGER PRIMARY KEY AUTOINCREMENT ,FirstName TEXT,LastName TEXT,Password TEXT,Email TEXT,Phone TEXT)");
        db.execSQL("CREATE TABLE " + TABLE_PRODUCTS + "(ID INTEGER PRIMARY KEY AUTOINCREMENT ,Rod TEXT,Reel TEXT,Lures TEXT)");
        db.execSQL("CREATE TABLE " + TABLE_PRICE + "(ID INTEGER PRIMARY KEY AUTOINCREMENT ,Price TEXT)");


    }

    public void AddProducts(ProductsActivity pa){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL_2_products, pa.getRodeONe());
        contentValues.put(COL_3_products, pa.getReelOne());
        contentValues.put(COL_4_products, pa.getLureOne());

        db.insert(TABLE_PRODUCTS, null,contentValues);
        db.close();

    }

    public ArrayList<ProductsActivity> getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<ProductsActivity> use= new ArrayList<ProductsActivity>();
        Cursor result = db.rawQuery("select * from "+TABLE_PRODUCTS , null);
        while(result.moveToNext()){
            use.add( new ProductsActivity(result.getString(result.getColumnIndex(COL_2_products)), result.getString(result.getColumnIndex(COL_3_products)),result.getString(result.getColumnIndex(COL_4_products))));

        }
        return use;
    }
}
