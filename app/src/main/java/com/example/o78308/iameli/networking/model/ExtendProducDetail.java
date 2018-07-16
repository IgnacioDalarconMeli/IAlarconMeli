package com.example.o78308.iameli.networking.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ExtendProducDetail implements Parcelable {

    private String text;
    private String plain_text;
    private String date_created;
    private String last_updated;

    protected ExtendProducDetail(Parcel in) {
        text = in.readString();
        plain_text = in.readString();
        date_created = in.readString();
        last_updated = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(text);
        dest.writeString(plain_text);
        dest.writeString(date_created);
        dest.writeString(last_updated);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ExtendProducDetail> CREATOR = new Creator<ExtendProducDetail>() {
        @Override
        public ExtendProducDetail createFromParcel(Parcel in) {
            return new ExtendProducDetail(in);
        }

        @Override
        public ExtendProducDetail[] newArray(int size) {
            return new ExtendProducDetail[size];
        }
    };

    public String getText() {
        return text;
    }

    public String getPlain_text() {
        return plain_text;
    }

    public static Creator<ExtendProducDetail> getCREATOR() {
        return CREATOR;
    }
}
