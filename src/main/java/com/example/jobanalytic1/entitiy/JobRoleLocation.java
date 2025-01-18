package com.example.jobanalytic1.entitiy;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JobRoleLocation {

    private final String role;
    private final String city;
    private final String state;
    private final int population;

  
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobRoleLocation that = (JobRoleLocation) o;
        return population == that.population &&
                Objects.equals(role, that.role) &&
                Objects.equals(city, that.city) &&
                Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, city, state, population);
    }
}
