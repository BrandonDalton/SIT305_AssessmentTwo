package com.example.sit305_assessmenttwo;

public class item {
    int id;
    String name;
    String brand;
    int stock;

    // constructors
    public item() {
    }

    public item(String name, String brand, int stock) {
        this.name = name;
        this.brand = brand;
        this.stock = stock;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getBrand() {
        return this.brand;
    }

    public int getStock() {
        return this.stock;
    }
}
