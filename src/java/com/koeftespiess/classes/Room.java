package com.koeftespiess.classes;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Room {

    @Id
    private String ID;
    private int rows;
    private int cols;
    private String name;

    public Room(String ID, int rows, int cols, String name) {
        this.ID = ID;
        this.rows = rows;
        this.cols = cols;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Room{" +
                "ID='" + ID + '\'' +
                ", rows=" + rows +
                ", cols=" + cols +
                ", name='" + name + '\'' +
                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
