package ru.croc.task15;

import ru.croc.task15.survey.AgeGroup;
import ru.croc.task15.survey.Person;
import ru.croc.task15.survey.Survey;

import java.util.*;

public class Task15 {

    public static void main(String[] args) {

        List<AgeGroup> ageGroups = new ArrayList<>();
        List<Integer> values = new ArrayList<>();

        for(String arg : args) {
            int value = Integer.parseInt(arg);
            values.add(value);
        }
        values.sort(Integer::compareTo);

        ageGroups.add(new AgeGroup(0, values.get(0)));
        for(int i = 0; i < values.size()-1; i++) {
            ageGroups.add(new AgeGroup(values.get(i), values.get(i+1)));
        }
        ageGroups.add(new AgeGroup(values.get(values.size()-1), 123));

        Scanner scanner = new Scanner(System.in);
        List<Person> peopleList = new ArrayList<>();
        String line = scanner.nextLine();
        while (!line.equals("END")) {
            peopleList.add(new Person(line));
            line = scanner.nextLine();
        }

        Survey survey = new Survey(ageGroups);
        Map<AgeGroup, List<Person>> result = survey.sortPeople(peopleList);

        List<String> categories = new ArrayList<>(survey.convertToList(result));

        for(int i = categories.size() - 1; i >= 0; i--) {
            System.out.println(categories.get(i));
        }

    }

}
/*
Шейко Данила Константинович,19
Романов Виктор Витальевич,32
Вавилова Мария Ивановна,86
Ющенко Анна Владимировна,12
Батушева Кристина Даниловна,22
Поминова Варвара Алесеевна,47
Кошельков Захар Брониславович,105
Иванов Варлам Якунович,12
Соколов Андрей Сергеевич,8
Павлов Евгений Андреевич,34
END
 */