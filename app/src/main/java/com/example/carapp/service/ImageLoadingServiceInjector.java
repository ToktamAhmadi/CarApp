package com.example.carapp.service;

public class ImageLoadingServiceInjector {
    private static ImageLoadingService imageLoadingService;

    public static ImageLoadingService getImageLoadingService() {
        if (imageLoadingService == null) {
            imageLoadingService = new FrescoImageLoadingService();
        }
        return imageLoadingService;
    }
}
