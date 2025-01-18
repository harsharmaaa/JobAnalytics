package com.example.jobanalytic1.entitiy;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class StateRoleKey {
  private final String role;
    private final String state;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StateRoleKey that = (StateRoleKey) o;
        return Objects.equals(role, that.role) && Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, state);
    }

}
