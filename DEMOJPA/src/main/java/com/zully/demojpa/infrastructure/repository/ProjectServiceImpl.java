package com.zully.demojpa.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zully.demojpa.aplication.service.ProjectService;
import com.zully.demojpa.domain.Project;

@Service
public class ProjectServiceImpl implements ProjectService {
    
    private final ProjectRepository projectRepository;

    
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    @Override
    public List<Project> findAllProyects() {
        return projectRepository.findAll();
    }


    
}
