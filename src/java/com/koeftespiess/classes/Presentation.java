package com.koeftespiess.classes;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Presentation {

    @Id
    @GeneratedValue
    private int ID;
    private LocalDate displayDate;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Room room;


    public Presentation() {
    }


    public Presentation(LocalDate displayDate, Movie movie, Room room) {
        this.displayDate = displayDate;
        this.movie = movie;
        this.room = room;
    }

    @Override
    public String toString() {
        return "Presentation{" +
                "ID='" + ID + '\'' +
                ", displayDate=" + displayDate +
                ", movie=" + movie +
                ", room=" + room +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public LocalDate getDisplayDate() {
        return displayDate;
    }

    public void setDisplayDate(LocalDate displayDate) {
        this.displayDate = displayDate;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public boolean isMe(int id){
        return id == this.ID ;
    }
}
