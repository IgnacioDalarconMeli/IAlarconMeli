package com.example.o78308.iameli.networking.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Variations implements Parcelable {

    private String size;
    private String url;
    private String secure_url;


    protected Variations(Parcel in) {
        size = in.readString();
        url = in.readString();
        secure_url = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(size);
        dest.writeString(url);
        dest.writeString(secure_url);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Variations> CREATOR = new Creator<Variations>() {
        @Override
        public Variations createFromParcel(Parcel in) {
            return new Variations(in);
        }

        @Override
        public Variations[] newArray(int size) {
            return new Variations[size];
        }
    };

    public String getSize() {
        return size;
    }

    public String getUrl() {
        return url;
    }

}
