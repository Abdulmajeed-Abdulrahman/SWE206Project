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
}