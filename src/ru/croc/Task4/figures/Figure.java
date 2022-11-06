package ru.croc.Task4.figures;

public abstract class Figure {
    public Figure getFigure(int points[]) {
        if (points.length == 4) {
            Figure rect = new Rectangle(points[0], points[1], points[2], points[3]);
            return rect;
        } else if (points.length == 3) {
            Figure circ = new Circle(points[0], points[1], points[2]);
            return circ;
        } else {
            throw new IllegalArgumentException("Wrong arguments! There must be 3 or 4 arguments");
        }
    }
}
