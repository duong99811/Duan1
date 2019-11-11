package com.example.duan1_empty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.duan1_empty.DAO.LoaiQuanAoDAO;
import com.example.duan1_empty.model.LoaiQuanAo;

public class ThemLoaiQuanAoActivity extends AppCompatActivity {
    Intent intent;
    EditText edmaLoaiQuanAo, edTenLoaiQuanAo, edHangQuanAo, edMoTa;
    LoaiQuanAoDAO loaiQuanAoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_loai_quan_ao);
        edmaLoaiQuanAo = findViewById(R.id.edMaLoaiQuanAo);
        edTenLoaiQuanAo = findViewById(R.id.edTenLoaiQuanAo);
        edHangQuanAo = findViewById(R.id.edHangQuanAo);
        edMoTa = findViewById(R.id.edMoTa);
    }


    public void cancel(View view) {
        finish();
    }

    public void themLoaiQuanAo(View view) {
        loaiQuanAoDAO = new LoaiQuanAoDAO(ThemLoaiQuanAoActivity.this);
        String maloaiquanao = edmaLoaiQuanAo.getText().toString();
        String tenloaiquanao = edTenLoaiQuanAo.getText().toString();
        String hangquanao = edHangQuanAo.getText().toString();
        String mota = edMoTa.getText().toString();
        LoaiQuanAo loaiQuanAo = new LoaiQuanAo(maloaiquanao, tenloaiquanao, hangquanao, mota);
        boolean isInsertTrue = loaiQuanAoDAO.inserLoaiQuanAo(loaiQuanAo);
        if (maloaiquanao.length() == 0 && tenloaiquanao.length() == 0) {

            if (isInsertTrue) {
                startActivity(new Intent(this, ListLoaiQuanAoActivity.class));
                Toast.makeText(this, "Thêm thành công.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Thêm thất bại ", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void showLoaiQuanAo(View view) {
        startActivity(new Intent(this, ListLoaiQuanAoActivity.class));
    }
}
