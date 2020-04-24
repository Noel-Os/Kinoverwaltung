package com.koeftespiess.classes;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Presentation {

    @Id
    @GeneratedValue
    private int ID;
    private LocalDate displayDate;
    private LocalTime time;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Room room;


    public Presentation() {
    }


    public Presentation(LocalDate displayDate, Movie movie, Room room, LocalTime time) {
        this.displayDate = displayDate;
        this.movie = movie;
        this.room = room;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Presentation{" +
                "ID=" + ID +
                ", displayDate=" + displayDate +
                ", time=" + time +
                ", movie=" + movie +
                ", room=" + room +
                '}';
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
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
