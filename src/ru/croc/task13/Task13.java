package ru.croc.task13;

import ru.croc.task13.cinema.Cinema;
import ru.croc.task13.cinema.Recommendations;
import ru.croc.task13.cinema.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Task13 {

    public static void main(String[] args) {

        try {
            final FileReader moviesPath = new FileReader("src/ru/croc/task13/data/movies.txt");
            final FileReader historyPath = new FileReader("src/ru/croc/task13/data/views_history.txt");

            Map<Integer, String> movies = new HashMap<>();
            BufferedReader reader1 = new BufferedReader(moviesPath);
            String line1 = reader1.readLine();
            while (line1 != null) {
                String[] parts = line1.split(",");
                movies.put(Integer.parseInt(parts[0]), parts[1]);
                line1 = reader1.readLine();
            }

            List<User> users = new ArrayList<>();
            BufferedReader reader2 = new BufferedReader(historyPath);
            line1 = reader2.readLine();
            while (line1 != null) {
                users.add(new User(line1));
                line1 = reader2.readLine();
            }
            reader1.close();
            reader2.close();
            Cinema kissPlaces = new Cinema(movies, users);

            System.out.println("Введите фильмы, которые вы смотрели: ");
            Scanner scanner = new Scanner(System.in);
            String line2 =  scanner.nextLine();
            List<Integer> userHistory = new ArrayList<>();
            String[] views = line2.split(",");
            if(views.length == 0) {
                throw new IllegalArgumentException("Views amount can't be lower than 1");
            }
            for(String view : views) {
                int id = Integer.parseInt(view);
                if(id < 1) {
                    throw new IllegalArgumentException("View id can't be less than 1");
                }
                userHistory.add(id);
            }
            Recommendations recommendations = new Recommendations();
            System.out.println("Мы рекомендуем вам посмотреть фильм: " +
                    recommendations.getRecommendation(kissPlaces, userHistory));


            moviesPath.close();
            historyPath.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
