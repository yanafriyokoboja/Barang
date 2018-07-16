package com.example.yanafriyoko.barang.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yanafriyoko.barang.R;
import com.example.yanafriyoko.barang.activity.EditJenisActivity;
import com.example.yanafriyoko.barang.activity.EditMerekActivity;
import com.example.yanafriyoko.barang.model.Merek;

import java.util.List;

public class MerekAdapter extends RecyclerView.Adapter<MerekAdapter.MyViewHolder> {
    List<Merek> mMerekList;

    public MerekAdapter(List<Merek> merekList) {
        mMerekList = merekList;
    }
    @Override
    public MerekAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.merek_list, parent, false);
        MerekAdapter.MyViewHolder mViewHolder = new MerekAdapter.MyViewHolder(mView);
        return mViewHolder;
    }
    @Override
    public void onBindViewHolder(MerekAdapter.MyViewHolder holder, final int position) {
        holder.mTextViewIdMerekBarang.setText("ID Merek Barang = " + mMerekList.get(position).getIdMerek());
        holder.mTextViewNamaMerekBarang.setText("Nama Merek Barang = " + mMerekList.get(position).getNamaMerek());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditMerekActivity.class);
                mIntent.putExtra("id_merek_barang", mMerekList.get(position).getIdMerek());
                mIntent.putExtra("nama_merek_barang", mMerekList.get(position).getNamaMerek());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMerekList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewIdMerekBarang, mTextViewNamaMerekBarang;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewIdMerekBarang = (TextView) itemView.findViewById(R.id.tvIdMerek);
            mTextViewNamaMerekBarang = (TextView) itemView.findViewById(R.id.tvNamaMerek);
        }
    }
}
