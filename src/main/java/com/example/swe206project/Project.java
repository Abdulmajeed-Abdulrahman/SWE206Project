package com.example.swe206project;

import java.util.Arrays;

public class Project {
    String name;
    String[] team;

    String[] machines;

    public Project(String name) {
        this.name = name;
    }

    public Project(String name, String[] team, String[] machines){
        this.name = name;
        this.team = team;
        this.machines = machines;

    }
    public String getName(){
        return this.name;
    }

    public int getNumberOfMachines(){
        return this.machines.length;
    }

    @Override
    public String toString() {
        return "Name: " + name + '\'' +
                ", Team: " + Arrays.toString(this.team) + "\n" +
                ", Machines: " + Arrays.toString(this.machines);
    }

    public void add(Member member) {
    }
}
