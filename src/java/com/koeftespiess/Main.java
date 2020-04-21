package com.koeftespiess;


import com.koeftespiess.classes.Cinema;
import com.koeftespiess.classes.Movie;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.UUID;

public class Main extends Application {

    Cinema cinema = new Cinema();

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

    public void addMovie(String movieName, String movieDescription, int movieLength) {

        cinema.addMovie(new Movie(UUID.randomUUID().toString(),movieName, movieDescription, movieLength));

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
