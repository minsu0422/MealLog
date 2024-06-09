package com.example.meallog;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Fragment100to200kcal extends Fragment {

    private RecyclerView recyclerView;
    private MealAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment100to200kcal, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new MealAdapter(getMealsInRange(100, 200), meal -> {
            // 클릭한 음식에 대한 동작을 추가할 수 있습니다.
        });
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<Meal> getMealsInRange(int minCal, int maxCal) {
        List<Meal> meals = new ArrayList<>();
        SQLiteDatabase db = getActivity().openOrCreateDatabase("food_database", Context.MODE_PRIVATE, null);

        Cursor cursor = db.rawQuery("SELECT * FROM food_database WHERE calories > ? AND calories <= ?", new String[]{String.valueOf(minCal), String.valueOf(maxCal)});
        if (cursor != null) {
            int nameIndex = cursor.getColumnIndex("name");
            int caloriesIndex = cursor.getColumnIndex("calories");
            int proteinIndex = cursor.getColumnIndex("protein");
            int fatIndex = cursor.getColumnIndex("fat");
            int carbohydrateIndex = cursor.getColumnIndex("carbohydrate");

            while (cursor.moveToNext()) {
                String name = cursor.getString(nameIndex);
                int calories = cursor.getInt(caloriesIndex);
                int protein = cursor.getInt(proteinIndex);
                int fat = cursor.getInt(fatIndex);
                int carbohydrate = cursor.getInt(carbohydrateIndex);

                int imageResourceId = findImageResourceId(calories);
                meals.add(new Meal(name, calories, protein, fat, carbohydrate));
            }

            cursor.close();
        }
        db.close();

        return meals;
    }

    private int findImageResourceId(int calories) {
        // 이미지 리소스를 선택하는 로직을 여기에 추가
        return R.drawable.range_100_200; // 예시로 리소스 ID를 반환
    }
}
