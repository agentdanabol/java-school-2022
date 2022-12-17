package ru.croc.ip.service;

public class Sentence {

    private final String sentence;
    private int difficulty;

    public Sentence(String sentence, String difficulty) {
        this.sentence = sentence;
        parseDifficulty(difficulty);
    }

    public void parseDifficulty(String level) {
        switch (level) {
            case "easy" -> difficulty = 1;
            case "medium" -> difficulty = 2;
            case "hard" -> difficulty = 3;
            default -> new Exception("Wrong difficulty level!");
        }
    }

    public String getSentence() {
        return sentence;
    }

    public int getDifficulty() {
        return difficulty;
    }
}
