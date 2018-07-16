package com.example.o78308.iameli.networking.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Paging implements Parcelable{
    private Integer total;
    private Integer offset;
    private Integer limit;
    private Integer primary_results;


    protected Paging(Parcel in) {
        if (in.readByte() == 0) {
            total = null;
        } else {
            total = in.readInt();
        }
        if (in.readByte() == 0) {
            offset = null;
        } else {
            offset = in.readInt();
        }
        if (in.readByte() == 0) {
            limit = null;
        } else {
            limit = in.readInt();
        }
        if (in.readByte() == 0) {
            primary_results = null;
        } else {
            primary_results = in.readInt();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (total == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(total);
        }
        if (offset == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(offset);
        }
        if (limit == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(limit);
        }
        if (primary_results == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(primary_results);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Paging> CREATOR = new Creator<Paging>() {
        @Override
        public Paging createFromParcel(Parcel in) {
            return new Paging(in);
        }

        @Override
        public Paging[] newArray(int size) {
            return new Paging[size];
        }
    };

    public Integer getTotal() {
        return total;
    }

    public Integer getOffset() {
        return offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public Integer getPrimary_results() {
        return primary_results;
    }

    public static Creator<Paging> getCREATOR() {
        return CREATOR;
    }
}
