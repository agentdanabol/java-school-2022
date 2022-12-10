package ru.croc.task15.survey;

import java.util.*;

public class Survey implements Comparator<Person> {

    private final List<AgeGroup> ageGroups;

    public Survey(List<AgeGroup> ageGroups) {
        this.ageGroups = new ArrayList<>(ageGroups);
    }

    public Map<AgeGroup, List<Person>> sortPeople(List<Person> people) {

        Map<AgeGroup, List<Person>> filteredGroups = new TreeMap<>(Comparator.comparingInt(AgeGroup::getMinAgeBound));

        for (Person person : people) {
            for (AgeGroup group : ageGroups) {
                if (group.includes(person)) {
                    filteredGroups.computeIfAbsent(group, k -> new ArrayList<>()).add(person);
                    break;
                }
            }
        }

        for (List<Person> groupPeople : filteredGroups.values()) {
            groupPeople.sort(this);
        }

        return filteredGroups;
    }

    public List<String> convertToList(Map<AgeGroup,List<Person>> result) {

        List<String> categories = new ArrayList<>();
        for(Map.Entry<AgeGroup, List<Person>> entry : result.entrySet()) {
            String age = "" + entry.getKey() + ": ";
            String people = "";
            for(Person person : entry.getValue()) {
                people += person;
            }
            categories.add(age + people);
        }

        return categories;
    }

    @Override
    public int compare(Person person1, Person person2) {
        if (person1.getAge() == person2.getAge()) {
            return person1.getFio().compareTo(person2.getFio());
        }
        return person2.getAge() - person1.getAge();
    }

    public List<AgeGroup> getAgeGroups() {
        return new ArrayList<>(ageGroups);
    }
}
