package ru.croc.task10.auction;

import java.util.concurrent.ThreadLocalRandom;

public class Participant implements Runnable {

    private static final Object lock = new Object();

    private final AuctionLot lot;
    private final String name;

    public Participant(AuctionLot lot, String name) {
        this.lot = lot;
        this.name = name;
    }

    public void bet1() {
        lot.bet(lot.getCost() + 1, name);
    }

    public void bet2() {
        lot.bet(lot.getCost() + 2, name);
    }

    public void bet3() {
        lot.bet(lot.getCost() + 3, name);
    }

    @Override
    public void run() {
        while (!lot.isFinished()) {
            synchronized (lock) {
                int r = ThreadLocalRandom.current().nextInt(0, 4);
                switch (r) {
                    case 0 -> bet1();
                    case 1 -> bet2();
                    case 2 -> bet3();
                    default -> {
                    }
                }
                lot.state();
            }
        }
    }
}
