package com.example.tlucontact2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class UnitListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UnitAdapter unitAdapter;
    private List<Unit> unitList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_list);

        TextView tvBack = findViewById(R.id.txt_TitleUnitList);
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        recyclerView = findViewById(R.id.recycler_view_unit);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        unitList = generateUnitList();
        unitAdapter = new UnitAdapter(this, unitList);
        recyclerView.setAdapter(unitAdapter);

        Toast.makeText(this, "Số Đơn Vị: " + unitList.size(), Toast.LENGTH_SHORT).show();
    }

    private List<Unit> generateUnitList() {
        List<Unit> list = new ArrayList<>();
        list.add(new Unit("Khoa Công nghệ thông tin", "0243.852.2201", "P. 201, Nhà A1"));
        list.add(new Unit("Khoa Kỹ thuật xây dựng", "0243.852.2202", "P. 301, Nhà A1"));
        list.add(new Unit("Phòng Đào tạo", "0243.852.2203", "P. 101, Nhà A2"));
        list.add(new Unit("Khoa Công Trình", "0243.852.7403", "P. 102, Nhà A2"));
        list.add(new Unit("Đào tạo quốc tế", "0243.552.2203", "P. 103, Nhà A2"));
        list.add(new Unit("Khoa Cơ Khí", "0243.852.2200", "P. 104, Nhà A2"));

        return list;
    }
}