package com.zully.demojpa.aplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zully.demojpa.domain.Person;
import com.zully.demojpa.domain.dto.PersonRequest;

@Service
public interface PersonService {

    public List<Person> findAllUsersByFilter(String filter, String value);
    public Person patchPerson(Long id,PersonRequest personDto);
    
/*
 // Actualizar persona 
    public Person updatePerson(Long id, Person person);
    // Eliminar persona
    public void deletePerson(Long id);

    // Actualizar y elminiar rol

    public Rol updateRol(Long id, String name);
    public void deleteRol(Long id);
 */
    

    
    
    
}
