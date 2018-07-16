package com.example.yanafriyoko.barang.rest;

/**
 * Created by root on 2/3/17.
 */

import com.example.yanafriyoko.barang.model.PostPutDelBarang;
import com.example.yanafriyoko.barang.model.PostPutDelJenis;
import com.example.yanafriyoko.barang.model.GetBarang;
import com.example.yanafriyoko.barang.model.GetJenis;
import com.example.yanafriyoko.barang.model.GetMerek;
import com.example.yanafriyoko.barang.model.PostPutDelMerek;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {

    @GET("data_barang")
    Call<GetBarang> getBarang();

    @GET("jenis_barang")
    Call<GetJenis> getJenis();

    @GET("merek_barang")
    Call<GetMerek> getMerek();


    @FormUrlEncoded
    @POST("data_barang")
    Call<PostPutDelBarang> postBarang(@Field("nama_barang") String nama_barang,
                                      @Field("id_jenis_barang") String id_jenis_barang,
                                      @Field("id_merek_barang") String id_merek_barang,
                                      @Field("stok") Integer stok);

    @FormUrlEncoded
    @POST("Jenis_barang")
    Call<PostPutDelJenis> postJenisBarang (@Field("id_jenis_barang") String id_jenis_barang,
                                           @Field("nama_jenis_barang") String nama_jenis_barang);

    @FormUrlEncoded
    @POST("Merek_barang")
    Call<PostPutDelMerek> postMerekBarang(@Field("id_merek_barang") String id_merek_barang,
                                   @Field("nama_merek_barang") String nama_merek_barang);




    @FormUrlEncoded
    @PUT("data_barang")
    Call<PostPutDelBarang> putBarang (@Field("id_barang") String id_barang,
                              @Field("nama_barang") String nama_barang);

    @FormUrlEncoded
    @PUT("jenis_barang")
    Call<PostPutDelJenis> putJenisBarang(@Field("id_jenis_barang") String id_jenis_barang,
                                         @Field("nama_jenis_barang") String nama_jenis_barang);
    @FormUrlEncoded
    @PUT("merek_barang")
    Call<PostPutDelMerek> putMerekBarang(@Field("id_merek_barang") String id_merek_barang,
                                  @Field("nama_merek_barang") String nama_merek_barang);


    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "data_barang", hasBody = true)
    Call<PostPutDelBarang> deleteBarang(@Field("id_barang") String id);


    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "Jenis_barang", hasBody = true)
    Call<PostPutDelJenis> deleteJenisBarang(@Field("id_jenis_barang") String id_jenis_barang);


    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "Merek_barang", hasBody = true)
    Call<PostPutDelMerek> deleteMerekBarang(@Field("id_merek_barang") String id_merek_barang);
}
