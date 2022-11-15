package ru.croc.task7.chess;

import ru.croc.task7.exception.IllegalMoveException;

public class KnightChecker {
    public static void checker(ChessPosition[] positions) {
        for(int i = 0; i < positions.length - 1; i++) {
            if(checkMove(positions[i], positions[i+1]) == false) {
                throw new IllegalMoveException(positions[i], positions[i+1]);
            }
        }
        System.out.println("Конь может так ходить!");
    }

    public static boolean checkMove(ChessPosition position1, ChessPosition position2) {
        if(position1.getX() == position2.getX() && position1.getY() == position2.getY()){
            return true;
        }
        else {
            int dx = Math.abs(position2.getX() - position1.getX());
            int dy = Math.abs(position2.getY() - position1.getY());
            if (dx > 0 && dx < 7 && dy > 0 && dy < 7) {
                if((dx == 2 && dy == 1) || (dx == 1 && dy == 2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
