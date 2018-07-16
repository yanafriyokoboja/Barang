package com.example.yanafriyoko.barang.model;


import com.google.gson.annotations.SerializedName;

public class PostPutDelBarang {

    @SerializedName("status")
    String status;
    @SerializedName("result")
    Barang mBarang;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Barang getmBarang() {
        return mBarang;
    }
    public void setmBarang(Barang barang) {
        mBarang = barang;
    }
}