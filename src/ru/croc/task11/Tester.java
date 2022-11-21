package ru.croc.task11;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Tester implements Runnable {

    static Socket socket;

    public Tester() {
        try {
            socket = new Socket("127.0.0.1", 3345);
            System.out.println("Клиент подключился");
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try (DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
                DataInputStream ois = new DataInputStream(socket.getInputStream())) {

            String in = ois.readUTF();
            oos.writeUTF(in);

//            int i = 0;
//            while (i < 5) {
//                oos.writeUTF("clientCommand " + i);
//
//                oos.flush();
//                Thread.sleep(10);
//
//                String in = ois.readUTF();
//                System.out.println(in);
//                i++;
//                Thread.sleep(5000);
//
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
