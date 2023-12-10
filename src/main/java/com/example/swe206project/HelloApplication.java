package com.example.swe206project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class HelloApplication extends Application {
    //Login page////////////////////////////////////////////////////////////////////////////////////////////////////////
    Pane loginPane= new Pane();
    TextArea idTextArea =new TextArea();
    TextArea passwordTextArea=new TextArea();
    Image imageLoginBackground= new Image( "C:/Users/addal/IdeaProjects/SWE206Project/src/Pic/KFUPM Research Center login page.png");
    ImageView imageViewLoginBackground= new ImageView(imageLoginBackground);

    Button loginButton=new Button("Login");
    Scene loginScene=new Scene(loginPane);
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Project page//////////////////////////////////////////////////////////////////////////////////////////////////////
    Pane projectPane=new Pane();
    Scene projectsScene=new Scene(projectPane);
    Image imageProjectsPageBackground= new Image("C:/Users/addal/IdeaProjects/SWE206Project/src/Pic/KFUPM Research Center project page.png");
    ImageView imageViewProjectsPageBackground= new ImageView(imageProjectsPageBackground);

    @Override
    public void start(Stage stage) throws IOException {
    //login page////////////////////////////////////////////////////////////////////////////////////////////////////////
        imageViewLoginBackground.setFitHeight(630);
        imageViewLoginBackground.setFitWidth(1120);

        idTextArea.setPrefHeight(5);
        idTextArea.setPrefWidth(410);
        idTextArea.setTranslateY(320);
        idTextArea.setTranslateX(350);

        passwordTextArea.setPrefHeight(5);
        passwordTextArea.setPrefWidth(410);
        passwordTextArea.setTranslateY(430);
        passwordTextArea.setTranslateX(350);

        loginButton.setTranslateX(460);
        loginButton.setTranslateY(500);
        loginButton.setPrefWidth(200);
        loginButton.setPrefHeight(50);

        loginButton.setOnAction(e->{
            String idFromTextArea=idTextArea.getText();
            String passwordFromTextArea= passwordTextArea.getText();

            System.out.println(idFromTextArea);
            System.out.println(passwordFromTextArea);

            int count =0;
            ArrayList<Admin> adminList = new ArrayList<>();
            File file = new File("C:/Users/addal/IdeaProjects/SWE206Project/src/main/java/com/example/swe206project/Admins.txt");
            try {
                Scanner read = new Scanner(file);
                while (read.hasNext()) {
                    adminList.add(new Admin(read.next(), read.next()));
                }
            } catch (FileNotFoundException e1) {
                System.out.println(e1);
            }
            for (Admin admin:adminList) {
                if (admin.userId.equals(idFromTextArea)) {
                    while (!adminList.get(count).userId.equals(idFromTextArea)) {
                        count++;
                    }
                    System.out.println(count);
                    if (adminList.get(count).userId.equals(idFromTextArea) && adminList.get(count).password.equals(passwordFromTextArea)) {
                        stage.setScene(projectsScene);

                        return;
                    }
                }
            }

            Text wrongLogin=new Text("Wrong ID or Password");
            loginPane.getChildren().add(wrongLogin);
            wrongLogin.setTranslateX(430);
            wrongLogin.setTranslateY(270);
            wrongLogin.setFont(Font.font(25));
            wrongLogin.setFill(Color.RED);
        });


        loginPane.setPrefHeight(630);
        loginPane.setPrefWidth(1120);
        loginPane.getChildren().addAll(imageViewLoginBackground, idTextArea,passwordTextArea,loginButton);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Admin projects page///////////////////////////////////////////////////////////////////////////////////////////
        projectPane.setPrefHeight(630);
        projectPane.setPrefWidth(1120);

        imageViewProjectsPageBackground.setFitHeight(630);
        imageViewProjectsPageBackground.setFitWidth(1120);

        projectPane.getChildren().addAll(imageViewProjectsPageBackground);
        populateProjectsList(projectPane);

        Button addProjectButton=new Button("Add project");
        addProjectButton.setTranslateX(460);
        addProjectButton.setTranslateY(500);
        addProjectButton.setPrefWidth(200);
        addProjectButton.setPrefHeight(50);

        Button deleteProjectButton=new Button("Delete project");
        deleteProjectButton.setTranslateX(260);
        deleteProjectButton.setTranslateY(500);
        deleteProjectButton.setPrefWidth(200);
        deleteProjectButton.setPrefHeight(50);
        projectPane.getChildren().addAll(addProjectButton, deleteProjectButton);

        addProjectButton.setOnAction(e -> {
            TextInputDialog projectNameDialog = new TextInputDialog();
            projectNameDialog.setTitle("Add Project");
            projectNameDialog.setHeaderText("Enter project name:");
            String projectName = projectNameDialog.showAndWait().orElse("");

            TextInputDialog membersDialog = new TextInputDialog();
            membersDialog.setTitle("Add Project");
            membersDialog.setHeaderText("Enter project members (separated by comma):");
            String members = membersDialog.showAndWait().orElse("");

            TextInputDialog machinesDialog = new TextInputDialog();
            machinesDialog.setTitle("Add Project");
            machinesDialog.setHeaderText("Enter machines used (separated by comma):");
            String machines = machinesDialog.showAndWait().orElse("");

            addProjectToFile(projectName, members, machines);

            // Refresh the projects list after adding a new project
            populateProjectsList(projectPane);
        });

        deleteProjectButton.setOnAction(e -> {
            TextInputDialog projectNameDialog = new TextInputDialog();
            projectNameDialog.setTitle("Delete Project");
            projectNameDialog.setHeaderText("Enter project name:");
            Optional<String> result = projectNameDialog.showAndWait();

            // Check if the dialog was completed and a project name was entered
            if (result.isPresent()) {
                String projectName = result.get();
                deleteProjectFromFile(projectName);

                // Refresh the projects list after deleting a project
                populateProjectsList(projectPane);
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        stage.setTitle("KFUPM Research Center");
        stage.setResizable(false);
        stage.setScene(loginScene);
        stage.show();
    }
    private void populateProjectsList(Pane pane) {
        Text projectsListTitle = new Text("Projects List");
        projectsListTitle.setTranslateX(20);
        projectsListTitle.setTranslateY(50);
        projectsListTitle.setFont(Font.font("Arial", 20));

        // Create a TextArea to display the projects list
        TextArea projectsListTextArea = new TextArea();
        projectsListTextArea.setTranslateX(20);
        projectsListTextArea.setTranslateY(80);
        projectsListTextArea.setPrefWidth(400);
        projectsListTextArea.setPrefHeight(400);

        // Retrieve project data from a file or any other source
        File file = new File("C:/Users/addal/IdeaProjects/SWE206Project/src/Project/project.txt");
        ArrayList<Project> projectsList = new ArrayList<>();
        try {
            Scanner read = new Scanner(file);
            while (read.hasNextLine()) {
                String line = read.nextLine();
                String projectName = parseValue(line);
                String projectDescription = parseValue(line);
                Member[] members = parseMembers(line);
                Machine[] machines = parseMachines(line);
                projectsList.add(new Project(projectName, members, machines));
            }
        } catch (FileNotFoundException e1) {
            System.out.println(e1);
        }



        // Populate the projects list in the TextArea
        StringBuilder projectsListText = new StringBuilder();
        for (Project project : projectsList) {
            projectsListText.append(project.toString());
        }
        projectsListTextArea.setText(projectsListText.toString());

        pane.getChildren().addAll(projectsListTitle, projectsListTextArea);
    }

    // Helper method to parse a value within delimiters from a line
    private String parseValue(String line) {
        int startIndex = line.indexOf("[ ") + "[ ".length();
        int endIndex = line.indexOf(" ]");
        return line.substring(startIndex, endIndex);
    }

    // Helper method to parse members enclosed within square brackets
    private Member[] parseMembers(String line) {
        int startIndex = line.indexOf("[ ") + "[ ".length();
        int endIndex = line.indexOf(" ]");
        String membersString = line.substring(startIndex, endIndex);
        String[] lines = line.split("\n");
        Member[] members = new Member[lines.length];

        for (int i = 0; i < lines.length; i++) {
            String[] parts = lines[i].split(" ");
            String name = parts[1];
            members[i] = new Member(name);
        }
        return members;
    }

    // Helper method to parse machines enclosed within square brackets
    private Machine[] parseMachines(String line) {
        int startIndex = line.indexOf("[ ") + "[ ".length();
        int endIndex = line.indexOf(" ]");
        String machinesString = line.substring(startIndex, endIndex);
        String[] machineNames = machinesString.split(", ");
        Machine[] machines = new Machine[machineNames.length];
        for (int i = 0; i < machineNames.length; i++) {
            machines[i] = new Machine(machineNames[i]);
        }
        return machines;
    }

    private void addProjectToFile(String projectName, String members, String machines) {
        final String FILE_PATH = "C:/Users/addal/IdeaProjects/SWE206Project/src/Project/project.txt";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true));
            writer.write("[ " + projectName + " ] [ " + members + " ] [ " + machines + " ]");
            writer.newLine();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void deleteProjectFromFile(String projectName) {
        final String FILE_PATH = "C:/Users/addal/IdeaProjects/SWE206Project/src/Project/project.txt";
        ArrayList<String> linesToRemove = new ArrayList<>();

        try {
            File inputFile = new File(FILE_PATH);
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("[ " + projectName + " ]")) {
                    // Skip the line if it matches the project name
                    continue;
                }
                writer.write(line);
                writer.newLine();
            }

            writer.close();
            reader.close();

            // Rename the temporary file to the original file
            if (inputFile.delete()) {
                if (!tempFile.renameTo(inputFile)) {
                    System.out.println("Failed to rename the temporary file.");
                } else {
                    // Print the confirmation message to the console
                    System.out.println("Project \"" + projectName + "\" deleted successfully.");
                    // Alternatively, update a label in your GUI with the confirmation message
                    // label.setText("Project \"" + projectName + "\" deleted successfully.");
                }
            } else {
                System.out.println("Failed to delete the original file.");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}