package com.example.meallog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// RecordAdapter.java
public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.RecordViewHolder> {

    private List<Record> recordList;

    public RecordAdapter(List<Record> recordList) {
        this.recordList = recordList;
    }

    @NonNull
    @Override
    public RecordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_record, parent, false);
        return new RecordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecordViewHolder holder, int position) {
        Record record = recordList.get(position);
        holder.bind(record);
    }

    @Override
    public int getItemCount() {
        return recordList.size();
    }

    public void setRecordList(List<Record> recordList) {
        this.recordList = recordList;
        notifyDataSetChanged();
    }

    public static class RecordViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, calTextView, froTextView, gibangTextView, tanTextView;

        public RecordViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            calTextView = itemView.findViewById(R.id.calTextView);
            froTextView = itemView.findViewById(R.id.froTextView);
            gibangTextView = itemView.findViewById(R.id.gibangTextView);
            tanTextView = itemView.findViewById(R.id.tanTextView);
        }

        public void bind(Record record) {
            nameTextView.setText(record.getName());
            calTextView.setText(record.getCal());
            froTextView.setText(record.getFro());
            gibangTextView.setText(record.getGibang());
            tanTextView.setText(record.getTan());
        }
    }
}
