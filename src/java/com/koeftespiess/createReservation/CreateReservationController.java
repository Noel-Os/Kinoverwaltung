package com.koeftespiess.createReservation;

import com.koeftespiess.Main;
import javafx.event.ActionEvent;

import java.io.IOException;

public class CreateReservationController {

    public void back(ActionEvent actionEvent) throws IOException {

        Main.getInstance().showMainMenu();

    }

}
