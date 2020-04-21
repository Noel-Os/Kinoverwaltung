package com.koeftespiess.classes;

import java.util.List;

public class Cinema {
    List<Movie> movies;
    List<Show> shows;
    List<Room> rooms;

    public void addMovie(Movie movie){
        this.movies.add(movie);
    }
    public void addShow(Show show){
        this.shows.add(show);
    }
    public void addRoom(Room room){
        this.rooms.add(room);
    }
}
