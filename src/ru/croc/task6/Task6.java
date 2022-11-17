package ru.croc.task6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Task6 {
    public static void main(String[] args) throws IOException {
        String source = "/*\n" +
                " * My first ever program in Java!\n" +
                " */\n" +
                "class Hello { // class body starts here \n" +
                "  \n" +
                "  /* main method */\n" +
                "  public static void main(String[] args/* we put command line arguments here*/) {\n" +
                "    // this line prints my first greeting to the screen\n" +
                "    System.out.println(\"Hi!\"); // :)\n" +
                "  }\n" +
                "} // the end\n" +
                "// to be continued...\n"; // test data
        String noComments = removeJavaComments(source);
        System.out.println(noComments);

        String filename = "src/ru/croc/task6/text.txt";
        try {
            System.out.println(removeJavaCommentsFromFile(filename));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String removeJavaComments(String str) throws IOException {
        StringBuilder processedStr = new StringBuilder();
        ArrayList<String> result = new ArrayList<String>();
        String[] split = str.split("\n");
        boolean inside = false;
        String temp = "";
        int current = 0;

        for(int i = 0; i < split.length; i++) {
            temp = "";
            if((current = split[i].indexOf("//")) != -1) {
                temp += split[i].substring(0, current);
                result.add(temp);
            }
            else if((current = split[i].indexOf("/*")) != -1){
                temp += split[i].substring(0, current);
                if((current = split[i].indexOf("*/")) != -1) {
                    temp += split[i].substring(current + 2);
                }
                else {
                    inside = true;
                }
                result.add(temp);
            }
            else if((current = split[i].indexOf("*/")) != -1) {
                temp += split[i].substring(current + 2);
                inside = false;
                result.add(temp);
            }
            else if(inside) {
                continue;
            }
            else {
                result.add(split[i]);
            }
        }
        for (String res : result) {
            processedStr.append(res);
            processedStr.append("\n");
        }
        return processedStr.toString();
    }

    public static String removeJavaCommentsFromFile(String filename) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        StringBuilder stringBuilder = new StringBuilder();
        String current = bufferedReader.readLine();
        while (current != null) {
            stringBuilder.append(current);
            stringBuilder.append("\n");
            current = bufferedReader.readLine();
        }
        String text = stringBuilder.toString();
        return removeJavaComments(text);
    }

}
