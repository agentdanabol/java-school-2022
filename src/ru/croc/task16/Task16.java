package ru.croc.task16;

import ru.croc.task16.taxi.Coordinates;
import ru.croc.task16.taxi.Driver;
import ru.croc.task16.taxi.TaxiService;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task16 {

    public static void main(String[] args) {

        try {
            Coordinates clientCord = new Coordinates(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
            String requiredClass = args[3];
            List<String> wishList = new ArrayList<>(Arrays.asList(args).subList(3, args.length));

            final FileReader filePath = new FileReader("src/ru/croc/task16/taxi/drivers_base.txt");
            TaxiService easyGo = new TaxiService(filePath);

            Driver bestDriver = new Driver(easyGo.getBestDriver(clientCord, requiredClass, wishList));
            System.out.println("Самый подходящий водитель:\n" + bestDriver.getDriverId());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
