package com.koeftespiess.classes;

public class Room extends Item {

    private int rows;
    private int cols;
    private String name;

    public Room(int rows, int cols, String name) {
        this.rows = rows;
        this.cols = cols;
        this.name = name;
    }
}
