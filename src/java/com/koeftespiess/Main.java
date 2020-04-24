package com.koeftespiess;

import com.koeftespiess.classes.*;
import com.koeftespiess.createReservation.showRoomController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    public Cinema cinema;

    public Stage primaryStage;

    private static Main instance;
    private Session session;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Main.instance = this;
        this.cinema = load();
        this.deleteOldPresentations();

        this.primaryStage = primaryStage;

        primaryStage.setTitle("MainMenu");
        showMainMenu();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void deleteOldPresentations(){
        ArrayList<Presentation> pToRemove = new ArrayList<>();
        for (Presentation presentation: this.cinema.getPresentations()) {
            if (presentation.getDisplayDate().compareTo(LocalDate.now()) < 0){
                pToRemove.add(presentation);
            }
        }
        this.cinema.deletePresentations(pToRemove);
    }

    public Cinema load() {
        ObservableList<Movie> movies = FXCollections.observableArrayList(loadAllMovies());
        ObservableList<Room> rooms = FXCollections.observableArrayList(loadAllRooms());
        ObservableList<Presentation> presentations = FXCollections.observableArrayList(loadAllPresentation());
        ObservableList<Customer> customers = FXCollections.observableArrayList(loadAllCustomers());
        ObservableList<ReservatedSeat> seats = FXCollections.observableArrayList(loadAllReservatedSeats());

        //Temporary cinema object
        Cinema tCinema = new Cinema();
        tCinema.setMovies(movies);
        tCinema.setRooms(rooms);
        tCinema.setPresentations(presentations);
        tCinema.setCustomers(customers);
        tCinema.setSeats(seats);

        return tCinema;
    }

    public List<Movie> loadAllMovies() {
        return this.getSession().createQuery("FROM Movie").list();
    }

    public List<Room> loadAllRooms() {
        return this.getSession().createQuery("FROM Room").list();
    }

    public List<Presentation> loadAllPresentation() {
        return this.getSession().createQuery("FROM Presentation").list();
    }

    public List<Customer> loadAllCustomers() {
        return this.getSession().createQuery("FROM Customer ").list();
    }

    public List<ReservatedSeat> loadAllReservatedSeats() {
        return this.getSession().createQuery("FROM ReservatedSeat ").list();
    }

    public List<Integer> getReservatedSeats(Presentation presentation) {
        List<Integer> reservatedSeats = new ArrayList<Integer>();
        int presentationID = presentation.getID();
        for (ReservatedSeat seat : this.cinema.getSeats()) {
            if (seat.getPresentation().getID() == presentationID) {
                reservatedSeats.add(seat.getSeatNumber());
            }
        }

        return reservatedSeats;
    }

    public Boolean isSeatReserved(Presentation presentation, int seat) {
        List<Integer> seats = this.getReservatedSeats(presentation);

        for (int item : seats) {
            if (seat == item) {
                return true;
            }
        }
        return false;
    }

    public Session getSession() {
        if (this.session != null) return this.session;

        Configuration con = new Configuration().configure();
        con.addAnnotatedClass(Movie.class);
        con.addAnnotatedClass(Room.class);
        con.addAnnotatedClass(Presentation.class);
        con.addAnnotatedClass(Customer.class);
        con.addAnnotatedClass(ReservatedSeat.class);

        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();

        SessionFactory sf = con.buildSessionFactory(sr);

        this.session = sf.openSession();
        return this.session;
    }

    public void saveMovie(Movie movie) {
        Transaction tx = getSession().beginTransaction();
        getSession().save(movie);
        tx.commit();
    }

    public void saveShow(Presentation presentation) {
        Transaction tx = getSession().beginTransaction();
        getSession().save(presentation);
        tx.commit();
    }

    public void saveRoom(Room room) {
        Transaction tx = getSession().beginTransaction();
        getSession().save(room);
        tx.commit();
    }

    public void saveCustomer(Customer customer) {
        Transaction tx = getSession().beginTransaction();
        getSession().save(customer);
        tx.commit();
    }

    private void saveSeat(ReservatedSeat seat) {
        Transaction tx = getSession().beginTransaction();
        getSession().save(seat);
        tx.commit();
    }

    public void addMovie(Movie movie) {
        System.out.println(movie.toString());
        this.cinema.addMovie(movie);
        this.saveMovie(movie);
    }

    public void addRoom(Room room) {
        System.out.println(room.toString());
        this.cinema.addRoom(room);
        this.saveRoom(room);
    }

    public void addShow(Presentation presentation) {
        System.out.println(presentation.toString());
        this.cinema.addShow(presentation);
        this.saveShow(presentation);
    }

    public void addCustomer(Customer customer) {
        System.out.println(customer.toString());
        this.cinema.addCustomer(customer);
        this.saveCustomer(customer);
    }

    public void addSeat(ReservatedSeat seat) {
        System.out.println(seat.toString());
        this.cinema.addSeat(seat);
        this.saveSeat(seat);
    }

    public void showMainMenu() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainMenu/MainMenu.fxml"));
        this.primaryStage.setScene(new Scene(root));
        root.getStylesheets().add("css/style.css");
    }

    public void showCreatePresentation() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("presentation/createPresentation.fxml"));
        this.primaryStage.setScene(new Scene(root));
        root.getStylesheets().add("css/style.css");
    }

    public void showCreateRoom() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("createRoom/CreateRoom.fxml"));
        this.primaryStage.setScene(new Scene(root));
        root.getStylesheets().add("css/style.css");
    }

    public void showCreateMovie() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("createMovie/CreateMovie.fxml"));
        this.primaryStage.setScene(new Scene(root));
        root.getStylesheets().add("css/style.css");
    }

    public void showCreateReservation() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("createReservation/CreateReservation.fxml"));
        this.primaryStage.setScene(new Scene(root));
        root.getStylesheets().add("css/style.css");
    }

    public void showShowRoom(Customer customer, Presentation presentation) throws IOException {
        Parent root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("createReservation/showRoom.fxml"));
        root = loader.load();
        root.getStylesheets().add("css/style.css");
        ((showRoomController) loader.getController()).setInformation(customer, presentation);
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 1920, 1080));
        stage.show();
    }
}