package com.koeftespiess.createMovie;

import com.koeftespiess.Main;
import com.koeftespiess.classes.Movie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class CreateMovieController {

    @FXML
    private TextField movieName;

    @FXML
    private TextField movieDescription;

    @FXML
    private TextField movieLength;

    @FXML
    private ImageView movieImage;

    public void addMovie() throws IOException {

        Movie movie = new Movie();
        movie.setName(movieName.getText());
        movie.setDescription(movieDescription.getText());
        movie.setDuration(Integer.parseInt(movieLength.getText()));
        Main.getInstance().addMovie(movie);
        this.back(new ActionEvent());
    }

    @FXML
    public void handleDragOver(DragEvent event) {

        if (event.getDragboard().hasFiles()) {
            event.acceptTransferModes(TransferMode.ANY);
        }
    }

    @FXML
    public void handleDrop(DragEvent event) throws FileNotFoundException {
        List<File> files = event.getDragboard().getFiles();
        Image img = new Image(new FileInputStream(files.get(0)));
        movieImage.setImage(img);
    }

    public void back(ActionEvent actionEvent) throws IOException {

        Main.getInstance().showMainMenu();

    }

}
