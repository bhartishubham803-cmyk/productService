package com.shubhambharti.productservice.models;

public class Product {
    private String id;
    private String name;
    private String description;
    private double price;
    private String CategoryId;
    public Product() {
    }
    public Product(String id, String name, String description, double price, String categoryId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        CategoryId = categoryId;
    }
}
