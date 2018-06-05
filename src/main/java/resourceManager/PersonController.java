package resourceManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/people")
    public ResponseEntity<Object> getAllPeople() {

        return new ResponseEntity<>(personService.getAllPeople(), HttpStatus.OK);
    }

    @GetMapping("/person/{name}")
    public ResponseEntity<Object> getPerson(@PathVariable String name) {

        return new ResponseEntity<>(personService.getPerson(name), HttpStatus.OK);
    }

    @PostMapping("/person")
    public ResponseEntity<Object> addPerson(@RequestBody Person person) {

        personService.addPerson(person);
        return new ResponseEntity<>("Person added", HttpStatus.OK);

    }

    @PutMapping("/person/{id}")
    public ResponseEntity<Object> updatePerson(@RequestBody Person person) {

        personService.updatePerson(person);
        return new ResponseEntity<>("Person updated", HttpStatus.OK);

    }

    @DeleteMapping("/person/{id}")
    public ResponseEntity<Object> deletePerson(@PathVariable String name) {

        personService.deletePerson(name);

        return new ResponseEntity<>("Person " + name + " Deleted", HttpStatus.OK);
    }

}
