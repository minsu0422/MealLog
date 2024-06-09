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

public class Fragment100kcalOrLess extends Fragment {

    private RecyclerView recyclerView;
    private MealAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment100kcal_or_less, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // 내부 DB에서 칼로리가 100 이하인 음식 정보를 가져와서 어댑터에 설정합니다.
        adapter = new MealAdapter(getMealsUnder100kcal(), meal -> {
            // 클릭한 음식에 대한 동작을 추가할 수 있습니다.
        });
        recyclerView.setAdapter(adapter);

        return view;
    }

    // 내부 DB에서 칼로리가 100 이하인 음식 정보를 가져오는 메서드입니다.
    private List<Meal> getMealsUnder100kcal() {
        List<Meal> meals = new ArrayList<>();
        SQLiteDatabase db = getActivity().openOrCreateDatabase("food_database", Context.MODE_PRIVATE, null);

        // 칼로리가 100 이하인 음식 정보를 쿼리합니다.
        Cursor cursor = db.rawQuery("SELECT * FROM food_database WHERE calories <= 100", null);
        if (cursor != null) {
            int nameIndex = cursor.getColumnIndex("name");
            int caloriesIndex = cursor.getColumnIndex("calories");
            int proteinIndex = cursor.getColumnIndex("protein");
            int fatIndex = cursor.getColumnIndex("fat");
            int carbohydrateIndex = cursor.getColumnIndex("carbohydrate");

            while (cursor.moveToNext()) {
                // 각 행에서 데이터를 가져와서 Meal 객체를 생성하고 리스트에 추가합니다.
                String name = cursor.getString(nameIndex);
                int calories = cursor.getInt(caloriesIndex);
                int protein = cursor.getInt(proteinIndex);
                int fat = cursor.getInt(fatIndex);
                int carbohydrate = cursor.getInt(carbohydrateIndex);

                meals.add(new Meal(name, calories, protein, fat, carbohydrate));
            }

            // 리소스를 해제합니다.
            cursor.close();
        }
        db.close();

        return meals;
    }
}
