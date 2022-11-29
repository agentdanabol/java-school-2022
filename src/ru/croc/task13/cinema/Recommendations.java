package ru.croc.task13.cinema;

import java.util.*;

public class Recommendations {

    private final List<Integer> userHistory;

    public Recommendations(Scanner scanner) {
        String line =  scanner.nextLine();
        userHistory = new ArrayList<>();
        String[] views = line.split(",");
        for(String view : views) {
            userHistory.add((int) view.charAt(0));
        }
    }

    public String getRecommendation(Cinema cinema) {
        String result;

        List<Person> allUsers = cinema.getUsers();
        ArrayList<Person> likelyUsers = getLikely(allUsers);
        HashSet<Integer> unwatched = getUnwatched(likelyUsers);
        Integer best = getBest(unwatched, allUsers);

        Map<Integer, String> movies = cinema.getMovies();
        result = movies.get(best);

        return result;
    }

    private ArrayList<Person> getLikely(List<Person> allUsers) {
        ArrayList<Person> likelyUsers = new ArrayList<>();

        for (Person user : allUsers) {
            HashSet<Integer> currentHistory = new HashSet<>(user.getHistory());
            int count = 0;

            for (int j = 0; j < currentHistory.size()-1; j++) {
                if (currentHistory.contains(userHistory.get(j))) {
                    count++;
                }
            }

            if (count >= currentHistory.size() / 2) {
                likelyUsers.add(user);
            }
        }

        return likelyUsers;
    }

    private HashSet<Integer> getUnwatched(ArrayList<Person> likelyUsers) {
        HashSet<Integer> unwatched = new HashSet<>();

        for(Person user : likelyUsers) {
            List<Integer> currentHistory = user.getHistory();

            for (Integer movie : currentHistory) {
                if (!userHistory.contains(movie)) {
                    unwatched.add(movie);
                }
            }

        }

        return unwatched;
    }

    private Integer getBest(HashSet<Integer> unwatchedSet, List<Person> allUsers) {
        Integer result;
        List<Integer> unwatchedList = new ArrayList<>(unwatchedSet);
        Map<Integer, Integer> targetMap = new HashMap<>();

        int maxCount = 0;
        for (Integer unwatched : unwatchedList) {
            int count = 0;
            for (Person user : allUsers) {
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
