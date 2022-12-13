package ru.croc.task18.database;

import java.sql.*;
import java.util.List;

public class DataBaseWorker {

    private Statement statement;

    public DataBaseWorker(Connection connection) {
        try {
            statement = connection.createStatement();
            statement.execute("create table `user`(id int primary key auto_increment, login varchar unique)");
            statement.execute("create table `product`(id int primary key auto_increment," +
                    " vendorCode varchar, name varchar, price integer)");
            statement.execute("create table `order`(id int, user_id int," +
                    "product_id int, foreign key (user_id) references `user`(id)," +
                    "foreign key (product_id) references `product`(id))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fulfillTable(List<Purchase> purchaseList, Connection connection) {
        try {
            for(Purchase purchase : purchaseList) {
                int id = purchase.getOrderId();
                String login = purchase.getLogin();
                String vendorCode = purchase.getVendorCode();
                String name = purchase.getName();
                int price = purchase.getPrice();

                String userRow = " values ('" + login + "')";
                PreparedStatement userStatement = connection.prepareStatement("select * from `user` where login = ? ");
                userStatement.setString(1, login);
                ResultSet userSet = userStatement.executeQuery();
                if (!userSet.next()) {
                    statement.execute("insert into `user` (login)" + userRow);
                }

                String productRow = " values ('" + vendorCode + "', '" + name + "', '" + price + "')";
                PreparedStatement productStatement = connection.prepareStatement("select * from `product` where vendorCode = ?");
                productStatement.setString(1, vendorCode);
                ResultSet productSet = productStatement.executeQuery();
                if(!productSet.next()){
                    statement.execute("insert into `product` (vendorCode, name, price)" + productRow);
                }

                userSet = userStatement.executeQuery();
                productSet = productStatement.executeQuery();
                if (userSet.next() && productSet.next()) {
                    int uId  = userSet.getInt("id");
                    int pID = productSet.getInt("id");
                    String orderRow = " values (" + id + ", " + uId + ", " + pID +")";
                    statement.execute("insert into `order` (id, user_id, product_id)" + orderRow);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printTables() {
        try {
            System.out.println("Table user:");
            ResultSet userSet = statement.executeQuery("select * from `user`");
            while(userSet.next()){
                System.out.println(userSet.getInt("id") + ", " + userSet.getString("login"));
            }

            System.out.println("Table product:");
            ResultSet productSet = statement.executeQuery("select * from `product`");
            while(productSet.next()){
                System.out.println(productSet.getInt("id") + ", " + productSet.getString("vendorCode") +
                        ", " +  productSet.getString("name") + ", " + productSet.getString("price"));
            }

            System.out.println("Table order:");
            ResultSet orderSet = statement.executeQuery("select * from `order`");
            while(orderSet.next()){
                System.out.println(orderSet.getInt("id") + ", " + orderSet.getInt("user_id") +
                        ", " +  orderSet.getInt("product_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeDataBaseWorker() {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
