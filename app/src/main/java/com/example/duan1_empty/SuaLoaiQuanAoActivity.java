package com.example.duan1_empty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.duan1_empty.DAO.LoaiQuanAoDAO;

public class SuaLoaiQuanAoActivity extends AppCompatActivity {
    EditText edSuaMaLoaiQuanAo, edSuaTenLoaiQuanAo, edSuaHangQuanAo, edSuaMoTa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_loai_quan_ao);
        edSuaMaLoaiQuanAo = findViewById(R.id.edSuaMaLoaiQuanAo);
        edSuaTenLoaiQuanAo = findViewById(R.id.edSuaTenLoaiQuanAo);
        edSuaHangQuanAo = findViewById(R.id.edSuaHangQuanAo);
        edSuaMoTa = findViewById(R.id.edSuaMoTa);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if (b != null) {
            edSuaMaLoaiQuanAo.setText(b.getString("maloaiquanao"));
            edSuaTenLoaiQuanAo.setText(b.getString("tenloaiquanao"));
            edSuaHangQuanAo.setText(b.getString("hangquanao"));
            edSuaMoTa.setText(b.getString("mota"));
        }

    }

    public void SuaLoaiQuanAo(View view) {
        LoaiQuanAoDAO loaiQuanAoDAO = new LoaiQuanAoDAO(this);
        String suamaloaiquanao = edSuaMaLoaiQuanAo.getText().toString();
        String suatenloaiquanao = edSuaTenLoaiQuanAo.getText().toString();
        String suahangquanao = edSuaHangQuanAo.getText().toString();
        String suamota = edSuaMoTa.getText().toString();
        loaiQuanAoDAO.updateLoaiQuanAo(suamaloaiquanao, suatenloaiquanao, suahangquanao, suamota);
        Toast.makeText(this, "Sửa thành công", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, ListLoaiQuanAoActivity.class));
    }
}
