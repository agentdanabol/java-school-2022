package ru.croc.task11.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadServer {
    static ExecutorService executeIt = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(3345);
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Сервер запущен");

            while (!server.isClosed()) {
                if (br.ready()) {

                    String serverCommand = br.readLine();
                    if (serverCommand.equalsIgnoreCase("quit")) {
                        System.out.println("Сервер завершает работу...");
                        server.close();
                        break;
                    }
                }
                Socket client = server.accept();

                executeIt.execute(new MonoThreadClient(client));
            }
            executeIt.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
