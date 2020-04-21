package com.koeftespiess.classes;

import java.util.UUID;

public class Item {
    private String Id;

    public Item() {
        Id = UUID.randomUUID().toString();
    }

    public String getId() {
        return Id;
    }
}
