
package com.example.carapp.model.data;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Brand {

    @SerializedName("id")
    private Long mId;
    @SerializedName("image_url")
    private String mImageUrl;
    @SerializedName("title")
    private String mTitle;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}
