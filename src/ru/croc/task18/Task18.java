package ru.croc.task18;

import ru.croc.task18.database.DataBaseWorker;
import ru.croc.task18.database.FileParser;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Task18 {

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/marketplace", "sa", "")) {

            String path = args[0];
            FileReader file = new FileReader(path);
            FileParser fileParser = new FileParser(file);

            DataBaseWorker dataBaseWorker = new DataBaseWorker(connection);
            dataBaseWorker.fulfillTable(fileParser.getOrderList(), connection);
            dataBaseWorker.printTables();
            dataBaseWorker.closeDataBaseWorker();

            file.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

    }

}
