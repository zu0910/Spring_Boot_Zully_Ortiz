package com.zully.demojpa.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zully.demojpa.aplication.service.PersonService;
import com.zully.demojpa.domain.Person;
import com.zully.demojpa.domain.dto.PersonRequest;

import jakarta.persistence.EntityNotFoundException;



@Service
public class PersonalServiceIMPL implements PersonService{
    
    private final PersonRepository personRepository;
    

    public PersonalServiceIMPL(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAllUsersByFilter(String filter, String value) {
        if (filter.toLowerCase().equals("name") && !value.isEmpty()){
            return personRepository.findByNameContains(value);
        }else if(filter.toLowerCase().equals("language")  && !value.isEmpty()){
           return personRepository.findByLanguajeEquals(value);
        }
        return personRepository.findAll();
    }

    @Override
    public Person patchPerson(Long id, PersonRequest personDto) {
        Person person = personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se encontro el usuario solicitado"));
        if(personDto.getName() != null){
            person.setName(personDto.getName());
        }
        if(personDto.getSuername() != null){
            person.setLastName(personDto.getSuername());
        }

        if(personDto.getSkill() != null){
            person.setLanguaje(personDto.getSkill());
        }
        personRepository.save(person);
        return person;
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
