package com.example.yanafriyoko.barang.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Yan afriyoko on 6/29/2018.
 */

public class GetBarang {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Barang> listDataBarang;
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
    public List<Barang> getListDataBarang() {
        return listDataBarang;
    }
    public void setListDataBarang(List<Barang> listDataBarang) {
        this.listDataBarang = listDataBarang;
    }
}
