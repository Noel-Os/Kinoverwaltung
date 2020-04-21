package com.koeftespiess.createRoom;

import com.koeftespiess.Main;
import com.koeftespiess.mainMenu.MainMenuController;
import com.sun.javafx.stage.EmbeddedWindow;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jdk.jfr.Event;

import java.io.IOException;

public class CreateRoomController {

    @FXML
    private Button bt;

    @FXML
    private Button btback;

    @FXML
    private Label namelb;

    @FXML
    private TextField nametxt;

    @FXML
    private Label seatlb;

    @FXML
    private TextField seattxt;

    @FXML
    private Label rowlb;

    @FXML
    private TextField rowtxt;

    public void create(Event event) {

    }

    public void back(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        primaryStage.setTitle("Startseite");
        primaryStage.setScene(new Scene(root, 473, 418));
        primaryStage.show();
    }
}
