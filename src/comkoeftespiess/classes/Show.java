package com.koeftespiess.classes;

import java.util.Date;

public class Show extends Item {

    private Date displayDate;
    private Movie movie;
    private Room room;

    public Show(Date displayDate, Movie movie, Room room) {
        this.displayDate = displayDate;
        this.movie = movie;
        this.room = room;
    }
}
