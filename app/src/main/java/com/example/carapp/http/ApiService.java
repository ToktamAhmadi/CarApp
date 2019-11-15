package com.example.carapp.http;

import com.example.carapp.model.data.Brand;
import com.example.carapp.model.data.Car;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiService {
    @GET("ytaxr")
    Single<List<Car>> cars();

    @GET("7706n")
    Single<List<Brand>> brands();
}
