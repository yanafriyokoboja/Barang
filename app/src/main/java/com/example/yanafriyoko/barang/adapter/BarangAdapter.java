package com.example.yanafriyoko.barang.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yanafriyoko.barang.activity.EditBarangActivity;
import com.example.yanafriyoko.barang.R;
import com.example.yanafriyoko.barang.model.Barang;

import java.util.List;

/**
 * Created by Yan afriyoko on 6/29/2018.
 */


public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.MyViewHolder> {
    List<Barang> mBarangList;

    public BarangAdapter(List<Barang> BarangList) {
        mBarangList = BarangList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.kontak_list, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.mTextViewIdBarang.setText("ID Barang = " + mBarangList.get(position).getIdBarang());
        holder.mTextViewNamaBarang.setText("Nama Barang = " + mBarangList.get(position).getNamaBarang());
        holder.mTextViewJenisBarang.setText("ID Jenis Barang = " + mBarangList.get(position).getIdJenisBarang());
        holder.mTextViewMerekBaranag.setText("ID Merek Barang = " + mBarangList.get(position).getIdMerekBarang());
        holder.mTextViewStok.setText("Stok = " + mBarangList.get(position).getStok());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditBarangActivity.class);
                mIntent.putExtra("id_barang", mBarangList.get(position).getIdBarang());
                mIntent.putExtra("nama_barang", mBarangList.get(position).getNamaBarang());
                mIntent.putExtra("id_jenis_barang", mBarangList.get(position).getIdJenisBarang());
                mIntent.putExtra("id_jenis_barang", mBarangList.get(position).getIdMerekBarang());
                mIntent.putExtra("stok", mBarangList.get(position).getStok());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mBarangList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewIdBarang, mTextViewNamaBarang, mTextViewJenisBarang,mTextViewMerekBaranag,mTextViewStok;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewIdBarang = (TextView) itemView.findViewById(R.id.tvIdBarang);
            mTextViewNamaBarang = (TextView) itemView.findViewById(R.id.tvNamaBarang);
            mTextViewJenisBarang = (TextView) itemView.findViewById(R.id.tvJenisBarang);
            mTextViewMerekBaranag = (TextView) itemView.findViewById(R.id.tvMerekBarang);
            mTextViewStok = (TextView) itemView.findViewById(R.id.tvStok);
        }
    }
}