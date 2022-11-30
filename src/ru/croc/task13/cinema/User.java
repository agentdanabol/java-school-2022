package ru.croc.task13.cinema;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final List<Integer> history;

    public User(String line) {
        history = new ArrayList<>();
        String[] views = line.split(",");
        if(views.length == 0) {
            throw new IllegalArgumentException("Views amount can't be lower than 1");
        }
        for(String view : views) {
            int id = Integer.parseInt(view);
            if(id < 1) {
                throw new IllegalArgumentException("View id can't be less than 1");
            }
            history.add(id);
        }
    }

    public List<Integer> getHistory() {
        return history;
    }

}
