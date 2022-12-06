package ru.croc.task16.taxi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaxiService {

    private List<Driver> driverList;

    public TaxiService() {
        driverList = new ArrayList<>();
    }

    public TaxiService(FileReader driverList) {
        try {
            this.driverList = new ArrayList<>();
            BufferedReader reader = new BufferedReader(driverList);
            String line = reader.readLine();
            String[] split = line.split(",");
            List<String> specialWishes = new ArrayList<>();
            for(int i = 4; i < split.length; i++) {
                specialWishes.add(split[i]);
            }
            while (line != null) {
                this.driverList.add(new Driver(split[0],
                        new Coordinates(Double.parseDouble(split[1]), Double.parseDouble(split[2])),
                        split[3], specialWishes));
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Driver getBestDriver(Coordinates clientCords, String requiredClass, List<String> wishList) throws Exception {

        Comparator<Driver> driverComparator = (driver1, driver2) -> {
            if(driver1.hasRequiredCar(requiredClass, wishList) && driver2.hasRequiredCar(requiredClass, wishList)) {
                return Double.compare(driver1.getCords().getDistance(clientCords), driver2.getCords().getDistance(clientCords));
            }
            else if(!driver1.hasRequiredCar(requiredClass, wishList) && driver2.hasRequiredCar(requiredClass, wishList)){
                return 1;
            }
            else if(driver1.hasRequiredCar(requiredClass, wishList)){
              return -1;
            }
            else {
                return 0;
            }
        };

        driverList.sort(driverComparator);
        if(!driverList.get(0).hasRequiredCar(requiredClass, wishList)) {
            throw new Exception("Can't find driver for your requirements! Sorry!");
        }
        return driverList.get(0);

    }

    public void addDriver(Driver driver) {
        driverList.add(driver);
    }

}
