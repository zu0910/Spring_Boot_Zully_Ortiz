package com.zully.demojpa.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zully.demojpa.domain.Passport;

public interface DocumentRepository extends JpaRepository<Passport, Long> {

}
