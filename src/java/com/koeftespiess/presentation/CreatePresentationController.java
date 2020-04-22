package com.koeftespiess.presentation;

import com.koeftespiess.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreatePresentationController implements Initializable {

    @FXML
    DatePicker date;

    @FXML
    Button backButton;

    @FXML
    Button createButton;

    @FXML
    ComboBox room;

    @FXML
    ComboBox movie;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void addShow() {
      //  Main.getInstance().addShow(date.getValue(),movie,room);
    }

    public void back(ActionEvent actionEvent) throws IOException {
        Main.getInstance().showMainMenu();
    }
}
