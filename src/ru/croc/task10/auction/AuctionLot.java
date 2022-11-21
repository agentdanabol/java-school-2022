package ru.croc.task10.auction;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AuctionLot implements Runnable {
    private int cost;
    private String owner;
    LocalDateTime time;

    private static final Object lock = new Object();

    public AuctionLot(int startCost) {
        this.cost = startCost;
        owner = "Пока никто не сделал ставку";
        time = LocalDateTime.now().plus(1, ChronoUnit.MINUTES);
    }

    public void bet(int cost, String name) {
        if(time.isBefore(LocalDateTime.now())) {
            System.out.println("Время вышло!");
        }
        else if(cost > this.cost){
            this.cost = cost;
            this.owner = name;
        }
        else {
            System.out.println("Ставка должна быть больше!");
        }
    }

    public String getWinner() {
        return owner;
    }

    public void state() {
        System.out.println("$$$ Текущая стоимость лота: " + cost + " $$$ Владелец: " + owner + " $$$");
    }

    @Override
    public void run() {
        int cost;
        Scanner read = new Scanner(System.in);
        try {
            while(time.isAfter(LocalDateTime.now())) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " введите ставку: ");
                    cost = read.nextInt();
                    bet(cost, Thread.currentThread().getName());
                }
                state();
            }
        }
        catch (InputMismatchException e) {
            throw new InputMismatchException("Вы должны вводить цело число!");
        }
    }
}
