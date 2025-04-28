package com.zully.demojpa.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zully.demojpa.aplication.service.PersonService;
import com.zully.demojpa.domain.Persona;

@Service
public class PersonalServiceIMPL implements PersonService{
    
    private final PersonRepository personRepository;

    

    public PersonalServiceIMPL(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }



    @Override
    public List<Persona> findAllByFilter(String filter, String value) {
        if (filter.toLowerCase().equals("name") && !value.isEmpty()){
            return personRepository.findByNameContains(value);
        }else if(filter.toLowerCase().equals("language")  && !value.isEmpty()){
           return personRepository.findByLanguajeEquals(value);
        }
        return personRepository.findAll();
    }
    
    
}
