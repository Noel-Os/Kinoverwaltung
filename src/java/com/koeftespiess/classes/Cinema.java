package com.koeftespiess.classes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

    public void addSeat(ReservatedSeat seat){
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

    public void deleteShow() {
        //this.presentations.remove();
    }

    public void deleteRoom() {
        //        this.rooms.remove();
    }

    public void deleteMovie() {
        //       this.movies.remove();
    }

    public void deleteCustomer() {
        //       this.customers.remove();
    }

    public void deleteSeat() {
        //       this.seats.remove();
    }


}
