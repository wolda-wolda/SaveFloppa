package com.floppa;

import com.floppa.Items.Item;

public interface Interaction {
    Item open();

    void unlock(Item key);
}
