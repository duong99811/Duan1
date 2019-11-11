package com.example.duan1_empty.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1_empty.Database.DatabaseHelper;
import com.example.duan1_empty.model.LoaiQuanAo;

import java.util.ArrayList;
import java.util.List;

public class LoaiQuanAoDAO {
    public static final String TABLE_NAME = "LoaiQuanAo";
    public static final String SQL_LOAI_QUAN_AO = "CREATE TABLE LoaiQuanAo (maloaiquanao text primary key," +
            "tenloaiquanao text, hangquanao text,mota text)";
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public LoaiQuanAoDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public boolean inserLoaiQuanAo(LoaiQuanAo loaiQuanAo) {
        ContentValues values = new ContentValues();
        values.put("maloaiquanao", loaiQuanAo.getMaloaiquanao());
        values.put("tenloaiquanao", loaiQuanAo.getTenloaiquanao());
        values.put("hangquanao", loaiQuanAo.getHangquanao());
        values.put("mota", loaiQuanAo.getMota());
        long result = db.insert(TABLE_NAME, null, values);
        try {
            if (result == -1) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<LoaiQuanAo> getAllLoaiQuanAo() {
        List<LoaiQuanAo> list = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            LoaiQuanAo loaiQuanAo = new LoaiQuanAo();
            loaiQuanAo.setMaloaiquanao(cursor.getString(cursor.getColumnIndex("maloaiquanao")));
            loaiQuanAo.setTenloaiquanao(cursor.getString(cursor.getColumnIndex("tenloaiquanao")));
            loaiQuanAo.setHangquanao(cursor.getString(cursor.getColumnIndex("hangquanao")));
            loaiQuanAo.setMota(cursor.getString(cursor.getColumnIndex("mota")));

            list.add(loaiQuanAo);
            cursor.moveToNext();
        }
        return list;
    }

    public int updateLoaiQuanAo(String maloaiquanao, String tenloaiquanao, String hangquanao, String mota) {
        ContentValues values = new ContentValues();
        values.put("tenloaiquanao", tenloaiquanao);
        values.put("hangquanao", hangquanao);
        values.put("mota", mota);
        int result = db.update(TABLE_NAME, values, "maloaiquanao=?", new String[]{maloaiquanao});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    public int xoaLoaiQuanAo(String maloaiquanao) {
        return db.delete(TABLE_NAME, "maloaiquanao=?", new String[]{maloaiquanao});
    }
}
