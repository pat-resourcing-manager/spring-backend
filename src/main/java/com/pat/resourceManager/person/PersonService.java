package com.pat.resourceManager.person;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private PersonRepository personRepository;

    public List<Person> getAllPeople() {

        List<Person> people = new ArrayList<>();

        personRepository.findAll()
                        .forEach(people::add);
        return people;
    }

    public Person getPerson(String name) {
        return personRepository.findByName(name);
    }

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    public void updatePerson(String name) {
        personRepository.findByName(name);
    }

    public void deletePerson(String employeeId) {
        personRepository.deleteById(employeeId);
    }

}
