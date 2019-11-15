package com.example.carapp.model.db;

import android.content.Context;

import com.example.carapp.model.data.Car;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Car.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase appDatabase;

    public static AppDatabase getInstance(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "db_seven")
                    .build();
        }
        return appDatabase;
    }

    public abstract CarDao carDao();
}
