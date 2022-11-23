package ru.croc.task11.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Starter {

    public static void main(String[] args) throws IOException {

        try(ServerSocket serverSocket = new ServerSocket(8000)) {
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                System.out.println("New user connected");
                Server server = new Server(socket);
                Thread thread = new Thread(server);
                thread.start();
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}