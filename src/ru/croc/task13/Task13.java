package ru.croc.task13;

import ru.croc.task13.cinema.Cinema;
import ru.croc.task13.cinema.Recommendations;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task13 {

    public static void main(String[] args) {

        try {
            final FileReader moviesPath = new FileReader("src/ru/croc/task13/data/movies.txt");
            final FileReader historyPath = new FileReader("src/ru/croc/task13/data/views_history.txt");
            Cinema kissPlaces = new Cinema(moviesPath, historyPath);

            System.out.println("Введите фильмы, которые вы смотрели: ");
            Scanner scanner = new Scanner(System.in);
            Recommendations recommendations = new Recommendations(scanner);
            System.out.println("Мы рекомендуем вам посмотреть фильм: " + recommendations.getRecommendation(kissPlaces));


            moviesPath.close();
            historyPath.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
