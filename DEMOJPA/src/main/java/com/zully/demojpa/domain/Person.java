package com.zully.demojpa.domain;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")
public class Person {
    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID autoincrement

    private Long id;

    @Column(name = "full_name", columnDefinition = "TEXT", length = 50, nullable = false)
    private String name;
    private String lastName;

    @Column(name = "programming_languaje")
    private String languaje;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rol_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference // Marca el lado que si seralizamos 
    private Rol rol;

    @OneToOne(mappedBy = "person", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private Passport passport;

    @ManyToMany
    @JoinTable(
        name = "persons_projects",
        joinColumns = @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "fk_persona_id_projects")),
        inverseJoinColumns = @JoinColumn(name = "projects_id", foreignKey = @ForeignKey(name = "fk_projects_id_projects"))
    )
        
    

    private List<Project> projects = new ArrayList<>();
    
    // Constructor vacio
    public Person() {
    }

    // Contructor con todos los parametros
    public Person(Long id, String name, String lastName, String languaje, Rol rol) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.languaje = languaje;
        this.rol = rol;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLanguaje() {
        return languaje;
    }

    public void setLanguaje(String languaje) {
        this.languaje = languaje;
    }

    public Rol gerRolt(){
        return rol;
    }

    public void setRol(Rol rol){
        this.rol = rol;
    }

    public Rol getRol() {
        throw new UnsupportedOperationException("Unimplemented method 'getRol'");
    }


}
