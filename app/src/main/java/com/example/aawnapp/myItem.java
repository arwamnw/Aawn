package com.example.aawnapp;

public class myItem {
    private int id;
    private String name;
    private String image;
    private String audio;
    private String album_name;

    public myItem(int id, String name, String image, String audio, String album_name) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.audio = audio;
        this.album_name = album_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
