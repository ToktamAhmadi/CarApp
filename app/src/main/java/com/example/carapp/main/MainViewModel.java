package com.example.carapp.main;

import com.example.carapp.base.BaseViewModel;
import com.example.carapp.model.data.Brand;
import com.example.carapp.model.data.Car;
import com.example.carapp.model.repo.BrandRepository;
import com.example.carapp.model.repo.CarRepository;

import java.util.List;

import io.reactivex.Single;

public class MainViewModel extends BaseViewModel
{
    private CarRepository carRepository;
    private BrandRepository brandRepository;

    public MainViewModel(CarRepository carRepository,BrandRepository brandRepository)
    {
        this.carRepository = carRepository;
        this.brandRepository = brandRepository;
    }

    public Single<List<Car>> getCars(){
        return carRepository.getCar();
    }

    public Single<List<Brand>> getBrands()
    {
        return brandRepository.getBrands();
    }

}
