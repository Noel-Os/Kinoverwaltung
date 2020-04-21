package com.koeftespiess.classes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Show {

    @Id
    private String ID;
    private Date displayDate;
    @OneToOne
    private Movie movie;
    @OneToOne
    private Room room;

    public Show(String ID, Date displayDate, Movie movie, Room room) {
        this.ID = ID;
        this.displayDate = displayDate;
        this.movie = movie;
        this.room = room;
    }

    @Override
    public String toString() {
        return "Show{" +
                "ID='" + ID + '\'' +
                ", displayDate=" + displayDate +
                ", movie=" + movie +
                ", room=" + room +
                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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
