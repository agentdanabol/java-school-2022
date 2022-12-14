package ru.croc.task4.figures;

public class Rectangle extends Figure {

    int x1;
    int y1;
    int x2;
    int y2;

    public Rectangle(int x1, int y1, int x2, int y2) {
        if(Math.abs(x1 - x2) == 0 || Math.abs(y1 - y2) == 0) {
            throw new IllegalArgumentException("Wrong points!");
        }
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public String toString() {
        return "Rectangle " + "(" + x1 + ", " +
                y1 + "), (" + x2 +
                ", " + y2 + "):";
    }
}