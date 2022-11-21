package ru.croc.task9.password;

public class PasswordSet {
    private final int numberOfThreads;
    private final String password;


    public PasswordSet(int numberOfThreads, String password) {
        this.numberOfThreads = numberOfThreads;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public int getNumberOfThreads() {
        return numberOfThreads;
    }

}
