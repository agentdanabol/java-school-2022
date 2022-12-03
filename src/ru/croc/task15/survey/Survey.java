package ru.croc.task15.survey;

import java.util.*;

public class Survey implements Comparator<Person> {

    public Map<AgeGroup, List<Person>> sortPeople(List<Person> people, List<AgeGroup> ageGroups) {

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

    @Override
    public int compare(Person person1, Person person2) {
        if (person1.getAge() == person2.getAge()) {
            return person1.getFio().compareTo(person2.getFio());
        }
        return person2.getAge() - person1.getAge();
    }

}
