package ru.croc.task18;

import ru.croc.task18.database.DataBaseWorker;
import ru.croc.task18.database.FileParser;
import ru.croc.task18.marketplace.Product;
import ru.croc.task18.marketplace.ProductDao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Task18 {

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:~/test", "sa", "")) {

            String path = "src/ru/croc/task17/source/data.csv";
            FileReader file = new FileReader(path);
            FileParser fileParser = new FileParser(file);

            DataBaseWorker dataBaseWorker = new DataBaseWorker(connection);
            dataBaseWorker.fulfillTable(fileParser.getOrderList(), connection);
            file.close();

            ProductDao productDao = new ProductDao();

            Product productToAdd = new Product("T6", "Жесткий диск", 1200);
            productToAdd = productDao.createProduct(productToAdd);

            Product productToDelete = productDao.findProduct("Т4");
            productDao.deleteProduct(productToDelete.getVendorCode());

            Product productToChange = new Product("Т3", "Оперативная память", 1600);
            productDao.updateProduct(productToChange);

            List<Product> productList = new ArrayList<>();
            productList.add(productToAdd);
            productList.add(productToChange);

            productDao.createOrder("nikita", productList);

            dataBaseWorker.printTables();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

    }

}
