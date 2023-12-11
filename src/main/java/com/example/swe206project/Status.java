package com.example.swe206project;

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
}
