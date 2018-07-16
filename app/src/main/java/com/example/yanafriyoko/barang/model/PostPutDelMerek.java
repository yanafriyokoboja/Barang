package com.example.yanafriyoko.barang.model;

import com.google.gson.annotations.SerializedName;

public class PostPutDelMerek {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Merek mMerek;
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

    public Merek getmMerek() {
        return mMerek;
    }

    public void setmMerek(Merek merek) {
        mMerek = merek;
    }
}
