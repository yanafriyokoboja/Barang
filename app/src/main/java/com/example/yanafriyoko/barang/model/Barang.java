package com.example.yanafriyoko.barang.model;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Yan afriyoko on 6/29/2018.
 */


public class Barang {

    @SerializedName("id_barang")
    private String id_barang;
    @SerializedName("nama_barang")
    private String nama_barang;
    @SerializedName("nama_jenis_barang")
    private String nama_jenis_barang;
    @SerializedName("nama_merek_barang")
    private String nama_merek_barang;
    @SerializedName("stok")
    private Integer stok;

    public Barang(){}

    public Barang(String id_barang, String nama_barang, String nama_jenis_barang, String nama_merek_barang,Integer stok) {
        this.id_barang = id_barang;
        this.nama_barang = nama_barang;
        this.nama_jenis_barang = nama_jenis_barang;
        this.nama_merek_barang = nama_merek_barang;
        this.stok = stok;
    }

    public String getIdBarang() {
        return id_barang;
    }

    public void setIdBarang(String id_barang) {
        this.id_barang = id_barang;
    }

    public String getNamaBarang() {
        return nama_barang;
    }

    public void setNamaBarang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getIdJenisBarang() {
        return nama_jenis_barang;
    }

    public void setIdJenisBarang(String nama_jenis_barang) {
        this.nama_jenis_barang = nama_jenis_barang;
    }
    public String getIdMerekBarang() {
        return nama_merek_barang;
    }

    public void setIdMerekBarang(String nama_merek_barang) {
        this.nama_merek_barang = nama_merek_barang;
    }
    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

}