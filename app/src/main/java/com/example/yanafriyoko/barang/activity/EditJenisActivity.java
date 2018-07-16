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
import com.example.yanafriyoko.barang.rest.ApiClient;
import com.example.yanafriyoko.barang.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditJenisActivity extends AppCompatActivity {
    EditText idEditJenisBarang,namaEditJenisBarang;
    Button btUpdate, btDelete;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_jenis);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("edit jenis");

        idEditJenisBarang = (EditText) findViewById(R.id.idEditJenisBarang);
        namaEditJenisBarang = (EditText) findViewById(R.id.namaEditJenisBarang);
        Intent mIntent = getIntent();
        idEditJenisBarang.setText(mIntent.getStringExtra("id_jenis_barang"));
        idEditJenisBarang.setTag(idEditJenisBarang.getKeyListener());
        idEditJenisBarang.setKeyListener(null);
        namaEditJenisBarang.setText(mIntent.getStringExtra("nama_jenis_barang"));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btUpdate = (Button) findViewById(R.id.btnUpdateJenisBarang);
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<PostPutDelJenis> updateKontakCall = mApiInterface.putJenisBarang(
                        idEditJenisBarang.getText().toString(),
                        namaEditJenisBarang.getText().toString());
                updateKontakCall.enqueue(new Callback<PostPutDelJenis>() {
                    @Override
                    public void onResponse(Call<PostPutDelJenis> call, Response<PostPutDelJenis> response) {
                        Toast.makeText(getApplicationContext(), "Edit Berhasil", Toast.LENGTH_LONG).show();
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

        btDelete = (Button) findViewById(R.id.btnDeleteJenisBarang);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (idEditJenisBarang.getText().toString().trim().isEmpty()==false){
                    Call<PostPutDelJenis> deleteJenis = mApiInterface.deleteJenisBarang(idEditJenisBarang.getText().toString());
                    deleteJenis.enqueue(new Callback<PostPutDelJenis>() {
                        @Override
                        public void onResponse(Call<PostPutDelJenis> call, Response<PostPutDelJenis> response) {
                            Toast.makeText(getApplicationContext(), "Delete Berhasil", Toast.LENGTH_SHORT).show();
                            JenisActivity.ma.refresh();
                            finish();
                        }

                        @Override
                        public void onFailure(Call<PostPutDelJenis> call, Throwable t) {
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
