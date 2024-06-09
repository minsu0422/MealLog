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

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView recyclerView;
    private MealAdapter adapter;
    private List<Meal> meals;

    private String mParam1;
    private String mParam2;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food_recommend, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        meals = new ArrayList<>();
        meals.add(new Meal("100kcal 이하", R.drawable.range_start));
        meals.add(new Meal("100-200kcal", R.drawable.range_100_200));
        meals.add(new Meal("200-300kcal", R.drawable.range_200_300));
        meals.add(new Meal("300-400kcal", R.drawable.range_300_400));
        meals.add(new Meal("400-500kcal", R.drawable.range_400_500));
        meals.add(new Meal("500-600kcal", R.drawable.range_500_600));
        meals.add(new Meal("700-800kcal", R.drawable.range_600_700));
        meals.add(new Meal("800-900kcal", R.drawable.range_700_800));
        meals.add(new Meal("900-1000kcal", R.drawable.range_900_1000));





        adapter = new MealAdapter(meals, meal -> {
            Toast.makeText(getContext(), "Clicked on " + meal.getCalorieRange(), Toast.LENGTH_SHORT).show();
        });
        recyclerView.setAdapter(adapter);

        return view;
    }


    public static food_recommend newInstance(String param1, String param2) {
        food_recommend fragment = new food_recommend();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

}