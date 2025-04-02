package com.example.tlucontact2;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class StudentListDetail extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        TextView tvBack = findViewById(R.id.txt_TitleUnitList);
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Student student = (Student) getIntent().getSerializableExtra("student");
        TextView tvStudentName = findViewById(R.id.txt_hoTen);
        TextView tvStudentMaSV = findViewById(R.id.txt_maSV);
        TextView tvStudentEmail = findViewById(R.id.txt_email);
        TextView tvStudentDiaChi = findViewById(R.id.txt_diaChi);
        TextView tvLop = findViewById(R.id.txt_Lop);

        if (student != null && tvStudentName != null && tvStudentMaSV != null && tvLop != null && tvStudentEmail != null && tvStudentDiaChi != null) {
            tvStudentName.setText(student.getHoTen());
            tvStudentMaSV.setText(student.getMaSinhVien());
            tvLop.setText(student.getLopHoc());
            tvStudentEmail.setText(student.getDiaChiEmail());
            tvStudentDiaChi.setText(student.getDiaChi());
        }
    }
}
