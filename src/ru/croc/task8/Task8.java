package ru.croc.task8;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) throws Exception {
        try {
            System.out.println("Enter a double: ");
            Scanner scanner = new Scanner(System.in);
            Double price = scanner.nextDouble();
            String[] splitter = String.valueOf(price).split("\\.");
            if(price < 0 || splitter[1].length() > 2) {
                throw new Exception("The price must be positive and contain no more 2 numbers after a comma!");
            }

            Currency usd = Currency.getInstance("USD");
            NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
            format.setCurrency(usd);
            String result = format.format(price);

            System.out.println("Result: " + result);
        }
        catch (InputMismatchException e) {
            throw new Exception("The price must be double!");
        }
    }
}
