package com.zully.demojpa.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.zully.demojpa.aplication.service.PersonService;
import com.zully.demojpa.domain.Person;
import com.zully.demojpa.domain.Rol;
import com.zully.demojpa.infrastructure.error.RolDuplicateException;

@Service
public class PersonalServiceIMPL implements PersonService{
    
    private final PersonRepository personRepository;
    private final RoleRepository roleRepository;
    

    public PersonalServiceIMPL(PersonRepository personRepository, RoleRepository _roleRepository) {
        this.personRepository = personRepository;
        this.roleRepository = _roleRepository;
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
    public List<Rol> findAllRolesByFilter(String filter, String value) {
        
        return roleRepository.findAll();
    }
    
    @Override
    public Rol createNewRol(String name){
        Rol newRol = new Rol();
        newRol.setName(name);

        if (getRolByName(name).isPresent()){
            throw new RolDuplicateException("El Rol" +name+ "ya está registrado",
            HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return roleRepository.save(newRol);
    }

    private Optional<Rol> getRolByName(String rolName){
        return roleRepository.findByName(rolName);
    }



    

   
    
    
}
