package ru.croc.task5.figures;

public class Circle extends Figure {
    private int x;
    private int y;
    private int R;

    public Circle(int x, int y, int R) {
        if(R < 1) {
            throw new IllegalArgumentException("Wrong radius!");
        }
        this.x = x;
        this.y = y;
        this.R = R;
    }

    public String toString() {
        return "Circle " + "(" + x + ", " + y +
                ") " + R + ": ";
    }

    @Override
    public boolean contains(int x, int y) {
        if ((Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2)) < Math.pow(this.R, 2)) {
            return true;
        }
        return false;
    }

    @Override
    public void move(int dx, int dy) {
        x = x + dx;
        y = y + dy;
    }
}