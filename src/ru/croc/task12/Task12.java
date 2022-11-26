package ru.croc.task12;

import ru.croc.task12.service.Service;

public class Task12 {
    public static void main(String[] args) {

        Service app = new Service();

        app.addComment("Отличный канал!! Андрей и всей команде кто работает на выпусками!");
        app.addComment("Смотрю видео во время тренировки");
        app.addComment("Всегда топ материал бро, спасибо за твою проделанную работу,смотрю тебя!!!");
        app.addComment("Колени ещё на превью вышли из чата. Ехал в метро пока смотрел");
        app.addComment("Вроде Исландия была совсем недавно, а столько времени пролетело...");
        app.addProhibitedWord("видео", "бро", "совсем");
        app.printComments();

    }
}
