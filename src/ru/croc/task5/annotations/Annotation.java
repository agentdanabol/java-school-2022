package ru.croc.task5.annotations;

import ru.croc.task5.figures.Circle;
import ru.croc.task5.figures.Figure;
import ru.croc.task5.figures.Rectangle;

public class Annotation {
    private Figure figure;
    private String signs;

    public Annotation(Figure figure, String signs) {
        this.figure = figure;
        this.signs = signs;
    }
    public Figure getFigure() {
        return figure;
    }

    public String getSigns() {
        return signs;
    }

    public String toString() {
        return figure + signs;
    }
}
