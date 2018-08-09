package com.pat.resourceManager.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/people")
    public ResponseEntity<Object> getAllPeople() {

        return new ResponseEntity<>(personService.getAllPeople(), HttpStatus.OK);
    }

    @GetMapping("/person/{employeeId}")
    public ResponseEntity<Object> getPerson(@PathVariable String employeeId) {

        return new ResponseEntity<>(personService.getPerson(employeeId), HttpStatus.OK);
    }

    @PostMapping("/person")
    public ResponseEntity<Object> addPerson(@RequestBody Person person) {

        personService.addPerson(person);
        return new ResponseEntity<>("Person added", HttpStatus.OK);

    }

    @PutMapping("/person/{name}")
    public ResponseEntity<Object> updatePerson(@RequestBody String employeeId) {

        personService.updatePerson(employeeId);
        return new ResponseEntity<>("Person " + employeeId + " updated", HttpStatus.OK);

    }

    @DeleteMapping("/person/{name}")
    public ResponseEntity<Object> deletePerson(@PathVariable String employeeId) {

        personService.deletePerson(employeeId);

        return new ResponseEntity<>("Person " + employeeId + " Deleted", HttpStatus.OK);
    }

}
