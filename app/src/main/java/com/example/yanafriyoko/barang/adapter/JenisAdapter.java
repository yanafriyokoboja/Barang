package com.example.yanafriyoko.barang.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yanafriyoko.barang.R;
import com.example.yanafriyoko.barang.activity.EditBarangActivity;
import com.example.yanafriyoko.barang.activity.EditJenisActivity;
import com.example.yanafriyoko.barang.model.Jenis;

import java.util.List;

public class JenisAdapter extends RecyclerView.Adapter<JenisAdapter.MyViewHolder> {
    List<Jenis> mJenisList;

    public JenisAdapter(List<Jenis> jenisList) {
        mJenisList = jenisList;
    }
    @Override
    public JenisAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.jenis_list, parent, false);
        JenisAdapter.MyViewHolder mViewHolder = new JenisAdapter.MyViewHolder(mView);
        return mViewHolder;
    }
    @Override
    public void onBindViewHolder(JenisAdapter.MyViewHolder holder, final int position) {
        holder.mTextViewIdJenisBarang.setText("ID Jenis Barang = " + mJenisList.get(position).getIdJenis());
        holder.mTextViewNamaJenisBarang.setText("Nama Jenis Barang = " + mJenisList.get(position).getNamaJenis());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditJenisActivity.class);
                mIntent.putExtra("id_jenis_barang", mJenisList.get(position).getIdJenis());
                mIntent.putExtra("nama_jenis_barang", mJenisList.get(position).getNamaJenis());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mJenisList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewIdJenisBarang, mTextViewNamaJenisBarang;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewIdJenisBarang = (TextView) itemView.findViewById(R.id.tvIdJenis);
            mTextViewNamaJenisBarang = (TextView) itemView.findViewById(R.id.tvNamaJenis);
        }
    }
}
