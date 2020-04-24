package com.koeftespiess.createReservation;

import com.koeftespiess.Main;
import com.koeftespiess.classes.Customer;
import com.koeftespiess.classes.Presentation;
import com.koeftespiess.classes.Room;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class showRoomController {

    @FXML
    public GridPane seatPane;

    private Customer customer;
    private Presentation presentation;

    private Image freeSeat = null;
    private Image reservedSeat = null;

    private List<ToggleButton> buttons = new ArrayList<>();

    public void setInformation(Customer customer, Presentation presentation) {
        this.customer = customer;
        this.presentation = presentation;

        this.freeSeat = new Image("images/freeSeat.png", 30, 30, false, true);
        this.reservedSeat = new Image("images/reservatedSeat.png", 30, 30, false, true);
        List<Integer> reservatedSeats = Main.getInstance().getReservatedSeats(presentation);
        Room room = presentation.getRoom();
        drawSeats(room.getRoomRows(), room.getRoomCols(), reservatedSeats);
    }

    public void create(ActionEvent actionEvent) {
        Main.getInstance().addCustomer(customer);
        for (int seat : this.getSelectedSeats()) {
            Main.getInstance().addSeat(this.presentation, customer, seat);
        }
    }

    public void drawSeats(int rows, int cols, List<Integer> reservatedSeats) {
        int seat = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                seat = r * cols + c;
                ToggleButton tButton = new ToggleButton();
                tButton.setText(seat + "");
                if (Main.getInstance().isSeatReserved(this.presentation, seat)) {
                    tButton.setDisable(true);
                    tButton.setGraphic(new ImageView(this.reservedSeat));
                } else {
                    tButton.setGraphic(new ImageView(this.freeSeat));
                }
                buttons.add(tButton);
                this.seatPane.add(tButton, c, r);
            }
        }
    }

    private List<Integer> getSelectedSeats() {
        List<Integer> selectedSeats = new ArrayList<Integer>();

        for (ToggleButton tButton : this.buttons) {
            if (tButton.isSelected()){
                selectedSeats.add(Integer.parseInt(tButton.getText()));
            }
        }

        return selectedSeats;
    }

    public void back(ActionEvent actionEvent) throws IOException {
        Main.getInstance().showMainMenu();
    }
}
