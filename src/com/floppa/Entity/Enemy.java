package com.floppa.Entity;

import com.floppa.Info;
import com.floppa.Room.Room;

import static com.floppa.Menu.Menu.Menu;

public class Enemy extends Entity {

    /**
     * Sets the Info
     *
     * @param info
     */
    public Enemy(Info info, int level) {
        super(info);
        this.setCurrentLevel(level);
    }

    public void attackPlayer(Player player, Room currentRoom) {
        while (player.getHp() > 0 && currentRoom.getEnemies().size() > 0) {
            player.setHp(player.getHp() - (19 - (player.getCurrentLevel() - this.getCurrentLevel())));
            currentRoom.getEnemies().remove(0);
            System.out.println("You have " + player.getHp() + " HP left and still " + currentRoom.getEnemies().size() + " Enemies to defeat");
        }
        if (player.getHp() <= 0) {
            System.out.println("You died! Game over");
            System.exit(0);
        }
        System.out.println("You defeated all the Enemies? Remember use the heal command to gain HP");
    }
}
