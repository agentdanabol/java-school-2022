package ru.croc.task7.exception;

import ru.croc.task7.chess.ChessPosition;

public class IllegalMoveException extends RuntimeException {
    public IllegalMoveException(ChessPosition position1, ChessPosition position2) {
        super("Конь так не ходит: " + position1 + " -> " + position2);
    }
}
