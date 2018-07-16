package com.example.yanafriyoko.barang.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yanafriyoko.barang.R;
import com.example.yanafriyoko.barang.model.Barang;
import com.example.yanafriyoko.barang.model.GetBarang;
import com.example.yanafriyoko.barang.model.GetJenis;
import com.example.yanafriyoko.barang.model.GetMerek;
import com.example.yanafriyoko.barang.model.Jenis;
import com.example.yanafriyoko.barang.model.Merek;
import com.example.yanafriyoko.barang.model.PostPutDelBarang;
import com.example.yanafriyoko.barang.model.PostPutDelJenis;
import com.example.yanafriyoko.barang.model.PostPutDelMerek;
import com.example.yanafriyoko.barang.rest.ApiClient;
import com.example.yanafriyoko.barang.rest.ApiInterface;
import com.example.yanafriyoko.barang.rest.UtilsApi;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class EditBarangActivity extends AppCompatActivity {
    ApiInterface mApiInterface;
    @BindView(R.id.spinnerEditJenisBarang)
    Spinner spinnerEditJenisBarang;
    @BindView(R.id.spinnerEditMerekBarang)
    Spinner spinnerEditMerekBarang;
    @BindView(R.id.idEditBarang)
    EditText idEditBarang;
    @BindView(R.id.nameEditBarang)
    EditText namaEditBarang;
    @BindView(R.id.stokEditBarang)
    EditText stokBarang;
    @BindView(R.id.btnEditBarang)
    Button btnEditBarang;
    @BindView(R.id.btnDeleteBarang)
    Button btnDeleteBarang;
    ApiInterface mApiService;
    List<String> listSpinner = new ArrayList<String>();
    List<String> list = new ArrayList<String>();
    List<String> listSpinnerJenis = new ArrayList<String>();
    List<String> listSpinnerIdJenis = new ArrayList<String>();
    String selectedName;
    String selectedJenis;
    Context mContext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_barang);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView toolbarText = (TextView) findViewById(R.id.toolbar_text);
        if(toolbarText!=null && toolbar!=null) {
            toolbarText.setText(getTitle());
            setSupportActionBar(toolbar);
        }
        ButterKnife.bind(this);
        Intent mIntent = getIntent();
        idEditBarang.setText(mIntent.getStringExtra("id_barang"));
        idEditBarang.setTag(idEditBarang.getKeyListener());
        idEditBarang.setKeyListener(null);
        namaEditBarang.setText(mIntent.getStringExtra("nama_barang"));
//        stokBarang.setText(String.valueOf(mIntent.getIntExtra("stok",0)));
        mApiService = UtilsApi.getAPIService();
        initSpinnerJenis();
        initSpinnerMerek();
        mContext = this;
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        btnEditBarang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Call<PostPutDelBarang> updateKontakCall = mApiInterface.putBarang(
                            idEditBarang.getText().toString(),
                            namaEditBarang.getText().toString());
                    updateKontakCall.enqueue(new Callback<PostPutDelBarang>() {
                        @Override
                        public void onResponse(Call<PostPutDelBarang> call, Response<PostPutDelBarang> response) {
                            Toast.makeText(getApplicationContext(), "Edit Berhasil", Toast.LENGTH_LONG).show();
                            MainActivity.ma.refresh();
                            finish();
                        }

                        @Override
                        public void onFailure(Call<PostPutDelBarang> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            });

//        btnDeleteBarang.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (idEditBarang.getText().toString().trim().isEmpty()==false){
//                    Call<PostPutDelBarang> deleteBarang = mApiInterface.deleteBarang(idEditBarang.getText().toString());
//                    deleteBarang.enqueue(new Callback<PostPutDelBarang>() {
//                        @Override
//                        public void onResponse(Call<PostPutDelBarang> call, Response<PostPutDelBarang> response) {
//                            Toast.makeText(getApplicationContext(), "Delete Berhasil", Toast.LENGTH_SHORT).show();
//                            MainActivity.ma.refresh();
//                            finish();
//                        }
//
//                        @Override
//                        public void onFailure(Call<PostPutDelBarang> call, Throwable t) {
//                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//                }else{
//                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
//                }
//            }
//        });
    }
    private void initSpinnerMerek() {

        mApiService.getMerek().enqueue(new Callback<GetMerek>() {
            @Override
            public void onResponse(Call<GetMerek> call, Response<GetMerek> response) {
                if (response.isSuccessful()) {
//                    loading.dismiss();
                    List<Merek> merekItems = response.body().getListDataMerek();

                    listSpinner = new ArrayList<String>();
                    list = new ArrayList<String>();

                    for (int i = 0; i < merekItems.size(); i++) {
                        list.add(merekItems.get(i).getIdMerek());
                        listSpinner.add(merekItems.get(i).getNamaMerek());
                    }

//                  listId= String.valueOf(Id);
                    // Set hasil result json ke dalam adapter spinner
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext,
                            android.R.layout.simple_spinner_item, listSpinner);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerEditMerekBarang.setAdapter(adapter);
                } else {
//                    loading.dismiss();
                    Toast.makeText(mContext, "Gagal mengambil data dosen", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetMerek> call, Throwable t) {
//                loading.dismiss();
                Toast.makeText(mContext, "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initSpinnerJenis() {
//        loading = ProgressDialog.show(mContext, null, "harap tunggu...", true, false);

        mApiService.getJenis().enqueue(new Callback<GetJenis>() {
            @Override
            public void onResponse(Call<GetJenis> call, Response<GetJenis> response) {
                if (response.isSuccessful()) {
//                    loading.dismiss();
                    List<Jenis> jenisItems = response.body().getListDataJenis();
                    listSpinnerJenis = new ArrayList<String>();
                    listSpinnerIdJenis = new ArrayList<String>();
                    for (int i = 0; i < jenisItems.size(); i++) {
                        listSpinnerJenis.add(jenisItems.get(i).getNamaJenis());
                        listSpinnerIdJenis.add(jenisItems.get(i).getIdJenis());
                    }
                    // Set hasil result json ke dalam adapter spinner
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext,
                            android.R.layout.simple_spinner_item, listSpinnerJenis);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerEditJenisBarang.setAdapter(adapter);
                } else {
//                    loading.dismiss();
                    Toast.makeText(mContext, "Gagal mengambil data dosen", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetJenis> call, Throwable t) {
//                loading.dismiss();
                Toast.makeText(mContext, "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }

}

