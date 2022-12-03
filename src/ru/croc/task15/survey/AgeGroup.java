package ru.croc.task15.survey;

public class AgeGroup {

    private final int minAgeBound;
    private final int maxAgeBound;

    public AgeGroup(int minAge, int maxAge){
        if(maxAge > 123) {
          maxAge = 123;
        }
        this.minAgeBound = minAge;
        this.maxAgeBound = maxAge;
    }

    public boolean includes(Person person) {
        return person.getAge() > minAgeBound && person.getAge() <= maxAgeBound && person.getAge() <= 123;
    }

    public int getMaxAgeBound() {
        return maxAgeBound;
    }

    public int getMinAgeBound() {
        return minAgeBound;
    }

    public String toString() {
        return minAgeBound + "-" + maxAgeBound;
    }
}
