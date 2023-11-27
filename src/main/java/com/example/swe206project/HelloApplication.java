package com.example.swe206project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    Pane loginPane= new Pane();
    TextArea idTextArea =new TextArea();
    TextArea passwordTextArea=new TextArea();
    Image imageLoginBackground= new Image("C:\\Users\\aar14\\IdeaProjects\\SWE206Project\\src\\Pic\\KFUPM Research Center.png");
    ImageView imageViewLoginBackground= new ImageView(imageLoginBackground);

    Button loginButton=new Button("Login");
    Scene loginScene=new Scene(loginPane);

    @Override
    public void start(Stage stage) throws IOException {
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

        loginPane.setPrefHeight(630);
        loginPane.setPrefWidth(1120);
        loginPane.getChildren().addAll(imageViewLoginBackground, idTextArea,passwordTextArea,loginButton);


        stage.setTitle("KFUPM Research Center");
        stage.setResizable(false);
        stage.setScene(loginScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}