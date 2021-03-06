/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savethecity.model;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import savethecity.SaveTheCity;
import savethecity.exceptions.RiddleControlException;

/**
 *
 * @author willnelson
 */
public class Tiles implements Serializable {
    
    protected final BufferedReader keyboard = SaveTheCity.getInFile();
    protected final PrintWriter console = SaveTheCity.getOutFile();

    private boolean visited;
    private Scene scene;
    private String riddle;
    private double answer;
    private ArrayList<Character> characters;
    private int column;
    private int row;

    public void setScene(Scene s) {
        scene = s;
    }

    public Scene getScene() {
        return scene;
    }

    public double getAnswer(){
        return answer;
    }
    
    public void getRiddle()
            throws RiddleControlException {
        if (riddle == null) {
            return;
        }
        throw new RiddleControlException(riddle);
    }

    private static Scene[] createScenes() {
        Game game = SaveTheCity.getCurrentGame();

        Scene[] scenes = new Scene[SceneType.values().length];

        Scene startingScene = new Scene();
        startingScene.setDescription(
                "\nWelcome.  Your city is being attacked by Villains."
                + "If you are going to save your city, you will need the"
                + "help of Heroes.  Better go and find some...good luck.");
        startingScene.setMapSymbol(" START ");
        startingScene.setBlocked(false);
        scenes[SceneType.start.ordinal()] = startingScene;

        Scene finishScene = new Scene();
        finishScene.setDescription(
                "\nCongratulations!  You have saved the city!");
        finishScene.setMapSymbol(" END ");
        finishScene.setBlocked(false);
        scenes[SceneType.finish.ordinal()] = finishScene;
        return null;
    }

    public void displayTile() {
        //TODO: Print the contents of the tile
        if (visited) {
            this.console.print(" TT "); // <== HERE!!!
        } else {
            this.console.print(" ?? ");
        }
    }

    public void setRiddle(String tRiddle, double tAnswer) {
        riddle = tRiddle;
        answer = tAnswer;
    }

    public enum SceneType {
        start,
        Batman,
        Superman,
        IronMan,
        CaptainAmerica,
        WonderWoman,
        Librarian,
        Baker,
        Tailors,
        Cobbler,
        Blacksmith,
        TaxCollector,
        Mystique,
        DoctorOctopus,
        MisterFreeze,
        GreenGoblin,
        Loki,
        DemonHead,
        empty,
        finish
    }

    //class instance variables
    private String heroName;
    private String villainName;
    private String itemTile;
    private String emptyTile;
    private String rescueTile;

    private Hero hero;
    private Villain villain;
    private Captive captive;

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setVillain(Villain villain) {
        this.villain = villain;
    }

    public void setCaptive(Captive captive) {
        this.captive = captive;
    }

    public Hero getHero() {
        return hero;
    }

    public Villain getVillain() {
        return villain;
    }

    public Captive getCaptive() {
        return captive;
    }

    public Tiles() {
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getVillainName() {
        return villainName;
    }

    public void setVillainName(String villainName) {
        this.villainName = villainName;
    }

    public String getItemTile() {
        return itemTile;
    }

    public void setItemTile(String itemTile) {
        this.itemTile = itemTile;
    }

    public String getEmptyTile() {
        return emptyTile;
    }

    public void setEmptyTile(String emptyTile) {
        this.emptyTile = emptyTile;
    }

    public String getRescueTile() {
        return rescueTile;
    }

    public void setRescueTile(String rescueTile) {
        this.rescueTile = rescueTile;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.heroName);
        hash = 71 * hash + Objects.hashCode(this.villainName);
        hash = 71 * hash + Objects.hashCode(this.itemTile);
        hash = 71 * hash + Objects.hashCode(this.emptyTile);
        hash = 71 * hash + Objects.hashCode(this.rescueTile);
        return hash;
    }

    @Override
    public String toString() {
        return "Tiles{" + "heroName=" + heroName + ", villainName=" + villainName + ", itemTile=" + itemTile + ", emptyTile=" + emptyTile + ", rescueTile=" + rescueTile + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tiles other = (Tiles) obj;
        if (!Objects.equals(this.heroName, other.heroName)) {
            return false;
        }
        if (!Objects.equals(this.villainName, other.villainName)) {
            return false;
        }
        if (!Objects.equals(this.itemTile, other.itemTile)) {
            return false;
        }
        if (!Objects.equals(this.emptyTile, other.emptyTile)) {
            return false;
        }
        if (!Objects.equals(this.rescueTile, other.rescueTile)) {
            return false;
        }
        return true;
    }

    void setColumn(int column) {
        this.column = column;
    }

    void setRow(int row) {
        this.row = row;
    }

    void setVisited(boolean b) {
        this.visited = visited;
    }

}
