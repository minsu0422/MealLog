package com.example.meallog;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Record.class}, version = 2, exportSchema = false)
public abstract class RecordDatabase extends RoomDatabase {

    private static volatile RecordDatabase INSTANCE;

    public abstract RecordDao recordDao();

    public static RecordDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RecordDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    RecordDatabase.class, "record_database")
                            .addMigrations(MIGRATION_1_2) // 마이그레이션 코드 추가
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // 이전 버전에서 새로운 버전으로의 마이그레이션 작업을 수행합니다.
        }
    };
}


