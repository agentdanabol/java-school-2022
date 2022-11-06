package ru.croc.task2;

public class Progression {
    public static void main(String[] args) {
        int start = Integer.parseInt(args[0]);
        int difference = Integer.parseInt(args[1]);
        int count = Integer.parseInt(args[2]);

        int sum = start;
        for(int i = 1; i < count; i++) {
            start = start + difference;
            sum += start;
        }
        System.out.println("Сумма прогрессии: " + sum);
    }
}
