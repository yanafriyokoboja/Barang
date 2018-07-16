package com.example.yanafriyoko.barang.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetJenis {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Jenis> listDataJenis;
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
    public List<Jenis> getListDataJenis() {
        return listDataJenis;
    }
    public void setListDataJenis(List<Jenis> listDataJenis) {
        this.listDataJenis = listDataJenis;
    }
}
