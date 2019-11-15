package com.example.carapp.model.repo;

import com.example.carapp.model.data.Car;

import java.util.List;

import io.reactivex.Single;

public class CarRepository {

    private CarDataSource carCloudDataSource;
    private CarDataSource carLocalDataSource;

    public CarRepository(CarDataSource carCloudDataSource) {

        this.carCloudDataSource = carCloudDataSource;

    }
    public Single<List<Car>> getCar(){
        return carCloudDataSource.getAll(0);
    }
}
