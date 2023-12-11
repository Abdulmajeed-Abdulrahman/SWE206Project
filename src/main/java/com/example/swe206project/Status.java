package com.example.swe206project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Status {
    String mostActiveMember;
    String mostUtilizedMachine;
    Project projectWithMostMachines;

    public Status(){

    }

    public void setMostActiveMember(String member){
        this.mostActiveMember = member;
    }

    public void setMostUtilizedMachine(String machine){
        this.mostUtilizedMachine = machine;
    }

    public void setProjectWithMostMachines(Project project){
        projectWithMostMachines = project;
    }

    public String getMostActiveMember(){
        return this.mostActiveMember;
    }

    public String getMostUtilizedMachine(){
        return this.mostUtilizedMachine;
    }

    public Project getProjectWithMostMachines(){
        return this.projectWithMostMachines;
    }

    // a method to find the most utilized machine
    public String findMostFrequentMachine(List<Project> projects){
        Map<String, Integer> machineOccurrences = new HashMap<>();

        // Iterate through projects and count machine occurrences
        for (Project project : projects) {
            for (String machine : project.machines) {
                machineOccurrences.put(machine, machineOccurrences.getOrDefault(machine, 0) + 1);
            }
        }

        // Find the machine with the highest count
        String mostRepeatedMachine = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : machineOccurrences.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostRepeatedMachine = entry.getKey();
            }
        }

        return mostRepeatedMachine;

    }

    // a method to find the most active member
    public String findMostFrequentMember(List<Project> projects){
        Map<String, Integer> machineOccurrences = new HashMap<>();

        // Iterate through projects and count machine occurrences
        for (Project project : projects) {
            for (String member : project.team) {
                machineOccurrences.put(member, machineOccurrences.getOrDefault(member, 0) + 1);
            }
        }

        // Find the member with the highest count
        String mostRepeatedMachine = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : machineOccurrences.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostRepeatedMachine = entry.getKey();
            }
        }

        return mostRepeatedMachine;

    }
}

