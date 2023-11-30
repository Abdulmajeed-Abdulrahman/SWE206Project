package com.example.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class machine {
    String name;
    String suggestedUsage;
    Date schedule;

    public machine(String name) {
        this.name = name;
    }

    public machine(String name, String suggestedUsage) {
        this.name = name;
        this.suggestedUsage = suggestedUsage;
    }
    @Override
    public String toString() {
        return "Name: " + name + '\'' +
                ", Suggested usage: " + suggestedUsage + "\n";
    }

    public static void main(String[] args) {
        ArrayList<machine> machineList = new ArrayList<>();
        File file = new File("C:\\Users\\Mohammed\\IdeaProjects\\demo\\src\\main\\java\\com\\example\\demo\\machine.txt");
        try {
            Scanner read = new Scanner(file);
            while (read.hasNext()) {
                machineList.add(new machine(read.nextLine(), read.nextLine()));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(machineList);
    }
}
