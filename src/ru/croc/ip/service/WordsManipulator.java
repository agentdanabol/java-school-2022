package ru.croc.ip.service;

import java.util.*;

public class WordsManipulator {

    private final String sourceSentence;
    private final List<String> mixedWords;

    public WordsManipulator(String sourceSentence) {
        this.sourceSentence = sourceSentence;

        String[] split = sourceSentence.split(" ");
        this.mixedWords = new ArrayList<>(Arrays.stream(split).toList());
        Collections.shuffle(this.mixedWords);
    }

    public boolean checkSentence(String processedSentence) {
        return processedSentence.toLowerCase(Locale.ROOT).equals(sourceSentence.toLowerCase(Locale.ROOT));
    }

    public String getMixedSentence() {
        StringBuilder sentence = new StringBuilder();
        for(String word : mixedWords) {
            sentence.append(word).append(" ");
        }
        return sentence.toString();
    }

    public String getSourceSentence() {
        return sourceSentence;
    }

}
