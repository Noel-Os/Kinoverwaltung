package com.koeftespiess.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int roomRows;
    private int roomCols;
    private String name;

    public Room() {
    }

    public Room(int rows, int cols, String name) {
        this.roomRows = rows;
        this.roomCols = cols;
        this.name = name;
    }

    public Boolean isMe(int id){
        return this.id == (id);
    }

    @Override
    public String toString() {
        return "Room{" +
                ", rows=" + roomRows +
                ", cols=" + roomCols +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
