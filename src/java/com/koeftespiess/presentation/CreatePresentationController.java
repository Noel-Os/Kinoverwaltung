package com.koeftespiess.presentation;

import com.koeftespiess.Main;
import com.koeftespiess.classes.Cinema;
import com.koeftespiess.classes.Movie;
import com.koeftespiess.classes.Room;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.util.StringConverter;

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

    public void addShow() throws IOException {
        Movie movie = null;
        Room room = null;
        System.out.println(this.room.getValue());
        this.cinema.getMovies();
        for (Room item : this.cinema.getRooms()) {
            if (item.isMe(this.room.getValue().getId())) {
                room = item;
            }
        }
        for (Movie item : this.cinema.getMovies()) {
            if (item.isMe(this.movie.getValue().getId())) {
                movie = item;
            }
        }
        if (movie != null && room != null) {
            Main.getInstance().addShow(date.getValue(), movie, room);
        }
        this.back(new ActionEvent());

    }

    public void back(ActionEvent actionEvent) throws IOException {
        Main.getInstance().showMainMenu();
    }
}
