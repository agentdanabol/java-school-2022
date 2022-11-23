package ru.croc.task11.server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server implements Runnable {

    private Socket serverSocket;
    private BufferedReader reader;
    private BufferedWriter writer;
    private String clientName;
    public static List<Server> users = new ArrayList<>();

    public Server(Socket socket) throws IOException {
        try {
            this.serverSocket = socket;
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.clientName = reader.readLine();
            users.add(this);
        } catch (IOException e) {
            e.printStackTrace();
            getServerSocket().close();
            getReader().close();
            getWriter().close();
        }
    }

    @Override
    public void run() {
        while (getServerSocket().isConnected()) {
            try {
                String message = getReader().readLine();
                for(Server user : users) {
                    if (!user.getClientName().equals(this.getClientName())) {
                        user.getWriter().write(message);
                        user.getWriter().newLine();
                        user.getWriter().flush();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
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
