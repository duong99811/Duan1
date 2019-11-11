package com.example.duan1_empty.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1_empty.DAO.LoaiQuanAoDAO;
import com.example.duan1_empty.R;
import com.example.duan1_empty.model.LoaiQuanAo;

import java.util.List;

public class LoaiQuanAoAdapter extends BaseAdapter {
    LoaiQuanAoDAO loaiQuanAoDAO;
    private Context context;
    private List<LoaiQuanAo> listloaiQuanAo;

    public LoaiQuanAoAdapter(Context context, List<LoaiQuanAo> loaiQuanAo) {
        this.context = context;
        this.listloaiQuanAo = loaiQuanAo;
        loaiQuanAoDAO = new LoaiQuanAoDAO(context);
    }

    @Override
    public int getCount() {
        return listloaiQuanAo.size();
    }

    @Override
    public LoaiQuanAo getItem(int i) {
        return listloaiQuanAo.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        LoaiQuanAoHolder loaiQuanAoHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.lv_loai_quan_ao, viewGroup, false);
            loaiQuanAoHolder = new LoaiQuanAoHolder();
            loaiQuanAoHolder.tvMaLoaiQuanAo = view.findViewById(R.id.tvMaLoaiQuanAo);
            loaiQuanAoHolder.tvTenLoaiQuanAo = view.findViewById(R.id.tvTenLoaiQuanAo);
            loaiQuanAoHolder.imgXoaLoaiQuanAo = view.findViewById(R.id.imgXoaLoaiQuanAo);
            view.setTag(loaiQuanAoHolder);
        } else {
            loaiQuanAoHolder = (LoaiQuanAoHolder) view.getTag();
        }
        loaiQuanAoHolder.tvMaLoaiQuanAo.setText(listloaiQuanAo.get(i).getMaloaiquanao());
        loaiQuanAoHolder.tvTenLoaiQuanAo.setText(listloaiQuanAo.get(i).getTenloaiquanao());
        loaiQuanAoHolder.imgXoaLoaiQuanAo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = loaiQuanAoDAO.xoaLoaiQuanAo(listloaiQuanAo.get(i).getMaloaiquanao());
                if (result > 0)
                    Toast.makeText(context, "Xoa thanh cong :D", Toast.LENGTH_SHORT).show();
                listloaiQuanAo.clear();
                listloaiQuanAo = loaiQuanAoDAO.getAllLoaiQuanAo();
                ondatasetchange(listloaiQuanAo);
            }
        });
        return view;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void ondatasetchange(List<LoaiQuanAo> quanAos) {
        this.listloaiQuanAo = quanAos;
        notifyDataSetChanged();
    }

    public class LoaiQuanAoHolder {
        TextView tvMaLoaiQuanAo, tvTenLoaiQuanAo;
        ImageView imgXoaLoaiQuanAo;
    }
}
