package com.zully.demojpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zully.demojpa.domain.Persona;;

public interface PersonRepository extends JpaRepository<Persona, Long>{
    List<Persona> findByNameContains(String name);
    List<Persona> findByLanguajeEquals(String name);
    List<Persona> findByIdEquals(Long id);
    List<Persona> findByNameEquals(String name);

}
