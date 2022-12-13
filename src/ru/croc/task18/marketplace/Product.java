package ru.croc.task18.marketplace;

public class Product {

    private final String vendorCode;
    private final String name;
    private final int price;

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

}
