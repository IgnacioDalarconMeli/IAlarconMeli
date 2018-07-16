package com.example.o78308.iameli.networking.model;

public class Seller {
    Integer id;
    String power_seller_status;
    Boolean car_dealer;
    Boolean real_state_agency;

    public Seller() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPower_seller_status() {
        return power_seller_status;
    }

    public void setPower_seller_status(String power_seller_status) {
        this.power_seller_status = power_seller_status;
    }

    public Boolean getCar_dealer() {
        return car_dealer;
    }

    public void setCar_dealer(Boolean car_dealer) {
        this.car_dealer = car_dealer;
    }

    public Boolean getReal_state_agency() {
        return real_state_agency;
    }

    public void setReal_state_agency(Boolean real_state_agency) {
        this.real_state_agency = real_state_agency;
    }
}
