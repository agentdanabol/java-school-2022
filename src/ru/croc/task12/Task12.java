package ru.croc.task12;

import ru.croc.task12.service.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task12 {
    public static void main(String[] args) {

        List<String> comments = new ArrayList<>();
        comments.add("Отличный канал!! Андрей и всей команде кто работает на выпусками!");
        comments.add("Смотрю видео во время тренировки");
        comments.add("Всегда топ материал бро, спасибо за твою проделанную работу,смотрю тебя!!!");
        comments.add("Колени ещё на превью вышли из чата. Ехал в метро пока смотрел");
        comments.add("Вроде Исландия была совсем недавно, а столько времени пролетело...");

        Set<String> prohibitedWords = new HashSet<>();
        prohibitedWords.add("видео");
        prohibitedWords.add("бро");
        prohibitedWords.add("совсем");

        System.out.println("Комментарии перед фильтрацией:\n");
        for(String comment : comments) {
            System.out.println(comment);
        }
        System.out.println("\n");

        Service app = new Service();
        app.filterComments(comments, prohibitedWords);

        System.out.println("Комментарии после фильтрации:\n");
        for(String comment : comments) {
            System.out.println(comment);
        }

    }
}
