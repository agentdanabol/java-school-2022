package ru.croc.task7;

import ru.croc.task7.chess.ChessPosition;
import ru.croc.task7.chess.KnightChecker;

public class Task7 {
    public static void main(String[] args) {
        String str = "h8";
        ChessPosition first = null;
        first = first.parse(str);
        System.out.println(first);

        String moves1 = "b1 c3 d1 f2 g4";
        System.out.println("Проверка первой последовательности: " + moves1);
        String[] split1 = moves1.split(" ");
        ChessPosition[] positions1 = new ChessPosition[split1.length];
        for(int i = 0; i < split1.length; i ++) {
            positions1[i] = positions1[i].parse(split1[i]);
        }
        KnightChecker.checker(positions1);


        String moves2 = "h6 c3 d5 f2 g4";
        System.out.println("Проверка второй последовательности: " + moves2);
        String[] split2 = moves2.split(" ");
        ChessPosition[] positions2 = new ChessPosition[split2.length];
        for(int i = 0; i < split2.length; i ++) {
            positions2[i] = positions2[i].parse(split2[i]);
        }
        KnightChecker.checker(positions2);
    }
}
