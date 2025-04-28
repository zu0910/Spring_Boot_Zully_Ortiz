package com.zully.demojpa.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "personas")
// Bidireccional
// ManyToOne
// OneToMany
// OneToOne
// ManyToMany (Llaves compuestas)
// Embeddable -¿Que son y como usarlas?
public class Persona {
    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID autoincrement
    private Long id;
    private String name;
    private String lastName;

    @Column(name = "programming_languaje")
    private String languaje;

    @OneToMany
    private List<Rol> rol;

    // Constructor vacio
    public Persona() {
    }

    // Contructor con todos los parametros
    public Persona(Long id, String name, String lastName, String languaje, List<Rol> rol) {
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

    public List<Rol> gerRolt(){
        return rol;
    }

    public void setRol(List<Rol> rol){
        this.rol = rol;
    }


}
