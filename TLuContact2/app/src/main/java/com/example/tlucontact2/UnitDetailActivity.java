package com.example.tlucontact2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UnitDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_detail);

        TextView tvBack = findViewById(R.id.txt_TitleUnitList);
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Unit unit = (Unit) getIntent().getSerializableExtra("unit");

        TextView tvUnitName = findViewById(R.id.tv_unit_name_detail);
        TextView tvUnitPhone = findViewById(R.id.tv_unit_phone_detail);
        TextView tvUnitAddress = findViewById(R.id.tv_unit_address_detail);

        if (unit != null) {
            tvUnitName.setText(unit.getName());
            tvUnitPhone.setText("Điện thoại: " + unit.getPhone());
            tvUnitAddress.setText("Địa chỉ: " + unit.getAddress());
        }
    }
}