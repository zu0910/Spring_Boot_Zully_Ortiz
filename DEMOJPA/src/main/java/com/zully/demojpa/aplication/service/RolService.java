package com.zully.demojpa.aplication.service;

import java.util.List;

import com.zully.demojpa.domain.Rol;

public interface RolService {
    
    public List<Rol> findAllRolesByFilter(String filter, String value);
    public Rol createNewRol (String name);
    public Rol removeRol(Long id);
}
