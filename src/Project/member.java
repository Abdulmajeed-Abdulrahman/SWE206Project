package com.example.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class member {
    String email;
    String name;
    String interests;

    public member(String name) {
        this.name = name;
    }

    public member(String email, String name , String interests) {
        this.email = email;
        this.name = name;
        this.interests = interests;
    }
    @Override
    public String toString() {
//        return "Email: " + email + '\'' + ", Name: " + name +  ", Interests: " + interests + "\n";
        return  name;
    }


    public static void main(String[] args) {
        ArrayList<member> memberList = new ArrayList<>();
        File file = new File("C:\\Users\\Mohammed\\IdeaProjects\\demo\\src\\main\\java\\com\\example\\demo\\members.txt");
        try {
            Scanner read = new Scanner(file);
            while (read.hasNext()) {
                memberList.add(new member(read.next(), read.next(), read.next()));
                read.next();
                memberList.add(new member(read.next()));
                read.next();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(memberList);
    }
}
