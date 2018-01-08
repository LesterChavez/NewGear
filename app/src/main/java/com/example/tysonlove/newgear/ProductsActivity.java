package com.example.tysonlove.newgear;

/**
 * Created by lchavez9669 on 1/8/2018.
 */

public class ProductsActivity {
    String rodeONe;
    String reelOne;
    String lureOne;


    int id;

    public ProductsActivity(String rodeONe, String reelOne, String lureOne){
        this.reelOne = reelOne;
        this.rodeONe = rodeONe;
        this.lureOne = lureOne;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRodeONe() {
        return rodeONe;
    }

    public void setRodeONe(String rodeONe) {
        this.rodeONe = rodeONe;
    }

    public String getReelOne() {
        return reelOne;
    }

    public void setReelOne(String reelOne) {
        this.reelOne = reelOne;
    }

    public String getLureOne() {
        return lureOne;
    }

    public void setLureOne(String lureOne) {
        this.lureOne = lureOne;
    }



}
