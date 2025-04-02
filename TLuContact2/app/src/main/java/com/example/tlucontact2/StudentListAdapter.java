package com.example.tlucontact2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.StudentViewHolder> {
    private Context context;
    private List<Student> studentList;

    public StudentListAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.tvMaSV.setText(student.getMaSinhVien());
        holder.tvHoTen.setText(student.getHoTen());
        holder.tvLop.setText(student.getLopHoc());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView tvHoTen;
        TextView tvMaSV;
        TextView tvLop;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMaSV = itemView.findViewById(R.id.txt_maSV);
            tvHoTen = itemView.findViewById(R.id.txt_hoTen);
            tvLop = itemView.findViewById(R.id.txt_Lop);
        }
    }
}