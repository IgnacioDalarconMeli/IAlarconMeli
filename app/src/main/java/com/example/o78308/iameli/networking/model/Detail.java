package com.example.o78308.iameli.networking.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Detail implements Parcelable {

    private String id;
    private String title;
    private String subtitle;
    private Double price;
    private String currency_id;
    private Integer available_quantity;
    private Integer sold_quantity;
    private Boolean accepts_mercadopago;
    private String condition;
    private ArrayList<DetailPicture> pictures;


    protected Detail(Parcel in) {
        id = in.readString();
        title = in.readString();
        subtitle = in.readString();
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
        byte tmpAccepts_mercadopago = in.readByte();
        accepts_mercadopago = tmpAccepts_mercadopago == 0 ? null : tmpAccepts_mercadopago == 1;
        condition = in.readString();
        pictures = in.createTypedArrayList(DetailPicture.CREATOR);
    }

    public static final Creator<Detail> CREATOR = new Creator<Detail>() {
        @Override
        public Detail createFromParcel(Parcel in) {
            return new Detail(in);
        }

        @Override
        public Detail[] newArray(int size) {
            return new Detail[size];
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
        dest.writeString(subtitle);
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
        dest.writeByte((byte) (accepts_mercadopago == null ? 0 : accepts_mercadopago ? 1 : 2));
        dest.writeString(condition);
        dest.writeTypedList(pictures);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getAvailable_quantity() {
        return available_quantity;
    }

    public Integer getSold_quantity() {
        return sold_quantity;
    }

    public Boolean getAccepts_mercadopago() {
        return accepts_mercadopago;
    }
    
    public ArrayList<DetailPicture> getPictures() {
        return pictures;
    }
}
