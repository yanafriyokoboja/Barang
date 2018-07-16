package com.example.yanafriyoko.barang.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.yanafriyoko.barang.R;
import com.example.yanafriyoko.barang.adapter.JenisAdapter;
import com.example.yanafriyoko.barang.adapter.MerekAdapter;
import com.example.yanafriyoko.barang.model.GetJenis;
import com.example.yanafriyoko.barang.model.GetMerek;
import com.example.yanafriyoko.barang.model.Jenis;
import com.example.yanafriyoko.barang.model.Merek;
import com.example.yanafriyoko.barang.rest.ApiClient;
import com.example.yanafriyoko.barang.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MerekActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static MerekActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merek);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabMerek);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent( MerekActivity.this, TambahMerekActivity.class));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_merek);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewMerek);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma=this;
        refresh();
    }


    public void refresh() {
        Call<GetMerek> merekCall = mApiInterface.getMerek();
        merekCall.enqueue(new Callback<GetMerek>() {
            @Override
            public void onResponse(Call<GetMerek> call, Response<GetMerek>
                    response) {
                List<Merek> merekList;
                merekList = response.body().getListDataMerek();
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        String.valueOf(merekList.size()));
                mAdapter = new MerekAdapter(merekList);
                mRecyclerView.setAdapter(mAdapter);
            }
            @Override
            public void onFailure(Call<GetMerek> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_merek);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent( MerekActivity.this, AboutActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            startActivity(new Intent( MerekActivity.this, MainActivity.class));
        } else if (id == R.id.nav_gallery) {
            startActivity(new Intent( MerekActivity.this, JenisActivity.class));

        } else if (id == R.id.nav_slideshow) {

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_merek);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

