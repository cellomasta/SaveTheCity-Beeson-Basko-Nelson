/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savethecity;

import savethecity.model.Character;
import savethecity.model.Item;
import savethecity.model.Players;

/**
 *
 * @author CHRIS
 */
public class SaveTheCity {

    public static void main(String[] args) {
        
        Character characterOne = new Character();
        Item itemOne = new Item();
        Players playerOne = new Players();
        
        characterOne.setName("Fred Flinstone");
        characterOne.setAttackPower(10);
        characterOne.setHitPoints(100);
        String characterInfo = characterOne.toString();
        System.out.println(characterInfo);
        
        itemOne.setItemPoints(5);
        String itemInfo = itemOne.toString();
        System.out.println(itemInfo);
        
        playerOne.setRank(1);
        playerOne.setHighScore(5000);
        String playersInfo = playerOne.toString();
        System.out.println(playersInfo);
      
    }
    
}
