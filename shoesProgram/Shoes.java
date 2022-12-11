package com.example.ex4;

import java.io.Serializable;

public class Shoes implements Serializable { // 객체 직렬화(implements Serializable)
    private String name;
    private String price;
    private String brand;
    private String date;

    //생성자
    public Shoes(String name, String price, String brand, String date) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.date = date;
    }

    // getter() / setter() 구현
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
