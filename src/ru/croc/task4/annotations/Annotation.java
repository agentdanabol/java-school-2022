package ru.croc.task4.annotations;

import ru.croc.task4.figures.Figure;

public class Annotation {
    private Figure figure;
    private String signs;

    public Annotation(Figure figure, String signs) {
        this.figure = figure;
        this.signs = signs;
    }

    public String toString() {
        return figure + signs;
    }
}
