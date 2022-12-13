package ru.croc.task18.marketplace;

public class Product {

    private final String vendorCode;
    private String name;
    private int price;

    public Product(String vendorCode, String name, int price) {
        this.vendorCode = vendorCode;
        this.name = name;
        this.price = price;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
