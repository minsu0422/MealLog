// food_recommend.java

package com.example.meallog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
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
        meals.add(new Meal("100kcal 이하", R.drawable.range_start, 0, 0, 0));
        meals.add(new Meal("100-200kcal", R.drawable.range_100_200, 0, 0, 0));
        meals.add(new Meal("200-300kcal", R.drawable.range_200_300, 0, 0, 0));
        meals.add(new Meal("300-400kcal", R.drawable.range_300_400, 0, 0, 0));
        meals.add(new Meal("400-500kcal", R.drawable.range_400_500, 0, 0, 0));
        meals.add(new Meal("500-600kcal", R.drawable.range_500_600, 0, 0, 0));
        meals.add(new Meal("600-700kcal", R.drawable.range_600_700, 0, 0, 0));
        meals.add(new Meal("700-800kcal", R.drawable.range_700_800, 0, 0, 0));
        meals.add(new Meal("800-900kcal", R.drawable.range_100_200, 0, 0, 0));
        meals.add(new Meal("900-1000kcal", R.drawable.range_900_1000, 0, 0, 0));

        adapter = new MealAdapter(meals, meal -> {
            String calorieRange = meal.getCalorieRange();

            if (calorieRange.equals("100kcal 이하")) {
                replaceFragment(new Fragment100kcalOrLess());
                showToast("100kcal 이하 클릭됨");
            } else if (calorieRange.equals("100-200kcal")) {
                replaceFragment(new Fragment100to200kcal());
                showToast("100-200kcal 클릭됨");
            } else if (calorieRange.equals("200-300kcal")) {
                replaceFragment(new Fragment200to300kcal());
                showToast("200-300kcal 클릭됨");
            } else if (calorieRange.equals("300-400kcal")) {
                replaceFragment(new Fragment300to400kcal());
                showToast("300-400kcal 클릭됨");
            } else if (calorieRange.equals("400-500kcal")) {
                replaceFragment(new Fragment400to500kcal());
                showToast("400-500kcal 클릭됨");
            } else if (calorieRange.equals("500-600kcal")) {
                replaceFragment(new Fragment500to600kcal());
                showToast("500-600kcal 클릭됨");
            } else if (calorieRange.equals("600-700kcal")) {
                replaceFragment(new Fragment600to700kcal());
                showToast("600-700kcal 클릭됨");
            } else if (calorieRange.equals("700-800kcal")) {
                replaceFragment(new Fragment700to800kcal());
                showToast("700-800kcal 클릭됨");
            } else if (calorieRange.equals("800-900kcal")) {
                replaceFragment(new Fragment800to900kcal());
                showToast("800-900kcal 클릭됨");
            } else if (calorieRange.equals("900-1000kcal")) {
                replaceFragment(new Fragment900to1000kcal());
                showToast("900-1000kcal 클릭됨");
            }
        });

        recyclerView.setAdapter(adapter);

        return view;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
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