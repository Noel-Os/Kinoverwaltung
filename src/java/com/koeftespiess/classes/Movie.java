package com.koeftespiess.classes;


import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import javax.persistence.*;
import java.awt.image.BufferedImage;
import java.io.*;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    //in Minuten
    private String description;
    private int duration;
    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] imageBlob = null;

    public Movie() {
    }

    public Movie(String name, String description, int duration){
        this.name = name;
        this.description = description;
        this.duration = duration;
    }

    public Image getImage(){
        return new Image(new ByteArrayInputStream(this.imageBlob),250,150,true,true);
    }

    public Boolean isMe(int id){
        return this.id == id;
    }

    @Override
    public String toString() {
        return "Movie{" +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                '}';
    }

    public void setImageBlob(byte[] image) {
        this.imageBlob = image;
    }

    public void setImageBlob(InputStream is) {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead = 0;
        byte[] data = new byte[16384];
        while (true) {
            try {
                if (!((nRead = is.read(data, 0, data.length)) != -1)) break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
            buffer.write(data, 0, nRead);
        }
        this.imageBlob = data;
    }

    public Image getImageBlob(){
        return new Image("images/Darth-Vader-icon.png");
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
