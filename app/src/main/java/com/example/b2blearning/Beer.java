package com.example.b2blearning;

public class Beer {
    private String title;
    private String description;
    private String price;
    private String nameOfImage;

    public Beer (String title, String description, String price){
        this.title = title;
        this.description = description;
        this.price = price;
        this.nameOfImage = nameOfImage;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getNameOfImage() {
        return nameOfImage;
    }
}
