package com.zully.demojpa.infrastructure.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zully.demojpa.aplication.service.ProjectService;
import com.zully.demojpa.domain.Project;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

     @GetMapping("/projects")
    // Listar todos los usuarios que hay en forma de JSON
    public List<Project> findAllProjects(
        @RequestParam(name="filter", defaultValue = "") String filter,
        @RequestParam(name="value", defaultValue = "") String value
    ){
        List<Project> results = projectService.findAllProyects();
        return results;
    }

    


    
}
