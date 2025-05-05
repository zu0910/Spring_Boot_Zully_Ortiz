package com.zully.demojpa.infrastructure.controller;

import java.util.List;

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
import com.zully.demojpa.aplication.service.RolService;
import com.zully.demojpa.domain.Person;
import com.zully.demojpa.domain.Project;
import com.zully.demojpa.domain.Rol;
import com.zully.demojpa.domain.RoleRequest;
import com.zully.demojpa.domain.dto.PersonRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {
    // /api/nombre_clase
    private final ProjectService projectService;
    private final RolService rolService;
    private final PersonService personService;

    

    public ApiController(ProjectService projectService, PersonService personService, RolService rolService) {
        this.personService = personService;
        this.projectService = projectService;
        this.rolService = rolService;
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
    
    @PatchMapping("/users/{id}")
    public ResponseEntity<Person> parcialUpdatePerson(@PathVariable Long id, @RequestBody PersonRequest personDto){

        return ResponseEntity.ok().body(personService.patchPerson(id, personDto));
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
        List<Rol> results = rolService.findAllRolesByFilter(filter,value);
        return results;
    }

    @PostMapping("/roles")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Rol> newRole(@Validated @RequestBody RoleRequest rol){
        return ResponseEntity.ok(rolService.createNewRol(rol.getName()));
    }

    @DeleteMapping("/roles/{id}")
    public ResponseEntity<Rol> removeRol(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok().body(rolService.removeRol(id));
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
    //Actualizar y eliminar persona
    //Actualizar y eliminar roles
    /*
     @PutMapping("/roles/{id}")
    public ResponseEntity<Rol> updateRol(@PathVariable Long id, @Validated @RequestBody RoleRequest roleRequest) {
        return ResponseEntity.ok(rolService.updateRol(id, roleRequest.getName()));
    }
     */

    /*
    @DeleteMapping("/roles/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRol(@PathVariable Long id){
        personService.deleteRol(id);
    }

    @DeleteMapping("/roles/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String revomeRol(@PathVariable(name = "id") Long id){
        return ResponseEntity.notFound().build();
    }
     */
    

}
