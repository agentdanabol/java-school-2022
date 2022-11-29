package ru.croc.task13.cinema;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private List<Integer> history;

    public Person(String line) {
        history = new ArrayList<>();
        String views[] = line.split(",");
        for(String view : views) {
            history.add((int) view.charAt(0));
        }
    }

    public List<Integer> getHistory() {
        return history;
    }

}
