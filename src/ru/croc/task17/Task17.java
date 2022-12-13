package ru.croc.task17;

import org.h2.tools.Server;
import ru.croc.task17.database.DataBaseWorker;
import ru.croc.task17.database.FileParser;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class Task17 {

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:~/test", "sa", "")) {

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

