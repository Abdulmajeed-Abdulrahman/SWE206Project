package com.example.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Machine {
    private String name;
    private String suggestedUsage;

    public Machine(String name) {
        this.name = name;
    }

    public Machine(String name, String suggestedUsage) {
        this.name = name;
        this.suggestedUsage = suggestedUsage;
    }

    public String getName() {
        return name;
    }

    public String getSuggestedUsage() {
        return suggestedUsage;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Suggested usage: " + suggestedUsage + "\n";
    }

    public static void main(String[] args) {
        ArrayList<Machine> machineList = new ArrayList<>();
        File file = new File("C:/Users/addal/IdeaProjects/SWE206Project/src/Project/machine.txt");
        try {
            Scanner read = new Scanner(file);
            while (read.hasNextLine()) {
                String name = read.nextLine();
                String suggestedUsage = read.nextLine();
                machineList.add(new Machine(name, suggestedUsage));
            }
            read.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(machineList);
    }
}
