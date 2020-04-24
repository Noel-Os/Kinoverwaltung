package com.koeftespiess.createReservation;

import com.koeftespiess.Main;
import com.koeftespiess.classes.Cinema;
import com.koeftespiess.classes.Customer;
import com.koeftespiess.classes.Presentation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateReservationController implements Initializable {

    @FXML
    TextField customerName;

    @FXML
    ComboBox<Presentation> prensentation;

    private final Cinema cinema = Main.getInstance().cinema;

    @FXML
    private Labeled warningLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        prensentation.setConverter(new StringConverter<Presentation>() {
            @Override
            public String toString(Presentation presentation) {
                return "Zeit: " + presentation.getDisplayDate() + "  Film: " + presentation.getMovie().getName() + "  Raum: " + presentation.getRoom().getName();
            }

            @Override
            public Presentation fromString(String s) {
                return null;
            }
        });

        prensentation.setItems(this.cinema.getPresentations());
    }

    public void back(ActionEvent actionEvent) throws IOException {
        Main.getInstance().showMainMenu();
    }

    public void informationProof() throws IOException {
        if (!customerName.equals("")) {
            if (prensentation.getValue() != null) {
                selectSeats(new ActionEvent());
            }
        }
        warningLabel.setText("False or Missing Information");
        warningLabel.setTextFill(Paint.valueOf("red"));
    }

    public void selectSeats(ActionEvent actionEvent) throws IOException {
        Customer customer = new Customer(customerName.getText());
        Main.getInstance().showShowRoom(customer, prensentation.getValue());
    }
}
