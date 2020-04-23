package com.koeftespiess.showRoom;

import com.koeftespiess.Main;
import com.koeftespiess.classes.Room;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShowRoomController implements Initializable {

    @FXML
    private GridPane seatGrid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        int roomRows = getRoomRows();
        int roomCols = getRoomCols();

        showRoom(roomRows, roomCols);

    }
    public void showRoom(int roomRows, int roomCols) {

        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        seatGrid.setAlignment(Pos.CENTER);
        for (int i = 0; i < roomRows; i++){
            for (int count = 0; count < roomCols; count++){
                ToggleButton seat = new ToggleButton(alphabet[i] + " | " + count + "");
                seat.setPrefWidth(200);
                seatGrid.add(seat, count, i);
            }

        }

    }

    public int getRoomRows() {
        ObservableList<Room> rooms = Main.getInstance().getRooms();
        return rooms.get(0).getRoomRows();
    }

    public int getRoomCols() {
        ObservableList<Room> rooms = Main.getInstance().getRooms();
        return rooms.get(0).getRoomCols();
    }


    public void back(ActionEvent actionEvent) throws IOException {
        Main.getInstance().showMainMenu();
    }
}
