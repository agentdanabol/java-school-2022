package ru.croc.task9.password;

import java.util.ArrayList;
import java.util.List;

public class GetPassword {


    public GetPassword(String hashPassword){
        //this.hashPassword = hashPassword;
    }

    public static String bruteForce(){
        List<Character> symbols = new ArrayList<Character>();
        for (char c='a'; c<='z'; c++) {
            symbols.add(c);
        }
        return "";
    }


}
