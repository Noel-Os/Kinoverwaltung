package com.koeftespiess.mainMenu;

import com.koeftespiess.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javassist.bytecode.CodeIterator;
import org.slf4j.IMarkerFactory;

import java.io.IOException;

public class MainMenuController {

    @FXML
    private GridPane grid;

    public void changeToCreatePresentation(ActionEvent actionEvent) throws IOException {
        Main.getInstance().showCreatePresentation();
    }

    public void changeToCreateMovie(ActionEvent actionEvent) throws IOException {
        Main.getInstance().showCreateMovie();
    }

    public void changeToCreateRoom(ActionEvent actionEvent) throws IOException {
        Main.getInstance().showCreateRoom();
    }

    public void showRoom(ActionEvent actionEvent) throws IOException {
        Main.getInstance().showRoom();
    }

    public void showMovies(ActionEvent actionEvent) {
    }
}
