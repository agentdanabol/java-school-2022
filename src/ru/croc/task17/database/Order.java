package ru.croc.task17.database;

public class Order {

    private final int orderId;
    private final String login;
    private final String vendorCode;
    private final String name;
    private final int price;

    public Order(int orderId, String login, String vendorCode, String name, int price) {
        this.orderId = orderId;
        this.login = login;
        this.vendorCode = vendorCode;
        this.name = name;
        this.price = price;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getLogin() {
        return login;
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
