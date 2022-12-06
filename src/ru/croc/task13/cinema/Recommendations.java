package ru.croc.task13.cinema;

import java.util.*;

public class Recommendations {

    private int getView(int id, List<Integer> userHistory) {
        if(id >= userHistory.size()) {
            return 0;
        }
        else {
            return userHistory.get(id);
        }
    }

    public String getRecommendation(Cinema cinema, List<Integer> userHistory) {
        String result;

        List<User> allUsers = cinema.getUsers();
        ArrayList<User> likelyUsers = getLikely(allUsers, userHistory);
        HashSet<Integer> unwatched = getUnwatched(likelyUsers, userHistory);
        Integer best = getBest(unwatched, likelyUsers);

        Map<Integer, String> movies = cinema.getMovies();
        result = movies.get(best);
        if(result == null) {
            result = "Для вас нет подходящего фильма :(";
        }

        return result;
    }

    private ArrayList<User> getLikely(List<User> allUsers, List<Integer> userHistory) {
        ArrayList<User> likelyUsers = new ArrayList<>();

        for (User user : allUsers) {
            List<Integer> currentHistory = user.getHistory();
            int count = 0;

            for (int j = 0; j < currentHistory.size(); j++) {
                if (currentHistory.contains(getView(j, userHistory))) {
                    count++;
                }
            }

            if (count >= currentHistory.size() / 2) {
                likelyUsers.add(user);
            }
        }

        return likelyUsers;
    }

    private HashSet<Integer> getUnwatched(ArrayList<User> likelyUsers, List<Integer> userHistory) {
        HashSet<Integer> unwatched = new HashSet<>();

        for(User user : likelyUsers) {
            List<Integer> currentHistory = user.getHistory();

            for (Integer movie : currentHistory) {
                if (!userHistory.contains(movie)) {
                    unwatched.add(movie);
                }
            }

        }

        return unwatched;
    }

    private Integer getBest(HashSet<Integer> unwatchedSet, List<User> allUsers) {
        Integer result;
        List<Integer> unwatchedList = new ArrayList<>(unwatchedSet);
        Map<Integer, Integer> targetMap = new HashMap<>();

        int maxCount = 0;
        for (Integer unwatched : unwatchedList) {
            int count = 0;
            for (User user : allUsers) {
                count += Collections.frequency(List.of(user.getHistory()), unwatched);
            }
            targetMap.put(count, unwatched);
            if (count < maxCount) {
                maxCount = count;
            }
        }

        result = targetMap.get(maxCount);

        return result;
    }

}
