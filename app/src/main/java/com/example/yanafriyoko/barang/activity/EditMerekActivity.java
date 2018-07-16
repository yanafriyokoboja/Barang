package com.example.yanafriyoko.barang.activity;

import android.content.Intent;
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

public class EditMerekActivity extends AppCompatActivity {
    EditText idEditMerekBarang,namaEditMerekBarang;
    Button btUpdateMerek, btDelete;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_merek);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("edit merek");
        idEditMerekBarang = (EditText) findViewById(R.id.idEditMerekBarang);
        namaEditMerekBarang = (EditText) findViewById(R.id.namaEditMerekBarang);
        Intent mIntent = getIntent();
        idEditMerekBarang.setText(mIntent.getStringExtra("id_merek_barang"));
        idEditMerekBarang.setTag(idEditMerekBarang.getKeyListener());
        idEditMerekBarang.setKeyListener(null);
        namaEditMerekBarang.setText(mIntent.getStringExtra("nama_merek_barang"));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btUpdateMerek = (Button) findViewById(R.id.btnUpdateMerekBarang);
        btUpdateMerek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelMerek> updateMerekCall = mApiInterface.putMerekBarang(
                        idEditMerekBarang.getText().toString(),
                        namaEditMerekBarang.getText().toString());
                updateMerekCall.enqueue(new Callback<PostPutDelMerek>() {
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

        btDelete = (Button) findViewById(R.id.btnDeleteMerekBarang);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (idEditMerekBarang.getText().toString().trim().isEmpty()==false){
                    Call<PostPutDelMerek> deleteMerek = mApiInterface.deleteMerekBarang(idEditMerekBarang.getText().toString());
                    deleteMerek.enqueue(new Callback<PostPutDelMerek>() {
                        @Override
                        public void onResponse(Call<PostPutDelMerek> call, Response<PostPutDelMerek> response) {
                            Toast.makeText(getApplicationContext(), "Delete Berhasil", Toast.LENGTH_SHORT).show();
                            MerekActivity.ma.refresh();
                            finish();
                        }

                        @Override
                        public void onFailure(Call<PostPutDelMerek> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
