package com.zully.demojpa.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zully.demojpa.aplication.service.PersonService;
import com.zully.demojpa.domain.Person;
import com.zully.demojpa.domain.Rol;
import com.zully.demojpa.infrastructure.repository.PersonRepository;

@Service
public class PersonalServiceIMPL implements PersonService{
    
    private final PersonRepository personRepository;

    

    public PersonalServiceIMPL(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }



    



    @Override
    public List<Person> findAllUsersByFilter(String filter, String value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllUsersByFilter'");
    }



    @Override
    public List<Rol> findAllRolesByFilter(String filter, String value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllRolesByFilter'");
    }



    @Override
    public Rol createNewRol(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createNewRol'");
    }



    @Override
    public Person updatePerson(Long id, Person person) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePerson'");
    }



    @Override
    public void deletePerson(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePerson'");
    }



    @Override
    public Rol updateRol(Long id, String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateRol'");
    }



    @Override
    public void deleteRol(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteRol'");
    }
    
    
}
