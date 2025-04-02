package com.example.tlucontact2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class StaffAdapter extends RecyclerView.Adapter<StaffAdapter.StaffViewHolder> implements Filterable {

    private Context context;
    private List<Staff> staffList;
    private List<Staff> staffListAll;

    public StaffAdapter(Context context, List<Staff> staffList) {
        this.context = context;
        this.staffList = staffList;
        this.staffListAll = new ArrayList<>(staffList);
    }

    @NonNull
    @Override
    public StaffViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_staff, parent, false);
        return new StaffViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StaffViewHolder holder, int position) {
        Staff staff = staffList.get(position); // Sử dụng staffList thay vì filteredStaffList
        holder.tvStaffName.setText(staff.getName());
        holder.tvStaffPosition.setText(staff.getPosition());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, StaffDetailActivity.class);
                intent.putExtra("staff", staff);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return staffList.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<Staff> filteredList = new ArrayList<>();
            if (charSequence == null || charSequence.length() == 0) {
                filteredList.addAll(staffListAll);
            } else {
                String filterPattern = charSequence.toString().toLowerCase().trim();
                for (Staff staff : staffListAll) {
                    if (staff.getName().toLowerCase().contains(filterPattern) ||
                            staff.getPosition().toLowerCase().contains(filterPattern)) {
                        filteredList.add(staff);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            results.count = filteredList.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            staffList.clear();
            staffList.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };

    public static class StaffViewHolder extends RecyclerView.ViewHolder {
        TextView tvStaffName;
        TextView tvStaffPosition;

        public StaffViewHolder(@NonNull View itemView) {
            super(itemView);
            tvStaffName = itemView.findViewById(R.id.tv_staff_name);
            tvStaffPosition = itemView.findViewById(R.id.tv_staff_position);
        }
    }
}