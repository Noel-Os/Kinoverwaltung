package com.koeftespiess.mainMenu;

import com.koeftespiess.Main;
import com.koeftespiess.classes.Cinema;
import com.koeftespiess.classes.Movie;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MainMenuController {
    public void changeToCreatePresentation(ActionEvent actionEvent) throws IOException {
        Main.getInstance().showCreatePresentation();
    }

    public void changeToCreateMovie(ActionEvent actionEvent) throws IOException {
        Main.getInstance().showCreateMovie();
    }

    public void changeToCreateRoom(ActionEvent actionEvent) throws IOException {
        Main.getInstance().showCreateRoom();
    }

    public void showMovies(ActionEvent event){
        ObservableList<Movie> movies = Main.getInstance().cinema.getMovies();
        for (Movie movie: movies) {

        }
    }

    public void createFilm() throws IOException {
        //"../java/com/koeftespiess/mainMenu/movieCard.fxml"
        FXMLLoader loader = FXMLLoader.load(getClass().getResource("../java/com/koeftespiess/mainMenu/movieCard.fxml"));
        AnchorPane pane = loader.load();
    }

    public void changeTocreateReservation(ActionEvent actionEvent) throws IOException {
        Main.getInstance().showCreateReservation();
    }
}
