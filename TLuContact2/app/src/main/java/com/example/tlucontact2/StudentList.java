package com.example.tlucontact2;

import static com.example.tlucontact2.R.*;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class StudentList extends AppCompatActivity {
    private RecyclerView recyclerView;
    private StudentListAdapter studentListAdapter;
    private List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        TextView tvBack = findViewById(R.id.txt_TitleUnitList);
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        recyclerView = findViewById(id.recycler_view_student);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        studentList = generateStudentList();
        studentListAdapter = new StudentListAdapter(this, studentList);
        recyclerView.setAdapter(studentListAdapter);

        Toast.makeText(this, "Số Sinh Viên : " + studentList.size(), Toast.LENGTH_SHORT).show();
    }

    private List<Student> generateStudentList() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("20191234", "Nguyen Van A", "nguyenvana@example.com", "123 Le Loi, Ha Noi", "CNTT1"));
        studentList.add(new Student("20195678", "Tran Thi B", "tranthib@example.com", "456 Tran Phu, Ho Chi Minh", "CNTT2"));
        studentList.add(new Student("20209012", "Le Hoang C", "lehoangc@example.com", "789 Nguyen Trai, Da Nang", "CNTT3"));
        studentList.add(new Student("20203456", "Pham Thu D", "phamthud@example.com", "10 Vo Van Kiet, Can Tho", "CNTT4"));
        studentList.add(new Student("20217890", "Hoang Minh E", "hoangminhe@example.com", "11 Ly Thuong Kiet, Hai Phong", "CNTT5"));
        studentList.add(new Student("20212345", "Do Xuan F", "doxuanf@example.com", "12 Dien Bien Phu, Hue", "CNTT6"));
        studentList.add(new Student("20226789", "Bui Thi G", "buithig@example.com", "13 Hung Vuong, Nha Trang", "CNTT7"));
        studentList.add(new Student("20221234", "Vu Duc H", "vuduch@example.com", "14 Tran Hung Dao, Quy Nhon", "CNTT8"));
        studentList.add(new Student("20235678", "Nguyen Thi I", "nguyenthii@example.com", "15 Quang Trung, Da Lat", "CNTT9"));
        studentList.add(new Student("20239012", "Tran Van K", "tranvank@example.com", "16 Hoang Dieu, Vung Tau", "CNTT10"));
        return studentList;
    }

}
