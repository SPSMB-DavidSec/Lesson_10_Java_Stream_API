package cz.spsmb.sec.lesson3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FakeDBService {

    List<Person> personsInDB = new ArrayList<>();


    public void savePerson(Person person){
        personsInDB.add(person);
    }

    public Optional<Person> findPersonByName(String name){
        Person foundPerson = null;
        for (Person person: personsInDB){
            if(person.getName().equals(name)){
                foundPerson = person;
            }
        }
        return Optional.ofNullable(foundPerson);
    }

    /**
     * getAllPersons in DB
     * @return
     */
    public List<Person> getAllPersons(){
        return personsInDB;
    }

    /**
     * find all persons with defined age
     * @param age
     * @return
     */
    public List<Person> getPersonsByAge(int age){
        return personsInDB.stream().filter((person)-> person.getAge() >= age).collect(Collectors.toList());
    }


}
