package ru.croc.Task4.figures;

public class Circle extends Figure {

    int x;
    int y;
    int R;

    public Circle(int x, int y, int R) {
        if(R < 1) {
            throw new IllegalArgumentException("Wrong radius!");
        }
        this.x = x;
        this.y = y;
        this.R = R;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getR() {
        return R;
    }
}