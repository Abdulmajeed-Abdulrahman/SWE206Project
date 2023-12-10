package com.example.demo;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class project {
    String name;
    member[] team;

    machine[] machines;

    public project(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name: " + name + '\'' +
                ", Team: " + team + "\n";
    }

    public void add(member member) {
    }

    public static void main(String[] args) {
        ArrayList<project> projectList = new ArrayList<>();
        File file = new File("C:/Users/addal/IdeaProjects/SWE206Project/src/Project/project.txt");
        try {
            Scanner read = new Scanner(file);
        }
         catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
//        System.out.println(projectList.get(0));
    }

}
