package cz.spsmb.sec.lesson3;

import java.util.*;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {
        Random random = new Random();
        FakeDBService db = new FakeDBService();
        db.savePerson(new Person("David Šec", 31, random.nextInt(50000)));
        db.savePerson(new Person("Correia Dominick", 18, random.nextInt(50000)));
        db.savePerson(new Person("Hercík Martin",17, random.nextInt(50000)));
        db.savePerson(new Person("Hýbl Štěpán", 18, random.nextInt(50000)));
        db.savePerson(new Person("Chen Ouyi",16, random.nextInt(50000)));
        db.savePerson(new Person("Kazmierczak Kornel",17, random.nextInt(50000)));
        db.savePerson(new Person("Kubelka Marek", 18, random.nextInt(50000)));
        db.savePerson(new Person("Landa Matěj", 17, random.nextInt(50000)));
        db.savePerson(new Person("Martinec Kryštof", 16, random.nextInt(50000)));
        db.savePerson(new Person("Mejzlík Tadeáš", 16, random.nextInt(50000)));
        db.savePerson(new Person("Mík Pavel", 17, random.nextInt(50000)));
        db.savePerson(new Person("Picek Filip", 18, random.nextInt(50000)));
        db.savePerson(new Person("Tomsa Štěpán", 16, random.nextInt(50000)));
        db.savePerson(new Person("Vlček Vojtěch", 17, random.nextInt(50000)));

        Optional<Person> found = db.findPersonByName("David Šec");
        System.out.println(found);
        if (found.isPresent()){
            Person person = found.get();
            int salary = person.getSalary();
            System.out.println(salary);
        }
        else {
            System.out.println("Person not found.");
        }


        Person defaultPerson = found.orElse(new Person("UNKNOWN",0,0));
        System.out.println(defaultPerson);

        //found.orElseThrow(()-> new NoElementFound("Person not found."));

        int salary = found.map(Person::getSalary).orElse(0);
        System.out.println(salary);


        // Vyfiltruj osoby kterým je více než 17 a zároveň mají plat větší než 1000 vypište jména všech takto nalezených osob

        List<String> foundPersons = db.getPersonsByAge(17).stream().filter((person -> person.getSalary() > 1000))
                .map(Person::getName).collect(Collectors.toList());




    }


}
