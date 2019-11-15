package com.example.carapp.model.repo;

import com.example.carapp.model.data.Brand;

import java.util.List;

import io.reactivex.Single;

public class BrandRepository {
    private BrandDataSource brandCloudDataSource;

    public BrandRepository(BrandDataSource brandCloudDataSource) {

        this.brandCloudDataSource = brandCloudDataSource;
    }

    public Single<List<Brand>> getBrands() {
        return brandCloudDataSource.getAll(0);
    }
}
