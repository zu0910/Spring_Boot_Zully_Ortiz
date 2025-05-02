package com.zully.demojpa.infrastructure.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zully.demojpa.aplication.service.PersonService;
import com.zully.demojpa.aplication.service.ProjectService;
import com.zully.demojpa.domain.Person;
import com.zully.demojpa.domain.Project;
import com.zully.demojpa.domain.Rol;
import com.zully.demojpa.domain.RoleRequest;
import com.zully.demojpa.infrastructure.repository.PersonRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {
    // /api/nombre_clase
    private final ProjectService projectService;
    private final PersonRepository personRepository;
    private final PersonService personService;

    

    public ApiController(PersonRepository personRepository, PersonService personService, ProjectService projectService) {
        this.personRepository = personRepository;
        this.personService = personService;
        this.projectService = projectService;
    }


    // http://localhost:8080/api/users // all
    // http://localhost:8080/api/users?filter=language&value=python 
    // http://localhost:8080/api/users?filter=a // valerie
    @GetMapping("/users")
    // Listar todos los usuarios que hay en forma de JSON
    public List<Person> findAll(
        @RequestParam(name="filter", defaultValue = "") String filter,
        @RequestParam(name="value", defaultValue = "") String value
    ){
        List<Person> results = personService.findAllUsersByFilter(filter,value);
        return results;
    }
        
    // Repositorio: clase que se va encargar de administrar esos datos, la logica que trae los datos sean independientes
    // Capa intermedia entre el contralador y los datos
    // Controlador: exponer los tipos de endpoint
    
    @GetMapping("/roles")
    // Listar todos los usuarios que hay en forma de JSON
    public List<Rol> findAllRoles(
        @RequestParam(name="filter", defaultValue = "") String filter,
        @RequestParam(name="value", defaultValue = "") String value
    ){
        List<Rol> results = personService.findAllRolesByFilter(filter,value);
        return results;
    }

    @PostMapping("/roles")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Rol> newRole(@Validated @RequestBody RoleRequest rol){
        return ResponseEntity.ok(personService.createNewRol(rol.getName()));
    }

    @GetMapping("/projects")
    // Listar todos los usuarios que hay en forma de JSON
    public List<Project> findAllProjects(
        @RequestParam(name="filter", defaultValue = "") String filter,
        @RequestParam(name="value", defaultValue = "") String value
    ){
        List<Project> results = projectService.findAllProyects();
        return results;
    }

}
