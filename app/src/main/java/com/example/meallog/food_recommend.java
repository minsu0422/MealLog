package com.example.meallog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class food_recommend extends Fragment {

    private RecyclerView recyclerView;
    private MealAdapter adapter;
    private List<Meal> meals;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food_recommend, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));  // getContext()로 컨텍스트 전달

        meals = new ArrayList<>();
        meals.add(new Meal("100-200kcal"));  // 예시 데이터 추가
        // Add more meals as needed

        adapter = new MealAdapter(meals, meal -> {
            // Handle click event
            Toast.makeText(getContext(), "Clicked on " + meal.getRange(), Toast.LENGTH_SHORT).show();
        });
        recyclerView.setAdapter(adapter);

        return view;  // 뷰 반환
    }
}

