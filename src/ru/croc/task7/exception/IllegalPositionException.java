package ru.croc.task7.exception;

public class IllegalPositionException extends RuntimeException {
    public IllegalPositionException() {
        super("Позиция фигуры задана неправильно!");
    }
}
