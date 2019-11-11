package com.example.duan1_empty;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.duan1_empty.DAO.LoaiQuanAoDAO;
import com.example.duan1_empty.adapter.LoaiQuanAoAdapter;
import com.example.duan1_empty.model.LoaiQuanAo;

import java.util.ArrayList;
import java.util.List;

public class ListLoaiQuanAoActivity extends AppCompatActivity {
    Intent intent;
    ListView lvLoaiQuanAo;
    LoaiQuanAoDAO loaiQuanAoDAO;
    List<LoaiQuanAo> listLoaiQuanAo;
    LoaiQuanAoAdapter loaiQuanAoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_loai_quan_ao);
        lvLoaiQuanAo = findViewById(R.id.lvLoaiQuanAo);
        loaiQuanAoDAO = new LoaiQuanAoDAO(this);

        listLoaiQuanAo = new ArrayList<>();
        listLoaiQuanAo = loaiQuanAoDAO.getAllLoaiQuanAo();

        loaiQuanAoAdapter = new LoaiQuanAoAdapter(this, listLoaiQuanAo);
        lvLoaiQuanAo.setAdapter(loaiQuanAoAdapter);

        lvLoaiQuanAo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intent = new Intent(ListLoaiQuanAoActivity.this, SuaLoaiQuanAoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("maloaiquanao", listLoaiQuanAo.get(i).getMaloaiquanao());
                bundle.putString("tenloaiquanao", listLoaiQuanAo.get(i).getTenloaiquanao());
                bundle.putString("hangquanao", listLoaiQuanAo.get(i).getHangquanao());
                bundle.putString("mota", listLoaiQuanAo.get(i).getMota());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.them_loai_quan_ao, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itThemLoaiQuanAo:
                intent = new Intent(this, ThemLoaiQuanAoActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
