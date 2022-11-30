package ru.croc.task13.cinema;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cinema {

    private Map<Integer, String> movies;
    private List<User> users;

    public Cinema(FileReader movies, FileReader history) {
        try {
            this.movies = new HashMap<>();
            BufferedReader reader1 = new BufferedReader(movies);
            String line = reader1.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                this.movies.put(Integer.parseInt(parts[0]), parts[1]);
                line = reader1.readLine();
            }

            this.users = new ArrayList<>();
            BufferedReader reader2 = new BufferedReader(history);
            line = reader2.readLine();
            while (line != null) {
                this.users.add(new User(line));
                line = reader2.readLine();
            }

            reader1.close();
            reader2.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<Integer, String> getMovies() {
        return movies;
    }

    public List<User> getUsers() {
        return users;
    }

}
