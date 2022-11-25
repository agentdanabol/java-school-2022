package ru.croc.task10;

import ru.croc.task10.auction.AuctionLot;
import ru.croc.task10.auction.Participant;

import java.util.ArrayList;

public class Task10 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("      Добро пожаловать на аукцион!      ");

        AuctionLot car = new AuctionLot(10);

        ArrayList<Participant> participants = new ArrayList<>();
        participants.add(new Participant(car, "Данил"));
        participants.add(new Participant(car, "Антон"));
        participants.add(new Participant(car, "Иван"));
        participants.add(new Participant(car, "Дмитрий"));
        participants.add(new Participant(car, "Василий"));


        Thread threads[] = new Thread[5];
        for (int i = 0; i < 5; i++){
            threads[i] = new Thread(participants.get(i));
            threads[i].start();
        }
        for (int i = 0; i < 5; i++){
            threads[i].join();
        }

        System.out.println("Победитель аукциона: " + car.getWinner());

        System.exit(0);
    }
}
