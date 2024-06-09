// Meal.java

package com.example.meallog;

public class Meal {
    private String name;
    private int calories;
    private int protein;
    private int fat;
    private int carbohydrate;
    private String calorieRange;

    public Meal(String name, int calories, int protein, int fat, int carbohydrate) {
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
        this.calorieRange = calculateCalorieRange(calories); // 초기화 시 칼로리 범위 계산
    }

    // 각 필드에 대한 getter 메서드
    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public int getProtein() {
        return protein;
    }

    public int getFat() {
        return fat;
    }

    public int getCarbohydrate() {
        return carbohydrate;
    }


    public String getCalorieRange() {
        return calorieRange;
    }

    private String calculateCalorieRange(int calories) {
        if (calories <= 100) {
            return "100kcal 이하";
        } else if (calories <= 200) {
            return "100-200kcal";
        } else if (calories <= 300) {
            return "200-300kcal";
        } else if (calories <= 400) {
            return "300-400kcal";
        } else if (calories <= 500) {
            return "400-500kcal";
        } else if (calories <= 600) {
            return "500-600kcal";
        } else if (calories <= 700) {
            return "600-700kcal";
        } else if (calories <= 800) {
            return "700-800kcal";
        } else if (calories <= 900) {
            return "800-900kcal";
        } else {
            return "900-1000kcal";
        }
    }
}
