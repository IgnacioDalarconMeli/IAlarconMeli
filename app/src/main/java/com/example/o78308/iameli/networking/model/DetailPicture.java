package com.example.o78308.iameli.networking.model;

import android.os.Parcel;
import android.os.Parcelable;

public class DetailPicture implements Parcelable {

    private String id;
    private String url;
    private String size;

    private DetailPicture(Parcel in) {
        id = in.readString();
        url = in.readString();
        size = in.readString();
    }

    public static final Creator<DetailPicture> CREATOR = new Creator<DetailPicture>() {
        @Override
        public DetailPicture createFromParcel(Parcel in) {
            return new DetailPicture(in);
        }

        @Override
        public DetailPicture[] newArray(int size) {
            return new DetailPicture[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(url);
        dest.writeString(size);
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getSize() {
        return size;
    }
}
