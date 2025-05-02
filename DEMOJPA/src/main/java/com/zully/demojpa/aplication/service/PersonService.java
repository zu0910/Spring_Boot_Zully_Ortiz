package com.zully.demojpa.aplication.service;

import java.util.List;


import com.zully.demojpa.domain.Person;
import com.zully.demojpa.domain.Rol;

public interface PersonService {

    public List<Person> findAllUsersByFilter(String filter, String value);
    public List<Rol> findAllRolesByFilter(String filter, String value);
    public Rol createNewRol (String name);
}
