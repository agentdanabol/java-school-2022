package ru.croc.task14.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public interface BlackListFilter<E> {

    /**
     * From the given list of comments removes ones
     * that contain words from the black list.
     *
     * @param comments  list of comments; every comment
     *                  is a sequence of words, separated
     *                  by spaces, punctuation or line breaks
     * @param predicate list of words that should not
     *                  be present in a comment
     */
    default Collection<E> filterComments(Iterable<E> comments, Predicate<E> predicate) {
        Collection<E> resultComments = new ArrayList<>();
        for(E comment : comments) {
            if(!predicate.test(comment)) {
                resultComments.add(comment);
            }
        }
        return resultComments;
    }

}
