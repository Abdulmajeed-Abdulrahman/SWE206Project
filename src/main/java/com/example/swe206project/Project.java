package com.example.swe206project;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Project {
    private String name;
    private Member[] team;
    private Machine[] machines;

    public Project(String name, Member[] team, Machine[] machines) {
        this.name = name;
        this.team = getTeam();
        this.machines = getMachines();

    }

    public String getName() {
        return name;
    }

    public Member[] getTeam() {
        return team;
    }

    public void setTeam(Member[] team) {
        this.team = team;
    }

    public Machine[] getMachines() {
        return machines;
    }

    public void setMachines(Machine[] machines) {
        this.machines = machines;
    }

    public void addMember(Member member) {
        // Add member to the team array
        // You can implement this method according to your requirements
    }

    public void addMachine(Machine machine) {
        // Add machine to the machines array
        // You can implement this method according to your requirements
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Team: " + teamToString() + "\n" +
                "Machines: " + machinesToString() + "\n";
    }

    private String teamToString() {
        if (team == null || team.length == 0) {
            return "No team members";
        }

        StringBuilder teamString = new StringBuilder();
        for (Member member : team) {
            teamString.append(member.getName()).append(", ");
        }
        // Remove the trailing comma and space
        teamString.delete(teamString.length() - 2, teamString.length());
        return teamString.toString();
    }

    private String machinesToString() {
        if (machines == null || machines.length == 0) {
            return "No machines";
        }

        StringBuilder machinesString = new StringBuilder();
        for (Machine machine : machines) {
            machinesString.append(machine.getName()).append(", ");
        }
        // Remove the trailing comma and space
        machinesString.delete(machinesString.length() - 2, machinesString.length());
        return machinesString.toString();
    }


}