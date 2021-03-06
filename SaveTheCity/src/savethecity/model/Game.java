/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savethecity.model;

import java.io.Serializable;

/**
 *
 * @author Alicia
 */
public class Game implements Serializable {
    private double totalTime;
    private double noPeople;
    //0 to 1 relationship
    private Map map;
    private Players player;
    //1 to many relationship
    private InventoryItem[] item;
    private Character[] character;

    public void setInventory(InventoryItem[] item) {
        this.item = item;
    }

    public void setCharacter(Character[] character) {
        this.character = character;
    }

    public InventoryItem[] getInventory() {
        return item;
    }

    public Character[] getCharacter() {
        return character;
    }
    

    public Map getMap() {
        return map;
    }

    public Players getPlayer() {
        return player;
    }
    

    public void setMap(Map map) {
        this.map = map;
    }

    public void setPlayer(Players player) {
        this.player = player;
    }
    

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public double getNoPeople() {
        return noPeople;
    }

    public void setNoPeople(double noPeople) {
        this.noPeople = noPeople;
    }

    public Game() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.totalTime) ^ (Double.doubleToLongBits(this.totalTime) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.noPeople) ^ (Double.doubleToLongBits(this.noPeople) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (Double.doubleToLongBits(this.totalTime) != Double.doubleToLongBits(other.totalTime)) {
            return false;
        }
        if (Double.doubleToLongBits(this.noPeople) != Double.doubleToLongBits(other.noPeople)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "totalTime=" + totalTime + ", noPeople=" + noPeople + '}';
    }
}