package ru.croc.Task5.figures;

public class Rectangle extends Figure {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Rectangle(int x1, int y1, int x2, int y2) {
        if(Math.abs(x1 - x2) == 0 || Math.abs(y1 - y2) == 0) {
            throw new IllegalArgumentException("Wrong points!");
        }
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public int getX1() {
        return x1;
    }
    public int getY1() {
        return y1;
    }
    public int getX2() {
        return x2;
    }
    public int getY2() {
        return y2;
    }

    public String toString() {
        return "(" + x1 + ", " + y1 + "), (" + x2 + ", " +  y2 + ")";
    }

    @Override
    public boolean contains(int x, int y) {
        if(this.x1 == x && this.y1 == y) {
            return true;
        }
        else if(this.x2 == x && this.y2 == y) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void move(int dx, int dy) {
        x1 = x1 + dx;
        y1 = y1 + dy;
        x2 = x2 + dx;
        y2 = y2 + dy;
    }
}