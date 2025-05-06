package com.zully.demojpa.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.zully.demojpa.aplication.service.PersonService;
import com.zully.demojpa.domain.Passport;
import com.zully.demojpa.domain.Person;
import com.zully.demojpa.domain.Rol;
import com.zully.demojpa.domain.dto.PersonRequest;
import com.zully.demojpa.domain.dto.PersonResponse;
import com.zully.demojpa.infrastructure.error.RolDuplicateException;

import jakarta.persistence.EntityNotFoundException;



@Service
public class PersonalServiceIMPL implements PersonService{
    
    private final PersonRepository personRepository;
    private final RoleRepository roleRepository;
    private final DocumentRepository documentRepository;

    public PersonalServiceIMPL(PersonRepository personRepository, RoleRepository roleRepository, DocumentRepository documentRepository) {
        this.personRepository = personRepository;
        this.roleRepository = roleRepository;
        this.documentRepository = documentRepository;
    }

    @Override
    public List<PersonResponse> findAllUsersByFilter(String filter, String value) {
        if (filter.toLowerCase().equals("name") && !value.isEmpty()){
            return personRepository.findByNameContains(value).stream().map((person) -> {
                PersonResponse response = new PersonResponse();
                response.setName(person.getName());
                response.setSurname(person.getLastName());
                response.setSkill(person.getLanguaje());
                response.setPassport(person.getPassport() != null);
                return response;
            }).toList();
        }else if(filter.toLowerCase().equals("language")  && !value.isEmpty()){
            return personRepository.findAll().stream().map((person) -> {
                PersonResponse response = new PersonResponse();
                response.setName(person.getName());
                response.setSurname(person.getLastName());
                response.setSkill(person.getLanguaje());
                response.setPassport(person.getPassport() != null);
                return response;
            }).toList();
        }
        return personRepository.findAll().stream().map((person) -> {
            PersonResponse response = new PersonResponse();
            response.setName(person.getName());
            response.setSurname(person.getLastName());
            response.setSkill(person.getLanguaje());
            response.setPassport(person.getPassport() != null);
            return response;
        }).toList();
    }

    @Override
    public PersonResponse patchPerson(Long id, PersonRequest personDto) {
        Person person = personRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("No se encontro el usuario solicitado"));
        if(personDto.getName() != null){
            person.setName(personDto.getName());
        }
        if(personDto.getSurname() != null){
            person.setLastName(personDto.getSurname());
        }

        if(personDto.getSkill() != null){
            person.setLanguaje(personDto.getSkill());
        }
        personRepository.save(person);
        
        PersonResponse response = new PersonResponse();
            response.setName(person.getName());
            response.setSurname(person.getLastName());
            response.setSkill(person.getLanguaje());
            response.setPassport(person.getPassport() != null);
            return response;
    }

    @Override
    public PersonResponse createNewUser(PersonRequest personDto) {
        Optional<Person> person = personRepository.findByPassportNumber(personDto.getPassport());

        // Validamos que el usuario no este registrado
        if(person.isPresent()){
            throw new RolDuplicateException("El usuario ya se encuentra registrado", HttpStatus.CONFLICT);
        }

        //Buscamos el rol para el usuario
        Rol userRol = roleRepository.findById(1L)
            .orElseThrow(() -> new EntityNotFoundException("No se encuentra el Rol por defecto"));

        //Creamos el usuario temporal
        Person newPerson = new Person();
        newPerson.setName(personDto.getName());
        newPerson.setLastName(personDto.getSurname());
        newPerson.setLanguaje(personDto.getSkill());
        newPerson.setRol(userRol);

        //Guardamos nuestro nuevo registro
        Person save = personRepository.save(newPerson);

        // Creamos el passport temporal
        Passport passport = new Passport();
        passport.setPerson(newPerson);
        passport.setNumber(personDto.getPassport());

        // Guardamos nuestro nuevo registro
        documentRepository.save(passport);
        // "Mapeo" de Person a PersonResponse
        save.setPassport(passport);

        PersonResponse response = new PersonResponse();
        response.setName(save.getName());
        response.setSurname(save.getLastName());
        response.setSkill(save.getLanguaje());
        response.setPassport(save.getPassport() != null);
        return response;

    }


    /*
    @Override
    public Person updatePerson(Long id, Person updaPerson){
        Optional<Person> existingPerson = personRepository.findById(id);
        if (!existingPerson.isPresent()){
            throw new PersonNotFoundException("Persona con ID" + id + " no encontrada", HttpStatus.NOT_FOUND);
        }
        Person person = existingPerson.get();
        person.setName(updaPerson.getName());
        person.setLastName(updaPerson.getLastName());
        person.setLanguaje(updaPerson.getLanguaje());
        return personRepository.save(person);

    }
    // Eliminar persona

    @Override
    public void deletePerson(Long id){
        if(!personRepository.existsById(id)){
            throw new PersonNotFoundException("Persona con ID" + id + " no encontrada", HttpStatus.NOT_FOUND);
        }
        personRepository.deleteById(id);
    }
    */
    /*
    MI FORMA DE HACER UPDATE Y DELETE
    // Actualizar Rol

    @Override
    public Rol updateRol(Long id, String name){
        Optional<Rol> existingRol = roleRepository.findById(id);
        if (!existingRol.isPresent()){
            throw new RolNotFoundException("Rol con ID" + id + " no encontrada", HttpStatus.NOT_FOUND);
        }
        if (getRolByName(name).isPresent()){
            throw new RolNotFoundException("El Rol" + name + " ya está registrada", HttpStatus.BAD_REQUEST);
        }
        Rol rol = existingRol.get();
        rol.setName((name));
        return roleRepository.save(rol);

    }
    // Eliminar Rol

    @Override
    public void deleteRol(Long id){
        if(!roleRepository.existsById(id)){
            throw new RolNotFoundException("Rol con ID" + id + " no encontrada", HttpStatus.NOT_FOUND);
        }
        roleRepository.deleteById(id);
    }
    */



    

   
    
    
}
