package com.example.travelapplication;

public class MainModel {
    String name, nameProvince,price, describe,picture;


    MainModel(){

    }

    public MainModel(String name, String nameProvince, String price, String describe, String picture) {
        this.name = name;
        this.nameProvince = nameProvince;
        this.price = price;
        this.describe = describe;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameProvince() {
        return nameProvince;
    }

    public void setNameProvince(String nameProvince) {
        this.nameProvince = nameProvince;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
