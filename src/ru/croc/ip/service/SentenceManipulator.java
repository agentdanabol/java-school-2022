package ru.croc.ip.service;

import java.util.*;

public class SentenceManipulator {

    private final List<Sentence> sentenceList;
    private int answersCount;

    public SentenceManipulator(List<Sentence> sentenceList) {
        this.sentenceList = new ArrayList<>(sentenceList);
        answersCount = this.sentenceList.size();
    }

    public List<String> setDifficulty(int difficulty) {
        List<String> resultList = new ArrayList<>();
        List<Sentence> tempList = new ArrayList<>(sentenceList);
        tempList.removeIf((sentence) -> sentence.getDifficulty() != difficulty);
        for(Sentence sentence : tempList) {
            resultList.add(sentence.getSentence());
        }
        answersCount = resultList.size();
        return resultList;
    }

    public String getSuccess(int rightAnswers) {
        double percents = (rightAnswers * 100.0) / answersCount;
        return String.format("%.0f", percents);
    }

}
