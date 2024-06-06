package com.example.meallog;

public class Meal {
    private String calorieRange;
    private int imageResourceId;  // 이미지 리소스 ID 추가

    public Meal(String calorieRange, int imageResourceId) {
        this.calorieRange = calorieRange;
        this.imageResourceId = imageResourceId;
    }

    public String getCalorieRange() {
        return calorieRange;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}


