package ru.croc.task10;

import ru.croc.task10.auction.AuctionLot;

public class Task10 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("      Добро пожаловать на аукцион!      ");

        AuctionLot car = new AuctionLot(10);

        Thread user1 = new Thread(car, "Данил");
        Thread user2 = new Thread(car, "Антон");
        Thread user3 = new Thread(car, "Иван");

        user1.start();
        user2.start();
        user3.start();
        user1.join();
        user2.join();
        user3.join();

        System.out.println("Победитель аукциона: " + car.getWinner());

        System.exit(0);
    }
}
