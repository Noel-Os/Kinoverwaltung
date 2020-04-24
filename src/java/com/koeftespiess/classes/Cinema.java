package com.koeftespiess.classes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Cinema {
    ObservableList<Movie> movies;
    ObservableList<Presentation> presentations;
    ObservableList<Room> rooms;
    ObservableList<Customer> customers;
    ObservableList<ReservatedSeat> seats;

    public Cinema() {
        this.movies = FXCollections.observableArrayList();
        this.presentations = FXCollections.observableArrayList();
        this.rooms = FXCollections.observableArrayList();
        this.customers = FXCollections.observableArrayList();
        this.seats = FXCollections.observableArrayList();
    }

    public ObservableList<ReservatedSeat> getSeats() {
        return seats;
    }

    public void setSeats(ObservableList<ReservatedSeat> seats) {
        this.seats = seats;
    }

    public ObservableList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ObservableList<Customer> customers) {
        this.customers = customers;
    }

    public ObservableList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ObservableList<Movie> movies) {
        this.movies = movies;
    }

    public ObservableList<Presentation> getPresentations() {
        return presentations;
    }

    public void setPresentations(ObservableList<Presentation> presentations) {
        this.presentations = presentations;
    }

    public ObservableList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ObservableList<Room> rooms) {
        this.rooms = rooms;
    }

    public ObservableList<String> getMovieNames() {
        ObservableList<String> movieNames = FXCollections.observableArrayList();
        for (Movie movie : this.movies) {
            movieNames.add(movie.getName());
        }
        return movieNames;
    }

    public ObservableList<String> getRoomNames() {
        ObservableList<String> roomNames = FXCollections.observableArrayList();
        for (Room room : this.rooms) {
            roomNames.add(room.getName());
        }
        return roomNames;
    }

    public void addSeat(ReservatedSeat seat) {
        this.seats.add(seat);
    }

    public void addMovie(Movie movie) {
        this.movies.add(movie);
    }

    public void addShow(Presentation presentation) {
        this.presentations.add(presentation);
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public void deletePresentations(ArrayList<Presentation> presentations) {
        ArrayList<ReservatedSeat> sToRemove = new ArrayList<>();
        for (Presentation presentation : presentations) {
            for (ReservatedSeat seat : getSeats()) {
                if (seat.getPresentation().getID() == presentation.getID()) {
                    sToRemove.add(seat);
                }
            }
        }
        deleteSeats(sToRemove);
        this.presentations.removeAll(presentations);
    }

    public void deleteRoom(Room room) {
        ArrayList<Presentation> pToRemove = new ArrayList<>();
        for (Presentation presentation:this.getPresentations()){
        if (presentation.getRoom() == room){
            pToRemove.add(presentation);
        }
    }
        this.deletePresentations(pToRemove);
        this.rooms.remove(room);
}

    public void deleteMovie(Movie movie) {
        ArrayList<Presentation> pToRemove = new ArrayList<>();
        for (Presentation presentation:this.getPresentations()){
            if (presentation.getMovie() == movie){
                pToRemove.add(presentation);
            }
        }
        this.deletePresentations(pToRemove);
        this.movies.remove(movie);
    }

    public void deleteCustomer(Customer customer) {
        this.customers.remove(customer);
    }

    public void deleteSeats(ArrayList<ReservatedSeat> seat) {
        this.seats.removeAll(seat);
    }

}
