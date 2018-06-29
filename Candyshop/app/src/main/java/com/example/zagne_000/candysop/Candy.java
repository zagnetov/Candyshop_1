package com.example.zagne_000.candysop;

import java.io.Serializable;

public class Candy implements Serializable {
    int image;
    String name;
    String description;
    String price;
    String category;

    public Candy(int image, String name, String description, String price, String category) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

