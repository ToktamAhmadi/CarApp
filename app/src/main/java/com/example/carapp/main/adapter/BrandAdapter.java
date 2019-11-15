package com.example.carapp.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.carapp.R;
import com.example.carapp.model.data.Brand;
import com.example.carapp.service.ImageLoadingService;
import com.example.carapp.view.MyImageView;
import com.example.carapp.view.RvAdapter;
import com.example.carapp.view.RvViewHolder;

import java.util.List;

import androidx.annotation.NonNull;

public class BrandAdapter extends RvAdapter<Brand, BrandAdapter.BrandViewHolder> {
    private final ImageLoadingService imageLoadingService;

    public BrandAdapter(List<Brand> brands, ImageLoadingService imageLoadingService) {
        super(brands);
        this.imageLoadingService = imageLoadingService;
    }

    @NonNull
    @Override
    public BrandViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BrandViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_brand, parent, false
        ));
    }

    public class BrandViewHolder extends RvViewHolder<Brand> {
        private MyImageView imageView;
        private TextView textView;

        public BrandViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_brand);
            textView = itemView.findViewById(R.id.tv_brand);
        }

        @Override
        public void bind(Brand item) {
            imageLoadingService.loadImage(imageView, item.getImageUrl());
            textView.setText(item.getTitle());
        }
    }
}
