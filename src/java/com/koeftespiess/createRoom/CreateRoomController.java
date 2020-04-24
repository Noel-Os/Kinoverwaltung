package com.koeftespiess.createRoom;

import com.koeftespiess.Main;
import com.koeftespiess.classes.Room;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

import java.io.IOException;

public class CreateRoomController {

    @FXML
    public Label warningLabel;
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
        Room room = new Room();
        room.setName(nametxt.getText());
        room.setRoomCols(Integer.parseInt(roomRows.getText()));
        room.setRoomRows(Integer.parseInt(roomCols.getText()));

        Main.getInstance().addRoom(room);
        this.back(new ActionEvent());
    }

    public void back(ActionEvent actionEvent) throws IOException {
        Main.getInstance().showMainMenu();
    }

    public void informationProof(ActionEvent actionEvent) throws IOException {
        if (!nametxt.getText().equals("")){
            if (tryParse(roomCols.getText()) != null){
                if (tryParse(roomRows.getText()) != null){
                    this.create(new ActionEvent());
                }
            }
        }
        warningLabel.setText("False or Missing Information");
        warningLabel.setTextFill(Paint.valueOf("red"));
    }

    public static Integer tryParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
