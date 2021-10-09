package org.example.entity;

public class DiscountProduct extends Product{

    private double discountPrice;
    private int discountNumber;

    public DiscountProduct(char code, double price, double discountPrice, int discountNumber) {
        super(code, price);
        this.discountPrice = discountPrice;
        this.discountNumber = discountNumber;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getDiscountNumber() {
        return discountNumber;
    }

    public void setDiscountNumber(int discountNumber) {
        this.discountNumber = discountNumber;
    }
}
