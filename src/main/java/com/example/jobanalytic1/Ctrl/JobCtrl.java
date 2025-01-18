package com.example.jobanalytic1.Ctrl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobanalytic1.Service.JobAnalyticsService;
import com.example.jobanalytic1.entitiy.JobCluster;
import com.example.jobanalytic1.entitiy.JobRoleDistribution;
import com.example.jobanalytic1.entitiy.StateRoleDistribution;



// Controller Layer
@RestController
@RequestMapping("/api/jobs")
class JobAnalyticsController {

    @Autowired
    private JobAnalyticsService jobAnalyticsService;

    @GetMapping("/roles")
    public List<JobRoleDistribution> getJobRoles() {
        return jobAnalyticsService.getJobRoleDistribution();
    }
// /df kjsnkdngvjdrgnkj;g;jnkkjn;
    @GetMapping("/roles/state")
    public List<StateRoleDistribution> getJobRolesByState() {
        return jobAnalyticsService.getJobRoleDistributionByState();
    }

    @GetMapping("/roles/cluster")
    public List<JobCluster> getJobRoleClusters() {
        return jobAnalyticsService.getJobRoleClusters();
    }
}
