package com.koeftespiess.createReservation;

import com.koeftespiess.Main;
import com.koeftespiess.classes.Cinema;
import com.koeftespiess.classes.Customer;
import com.koeftespiess.classes.Presentation;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CreateReservationController implements Initializable {

    @FXML
    TextField customerName;

    @FXML
    ComboBox<Presentation> prensentation;

    private List<Integer> selectedSeats = null;

    private final Cinema cinema = Main.getInstance().cinema;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        prensentation.setConverter(new StringConverter<Presentation>() {
            @Override
            public String toString(Presentation presentation) {
                return "Zeit: " + presentation.getDisplayDate() + "  Film: " + presentation.getMovie().getName() + "  Raum: " +presentation.getRoom().getName();
            }

            @Override
            public Presentation fromString(String s) {
                return null;
            }
        });

        prensentation.setItems(this.cinema.getPresentations());
    }

    public void create(ActionEvent actionEvent) throws IOException {
        Customer customer = new Customer(customerName.getText());
        Main.getInstance().addCustomer(customer);
        for (int seat:this.getSelectedSeats()) {
            Main.getInstance().addSeat(prensentation.getValue(),customer, seat);
        }
        System.out.println(customerName.getText() + prensentation.getValue());
        this.back(actionEvent);
    }

    private List<Integer> getSelectedSeats() {
        List<Integer> selectedSeats = new ArrayList<>();
        selectedSeats.add(1);
        selectedSeats.add(2);
        selectedSeats.add(7);

        this.selectedSeats = selectedSeats;
        return selectedSeats;
    }

    public void back(ActionEvent actionEvent) throws IOException {

        Main.getInstance().showMainMenu();

    }

}
