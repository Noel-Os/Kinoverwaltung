package com.koeftespiess.classes;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {

    @Id
    private String name;
    //in Minuten
    private String description;
    private int duration;


    public Movie(String name, String description, int duration) {
        this.name = name;
        this.description = description;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Movie{" +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                '}';
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
