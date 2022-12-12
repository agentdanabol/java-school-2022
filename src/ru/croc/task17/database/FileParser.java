package ru.croc.task17.database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileParser {

    private final List<Order> orderList;

    public FileParser(FileReader file) {
        BufferedReader reader = new BufferedReader(file);
        orderList = new ArrayList<>();
        try {
            String line = reader.readLine();
            while (line != null) {
                String[] split = line.split(",");
                orderList.add(new Order(Integer.parseInt(split[0]),
                        split[1], split[2], split[3], Integer.parseInt(split[4].replace(" ", ""))));
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileParser(List<Order> orderList) {
        this.orderList = new ArrayList<>(orderList);
    }

    public List<Order> getOrderList() {
        return new ArrayList<>(orderList);
    }

}
