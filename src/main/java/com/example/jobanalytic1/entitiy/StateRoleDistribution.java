package com.example.jobanalytic1.entitiy;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StateRoleDistribution {
    String role;
  private int cityCount;
    private String state;
    private Set<String> cities;

    public StateRoleDistribution(String role, int cityCount, String state, Set<String> cities) {
        this.role = role;
        this.cityCount = cityCount;
        this.state = state;
        this.cities = cities;
    }
   
}
