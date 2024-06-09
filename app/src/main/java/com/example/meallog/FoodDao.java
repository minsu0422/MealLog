package com.example.meallog;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FoodDao {
    @Insert
    void insert(Food food);

    @Query("SELECT * FROM food_table")
    List<Food> getAllFoods();
}

