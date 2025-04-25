package com.zully.demojpa.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zully.demojpa.domain.Persona;
import com.zully.demojpa.repository.PersonRepository;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {
    // /api/nombre_clase

    private final PersonRepository personRepository;

    public ApiController(PersonRepository personRepository){
        this.personRepository= personRepository;
    }

    @GetMapping("/users")
    // Listar todos los usuarios que hay en forma de JSON
    public List<Persona> findAll(){
        List<Persona> results = personRepository.findByLanguajeEquals("Python");
        return results;
    }

    // Repositorio: clase que se va encargar de administrar esos datos, la logica que trae los datos sean independientes
    // Capa intermedia entre el contralador y los datos
    // Controlador: exponer los tipos de endpoint
    

}
