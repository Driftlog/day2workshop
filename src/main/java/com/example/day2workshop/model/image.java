package com.example.day2workshop.model;

//to populate image data, plain java class
//entity is image
//POJO = plain old java object
public class image {
    
    private String name;
    private String path;

    public image() {

    }    

    public image(String name, String path) {
        this.name = name;
        this.path = path;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    
    @Override
    public String toString() {
        return "image [name=" + name + ", path=" + path + "]";
    }

    
}
