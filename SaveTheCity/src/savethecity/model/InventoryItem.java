/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savethecity.model;

import java.io.Serializable;

/**
 *
 * @author willnelson
 */
public class InventoryItem implements Serializable {
    public String description;
    public double quantityHeld;

    //Need to find alternate method.
    private void setDescription(String batarang) {
        System.out.println("batarang descripiton.");
    }

        
    
    
    public enum Item {
        batarang,
        lightning,
        sword,
        paperclip;
    }
    
    public static InventoryItem[] createInventoryList(){
        InventoryItem[] inventory = new InventoryItem[4];
        
        InventoryItem batarang = new InventoryItem();
        batarang.setDescription("Batarang");
        batarang.setQuantityHeld(0);
        inventory[Item.batarang.ordinal()] = batarang;
        
        InventoryItem lightning = new InventoryItem();
        lightning.setDescription("Lightning");
        lightning.setQuantityHeld(0);
        inventory[Item.lightning.ordinal()] = lightning;
        
        InventoryItem sword = new InventoryItem();
        sword.setDescription("Sword");
        sword.setQuantityHeld(0);
        inventory[Item.sword.ordinal()] = sword;
        
        InventoryItem paperclip = new InventoryItem();
        paperclip.setDescription("Paperclip");
        paperclip.setQuantityHeld(0);
        inventory[Item.paperclip.ordinal()] = paperclip;
        
        return inventory;
    }
    
     public void setQuantityHeld(double quantityHeld) {
        this.quantityHeld = quantityHeld;
    }

    public String getDescription() {
        return description;
    }

    public double getQuantityHeld() {
        return quantityHeld;
    }
    
}