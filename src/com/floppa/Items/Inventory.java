package com.floppa.Items;

import java.util.ArrayList;

public class Inventory {

    ArrayList<Item> items = new ArrayList<>;

    public Inventory(int size) {
        for (int i = 0; i < size; i++) {
            items.add(null);
        }
     }

    public void setItems(int index, Item item) {
       items.set(index, item);
    }

    public void removeItem(int index){
        items.set(index,null);
        System.out.println("Item removed");
    }

    public void switchItem(int sIndex, int tIndex) {
        var tmp = items.get(sIndex);
        items.set(sIndex, items.get(tIndex));
        items.set(sIndex, tmp);
        System.out.println("Item changed");
    }

    public boolean addItem(Item item){
        for (int i = 0; i < items.size(); i ++){
            if (items.get(i) == null){
                setItems(i, item);
                return true;
            }
            else if (items.get(i).getInfo() == item.getInfo()){
                items.get(i).incrementCount();
                return true;
            }
        }
        return false;
    }


}





