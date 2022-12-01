package ru.croc.task12.service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Service implements BlackListFilter{

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
        comments.clear();
        comments.addAll(editedComments);
    }
}
