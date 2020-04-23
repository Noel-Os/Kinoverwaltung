package com.koeftespiess.createReservation;

import com.koeftespiess.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CreateReservationController {

    @FXML
    TextField customerName;

    @FXML
    ComboBox prensentation;

    public void create(ActionEvent actionEvent) throws IOException {
        this.back(actionEvent);
    }

    public void back(ActionEvent actionEvent) throws IOException {

        Main.getInstance().showMainMenu();

    }

}
