package com.example.sit305_assessmenttwo;

public class item {
    //Item Variables
    String name;
    String brand;
    String stock;

    public item() {
    }

    //Setting Inputted To Values
    public item(String name, String brand, String stock) {
        this.name = name;
        this.brand = brand;
        this.stock = stock;
    }
    //Helper Functions To Set And Retrieve Certain Item Variables
    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getName() {
        return this.name;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getStock() {
        return this.stock;
    }
}
