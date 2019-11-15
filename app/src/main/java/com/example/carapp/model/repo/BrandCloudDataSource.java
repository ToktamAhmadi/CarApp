package com.example.carapp.model.repo;



import com.example.carapp.http.ApiService;
import com.example.carapp.model.data.Brand;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public class BrandCloudDataSource implements BrandDataSource {
    private ApiService apiService;

    public BrandCloudDataSource(ApiService apiService)
    {this.apiService=apiService;}

    @Override
    public Single<Brand> get(Integer id) {
        return null;
    }

    @Override
    public Comparable delete(Brand item) {
        return null;
    }

    @Override
    public Single<List<Brand>> getAll(int page) {
        return apiService.brands();
    }

    @Override
    public Single<Brand> inert(Brand item) {
        return null;
    }

    @Override
    public Single<Brand> update(Brand item) {
        return null;
    }
}
