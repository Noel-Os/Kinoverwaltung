package com.koeftespiess.classes;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {

    @Id
    private String ID;
    private String name;
    //in Minuten
    private String description;
    private int duration;


    public Movie(String ID, String name, String description, int duration) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
