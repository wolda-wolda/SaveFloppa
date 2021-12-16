package Config.SaveGame;

import com.floppa.Entity.Player;
import com.floppa.Position.Pos;

import java.io.*;
import java.util.Properties;

public class SaveGame {
    public static void saveGame(Player player) {
        try (OutputStream output = new FileOutputStream("src/Config/SaveGame/SaveGame.properties")) {
            Properties prop = new Properties();

            // set the properties value
            prop.setProperty("level", String.valueOf(player.getCurrentLevel()));
            prop.setProperty("XP", String.valueOf(player.getCurXP()));
            prop.setProperty("hp", String.valueOf(player.getHp()));
            prop.setProperty("pos", player.getPos());

            // save properties to project root folder
            prop.store(output, null);

            System.out.println("Ihre Savegame Dateien befinden sich im Ordner: " + prop);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadGame(Player player1) {
        try (InputStream input = new FileInputStream("src/Config/SaveGame/SaveGame.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            player1.setCurrentLevel(Integer.parseInt(prop.getProperty("level")));
            player1.setHp(Integer.parseInt(prop.getProperty("hp")));
            player1.setCurXP(Integer.parseInt(prop.getProperty("XP")));
            player1.stringToKey(prop.getProperty("pos"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
