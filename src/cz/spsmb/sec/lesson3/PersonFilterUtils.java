package cz.spsmb.sec.lesson3;

import java.util.*;
import java.util.stream.Collectors;

public class PersonFilterUtils {
    public static final int ADULT_AGE = 18;

    public static Person findMinSalary(List<Person> personList) {
        Person personWithMinSalary = null;
        for (Person person : personList) {
            if (personWithMinSalary == null || person.getSalary() < personWithMinSalary.getSalary()) {
                personWithMinSalary = person;
            }
        }
        return personWithMinSalary;
    }

    public static Person findMinSalaryWithJavaStreamAPI(List<Person> personList) {
        return personList.stream().min(Comparator.comparing(Person::getSalary)).get();
    }


    public static List<Person> sortPersonsByName(List<Person> personList) {
        return personList.stream().sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());
    }

    public static List<Person> filterAdultPersons(List<Person> personList) {
        List<Person> filteredPersons = new ArrayList<>();
        for (Person person : personList) {
            if (person.age >= ADULT_AGE) {
                filteredPersons.add(person);
            }
        }
        return filteredPersons;
    }

    public static List<Person> filterAdultPersonsWithJavaStreamAPI(List<Person> personList) {
        return personList.stream().filter(person -> person.getAge() >= ADULT_AGE)
                .collect(Collectors.toList());
    }

    public static Integer countSumOfSalary(List<Person> personList) {
        Integer sum = 0;
        for (Person person : personList) {
            sum += person.getSalary();
        }
        return sum;
    }

    public static Integer countSumOfSalaryWithJavaStreamAPI(List<Person> personList) {
        return personList.stream().map(Person::getSalary).reduce(Integer::sum).get();
    }

    public static List<String> addHelloToEachName(List<Person> personList) {
        List<String> helloList = new ArrayList<>();
        for (Person person : personList) {
            String name = "Hello " + person.getName();
            helloList.add(name);
        }
        return helloList;
    }

    public static List<String> addHelloToEachNameWithJavaStreamAPI(List<Person> personList) {
        return personList.stream().map(p -> String.format("Hello %s", p.getName()))
                .collect(Collectors.toList());
    }


    public static Map<Integer, List<Person>> groupPersonsByAge(List<Person> personList) {
        Map<Integer, List<Person>> map = new HashMap<>();

        for (Person person : personList) {
            if (!map.containsKey(person.getAge())) {
                map.put(person.getAge(), new ArrayList<>());
            }
        }

        for (Person person : personList) {
            Integer age = person.getAge();
            map.get(age).add(person);
        }
        return map;
    }


    public static Map<Integer, List<Person>> groupPersonsByAgeWithJavaStreamAPI(List<Person> personList) {
        return personList.stream().collect(Collectors.groupingBy(Person::getAge));
    }
}
