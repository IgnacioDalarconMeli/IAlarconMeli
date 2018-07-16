package com.example.o78308.iameli.networking.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class ProductListCallback implements Parcelable {

    private String site_id;
    private String query;
    private Paging paging;
    private ArrayList<Result> results;

    protected ProductListCallback(Parcel in) {
        site_id = in.readString();
        query = in.readString();
        results = in.createTypedArrayList(Result.CREATOR);
    }

    public static final Creator<ProductListCallback> CREATOR = new Creator<ProductListCallback>() {
        @Override
        public ProductListCallback createFromParcel(Parcel in) {
            return new ProductListCallback(in);
        }

        @Override
        public ProductListCallback[] newArray(int size) {
            return new ProductListCallback[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(site_id);
        dest.writeString(query);
        dest.writeTypedList(results);
    }

    public ArrayList<Result> getResults() {
        return results;
    }

}
