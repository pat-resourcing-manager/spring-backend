package com.pat.resourceManager.skill;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Skill {

    @Id
    private String name;


    public Skill(String name) {
        this.name = name;
    }

}
