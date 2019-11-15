package com.example.carapp.model.db;


import com.example.carapp.model.data.Car;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Single;

@Dao
public interface CarDao {

    @Query("SELECT * FROM tbl_cars")
    Single<List<Car>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Car car);

    @Delete
    int delete(Car car);

}
