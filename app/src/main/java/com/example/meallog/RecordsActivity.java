package com.example.meallog;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class RecordsActivity extends AppCompatActivity {

    private RecordDatabase db;
    private RecyclerView recyclerView;
    private RecordAdapter recordAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        db = RecordDatabase.getDatabase(this);

        recyclerView= findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recordAdapter = new RecordAdapter(new ArrayList<>());
        recyclerView.setAdapter(recordAdapter);

        // 데이터베이스에서 레코드를 가져와 RecyclerView에 설정
        loadDataFromDatabase();
    }

    // 데이터베이스에서 레코드를 가져오는 메서드
    private void loadDataFromDatabase() {
        new Thread(() -> {
            List<Record> recordList = db.recordDao().getAllRecords();
            runOnUiThread(() -> {
                recordAdapter.setRecordList(recordList);
            });
        }).start();
    }
}

