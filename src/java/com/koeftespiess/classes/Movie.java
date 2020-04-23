package com.koeftespiess.classes;


import javafx.scene.image.Image;

import javax.persistence.*;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    //in Minuten
    private String description;
    private int duration;


    public Movie() {
    }

    public Movie(String name, String description, int duration) {
        this.name = name;
        this.description = description;
        this.duration = duration;
    }

    public Boolean isMe(int id){
        return this.id == id;
    }

    public Image getImage(){
        return new Image("../images/Darth-Vader-icon.png");
    }

    @Override
    public String toString() {
        return "Movie{" +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
