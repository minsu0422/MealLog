// MealAdapter.java

package com.example.meallog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.MealViewHolder> {

    private List<Meal> meals;
    private OnMealClickListener listener;

    public MealAdapter(List<Meal> meals, OnMealClickListener listener) {
        this.meals = meals;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_calorie_range, parent, false); // item_calorie_range.xml 사용
        return new MealViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealViewHolder holder, int position) {
        Meal meal = meals.get(position);
        holder.bind(meal, listener);
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    public interface OnMealClickListener {
        void onMealClick(Meal meal);
    }

    static class MealViewHolder extends RecyclerView.ViewHolder {

        private TextView calorieRangeView;
        private ImageView imageView;

        public MealViewHolder(@NonNull View itemView) {
            super(itemView);
            calorieRangeView = itemView.findViewById(R.id.calorieRange);
            imageView = itemView.findViewById(R.id.imageView);
        }

        public void bind(Meal meal, OnMealClickListener listener) {
            calorieRangeView.setText(meal.getCalorieRange());


            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onMealClick(meal); // meal 객체 전달
                }
            });
        }
    }
}