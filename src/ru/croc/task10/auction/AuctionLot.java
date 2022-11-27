package ru.croc.task10.auction;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class AuctionLot {
    private int cost;
    private String owner;
    LocalDateTime time;

    private static final Object lock = new Object();

    public AuctionLot(int startCost) {
        this.cost = startCost;
        owner = "Пока никто не сделал ставку";
        time = LocalDateTime.now().plus(1, ChronoUnit.MINUTES);
    }

    public int getCost() {
        return cost;
    }

    public void bet(int cost, String name) {
        synchronized (lock) {
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
    }

    public boolean isFinished() {
        return time.isBefore(LocalDateTime.now());
    }

    public String getWinner() {
        return owner;
    }

    public void state() {
        System.out.println("$$$ Текущая стоимость лота: " + cost + " $$$ Владелец: " + owner + " $$$");
    }
}
