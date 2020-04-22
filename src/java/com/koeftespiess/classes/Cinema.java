package com.koeftespiess.classes;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class Cinema {
    ObservableList<Movie> movies;
    ObservableList<Show> shows;
    ObservableList<Room> rooms;

    public ObservableList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ObservableList<Movie> movies) {
        this.movies = movies;
    }

    public ObservableList<Show> getShows() {
        return shows;
    }

    public void setShows(ObservableList<Show> shows) {
        this.shows = shows;
    }

    public ObservableList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ObservableList<Room> rooms) {
        this.rooms = rooms;
    }

    public Cinema() {
        this.movies = FXCollections.observableArrayList();
        this.shows = FXCollections.observableArrayList();
        this.rooms = FXCollections.observableArrayList();
    }

    public void addMovie(Movie movie) {
        this.movies.add(movie);
    }

    public void addShow(Show show) {
        this.shows.add(show);
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public void deleteShow() {
        //this.shows.remove();
    }

    public void deleteRoom() {
        //        this.rooms.remove();
    }

    public void deleteMovie() {
        //      this.movies.remove();
    }


}
