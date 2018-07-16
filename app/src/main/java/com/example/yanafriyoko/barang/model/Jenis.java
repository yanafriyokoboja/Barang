package com.example.yanafriyoko.barang.model;

import com.google.gson.annotations.SerializedName;

public class Jenis {
    @SerializedName("id_jenis_barang")
    private String id_jenis_barang;
    @SerializedName("nama_jenis_barang")
    private String nama_jenis_barang;

    public Jenis(){}

    public Jenis(String id_jenis_barang, String nama_jenis_barang) {
        this.id_jenis_barang = id_jenis_barang;
        this.nama_jenis_barang = nama_jenis_barang;
    }
    public String getIdJenis() {
        return id_jenis_barang;
    }

    public void setIdJenis(String id_jenis_barang) {
        this.id_jenis_barang = id_jenis_barang;
    }

        public String getNamaJenis() {
        return nama_jenis_barang;
    }

    public void setNamaJenis(String nama_jenis_barang) {
        this.nama_jenis_barang = nama_jenis_barang;
    }
}
