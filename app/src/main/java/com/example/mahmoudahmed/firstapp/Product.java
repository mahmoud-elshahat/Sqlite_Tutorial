package com.example.mahmoudahmed.firstapp;

/**
 * Created by Mahmoud Ahmed on 3/24/2017.
 */

public class Product {
    public int id;
    public String name;
    public int price;

    public Product(int price, String name) {
        this.price = price;
        this.name = name;
    }
    public Product(int id, String name,int price) {
        this.price = price;
        this.name = name;
        this.id=id;
    }

}
