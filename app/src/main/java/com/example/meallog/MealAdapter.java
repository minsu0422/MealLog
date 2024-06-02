package com.example.meallog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.MealViewHolder> {

    private List<Meal> meals; // Replace Meal with your data class
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Meal meal);
    }

    public MealAdapter(List<Meal> meals, OnItemClickListener listener) {
        this.meals = meals;
        this.listener = listener;
    }

    @Override
    public MealViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meal, parent, false);
        return new MealViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MealViewHolder holder, int position) {
        Meal meal = meals.get(position);
        holder.mealRange.setText(meal.getRange());
        holder.mealArrow.setOnClickListener(view -> listener.onItemClick(meal));
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    static class MealViewHolder extends RecyclerView.ViewHolder {
        ImageView mealIcon;
        TextView mealRange;
        ImageButton mealArrow;

        public MealViewHolder(View itemView) {
            super(itemView);
            mealIcon = itemView.findViewById(R.id.mealIcon);
            mealRange = itemView.findViewById(R.id.mealRange);
            mealArrow = itemView.findViewById(R.id.mealArrow);
        }
    }
}
