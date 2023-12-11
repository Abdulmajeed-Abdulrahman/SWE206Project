package com.example.swe206project;

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
}