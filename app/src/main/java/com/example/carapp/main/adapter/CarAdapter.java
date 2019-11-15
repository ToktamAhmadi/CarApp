package com.example.carapp.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.carapp.R;
import com.example.carapp.model.data.Car;
import com.example.carapp.service.ImageLoadingService;
import com.example.carapp.view.MyImageView;
import com.example.carapp.view.RvAdapter;
import com.example.carapp.view.RvViewHolder;

import java.util.List;

import androidx.annotation.NonNull;

public class CarAdapter extends RvAdapter<Car, CarAdapter.CarViewHolder> {
    private ImageLoadingService imageLoadingService;

    public CarAdapter(List<Car> cars, ImageLoadingService imageLoadingService) {
        super(cars);
        this.imageLoadingService = imageLoadingService;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CarViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_car, parent, false
        ));
    }

    public class CarViewHolder extends RvViewHolder<Car> {
        private MyImageView carIv;
        private TextView titleTv;
        private TextView modelYearTv;
        private TextView priceTv;

        public CarViewHolder(@NonNull View itemView) {
            super(itemView);

            carIv = itemView.findViewById(R.id.iv_car);
            titleTv = itemView.findViewById(R.id.tv_car_title);
            modelYearTv = itemView.findViewById(R.id.tv_car_year);
            priceTv = itemView.findViewById(R.id.tv_car_price);
        }

        @Override
        public void bind(Car item) {
            titleTv.setText(item.getBrand() + " " + item.getTitle());
            modelYearTv.setText(item.getModel().toString());
            priceTv.setText(item.getPrice());
            imageLoadingService.loadImage(carIv, item.getImageUrl());
        }
    }
}
