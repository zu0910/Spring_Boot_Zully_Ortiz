package com.zully.demojpa.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zully.demojpa.domain.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{

}
