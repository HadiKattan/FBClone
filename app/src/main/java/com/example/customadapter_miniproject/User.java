package com.example.customadapter_miniproject;
import android.net.Uri;

public class User {
    private String text,name;
    private Uri image;

    public User(String name,Uri image) {
        this.image = image;
        this.name = name;
    }

    public User(String name,String text) {
        this.text = text;
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Uri getImage() {
        return image;
    }

    public void setImage(Uri image) {
        this.image = image;
    }
}
