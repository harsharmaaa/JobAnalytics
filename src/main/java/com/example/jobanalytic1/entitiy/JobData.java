package com.example.jobanalytic1.entitiy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JobData {
    private String title;
    
    private String description;
    private String city;
    private String state;
    private int population;
    
    public String getRole() {
        if (title.contains("RN")) return "RN";
        if (title.contains("LPN")) return "LPN";
        return "Other";
    }

    // Getters and Setters
    public String getCity() { return city; }
    public String getState() { return state; }
    public int getPopulation() { return population; }
}
