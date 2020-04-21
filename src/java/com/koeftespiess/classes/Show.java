package com.koeftespiess.classes;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Show {

    @Id
    private Date displayDate;
    @OneToOne
    private Movie movie;
    @OneToOne
    private Room room;

    public Show(Date displayDate, Movie movie, Room room) {
        this.displayDate = displayDate;
        this.movie = movie;
        this.room = room;
    }

    @Override
    public String toString() {
        return "Show{" +
                "displayDate=" + displayDate +
                ", movie=" + movie +
                ", room=" + room +
                '}';
    }

    public Date getDisplayDate() {
        return displayDate;
    }

    public void setDisplayDate(Date displayDate) {
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
}
