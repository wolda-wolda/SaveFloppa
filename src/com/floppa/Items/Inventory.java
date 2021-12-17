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
        System.out.println("Item removed");
        return items.get(index);
    }

    public void switchItem(int sIndex, int tIndex) {
        var tmp = items.get(sIndex);
        items.set(sIndex, items.get(tIndex));
        items.set(sIndex, tmp);
        System.out.println("Item changed");
    }

    public boolean addItem(Item item){
        for (int i = 0; i < items.size(); i ++){
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
            if (Objects.equals(item, items.get(i).info.getName())) {
                return i;
            } else {
                System.out.println("Object not in your Inventory");
            }
        }
        return -1;
    }
}





