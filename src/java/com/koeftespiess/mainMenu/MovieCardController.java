package com.koeftespiess.mainMenu;

import com.koeftespiess.Main;
import com.koeftespiess.classes.Movie;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MovieCardController {

    public Label name;
    public Label duration;
    public Label description;
    public ImageView movieImage;
    public Label descriptionT;
    Movie movie;

    public void setInformation(Movie movie) {
        this.movie = movie;
        this.name.setText("Name: " + movie.getName());
        this.duration.setText("Länge: " + movie.getDuration() + " Minuten");
        this.description.setText(movie.getDescription());
        this.description.setPadding(new Insets(2));
        this.descriptionT.setStyle("-fx-border-color: white; -fx-border-width: 0 0 1 0");
        this.movieImage.setImage(movie.getImage());
    }

    public void delete(ActionEvent event) {
        System.out.println("Deleted" + movie.toString());
        Main.getInstance().cinema.deleteMovie(this.movie);
    }
}
