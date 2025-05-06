package com.zully.demojpa.infrastructure.controller;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zully.demojpa.aplication.service.PersonService;
import com.zully.demojpa.domain.Person;
import com.zully.demojpa.domain.dto.PersonRequest;
import com.zully.demojpa.domain.dto.PersonResponse;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final PersonService personService;

    public UserController(PersonService personService) {
        this.personService = personService;
    }

    // http://localhost:8080/api/users // all
    // http://localhost:8080/api/users?filter=language&value=python 
    // http://localhost:8080/api/users?filter=a 

    @GetMapping("/users")
    // Listar todos los usuarios que hay en forma de JSON
    public List<PersonResponse> findAll(
        @RequestParam(name="filter", defaultValue = "") String filter,
        @RequestParam(name="value", defaultValue = "") String value
    ){
        List<PersonResponse> results = personService.findAllUsersByFilter(filter,value);
        return results;
    }

    @PostMapping("/users")
    public ResponseEntity<PersonResponse> createNewUser(@Valid @RequestBody PersonRequest personDto) {
        
        return new ResponseEntity<PersonResponse>(
            personService.createNewUser(personDto),
            HttpStatusCode.valueOf(201)
        );
    }
    
    @PatchMapping("/users/{id}")
    public ResponseEntity<PersonResponse> parcialUpdatePerson(@PathVariable Long id, @RequestBody PersonRequest personDto){
        return ResponseEntity.ok().body(personService.patchPerson(id, personDto));
    }
    
    
    
    /*
     @PutMapping("/users/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person person) {
        return ResponseEntity.ok(personService.updatePerson(id, person));
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
    }
     */

}
