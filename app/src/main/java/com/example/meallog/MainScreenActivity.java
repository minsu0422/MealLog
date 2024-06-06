package com.example.meallog;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainScreenActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        BottomNavigationView navView = findViewById(R.id.navigation);


        navView.setOnItemSelectedListener(item -> {
            Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.frame_container);
            Fragment selectedFragment = null;
            int id = item.getItemId(); // item의 ID를 가져옵니다.

            if (id == R.id.navigation_home) {
                if (!(currentFragment instanceof HomeFragment)) {
                    selectedFragment = new HomeFragment(); // 홈 프래그먼트
                }
            } else if (id == R.id.navigation_food_input) {
                selectedFragment = new FoodInputFragment(); // 음식 입력 프래그먼트
            } else if (id == R.id.navigation_board) {
                selectedFragment = new MainBoard(); // 게시판 프래그먼트
            } else if (id == R.id.navigation_statistics) {
                selectedFragment = new StatisticsFragment(); // 통계 프래그먼트
            }
            // 선택된 프래그먼트가 존재하고, 현재 프래그먼트와 다르며, 현재 프래그먼트가 null이 아닐 때에만 FrameLayout 컨테이너에 적용
            if (selectedFragment != null && (currentFragment == null || !selectedFragment.getClass().equals(currentFragment.getClass()))) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, selectedFragment).commit();
            }
            return true; // 이벤트가 처리되었음을 나타냄
        });


        // 이미 선택된 아이템 다시 선택 이벤트 처리
        navView.setOnItemReselectedListener(item -> {
            // 다시 선택된 아이템에 대한 특별한 반응이 필요한 경우 여기에 로직 추가
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new HomeFragment()).commit();
        }
    }

    }


