package com.shubhambharti.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String image;
    private String description;
    private double price;
    private String Category;
    public Product() {
    }
    public Product(int id, String title, String description, double price, String category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        Category = category;
    }
}
