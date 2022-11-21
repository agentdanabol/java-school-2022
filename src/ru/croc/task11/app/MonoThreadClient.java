package ru.croc.task11.app;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MonoThreadClient implements Runnable {

    private static Socket clientDialog;
    private static String name;

    public MonoThreadClient(Socket client) {
        MonoThreadClient.clientDialog = client;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {

        try {
            DataOutputStream out = new DataOutputStream(clientDialog.getOutputStream());
            DataInputStream in = new DataInputStream(clientDialog.getInputStream());

            if(!clientDialog.isClosed()) {
                System.out.println("Введите ваше имя: ");
                name = in.readUTF();
            }
            while (!clientDialog.isClosed()) {

                String entry = in.readUTF();

                if (entry.equalsIgnoreCase("quit")) {
                    System.out.println("Клиент покидает сервер...");
                    out.writeUTF("Ответ сервера - " + entry + " - OK");
                    Thread.sleep(3000);
                    break;
                }
                System.out.println(entry);

                out.writeUTF(entry);

                out.flush();
            }

            System.out.println("Клиент покинул сервер");
            in.close();
            out.close();
            clientDialog.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
