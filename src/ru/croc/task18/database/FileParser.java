package ru.croc.task18.database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileParser {

    private final List<Purchase> purchaseList;

    public FileParser(FileReader file) {
        BufferedReader reader = new BufferedReader(file);
        purchaseList = new ArrayList<>();
        try {
            String line = reader.readLine();
            while (line != null) {
                String[] split = line.split(",");
                purchaseList.add(new Purchase(Integer.parseInt(split[0]),
                        split[1], split[2], split[3], Integer.parseInt(split[4].replace(" ", ""))));
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileParser(List<Purchase> purchaseList) {
        this.purchaseList = new ArrayList<>(purchaseList);
    }

    public List<Purchase> getOrderList() {
        return new ArrayList<>(purchaseList);
    }

}
