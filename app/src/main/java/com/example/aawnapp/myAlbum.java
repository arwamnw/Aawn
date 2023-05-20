package com.example.aawnapp;

public class myAlbum {
    private int id;
    private String name;
    private String image;
    private int child_id;
    public myAlbum(int id, String name, String image,int child_id) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.child_id=child_id;
    }

    public int getChild_id() {
        return child_id;
    }

    public void setChild_id(int child_id) {
        this.child_id = child_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
}
