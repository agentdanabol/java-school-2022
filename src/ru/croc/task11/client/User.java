package ru.croc.task11.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class User {

    public static void main(String[] args) throws IOException {

        System.out.println("Enter your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        Socket socket = new Socket("127.0.0.1", 8000);
        Client client = new Client(socket, name);

        client.readMessages();
        client.writeMessages();
    }

}
