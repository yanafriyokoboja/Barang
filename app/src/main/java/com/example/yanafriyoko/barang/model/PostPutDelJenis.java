package com.example.yanafriyoko.barang.model;


import com.example.yanafriyoko.barang.model.Jenis;
import com.google.gson.annotations.SerializedName;

public class PostPutDelJenis {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Jenis mJenis;
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

    public Jenis getmJenis() {
        return mJenis;
    }

    public void setmJenis(Jenis jenis) {
        mJenis = jenis;
    }
}