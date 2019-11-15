package com.example.carapp.main;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carapp.R;
import com.example.carapp.base.ObserverFragment;
import com.example.carapp.http.ApiService;
import com.example.carapp.http.ApiServiceContainer;
import com.example.carapp.main.adapter.BrandAdapter;
import com.example.carapp.main.adapter.CarAdapter;
import com.example.carapp.model.data.Brand;
import com.example.carapp.model.data.Car;
import com.example.carapp.model.repo.BrandCloudDataSource;
import com.example.carapp.model.repo.BrandRepository;
import com.example.carapp.model.repo.CarCloudDataSource;
import com.example.carapp.model.repo.CarRepository;
import com.example.carapp.service.ImageLoadingServiceInjector;
import com.example.carapp.view.OnRvItemClickListener;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainFragment extends ObserverFragment {

    private MainViewModel mainViewModel;
    private static final String TAG = "MainFragment";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainViewModel= new MainViewModel(new CarRepository(new CarCloudDataSource(ApiServiceContainer.getApiService()))
        ,new BrandRepository(new BrandCloudDataSource(ApiServiceContainer.getApiService())));
    }


    @Override
    public void subscribe() {
        mainViewModel.getCars()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Car>>() {
                    @Override
                    public void onSubscribe(Disposable d) {


                    }

                    @Override
                    public void onSuccess(List<Car> cars) {
                        RecyclerView recyclerView = getView().findViewById(R.id.rv_main_cars);
                        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false));
                        CarAdapter carAdapter = new CarAdapter(cars, ImageLoadingServiceInjector.getImageLoadingService());
                        carAdapter.setOnRvItemClickListener(new OnRvItemClickListener<Car>() {
                            @Override
                            public void onItemClick(Car item, int position) {
                                }
                        });
                        recyclerView.setAdapter(carAdapter);
                        }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

        mainViewModel.getBrands()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Brand>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(List<Brand> brands) {
                        Log.e(TAG, "onsu: " + brands.toString());
                        Log.i(TAG, "onSuccess: ");
                       RecyclerView recyclerView = getView().findViewById(R.id.rv_main_brands);
                       recyclerView.setLayoutManager(new LinearLayoutManager(
                               getContext(), RecyclerView.HORIZONTAL, false

                       ));
                        recyclerView.setAdapter(new BrandAdapter(brands, ImageLoadingServiceInjector.getImageLoadingService()));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e.toString());
                    }
                });


    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_main;
    }
}
