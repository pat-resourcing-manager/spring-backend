package com.pat.resourceManager.person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface PersonRepository extends CrudRepository<Person, String> {


    Person findByName(String name);
}