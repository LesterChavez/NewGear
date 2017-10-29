package com.example.tysonlove.newgear;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by TysonLove on 10/29/2017.
 */

public class stetho extends Application {
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
