package com.example.tlucontact2;

import static com.example.tlucontact2.R.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class StaffListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StaffAdapter staffAdapter;
    private List<Staff> staffList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_list);

        TextView tvBack = findViewById(id.txt_TitleUnitList);
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        recyclerView = findViewById(R.id.recycler_view_staff);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        staffList = generateStaffList();
        staffAdapter = new StaffAdapter(this, staffList);
        recyclerView.setAdapter(staffAdapter);

        Toast.makeText(this, "Số Nhân Viên : " + staffList.size(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        MenuItem item = menu.findItem(R.id.search_bar);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Gọi setFilter() để lọc dữ liệu
                setFilter(newText);
                return true;
            }
        });
        return true;
    }

    // Xử lý sự kiện click nút "Back"
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // Quay lại Activity trước đó
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setFilter(CharSequence charSequence) {
        staffAdapter.getFilter().filter(charSequence);
    }

    private List<Staff> generateStaffList() {
        List<Staff> list = new ArrayList<>();
        list.add(new Staff("Nguyễn Văn A", "Giảng viên", "0912345678", "anv@tlu.edu.vn", "Khoa CNTT"));
        list.add(new Staff("Trần Thị B", "Trưởng phòng", "0987654321", "btt@tlu.edu.vn", "Phòng Đào tạo"));
        return list;
    }
}