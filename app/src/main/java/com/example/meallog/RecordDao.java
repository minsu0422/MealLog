package com.example.meallog;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RecordDao {

    @Insert
    void insert(Record record);

    @Query("SELECT * FROM record_table")
    List<Record> getAllRecords();

    @Query("SELECT * FROM record_table LIMIT :limit")
    List<Record> getLimitedRecords(int limit);

}

