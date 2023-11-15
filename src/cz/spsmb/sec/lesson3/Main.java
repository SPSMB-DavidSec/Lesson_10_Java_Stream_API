package cz.spsmb.sec.lesson3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {

    private static List<Person> personList = new ArrayList<>();

    public static void main(String[] args) {
        Random random = new Random();
        personList.add(new Person("David Šec", 31, random.nextInt(50000)));
        personList.add(new Person("Correia Dominick", 18, random.nextInt(50000)));
        personList.add(new Person("Hercík Martin",17, random.nextInt(50000)));
        personList.add(new Person("Hýbl Štěpán", 18, random.nextInt(50000)));
        personList.add(new Person("Chen Ouyi",16, random.nextInt(50000)));
        personList.add(new Person("Kazmierczak Kornel",17, random.nextInt(50000)));
        personList.add(new Person("Kubelka Marek", 18, random.nextInt(50000)));
        personList.add(new Person("Landa Matěj", 17, random.nextInt(50000)));
        personList.add(new Person("Martinec Kryštof", 16, random.nextInt(50000)));
        personList.add(new Person("Mejzlík Tadeáš", 16, random.nextInt(50000)));
        personList.add(new Person("Mík Pavel", 17, random.nextInt(50000)));
        personList.add(new Person("Picek Filip", 18, random.nextInt(50000)));
        personList.add(new Person("Tomsa Štěpán", 16, random.nextInt(50000)));
        personList.add(new Person("Vlček Vojtěch", 17, random.nextInt(50000)));

        Person personWithMinSalary = PersonFilterUtils.findMinSalary(personList);
        Person personWithMinSalary2 = PersonFilterUtils.findMinSalaryWithJavaStreamAPI(personList);
        System.out.println(personWithMinSalary);
        System.out.println(personWithMinSalary2);

        System.out.println(PersonFilterUtils.sortPersonsByName(personList));

        System.out.println(PersonFilterUtils.filterAdultPersons(personList));
        System.out.println(PersonFilterUtils.filterAdultPersonsWithJavaStreamAPI(personList));

        System.out.println(PersonFilterUtils.countSumOfSalary(personList));
        System.out.println(PersonFilterUtils.countSumOfSalaryWithJavaStreamAPI(personList));

        System.out.println(PersonFilterUtils.addHelloToEachName(personList));
        System.out.println(PersonFilterUtils.addHelloToEachNameWithJavaStreamAPI(personList));

        Map<Integer, List<Person>> groupedPersons = PersonFilterUtils.groupPersonsByAge(personList);
        Map<Integer, List<Person>> groupedPersons2 = PersonFilterUtils.groupPersonsByAge(personList);
        System.out.println(groupedPersons);
        System.out.println(groupedPersons2);
    }


}
