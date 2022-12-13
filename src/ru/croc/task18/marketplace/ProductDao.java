package ru.croc.task18.marketplace;

import ru.croc.task18.marketplace.Order;
import ru.croc.task18.marketplace.Product;

import java.sql.*;
import java.util.List;

public class ProductDao {

    public Product findProduct(String productCode){
        try(Connection connection = DriverManager.getConnection("jdbc:h2:~/marketplace", "sa", "")) {
            PreparedStatement getProduct = connection.prepareStatement("select * from `product` where vendorCode = ?");
            getProduct.setString(1, productCode);
            ResultSet resultSet = getProduct.executeQuery();
            if(!resultSet.next()) {
                throw new Exception("Product not found!");
            }
            return new Product(resultSet.getString("vendorCode"),
                    resultSet.getString("name"),
                    resultSet.getInt("price"));
        }
        catch (Exception e) {
            return null;
        }
    }

    public Product createProduct(Product product) throws SQLException {
       try(Connection connection = DriverManager.getConnection("jdbc:h2:~/marketplace", "sa", "")){
           String vendorCode = product.getVendorCode();
           String name = product.getName();
           int price = product.getPrice();

           String productRow = " values ('" + vendorCode + "', '" + name + "', '" + price + "')";
           PreparedStatement productStatement = connection.prepareStatement("select * from `product` where vendorCode = ?");
           productStatement.setString(1, vendorCode);
           ResultSet productSet = productStatement.executeQuery();
           if(!productSet.next()){
               productStatement.execute("insert into `product` (vendorCode, name, price)" + productRow);
           }
           return findProduct(vendorCode);
       }
        catch (SQLException e){
            return null;
        }
    }

    public Product updateProduct(Product product) {
        try(Connection connection = DriverManager.getConnection("jdbc:h2:~/marketplace", "sa", "")) {
            Product updatedProduct = findProduct(product.getVendorCode());

            deleteProduct(updatedProduct.getVendorCode());
            updatedProduct.setName(product.getName());
            updatedProduct.setPrice(product.getPrice());
            return createProduct(updatedProduct);
        }
        catch (SQLException e) {
            return null;
        }
    }

    public void deleteProduct(String productCode) {
        try(Connection connection = DriverManager.getConnection("jdbc:h2:~/marketplace", "sa", "")) {
            Product product = findProduct(productCode);

            PreparedStatement productStatement = connection.prepareStatement("select * from `product` where vendorCode = ?");
            productStatement.setString(1, productCode);
            ResultSet resultSet = productStatement.executeQuery();
            int id = resultSet.getInt(1);

            productStatement = connection.prepareStatement("delete from `order` where product_id=?");
            productStatement.setInt(1, id);
            productStatement.executeQuery();

            productStatement = connection.prepareStatement("delete from `product` where vendorCode=?");
            productStatement.setString(1, productCode);
            productStatement.executeQuery();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Order createOrder(String userLogin, List<Product> products) {



        return new Order();
    }

}
