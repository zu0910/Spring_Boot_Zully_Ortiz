package com.zully.demojpa.aplication.service;

import java.util.List;


import com.zully.demojpa.domain.Person;
import com.zully.demojpa.domain.Rol;

public interface PersonService {

    public List<Person> findAllUsersByFilter(String filter, String value);
    public List<Rol> findAllRolesByFilter(String filter, String value);
    public Rol createNewRol (String name);

    // Actualizar persona 
    public Person updatePerson(Long id, Person person);
    // Eliminar persona
    public void deletePerson(Long id);

    // Actualizar y elminiar rol

    public Rol updateRol(Long id, String name);
    public void deleteRol(Long id);
}
