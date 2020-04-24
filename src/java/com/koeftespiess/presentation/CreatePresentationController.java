package com.koeftespiess.presentation;

import com.koeftespiess.Main;
import com.koeftespiess.classes.Cinema;
import com.koeftespiess.classes.Movie;
import com.koeftespiess.classes.Presentation;
import com.koeftespiess.classes.Room;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Paint;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class CreatePresentationController implements Initializable {

    @FXML
    public Label warningLabel;
    @FXML
    public TextField seconds;
    @FXML
    public TextField hours;
    @FXML
    DatePicker date;

    @FXML
    Button backButton;

    @FXML
    Button createButton;

    @FXML
    ComboBox<Room> room;

    @FXML
    ComboBox<Movie> movie;

    private final Cinema cinema = Main.getInstance().cinema;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        room.setConverter(new StringConverter<Room>() {
            @Override
            public String toString(Room room) {
                return room.getName();
            }

            @Override
            public Room fromString(String s) {
                return null;
            }
        });
        room.setItems(this.cinema.getRooms());

        movie.setConverter(new StringConverter<Movie>() {
            @Override
            public String toString(Movie movie) {
                return movie.getName();
            }

            @Override
            public Movie fromString(String s) {
                return null;
            }
        });
        movie.setItems(this.cinema.getMovies());
    }

    public void addShow(Movie movie, Room room) throws IOException {
        Presentation presentation = new Presentation();
        presentation.setDisplayDate(date.getValue());
        presentation.setTime(LocalTime.of(Integer.parseInt(hours.getText()), Integer.parseInt(seconds.getText()), 0, 0));
        presentation.setMovie(movie);
        presentation.setRoom(room);
        Main.getInstance().addShow(presentation);
        this.back(new ActionEvent());

    }

    public void back(ActionEvent actionEvent) throws IOException {
        Main.getInstance().showMainMenu();
    }

    public void informationProof(ActionEvent actionEvent) throws IOException {
        Movie movie = this.movie.getValue();
        Room room = this.room.getValue();
        if (movie != null && room != null) {
            if (date.getValue() != null) {
                if (tryParse(hours.getText()) != null) {
                    if (tryParse(hours.getText()) < 24) {
                        if (tryParse(seconds.getText()) != null) {
                            if (tryParse(hours.getText()) < 60) {
                                this.addShow(movie, room);
                            }
                        }
                    }
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
