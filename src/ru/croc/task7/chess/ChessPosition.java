package ru.croc.task7.chess;

import ru.croc.task7.exception.IllegalPositionException;

public class ChessPosition {
    private int x;
    private int y;

    public ChessPosition(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new IllegalPositionException();
        }

        this.x = x;
        this.y = y;
    }

    public String toString() {
        char x = castToString(this.x);
        int y = this.y + 1;
        return String.valueOf(x) + y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private char castToString(int x) {
        switch (x) {
            case 0:
                return 'a';
            case 1:
                return 'b';
            case 2:
                return 'c';
            case 3:
                return 'd';
            case 4:
                return 'e';
            case 5:
                return 'f';
            case 6:
                return 'g';
            case 7:
                return 'h';
            default:
                throw new IllegalPositionException();
        }
    }

    public static ChessPosition parse(String position) {
        if (position.length() == 2) {
            int x = checkX(position.charAt(0));
            int y = checkY(position.charAt(1));
            return new ChessPosition(x, y);
        }
        else {
            throw new IllegalPositionException();
        }
    }

    private static int checkX(char x) throws IllegalPositionException {
        switch (x) {
            case 'a':
                return 0;
            case 'b':
                return 1;
            case 'c':
                return 2;
            case 'd':
                return 3;
            case 'e':
                return 4;
            case 'f':
                return 5;
            case 'g':
                return 6;
            case 'h':
                return 7;
            default:
                throw new IllegalPositionException();
        }
    }

    private static int checkY(char y) throws IllegalPositionException {
        switch (y) {
            case '1':
                return 0;
            case '2':
                return 1;
            case '3':
                return 2;
            case '4':
                return 3;
            case '5':
                return 4;
            case '6':
                return 5;
            case '7':
                return 6;
            case '8':
                return 7;
            default:
                throw new IllegalPositionException();
        }
    }

}
