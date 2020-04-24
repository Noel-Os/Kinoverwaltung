package com.koeftespiess.createMovie;

import com.koeftespiess.Main;
import com.koeftespiess.classes.Movie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.stream.FileImageInputStream;
import java.io.*;
import java.util.List;

public class CreateMovieController {

    @FXML
    public Button cButton;
    public Label warningLabel;
    public ImageView imageView;

    @FXML
    private TextField movieName;

    @FXML
    private TextField movieDescription;

    @FXML
    private TextField movieLength;

    @FXML
    private ImageView movieImage;

    Movie movie = new Movie();

    public void informationProof() throws IOException {
        if (!movieName.getText().equals("")){
            if (!movieDescription.getText().equals("")){
                if (tryParse(movieLength.getText()) != null)
                    this.addMovie();
            }
        }
        warningLabel.setText("False or Missing Information");
        warningLabel.setTextFill(Paint.valueOf("red"));
    }

    public void addMovie() throws IOException {
        Movie movie = this.movie;
        movie.setName(movieName.getText());
        movie.setDescription(movieDescription.getText());
        movie.setDuration(Integer.parseInt(movieLength.getText()));
        Main.getInstance().addMovie(movie);
        this.back(new ActionEvent());
    }

    public void back(ActionEvent actionEvent) throws IOException {

        Main.getInstance().showMainMenu();

    }

    public static Integer tryParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public void openFileChooser(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Movie Picture");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png"));
        File selectedFile = fileChooser.showOpenDialog(null);

        Image image = new Image(selectedFile.toURI().toString());
        imageView.setImage(image);

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(selectedFile);
            this.movie.setImageBlob(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
