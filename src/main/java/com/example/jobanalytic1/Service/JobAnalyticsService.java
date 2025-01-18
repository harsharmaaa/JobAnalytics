package com.example.jobanalytic1.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.jobanalytic1.entitiy.JobCluster;
import com.example.jobanalytic1.entitiy.JobData;
import com.example.jobanalytic1.entitiy.JobRoleDistribution;
import com.example.jobanalytic1.entitiy.JobRoleLocation;
import com.example.jobanalytic1.entitiy.StateRoleDistribution;
import com.example.jobanalytic1.entitiy.StateRoleKey;


@Service
public class JobAnalyticsService {
    private final String CSV_FILE_PATH = "src/main/resources/interview_test.csv";

    public List<JobRoleDistribution> getJobRoleDistribution() {
        List<JobData> jobData = parseCsvFile();

    Map<JobRoleLocation, Long> groupedData = new HashMap<>();
    for (JobData job : jobData) {
        JobRoleLocation key = new JobRoleLocation(
            job.getRole(),
            job.getCity(),
            job.getState(),
            job.getPopulation()
        );
        groupedData.put(key, groupedData.getOrDefault(key, 0L) + 1);
    }

    List<JobRoleDistribution> jobRoleDistributions = new ArrayList<>();
    for (Map.Entry<JobRoleLocation, Long> entry : groupedData.entrySet()) {
        JobRoleLocation key = entry.getKey();
        jobRoleDistributions.add(
            new JobRoleDistribution(
                key.getRole(),
                entry.getValue().intValue(),
                key.getCity(),
                key.getState(),
                key.getPopulation()
            )
        );
    }

    return jobRoleDistributions;
    }

    public List<StateRoleDistribution> getJobRoleDistributionByState() {
        List<JobData> jobData = parseCsvFile();

        return jobData.stream()
                .collect(Collectors.groupingBy(
                        job -> new StateRoleKey(job.getRole(), job.getState()),
                        Collectors.mapping(JobData::getCity, Collectors.toSet())
                ))
                .entrySet()
                .stream()
                .map(entry -> new StateRoleDistribution(
                        entry.getKey().getRole(),
                        entry.getValue().size(),
                        entry.getKey().getState(),
                        entry.getValue()
                ))
                .collect(Collectors.toList());
    }

    public List<JobCluster> getJobRoleClusters() {
        return Collections.emptyList();
    }

    private List<JobData> parseCsvFile() {
        List<JobData> jobDataList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            br.readLine(); 
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
               if (values.length >= 5) {
    try {
        
        String populationStr = values[4].replaceAll("[^0-9]", ""); 
        int population = populationStr.isEmpty() ? 0 : Integer.parseInt(populationStr); 
        jobDataList.add(new JobData(values[0], values[1], values[2], values[3], population));
    } catch (NumberFormatException e) {
        System.err.println("Invalid population value in row: " + Arrays.toString(values));
    }
}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jobDataList;
    }
}
