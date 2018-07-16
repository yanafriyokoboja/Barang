package com.example.yanafriyoko.barang.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetMerek {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Merek> listDataMerek;
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
    public List<Merek> getListDataMerek() {
        return listDataMerek;
    }
    public void setListDataJenis(List<Merek> listDataMerek) {
        this.listDataMerek = listDataMerek;
    }
}
