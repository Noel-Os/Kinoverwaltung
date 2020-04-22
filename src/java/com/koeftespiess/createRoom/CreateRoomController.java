package com.koeftespiess.createRoom;

import com.koeftespiess.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CreateRoomController {

    @FXML
    private Button bt;

    @FXML
    private Button btback;

    @FXML
    private TextField nametxt;

    @FXML
    private TextField roomCols;

    @FXML
    private TextField roomRows;

    public void create(ActionEvent actionEventevent) throws IOException {
        Main.getInstance().addRoom(nametxt.getText(), Integer.parseInt(roomRows.getText()), Integer.parseInt(roomCols.getText()));
        this.back(new ActionEvent());
    }

    public void back(ActionEvent actionEvent) throws IOException {
        Main.getInstance().showMainMenu();
    }
}
