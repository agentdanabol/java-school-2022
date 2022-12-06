package ru.croc.task16.taxi;

public class Coordinates {
    private double latitude;
    private double longitude;

    public Coordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Coordinates(Coordinates cords) {
        this.latitude = cords.getLatitude();
        this.longitude = cords.getLongitude();
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getDistance(Coordinates cord) {
        return Math.sqrt(Math.pow((latitude - cord.getLatitude()), 2)
                + Math.pow((longitude - cord.getLongitude()), 2));
    }

}
