package com.floppa;

import com.floppa.Items.Item;

/**
 * Interface with various Interactions with various things
 */
public interface Interaction {
    /**
     * Open a Container and get the Items in it
     * @return
     */
    Item open();

    /**
     * Unlock something
     * @param key
     */
    void unlock(Item key);
}
