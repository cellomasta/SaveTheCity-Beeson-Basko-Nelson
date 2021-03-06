/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savetheciy.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import savethecity.SaveTheCity;
import savethecity.exceptions.RiddleControlException;
import savethecity.model.Tiles;

/**
 * This class displays to the user when they land on a SuperheroTile, which will
 * initiate a Riddle that must be solved to unlock a superhero.
 *
 * @author willnelson
 */
public class SuperheroTileView extends View {

    protected final BufferedReader keyboard = SaveTheCity.getInFile();
    protected final PrintWriter console = SaveTheCity.getOutFile();

    public SuperheroTileView(String promptMessage) {
        super("\n"
                + "\n------------------------------"
                + "\nYou have just stumbled upon a"
                + "\nsuperhero. They are willing to"
                + "\nhelp you on your quest, if you"
                + "\ncan answer the question below:"
                + "\n------------------------------");
    }

    //Call the riddleController to load a riddle.
    public void getRiddle(Tiles[][] locations) {

        //String locations.setRiddle();
        this.console.println("I need to ask a question here, and get your input.");

    }

    @Override
    public boolean doAction(Object obj) {
        boolean valid = false; //indicates if the input has been retrieved
        String userInput = null;
        try {
            userInput = this.keyboard.readLine();
        } catch (IOException ex) {
            Logger.getLogger(SuperheroTileView.class.getName()).log(Level.SEVERE, null, ex);
        }

        Tiles t = SaveTheCity.getCurrentGame().getMap().getCurrentLocation();
        try {
            t.getRiddle();
        } catch (RiddleControlException re) {
            this.console.println(re.getMessage());
            double dobInput = -1;
            try {
                dobInput = Double.parseDouble(keyboard.readLine());
            } catch (IOException ex) {
                Logger.getLogger(SuperheroTileView.class.getName()).log(Level.SEVERE, null, ex);
            }
            double riddleAnswer = t.getAnswer();
            return (dobInput == riddleAnswer);
        }

        return true;

    }

}
