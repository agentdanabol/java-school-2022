package ru.croc.task18.marketplace;

import ru.croc.task18.marketplace.Order;
import ru.croc.task18.marketplace.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    public Product findProduct(String productCode){
        try(Connection connection = DriverManager.getConnection("jdbc:h2:mem:~/test", "sa", "")) {
            PreparedStatement getProduct = connection.prepareStatement("select * from `product` where vendorCode =?");
            getProduct.setString(1, productCode);
            ResultSet resultSet = getProduct.executeQuery();
            if(resultSet.next()) {
                return new Product(resultSet.getString("vendorCode"),
                        resultSet.getString("name"),
                        resultSet.getInt("price"));
            }
            return null;
        }
        catch (SQLException e) {
            return null;
        }
    }

    public Product createProduct(Product product) throws SQLException {
       try(Connection connection = DriverManager.getConnection("jdbc:h2:mem:~/test", "sa", "")){
           String vendorCode = product.getVendorCode();
           String name = product.getName();
           int price = product.getPrice();

           if(findProduct(product.getVendorCode()) != null) {
               return null;
           }
           String productRow = " values ('" + vendorCode + "', '" + name + "', " + price + ")";
           Statement productStatement = connection.createStatement();
           productStatement.execute("insert into `product` (vendorCode, name, price)" + productRow);

           return findProduct(vendorCode);
       }
        catch (SQLException e){
            return null;
        }
    }

    public Product updateProduct(Product product) {
        try(Connection connection = DriverManager.getConnection("jdbc:h2:mem:~/test", "sa", "")) {
            if(findProduct(product.getVendorCode()) == null) {
                return null;
            }

            PreparedStatement productStatement = connection.prepareStatement("select * from `product` where vendorCode = ?");
            productStatement.setString(1, product.getVendorCode());
            ResultSet resultSet = productStatement.executeQuery();
            resultSet.next();
            int productId = resultSet.getInt("id");

            Statement statement = connection.createStatement();
            statement.execute("update product set vendorCode = '" + product.getVendorCode() + "',name = '" +
                    product.getName() + "', price = " + product.getPrice() + " where id =" + productId);
            return findProduct(product.getVendorCode());
        }
        catch (SQLException e) {
            return null;
        }
    }

    public void deleteProduct(String productCode) {
        try(Connection connection = DriverManager.getConnection("jdbc:h2:mem:~/test", "sa", "")) {
            if(findProduct(productCode) == null) {
                return;
            }

            PreparedStatement productStatement = connection.prepareStatement("select * from `product` where vendorCode =?");
            productStatement.setString(1, productCode);
            ResultSet resultSet = productStatement.executeQuery();
            resultSet.next();
            int productId = resultSet.getInt(1);

            productStatement = connection.prepareStatement("delete from `order` where product_id=?");
            productStatement.setInt(1, productId);
            productStatement.execute();

            productStatement = connection.prepareStatement("delete from `product` where vendorCode=?");
            productStatement.setString(1, productCode);
            productStatement.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Order createOrder(String userLogin, List<Product> products) {
        try(Connection connection = DriverManager.getConnection("jdbc:h2:mem:~/test", "sa", "")){

            PreparedStatement userStatement = connection.prepareStatement("select * from `user` where login =?");
            userStatement.setString(1, userLogin);
            ResultSet userSet = userStatement.executeQuery();
            userSet.next();
            int userId = userSet.getInt(1);

            PreparedStatement orderStatement = connection.prepareStatement("select * from `order`");
            ResultSet orderSet = orderStatement.executeQuery();
            orderSet.last();
            int orderId = orderSet.getInt(1) + 1;

            List<Integer> userIdList = new ArrayList<>();
            List<Integer> productIdList = new ArrayList<>();
            for(Product product : products) {
                String vendorCode = product.getVendorCode();

                PreparedStatement productStatement = connection.prepareStatement("select * from `product` where vendorCode =?");
                productStatement.setString(1, vendorCode);
                ResultSet productSet = productStatement.executeQuery();
                productSet.next();
                int productId = productSet.getInt(1);

                Statement statement = connection.createStatement();
                String orderRow = " values (" + orderId + ", " + userId + ", " + productId +")";
                statement.execute("insert into `order` (id, user_id, product_id)" + orderRow);
                userIdList.add(userId);
                productIdList.add(productId);
            }
            return new Order(userIdList, productIdList);
        }
        catch (SQLException e){
            return null;
        }
    }

}
