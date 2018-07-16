package com.example.yanafriyoko.barang.model;

import com.google.gson.annotations.SerializedName;

public class Merek {
    @SerializedName("id_merek_barang")
    private String id_merek_barang;
    @SerializedName("nama_merek_barang")
    private String nama_merek_barang;

    public Merek(){}

    public Merek(String id_merek_barang, String nama_merek_barang) {
        this.id_merek_barang = id_merek_barang;
        this.nama_merek_barang = nama_merek_barang;
    }
    public String getIdMerek() {
        return id_merek_barang;
    }

    public void setIdMerek(String id_merek_barang) {
        this.id_merek_barang = id_merek_barang;
    }

    public String getNamaMerek() {
        return nama_merek_barang;
    }

    public void setNamaMerek(String nama_merek_barang) {
        this.nama_merek_barang = nama_merek_barang;
    }
}
