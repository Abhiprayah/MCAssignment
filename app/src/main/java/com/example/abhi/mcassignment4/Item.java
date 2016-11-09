package com.example.abhi.mcassignment4;

import java.io.Serializable;

/**
 * Created by Abhi on 01-11-2016.
 */

class Item implements Serializable{
    private String title;
    private String details;

    public Item(String details, String title) {
        this.details = details;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
