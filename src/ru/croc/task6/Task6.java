package ru.croc.task6;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Task6 {
    public static void main(String[] args) {
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

        try {
            FileReader reader = new FileReader("src/ru/croc/task6/text.txt");
            System.out.println(removeJavaCommentsFromFile(reader));
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String removeJavaComments(String str) {
        String[] split = str.split("\n");
        StringBuilder processedStr = new StringBuilder();
        ArrayList<String> result = new ArrayList<String>();
        String temp = "";
        boolean inside = false;
        String current;
        for(int j = 0; j < split.length; j++) {
            current = split[j];
            temp = "";
            for(int i = 0; i < current.length(); i++) {
                if(inside == true) {
                    if(current.charAt(i) == '*' && i + 1 < current.length() && current.charAt(i+1) == '/') {
                        inside = false;
                        i++;
                    }
                }
                else {
                    if(current.charAt(i) == '/' && i + 1 < current.length() && current.charAt(i+1) == '/') {
                        break;
                    }
                    if (current.charAt(i) == '/' && i + 1 < current.length() && current.charAt(i+1) == '*') {
                        inside = true;
                        i++;
                        continue;
                    }
                    temp += current.charAt(i);
                }
            }
            if(inside == false) {
                if (temp.length() > 0) {
                    result.add(temp);
                }
            }
        }

        for(String res : result) {
            processedStr.append(res);
            processedStr.append("\n");
        }
        return processedStr.toString();
    }

    public static String removeJavaCommentsFromFile(FileReader file) throws IOException {
        int c;
        String str = "";
        while((c = file.read()) != -1) {
            str += (char) c;
        }

        return removeJavaComments(str);
    }

}
