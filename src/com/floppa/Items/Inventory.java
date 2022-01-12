package com.floppa.Items;

import java.util.ArrayList;
import java.util.Objects;

/***
 * Class for creating an Inventory for any Object or Entity
 */
public class Inventory {

    private ArrayList<Item> items = new ArrayList<>();

    /**
     * Adds a given Amount of Slots to the Inventory
     * Sets the Inventory Slots to null, indicating that they are empty
     * @param size
     */
    public Inventory(int size) {
        for (int i = 0; i < size; i++) {
            items.add(null);
        }
    }

    /**
     * Sets an Item at a given Index
     * @param index
     * @param item
     */
    public void setItems(int index, Item item) {
        items.set(index, item);
    }

    /**
     * Removes an Item at a given Index
     * @param index
     * @return
     */
    public Item removeItem(int index) {
        if (items.size() > 0) {
            var tmp = items.get(index);
            items.set(index, null);
            System.out.println("Item removed");
            return tmp;
        }
        return null;
    }

    /**
     * Switches an Item at a given Index with an Item at another given Index
     * @param sIndex
     * @param tIndex
     */
    public void switchItem(int sIndex, int tIndex) {
        var tmp = items.get(sIndex);
        items.set(sIndex, items.get(tIndex));
        items.set(sIndex, tmp);
        System.out.println("Item changed");
    }

    /***
     * Adds a given Item in the first found free Inventory Slot
     * If the given Item is equal to the Item that has been found, it's Amount
     * is simply added to the found Item's Amount
     * @param item
     * @return
     */
    public boolean addItem(Item item) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) == null) {
                setItems(i, item);
                return true;
            } else if (Objects.equals(items.get(i).getInfo(), item.getInfo())) {
                items.get(i).incrementCount();
                return true;
            }
        }
        return false;
    }

    /***
     * Return the Index of the First Occurrence of an Item
     * Searches by Item Name
     * @param item
     * @return
     */
    public int findItem(String item) {
        for (int i = 0; i < this.items.size(); i++) {
            var tmp = items.get(i);
            if (tmp != null) {
                if (Objects.equals(item, tmp.info.getName())) {
                    return i;
                }
            }
        }
        System.out.println("Object not in your Inventory");
        return -1;
    }

    /***
     * Prints the Contents of the Inventory
     */
    public void print() {
        int count = 0;
        for (Item x : items) {
            if(x != null) {
                count++;
                System.out.println(count + ": " + x);
            }
        }
    }
}





