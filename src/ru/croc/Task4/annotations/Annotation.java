package ru.croc.Task4.annotations;

import ru.croc.Task4.figures.Circle;
import ru.croc.Task4.figures.Figure;
import ru.croc.Task4.figures.Rectangle;

public class Annotation {
    private Figure figure;
    private String signs;

    public Annotation(Figure figure, String signs) {
        this.figure = figure;
        this.signs = signs;
    }

    public String toString() {
        if(figure instanceof Circle) {
            return "Circle " + "(" + ((Circle) figure).getX() + ", " + ((Circle) figure).getY() +
                    ") " + ((Circle) figure).getR() + ": " + signs;
        }
        else {
            return "Rectangle " + "(" + ((Rectangle) figure).getX1() + ", " +
                    ((Rectangle) figure).getY1() + "), (" + ((Rectangle) figure).getX2() +
                    ", " + ((Rectangle) figure).getY2() + ") :" + signs;
        }
    }
}
