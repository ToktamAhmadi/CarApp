package com.example.carapp.service;

import android.net.Uri;

import com.example.carapp.view.MyImageView;


public class FrescoImageLoadingService implements ImageLoadingService {
    @Override
    public void loadImage(MyImageView imageView, String url) {
        imageView.setImageURI(Uri.parse(url));
    }
}
