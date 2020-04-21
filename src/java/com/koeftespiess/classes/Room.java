package com.koeftespiess.classes;

import javax.persistence.*;

@Entity
public class Room{

    @Id
    private int rows;
    private int cols;
    private String name;

    public Room(int rows, int cols, String name) {
        this.rows = rows;
        this.cols = cols;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Room{" +
                "rows=" + rows +
                ", cols=" + cols +
                ", name='" + name + '\'' +
                '}';
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
