    package com.example.meallog;

    import android.content.SharedPreferences;
    import android.os.Bundle;
    import android.widget.ImageView;
    import android.widget.TextView;

    import androidx.appcompat.app.AppCompatActivity;
    import androidx.fragment.app.Fragment;
    import androidx.fragment.app.FragmentManager;
    import androidx.fragment.app.FragmentTransaction;

    import com.google.android.material.bottomnavigation.BottomNavigationView;

    public class MainScreenActivity extends AppCompatActivity {

        private ImageView statusImageView;
        private static final String MALE = "Male";
        int kcal;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_screen);

            // 텍스트뷰 찾기
            TextView nameTextView = findViewById(R.id.nameTextView);
            TextView heightweightTextView = findViewById(R.id.heightweightTextView);
            TextView kcalTextview = findViewById(R.id.kcalTextview);
            TextView takekcalTextview = findViewById(R.id.takekcalTextview);
            TextView remainkcalTextview = findViewById(R.id.remainkcalTextview);
            statusImageView = findViewById(R.id.Person); // statusImageView 초기화

            // 값 설정
            SharedPreferences sharedPreferences = getSharedPreferences("UserPreferences", MODE_PRIVATE);
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

            // 남은 비율 계산
            double remainingPercent = ((double) total / kcal) * 100;
            updateImage(remainingPercent);

            String hewe = height + "CM/ " + weight + "Kg";
            String KcalText = "하루 섭취 권장량: " + kcal + "Kcal";
            String TakeKc = "오늘의 섭취량: " + takeKcal + "Kcal";
            String ReamainKc = "오늘 남은 섭취량: " + total + "Kcal";

            nameTextView.setText(name);
            heightweightTextView.setText(hewe);
            kcalTextview.setText(KcalText);
            takekcalTextview.setText(TakeKc);
            remainkcalTextview.setText(ReamainKc);

            // 홈 프래그먼트를 초기에 표시
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame_container, new HomeFragment());
            fragmentTransaction.commit();

            // BottomNavigationView 설정
            BottomNavigationView navView = findViewById(R.id.navigation);
            navView.setOnItemSelectedListener(item -> {
                Fragment selectedFragment = null;
                int id = item.getItemId(); // item의 ID를 가져옵니다.

                if (id == R.id.navigation_home) {
                    selectedFragment = new HomeFragment(); // 홈 프래그먼트
                } else if (id == R.id.navigation_food_input) {
                    selectedFragment = new FoodInputFragment(); // 음식 입력 프래그먼트
                } else if (id == R.id.navigation_board) {
                    selectedFragment = new MainBoard(); // 게시판 프래그먼트
                } else if (id == R.id.navigation_statistics) {
                    selectedFragment = new StatisticsFragment(); // 통계 프래그먼트
                }

                // 선택된 프래그먼트가 존재할 때에만 FrameLayout 컨테이너에 적용
                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, selectedFragment).commit();
                }
                return true; // 이벤트가 처리되었음을 나타냄
            });

            // 이미 선택된 아이템 다시 선택 이벤트 처리
            navView.setOnItemReselectedListener(item -> {
                // 다시 선택된 아이템에 대한 특별한 반응이 필요한 경우 여기에 로직 추가
            });
        }

        private void updateImage(double remainingPercent) {
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
