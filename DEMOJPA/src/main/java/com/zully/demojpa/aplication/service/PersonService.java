package com.zully.demojpa.aplication.service;

import java.util.List;


import com.zully.demojpa.domain.Persona;

public interface PersonService {
/* 
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public List<Persona> findAllByFilter(String filter, String value){
        if (filter.toLowerCase().equals("name") && !value.isEmpty()){
            return personRepository.findByNameContains(value);
        }else if(filter.toLowerCase().equals("language")  && !value.isEmpty()){
            return personRepository.findByLanguajeEquals(value);
        }
        return personRepository.findAll();
    }
*/
    public List<Persona> findAllByFilter(String filter, String value);
}
