package com.floppa.Items;

import java.util.ArrayList;
import java.util.Objects;

public class Inventory {

    private ArrayList<Item> items = new ArrayList<>();

    public Inventory(int size) {
        for (int i = 0; i < size; i++) {
            items.add(null);
        }
    }

    public void setItems(int index, Item item) {
        items.set(index, item);
    }

    public Item removeItem(int index) {
        if (items.size() > 0) {
            var tmp = items.get(index);
            items.set(index, null);
            System.out.println("Item removed");
            return tmp;
        }
        return null;
    }

    public void switchItem(int sIndex, int tIndex) {
        var tmp = items.get(sIndex);
        items.set(sIndex, items.get(tIndex));
        items.set(sIndex, tmp);
        System.out.println("Item changed");
    }

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

    public int findItem(String item) {
        for (int i = 0; i < this.items.size(); i++) {
            var tmp = items.get(i);
            if (tmp != null) {
                if (Objects.equals(item, tmp.info.getName())) {
                    return i;
                } else {
                    System.out.println("Object not in your Inventory");
                }
            } else {
                System.out.println("Object not in your Inventory");
                break;
            }
        }
        return -1;
    }

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





