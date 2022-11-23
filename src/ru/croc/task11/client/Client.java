package ru.croc.task11.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket serverSocket;
    private BufferedReader reader;
    private BufferedWriter writer;
    private String clientName;

    public Client(Socket socket, String clientUsername) throws IOException {
        try {
            this.serverSocket = socket;
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.clientName = clientUsername;
        } catch (IOException e) {
            e.printStackTrace();
            getServerSocket().close();
            getReader().close();
            getWriter().close();
        }
    }

    public void writeMessages() {
        try {
            getWriter().write(getClientName());
            getWriter().newLine();
            getWriter().flush();
            Scanner scanner = new Scanner(System.in);
            while (getServerSocket().isConnected()) {
                String message = scanner.nextLine();
                getWriter().write(getClientName() + ": " + message);
                getWriter().newLine();
                getWriter().flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readMessages() {
        Thread listenThread = new Thread(() -> {
            while (getServerSocket().isConnected()) {
                try {
                    String message = getReader().readLine();
                    System.out.println(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        listenThread.start();
    }

    public Socket getServerSocket() {
        return serverSocket;
    }

    public BufferedReader getReader() {
        return reader;
    }
    public BufferedWriter getWriter() {
        return writer;
    }

    public String getClientName() {
        return clientName;
    }
}