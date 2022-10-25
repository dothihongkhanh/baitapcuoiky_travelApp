package com.example.travelapplication;

public class Destination {
    String name, nameProvince,price, describe;
    int picture;

    public Destination(String name, String nameProvince, String price, String describe, int picture) {
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

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}
