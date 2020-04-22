package com.koeftespiess.classes;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Room {

    @Id
    private int roomRows;
    private int roomCols;
    private String name;

    public Room(int rows, int cols, String name) {
        this.roomRows = rows;
        this.roomCols = cols;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Room{" +
                ", rows=" + roomRows +
                ", cols=" + roomCols +
                ", name='" + name + '\'' +
                '}';
    }

    public int getRoomRows() {
        return roomRows;
    }

    public void setRoomRows(int roomRows) {
        this.roomRows = roomRows;
    }

    public int getRoomCols() {
        return roomCols;
    }

    public void setRoomCols(int roomCols) {
        this.roomCols = roomCols;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
