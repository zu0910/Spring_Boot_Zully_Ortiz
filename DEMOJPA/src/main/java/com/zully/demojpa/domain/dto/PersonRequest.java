package com.zully.demojpa.domain.dto;

import jakarta.validation.constraints.NotNull;

public class PersonRequest {

    @NotNull (message = "Estos campos son requeridos")
    private String name, surname, skill, passport;

    public PersonRequest() {
    }

    public PersonRequest(String name, String suername, String skill, String passport) {
        this.name = name;
        this.surname = suername;
        this.skill = skill;
        this.passport = passport;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    
}
