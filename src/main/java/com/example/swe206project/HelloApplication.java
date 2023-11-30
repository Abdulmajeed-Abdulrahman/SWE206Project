package com.example.swe206project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HelloApplication extends Application {
    //Login page////////////////////////////////////////////////////////////////////////////////////////////////////////
    Pane loginPane= new Pane();
    TextArea idTextArea =new TextArea();
    TextArea passwordTextArea=new TextArea();
    Image imageLoginBackground= new Image("C:\\Users\\aar14\\IdeaProjects\\SWE206Project\\src\\Pic\\KFUPM Research Center login page.png");
    ImageView imageViewLoginBackground= new ImageView(imageLoginBackground);

    Button loginButton=new Button("Login");
    Scene loginScene=new Scene(loginPane);
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Project page//////////////////////////////////////////////////////////////////////////////////////////////////////
    Pane projectPane=new Pane();
    Scene projectsScene=new Scene(projectPane);
    Image imageProjectsPageBackground= new Image("C:\\Users\\aar14\\IdeaProjects\\SWE206Project\\src\\Pic\\KFUPM Research Center project page.png");
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
            File file = new File("C:\\Users\\aar14\\IdeaProjects\\SWE206Project\\src\\main\\java\\com\\example\\swe206project\\Admins.txt");
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
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        stage.setTitle("KFUPM Research Center");
        stage.setResizable(false);
        stage.setScene(loginScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}