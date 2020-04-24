package com.koeftespiess.mainMenu;

import com.koeftespiess.Main;
import com.koeftespiess.classes.Movie;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    @FXML
    public AnchorPane moviePane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.loadMovies();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMovies() throws IOException {
        int posY = 0;
        for (Movie movie:Main.getInstance().cinema.getMovies()) {
            FXMLLoader laoder = new FXMLLoader(MainMenuController.class.getResource("movieCard.fxml"));
            AnchorPane pane = laoder.load();
            pane.setStyle("-fx-border-color: white;");
            pane.setLayoutY(posY);
            posY += 220;
            MovieCardController controller = laoder.getController();
            controller.setInformation(movie);
            moviePane.getChildren().add(pane);
            moviePane.setPrefHeight(posY + 200);
        }
    }

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
