package com.koeftespiess;

import com.koeftespiess.classes.Cinema;
import com.koeftespiess.classes.Movie;
import com.koeftespiess.classes.Room;
import com.koeftespiess.classes.Show;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

public class Main extends Application {

    private Cinema cinema = new Cinema();

    public Stage primaryStage;

    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Main.instance = this;
        this.primaryStage = primaryStage;

        primaryStage.setTitle("MainMenu");
        showMainMenu();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void saveMovie(Movie movie) {
        Configuration con = new Configuration().configure().addAnnotatedClass(Movie.class);

        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();

        SessionFactory sf = con.buildSessionFactory(reg);

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        session.save(movie);

        tx.commit();
    }
    public void saveShow(Show show) {
        Configuration con = new Configuration().configure().addAnnotatedClass(Show.class);

        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();

        SessionFactory sf = con.buildSessionFactory(reg);

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        session.save(show);

        tx.commit();
    }
    public void saveRoom(Room room) {
        Configuration con = new Configuration().configure().addAnnotatedClass(Room.class);

        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();

        SessionFactory sf = con.buildSessionFactory(reg);

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        session.save(room);

        tx.commit();
    }

    public void addMovie(String name, String description, int duration) {
        Movie movie = new Movie(name, description, duration);
        System.out.println(movie.toString());
        this.cinema.addMovie(movie);
        this.saveMovie(movie);
    }

    public void addRoom(String name, int rows, int cols) {
        Room room = new Room(rows, cols, name);
        System.out.println(room.toString());
        this.cinema.addRoom(room);
        this.saveRoom(room);
    }

    public void addShow(LocalDate date, Movie movie, Room room){
        Show show = new Show(UUID.randomUUID().toString(), date, movie, room);
        System.out.println(show.toString());
        this.cinema.addShow(show);
        this.saveShow(show);
    }

    public void showMainMenu() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainMenu/MainMenu.fxml"));
        this.primaryStage.setScene(new Scene(root));
        root.getStylesheets().add("com/koeftespiess/style.css");
    }

    public void showCreatePresentation() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("presentation/createPresentation.fxml"));
        this.primaryStage.setScene(new Scene(root));
        root.getStylesheets().add("com/koeftespiess/style.css");
    }

    public void showCreateRoom() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("createRoom/CreateRoom.fxml"));
        this.primaryStage.setScene(new Scene(root));
        root.getStylesheets().add("com/koeftespiess/style.css");
    }

    public void showCreateMovie() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("createMovie/CreateMovie.fxml"));
        this.primaryStage.setScene(new Scene(root));
        //root.getStylesheets().add("com/koeftespiess/style.css");
    }

    public void showRoom() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("showRoom/showRoom.fxml"));
        this.primaryStage.setScene(new Scene(root));
    }

    public ObservableList<Room> getRooms() {
        return cinema.getRooms();
    }
}