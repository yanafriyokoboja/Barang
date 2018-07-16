package com.example.yanafriyoko.barang.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yanafriyoko.barang.R;
import com.example.yanafriyoko.barang.model.PostPutDelJenis;
import com.example.yanafriyoko.barang.model.PostPutDelMerek;
import com.example.yanafriyoko.barang.rest.ApiClient;
import com.example.yanafriyoko.barang.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahMerekActivity extends AppCompatActivity {
    EditText idMerekBarang,namaMerekBarang;
    Button btnSimpan;
    ApiInterface mApiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_merek);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("tambah merek");
        toolbar.setTitleTextColor(Color.WHITE);

        idMerekBarang =(EditText)findViewById(R.id.IdTambahMerekBarang);
        namaMerekBarang =(EditText)findViewById(R.id.NamaTambahMerekBarang);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btnSimpan =(Button)findViewById(R.id.btnTambahMerekBarang);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelMerek> postMerekCall = mApiInterface.postMerekBarang(idMerekBarang.getText().toString(), namaMerekBarang.getText().toString());
                postMerekCall.enqueue(new Callback<PostPutDelMerek>() {
                    @Override
                    public void onResponse(Call<PostPutDelMerek> call, Response<PostPutDelMerek> response) {
                        Toast.makeText(getApplicationContext(), "Sukses", Toast.LENGTH_SHORT).show();
                        MerekActivity.ma.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelMerek> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
