
package com.example.carapp.model.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@SuppressWarnings("unused")
@Entity(tableName = "tbl_cars")
public class Car implements Parcelable {

    @SerializedName("brand")
    private String mBrand;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("id")
    @PrimaryKey
    private Long mId;
    @SerializedName("image_url")
    private String mImageUrl;
    @SerializedName("model")
    private Long mModel;
    @SerializedName("price")
    private String mPrice;
    @SerializedName("title")
    private String mTitle;

    public String getBrand() {
        return mBrand;
    }

    public void setBrand(String brand) {
        mBrand = brand;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

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

    public Long getModel() {
        return mModel;
    }

    public void setModel(Long model) {
        mModel = model;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        mPrice = price;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mBrand);
        dest.writeString(this.mDescription);
        dest.writeValue(this.mId);
        dest.writeString(this.mImageUrl);
        dest.writeValue(this.mModel);
        dest.writeString(this.mPrice);
        dest.writeString(this.mTitle);
    }

    public Car() {
    }

    protected Car(Parcel in) {
        this.mBrand = in.readString();
        this.mDescription = in.readString();
        this.mId = (Long) in.readValue(Long.class.getClassLoader());
        this.mImageUrl = in.readString();
        this.mModel = (Long) in.readValue(Long.class.getClassLoader());
        this.mPrice = in.readString();
        this.mTitle = in.readString();
    }

    public static final Parcelable.Creator<Car> CREATOR = new Parcelable.Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel source) {
            return new Car(source);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };
}
