package com.zully.demojpa.domain.dto;

public class PersonRequest {

    private String name, suername, skill;

    public PersonRequest() {
    }

    public PersonRequest(String name, String suername, String skill) {
        this.name = name;
        this.suername = suername;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuername() {
        return suername;
    }

    public void setSuername(String suername) {
        this.suername = suername;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    
}
