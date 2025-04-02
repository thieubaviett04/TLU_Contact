package com.example.tlucontact2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StaffDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_detail);

        TextView tvBack = findViewById(R.id.txt_TitleUnitList);
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Staff staff = (Staff) getIntent().getSerializableExtra("staff");

        TextView tvStaffName = findViewById(R.id.tv_staff_name_detail);
        TextView tvStaffPosition = findViewById(R.id.tv_staff_position_detail);
        TextView tvStaffPhone = findViewById(R.id.tv_staff_phone_detail);
        TextView tvStaffEmail = findViewById(R.id.tv_staff_email_detail);
        TextView tvStaffUnit = findViewById(R.id.tv_staff_unit_detail);

        if (staff != null) {
            tvStaffName.setText(staff.getName());
            tvStaffPosition.setText("Địa Chỉ: " + staff.getPosition());
            tvStaffPhone.setText("Điện Thoại: " + staff.getPhone());
            tvStaffEmail.setText("Email: " + staff.getEmail());
            tvStaffUnit.setText("Đơn Vị: " + staff.getUnit());
        }
    }
}