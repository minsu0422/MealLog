package com.example.meallog;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CSVReader {
    private static final ExecutorService executor = Executors.newSingleThreadExecutor();

    public static void readCSV(Context context) {
        FoodDatabase db = Room.databaseBuilder(context, FoodDatabase.class, "food_database")
                .build();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open("Food1_UTF8.csv")))) {
            String line;
            reader.readLine(); // 헤더를 건너뜁니다.
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                String name = values[1];
                float calories;
                float protein;
                float fat;
                float carbohydrate;
                try {
                    calories = Float.parseFloat(values[17]);
                    protein = Float.parseFloat(values[19]);
                    fat = Float.parseFloat(values[20]);
                    carbohydrate = Float.parseFloat(values[22]);
                    Log.d("CSVReader", "Inserted: " + name);
                } catch (NumberFormatException e) {
                    // 잘못된 값이 발견되었을 때, 기본값으로 설정하거나 무시할 수 있습니다.
                    // 이 예제에서는 기본값으로 0을 설정합니다.
                    calories = 0;
                    protein = 0;
                    fat = 0;
                    carbohydrate = 0;
                }

                Food food = new Food();
                food.setName(name);
                food.setCalories((int) calories);
                food.setProtein((int) protein);
                food.setFat((int) fat);
                food.setCarbohydrate((int) carbohydrate);

                // 백그라운드 스레드에서 데이터 삽입
                executor.execute(() -> db.foodDao().insert(food));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
