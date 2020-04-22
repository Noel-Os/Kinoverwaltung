package com.koeftespiess.mainMenu;

import com.koeftespiess.Main;
import javafx.event.ActionEvent;

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
}
