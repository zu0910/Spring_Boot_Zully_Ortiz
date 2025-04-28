package com.zully.demojpa.infrastructure.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zully.demojpa.aplication.service.PersonService;
import com.zully.demojpa.domain.Persona;
import com.zully.demojpa.repository.PersonRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {
    // /api/nombre_clase
    private final PersonRepository personRepository;
    private final PersonService personService;

    

    public ApiController(PersonRepository personRepository, PersonService personService) {
        this.personRepository = personRepository;
        this.personService = personService;
    }


    // http://localhost:8080/api/users // all
    // http://localhost:8080/api/users?filter=language&value=python 
    // http://localhost:8080/api/users?filter=a // valerie
    @GetMapping("/users")
    // Listar todos los usuarios que hay en forma de JSON
    public List<Persona> findAll(
        @RequestParam(name="filter", defaultValue = "") String filter,
        @RequestParam(name="value", defaultValue = "") String value
    ){
        List<Persona> results = personService.findAllByFilter(filter,value);
        return results;
    }
        
    // Repositorio: clase que se va encargar de administrar esos datos, la logica que trae los datos sean independientes
    // Capa intermedia entre el contralador y los datos
    // Controlador: exponer los tipos de endpoint
    
    // http://localhost:8080/api/id
    @RequestMapping( value= "/id")
    public List<Persona> findId(){
        List<Persona> rPersons = personRepository.findByIdEquals(1L);
        return rPersons;
    }

    // http://localhost:8080/api/name
    @RequestMapping( value= "/name")
    public List<Persona> findName(){
        List<Persona> rPersonsName = personRepository.findByNameContains("z");
        return rPersonsName;
    }

    

}
