package com.koeftespiess;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    Cinema cinema = new Cinema();

    public Object addMovie;

    public Stage primaryStage;

    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Main.instance = this;
        this.primaryStage = primaryStage;

        primaryStage.setTitle("Hello World");
        showMainMenu();
        primaryStage.show();
    }

    public void showMainMenu() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("mainMenu/MainMenu.fxml"));
        }catch (IOException e){
            e.printStackTrace();
        }
        this.primaryStage.setScene(new Scene(root, 300, 275));
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void addMovie(String movieName, String movieDescription, String movieLength) {

        cinema.addMovie(new Movie(movieName, movieDescription, movieLength));

    }

    public void showCreateMovie() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("createMovie/CreateMovie.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.primaryStage.setScene(new Scene(root, 600, 530));
    }

}
