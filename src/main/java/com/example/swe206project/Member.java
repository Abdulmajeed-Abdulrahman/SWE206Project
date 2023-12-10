package com.example.swe206project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Member {
    private String email;
    private String name;
    private String interests;

    public Member(String name) {
        this.name = name;
    }

    public Member(String email, String name, String interests) {
        this.email = email;
        this.name = name;
        this.interests = interests;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getInterests() {
        return interests;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        ArrayList<Member> memberList = new ArrayList<>();
        File file = new File("C:/Users/addal/IdeaProjects/SWE206Project/src/Project/members.txt");
        try {
            Scanner read = new Scanner(file);
            while (read.hasNext()) {
                String email = read.next();
                String name = read.next();
                String interests = read.next();
                read.nextLine(); // Skip the rest of the line
                memberList.add(new Member(email, name, interests));
            }
            read.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(memberList);
    }
}