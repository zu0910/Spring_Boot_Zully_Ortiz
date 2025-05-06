package com.zully.demojpa.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zully.demojpa.domain.Person;;

public interface PersonRepository extends JpaRepository<Person, Long>{

    List<Person> findByNameContains(String name);
    List<Person> findByLanguajeEquals(String name);
    List<Person> findByIdEquals(Long id);
    List<Person> findByNameEquals(String name);
    Optional<Person> findByPassportNumber(String number);
}
