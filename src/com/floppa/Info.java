package com.floppa;

public class Info {
    private String name;
    private String description;

    public Info(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public void printInfo() {
        System.out.println("Name: " + this.name + " Beschreibung: " + this.description);
    }

    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }
}
