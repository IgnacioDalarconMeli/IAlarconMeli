package com.example.o78308.iameli.networking.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Picture implements Parcelable {

    private String id;
    private String max_size;
    @SerializedName("variations")
    private ArrayList<Variations> variationsArrayList;

    protected Picture(Parcel in) {
        id = in.readString();
        max_size = in.readString();
    }

    public static final Creator<Picture> CREATOR = new Creator<Picture>() {
        @Override
        public Picture createFromParcel(Parcel in) {
            return new Picture(in);
        }

        @Override
        public Picture[] newArray(int size) {
            return new Picture[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(max_size);
    }

    public String getId() {
        return id;
    }

    public ArrayList<Variations> getVariationsArrayList() {
        return variationsArrayList;
    }

}
