package ru.croc.task11;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task11 {

    public static void main(String[] args) throws IOException, InterruptedException {

        ExecutorService exec = Executors.newFixedThreadPool(2);

        exec.execute(new Tester());
        Thread.sleep(10);

        exec.execute(new Tester());
        Thread.sleep(10);

        exec.shutdown();

    }

}
