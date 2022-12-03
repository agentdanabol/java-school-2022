package ru.croc.task15.survey;

public class Person {

    private final String fio;
    private final int age;

    public Person(String person) {
        String[] splitPerson = person.split(",");
        this.fio = splitPerson[0];
        this.age = Integer.parseInt(splitPerson[1].replace(" ", ""));
    }

    public int getAge() {
        return age;
    }

    public String getFio() {
        return fio;
    }

    public String toString() {
        return fio + " (" + age + "); ";
    }
}
