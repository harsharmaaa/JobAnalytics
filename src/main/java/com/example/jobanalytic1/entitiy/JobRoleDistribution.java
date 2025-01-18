package com.example.jobanalytic1.entitiy;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobRoleDistribution {
    private String role;
    private int count;
    private String city;
    private String state;
    private int population;

    public JobRoleDistribution(String role, int count, String city, String state, int population) {
        this.role = role;
        this.count = count;
        this.city = city;
        this.state = state;
        this.population = population;
    }

    
}