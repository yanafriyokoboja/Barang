package com.example.yanafriyoko.barang.activity;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yanafriyoko.barang.R;
import com.example.yanafriyoko.barang.model.PostPutDelJenis;
import com.example.yanafriyoko.barang.rest.ApiClient;
import com.example.yanafriyoko.barang.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahJenisActivity extends AppCompatActivity {
    EditText idJenisBarang,namaJenisBarang;
    Button btnSimpan;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_jenis);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("tambah jenis");
        toolbar.setTitleTextColor(Color.WHITE);

        idJenisBarang =(EditText)findViewById(R.id.IdTambahJenisBarang);
        namaJenisBarang =(EditText)findViewById(R.id.NamaTambahJenisBarang);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btnSimpan =(Button)findViewById(R.id.btnTambahJenisBarang);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelJenis> postJenisCall = mApiInterface.postJenisBarang(idJenisBarang.getText().toString(), namaJenisBarang.getText().toString());
                postJenisCall.enqueue(new Callback<PostPutDelJenis>() {
                    @Override
                    public void onResponse(Call<PostPutDelJenis> call, Response<PostPutDelJenis> response) {
                        Toast.makeText(getApplicationContext(), "Sukses", Toast.LENGTH_SHORT).show();
                        JenisActivity.ma.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelJenis> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });


    }
}
