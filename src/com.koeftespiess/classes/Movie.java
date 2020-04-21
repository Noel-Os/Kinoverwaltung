package com.koeftespiess.classes;

import org.hibernate.annotations.Entity;

@Entity
public class Movie extends Item {


    private String name;
    //in Minuten
    private int duration;
    private int fsk;
}
