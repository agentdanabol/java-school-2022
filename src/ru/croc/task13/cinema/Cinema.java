package ru.croc.task13.cinema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cinema {

    private final Map<Integer, String> movies;
    private final List<User> users;

    public Cinema(Map<Integer, String> movies, List<User> users) {
        this.movies = movies;
        this.users = users;
    }

    public Map<Integer, String> getMovies() {
        return new HashMap<>(movies);
    }

    public List<User> getUsers() {
        return new ArrayList<>(users);
    }

}
