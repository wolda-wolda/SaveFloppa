package com.floppa;

/***
 * Class for adding Info to any Object or Entity
 */
public class Info {
    private String name;
    private String description;

    /**
     * Sets the Name and Description
     * @param name
     * @param description
     */
    public Info(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /***
     * Prints Name and Description
     */
    public void printInfo() {
        System.out.println("Name: " + this.name + " Description: " + this.description);
    }

    /**
     * Returns the Name
     * @return
     */
    public String getName() {
        return this.name;
    }

    /***
     * Returns the Description
     * @return
     */
    public String getDescription() {
        return this.description;
    }
}
