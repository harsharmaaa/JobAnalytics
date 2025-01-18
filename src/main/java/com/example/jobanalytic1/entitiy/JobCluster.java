package com.example.jobanalytic1.entitiy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JobCluster {
    private String role;
    private int count;
    private String location;
    private int population;
}
