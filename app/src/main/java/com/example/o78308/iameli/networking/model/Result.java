package com.example.o78308.iameli.networking.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

public class Result implements Parcelable {

    private String id;
    private String title;
    private Double price;
    private String currency_id;
    private Integer available_quantity;
    private Integer sold_quantity;
    private String thumbnail;
    private Seller seller;
    private String condition;

    public Result() {
    }


    protected Result(Parcel in) {
        id = in.readString();
        title = in.readString();
        if (in.readByte() == 0) {
            price = null;
        } else {
            price = in.readDouble();
        }
        currency_id = in.readString();
        if (in.readByte() == 0) {
            available_quantity = null;
        } else {
            available_quantity = in.readInt();
        }
        if (in.readByte() == 0) {
            sold_quantity = null;
        } else {
            sold_quantity = in.readInt();
        }
        thumbnail = in.readString();
        condition = in.readString();
    }

    public static final Creator<Result> CREATOR = new Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(title);
        if (price == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(price);
        }
        dest.writeString(currency_id);
        if (available_quantity == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(available_quantity);
        }
        if (sold_quantity == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(sold_quantity);
        }
        dest.writeString(thumbnail);
        dest.writeString(condition);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    public String getCurrency_id() {
        return currency_id;
    }

    public Integer getAvailable_quantity() {
        return available_quantity;
    }

    public Integer getSold_quantity() {
        return sold_quantity;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public Seller getSeller() {
        return seller;
    }

    public String getCondition() {
        return condition;
    }

    public static Creator<Result> getCREATOR() {
        return CREATOR;
    }
}
