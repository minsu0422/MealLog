package com.example.meallog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Fragment800to900kcal extends Fragment {

    private RecyclerView recyclerView;
    private MealAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment800to900kcal, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // 데이터 리스트 생성
        List<Meal> meals = generateMeals200to300kcal();

        // 어댑터 초기화 및 설정
        adapter = new MealAdapter(meals, new MealAdapter.OnMealClickListener() {
            @Override
            public void onMealClick(Meal meal) {
                // 리사이클러뷰의 아이템 클릭 이벤트 처리
            }
        });
        recyclerView.setAdapter(adapter);

        return view;
    }

    // 200에서 300 칼로리 사이의 음식 데이터를 생성하는 메서드
    private List<Meal> generateMeals200to300kcal() {
        List<Meal> meals = new ArrayList<>();
        // TODO: 필요한 데이터를 생성하고 리스트에 추가하는 로직을 작성하세요.
        return meals;
    }
}
