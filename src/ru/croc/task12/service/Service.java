package ru.croc.task12.service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Service implements BlackListFilter{

    ArrayList<String> allComments;
    Set<String> prohibitedWords;

    public Service() {
        this.allComments = new ArrayList<>();
        this.prohibitedWords = new TreeSet<>();
    }

    public void addComment(String comment) {
        allComments.add(comment);
        filterComments(allComments, prohibitedWords);
    }

    public void addProhibitedWord(String... words) {
        prohibitedWords.addAll(Arrays.asList(words));
        filterComments(allComments, prohibitedWords);
    }

    public void printComments() {
        for (String comment : allComments) {
            System.out.println(comment);
        }
    }


    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        if(blackList.isEmpty()){
            return;
        }
        List<String> editedComments = new ArrayList<>();
        for(String comment : comments) {
            for(String prohibited : blackList) {
                if(comment.contains(prohibited)) {
                    String asterisks = IntStream.range(0, prohibited.length()).mapToObj(index -> "" + '*').collect(Collectors.joining());
                    comment = comment.replaceAll(prohibited, asterisks);

                }
            }
            editedComments.add(comment);
        }
        allComments.clear();
        allComments.addAll(editedComments);
    }
}
