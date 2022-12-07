package ru.croc.task16.taxi;

import java.util.ArrayList;
import java.util.List;

public class Driver {

    private final String driverId;
    private final Coordinates cords;
    private final String carClass;
    private final List<String> specialFeatures;

    public Driver(String driverId, Coordinates cords, String carClass, List<String> specialFeatures) {
        this.driverId = driverId;
        this.cords = cords;
        this.carClass = carClass;
        this.specialFeatures = new ArrayList<>(specialFeatures);
    }

    public Driver(Driver driver) {
        this.driverId = driver.getDriverId();
        this.cords = driver.getCords();
        this.carClass = driver.getCarClass();
        this.specialFeatures = new ArrayList<>(driver.getSpecialFeatures());
    }

    public String getDriverId() {
        return driverId;
    }

    public Coordinates getCords() {
        return new Coordinates(cords);
    }

    public boolean hasRequiredCar(String requiredClass, List<String> wishList) {
        return (requiredClass.equals(carClass) && specialFeatures.containsAll(wishList));
    }

    public String getCarClass() {
        return carClass;
    }

    public List<String> getSpecialFeatures() {
        return new ArrayList<>(specialFeatures);
    }

}
