package io.zipcoder.crudapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {



    private PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/people", method = RequestMethod.POST)
    public ResponseEntity<Person> createPerson(@RequestBody Person p){

       return  new ResponseEntity<>(personService.create(p), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/people", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> getPersonList(){

        return new ResponseEntity<>(personService.readAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.GET)
    public ResponseEntity<Person> getPerson(@PathVariable Integer id){
        return new ResponseEntity<>(personService.readById(id),HttpStatus.OK);
    }
    @RequestMapping(value = "/people/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Person> updatePerson(@PathVariable Integer id,@RequestBody Person p){
        return new ResponseEntity<>(personService.update(id, p),HttpStatus.OK);
    }
    @RequestMapping(value = "/people/{id}")
    public void DeletePerson(@PathVariable Integer id){
        personService.deleteById(id);
    }


}
