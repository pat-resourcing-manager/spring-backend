package com.pat.resourceManager.person;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Person {

    @Id
    private String employeeId;
    private String name;


    public Person(String employeeId, String name) {
        this.employeeId = employeeId;
        this.name = name;
    }
}