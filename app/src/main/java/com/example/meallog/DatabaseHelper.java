package com.example.meallog;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;

public class DatabaseHelper {

    private RecordDatabase db;

    public DatabaseHelper(Context context) {
        db = RecordDatabase.getDatabase(context);
    }

    public void readAndStoreCSV(Context context) {
        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                InputStream inputStream = context.getAssets().open("Food1_UTF8.csv");
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

                String line;
                reader.readLine();

                int count = 0;
                while ((line = reader.readLine()) != null && count < 5000) {
                    String[] values = line.split(",");

                    String name = values[1];
                    String cal = values[17];
                    String fro = values[19];
                    String gibang = values[20];
                    String tan = values[22];

                    Record record = new Record(name, cal, fro, gibang, tan);
                    db.recordDao().insert(record);
                    Log.d("CSVReader", "Inserted: " + name);

                    count++;
                }

                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
