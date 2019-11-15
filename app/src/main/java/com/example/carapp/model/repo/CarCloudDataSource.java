package com.example.carapp.model.repo;

import com.example.carapp.http.ApiService;
import com.example.carapp.model.data.Car;

import java.util.List;

import io.reactivex.Single;

public class CarCloudDataSource implements CarDataSource {
    private ApiService apiService;
    public CarCloudDataSource(ApiService apiService)
    {
        this.apiService=apiService;
    }

    @Override
    public Single<Car> get(Integer id) {
        return null;
    }

    @Override
    public Comparable delete(Car item) {
        return null;
    }

    @Override
    public Single<List<Car>> getAll(int page) {
        return apiService.cars();
    }

    @Override
    public Single<Car> inert(Car item) {
        return null;
    }

    @Override
    public Single<Car> update(Car item) {
        return null;
    }
}
