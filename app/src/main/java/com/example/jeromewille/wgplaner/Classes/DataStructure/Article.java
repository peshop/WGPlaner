package com.example.jeromewille.wgplaner.Classes.DataStructure;

/**
 * Created by jeromewille on 05.12.2017.
 */

public class Article
{
    private String name;
    private String description;
    private float price;

    public Article(String name, String description, float price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }
}
