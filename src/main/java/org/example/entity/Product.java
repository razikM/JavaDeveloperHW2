package org.example.entity;

public class Product {

    private char code;
    private double price;

    public Product(char code, double price) {
        this.code = code;
        this.price = price;
    }

    public char getCode() {
        return code;
    }

    public void setCode(char code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
