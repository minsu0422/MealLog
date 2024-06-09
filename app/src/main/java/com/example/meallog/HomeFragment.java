package com.example.meallog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button recommend;

    private ImageView statusImageView;
    private static final String MALE = "Male";
    int kcal;


    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        TextView nameTextView = view.findViewById(R.id.nameTextView);
        TextView heightweightTextView = view.findViewById(R.id.heightweightTextView);
        TextView kcalTextview = view.findViewById(R.id.kcalTextview);
        TextView takekcalTextview = view.findViewById(R.id.takekcalTextview);
        TextView remainkcalTextview = view.findViewById(R.id.remainkcalTextview);
        statusImageView = view.findViewById(R.id.Person);
        // 버튼 찾기
        recommend = view.findViewById(R.id.food_recommend);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("UserPreferences", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "");
        int age = sharedPreferences.getInt("age", 0);
        int height = sharedPreferences.getInt("height", 0);
        int weight = sharedPreferences.getInt("weight", 0);
        String gender = sharedPreferences.getString("gender", "");

        if (MALE.equals(gender)) {
            kcal = (int)((10 * weight) + (6.25 * height) - (5 * age) + 5);
        } else {
            kcal = (int)((10 * weight) + (6.25 * height) - (5 * age) - 161);
        }

        int takeKcal = 1000;
        int total = kcal - takeKcal;

        double remainingPercent = ((double) total / kcal) * 100;
        updateImage(remainingPercent, view);

        String hewe = height + "CM/ " + weight + "Kg";
        String KcalText = "하루 섭취 권장량: " + kcal + "Kcal";
        String TakeKc = "오늘의 섭취량: " + takeKcal + "Kcal";
        String ReamainKc = "오늘 남은 섭취량: " + total + "Kcal";

        nameTextView.setText(name);
        heightweightTextView.setText(hewe);
        kcalTextview.setText(KcalText);
        takekcalTextview.setText(TakeKc);
        remainkcalTextview.setText(ReamainKc);

        recommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                food_recommend foodRecommendFragment = food_recommend.newInstance("Example Param1", "Example Param2");
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, foodRecommendFragment);
                transaction.addToBackStack(null); // 이전 프래그먼트로 돌아갈 수 있게 스택에 추가
                transaction.commit();

            }
        });

        return view;
    }
    private void updateImage(double remainingPercent, View view) {
        int progress = (int) remainingPercent;

        // 이미지 변경
        if (progress >= 100) {
            statusImageView.setImageResource(R.drawable.person_shape_filled);
        } else if (progress >= 95) {
            statusImageView.setImageResource(R.drawable.person_shape_95);
        } else if (progress >= 90) {
            statusImageView.setImageResource(R.drawable.person_shape_90);
        } else if (progress >= 85) {
            statusImageView.setImageResource(R.drawable.person_shape_85);
        } else if (progress >= 80) {
            statusImageView.setImageResource(R.drawable.person_shape_80);
        } else if (progress >= 75) {
            statusImageView.setImageResource(R.drawable.person_shape_75);
        } else if (progress >= 70) {
            statusImageView.setImageResource(R.drawable.person_shape_70);
        } else if (progress >= 65) {
            statusImageView.setImageResource(R.drawable.person_shape_65);
        } else if (progress >= 60) {
            statusImageView.setImageResource(R.drawable.person_shape_60);
        } else if (progress >= 55) {
            statusImageView.setImageResource(R.drawable.person_shape_55);
        } else if (progress >= 50) {
            statusImageView.setImageResource(R.drawable.person_shape_50);
        } else if (progress >= 45) {
            statusImageView.setImageResource(R.drawable.person_shape_45);
        } else if (progress >= 40) {
            statusImageView.setImageResource(R.drawable.person_shape_40);
        } else if (progress >= 35) {
            statusImageView.setImageResource(R.drawable.person_shape_35);
        } else if (progress >= 30) {
            statusImageView.setImageResource(R.drawable.person_shape_30);
        } else if (progress >= 25) {
            statusImageView.setImageResource(R.drawable.person_shape_25);
        } else if (progress >= 20) {
            statusImageView.setImageResource(R.drawable.person_shape_20);
        } else if (progress >= 15) {
            statusImageView.setImageResource(R.drawable.person_shape_15);
        } else if (progress >= 10) {
            statusImageView.setImageResource(R.drawable.person_shape_10);
        } else if (progress >= 5) {
            statusImageView.setImageResource(R.drawable.person_shape_05);
        } else {
            statusImageView.setImageResource(R.drawable.person_shape_empty);
        }
    }


}