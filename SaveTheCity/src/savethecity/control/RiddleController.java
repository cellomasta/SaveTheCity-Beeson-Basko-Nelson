/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savethecity.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import savethecity.SaveTheCity;
import savethecity.exceptions.RiddleControlException;
import savethecity.model.Map;
import savethecity.model.Tiles;

/**
 *
 * @author Alicia
 */
public class RiddleController {
    //Randomly select from available functions
    //int which = (int)(Math.random() * 1);
    //switch(which){

    protected final BufferedReader keyboard = SaveTheCity.getInFile();
    protected final PrintWriter console = SaveTheCity.getOutFile();

    //Calculate Volume of User
    final int AVG_DENSITY = 1;
    final int GRAMS_PER_POUND = 453;
    final int CC_PER_CUBIC_FOOT = 283168;

    /*Volume of Container*/
    final double INCH_TO_GALLON = 0.004329;

    public String userVolume() throws RiddleControlException, IOException {
        boolean valid = false; //indicates if the input has been retrieved
        String userInput = null;
        userInput = this.keyboard.readLine();

        int userWeightInPounds;
             userWeightInPounds = Integer.parseInt(keyboard.readLine());
        if (userWeightInPounds >= 0) {
            int userMass = userWeightInPounds * GRAMS_PER_POUND;
            int userVolumeLong = (userMass * AVG_DENSITY) / CC_PER_CUBIC_FOOT;
            DecimalFormat df = new DecimalFormat("#.00");
            String userVolumeString = df.format(userVolumeLong); //Math rounding to two decimal places.
            //int userVolume = Integer.parseInt(userVolumeString);
            //return userVolume;
            return userVolumeString;
        } else {
            throw new RiddleControlException("Volume must be a number greater than zero.");
        }
    }

    public String containerVolume() throws RiddleControlException, IOException {
        boolean valid = false; //indicates if the input has been retrieved
        String userInput = null;
        userInput = this.keyboard.readLine();

        int containerLength;
                containerLength = Integer.parseInt(keyboard.readLine());
        int containerWidth;
         containerWidth = Integer.parseInt(keyboard.readLine());
        int containerHeight;
        containerHeight = Integer.parseInt(keyboard.readLine());
        int volumeOfBox = containerLength * containerWidth * containerHeight;
        if (volumeOfBox > 0) {
            double gallonCapacityLong = volumeOfBox * INCH_TO_GALLON;
            DecimalFormat df = new DecimalFormat("#.00");
            String gallonCapacityString = df.format(gallonCapacityLong); //rounding to two decimal places.
            //double gallonCapacity = Double.parseDouble(gallonCapacityString);
            //return gallonCapacity;
            return gallonCapacityString;
        } else {
            throw new RiddleControlException("Volume must be a number greater than zero.");
        }
    }

    public String EQSolver() throws IOException {
        boolean valid = false; //indicates if the input has been retrieved
        String userInput = null;
        userInput = this.keyboard.readLine();

        int multiplier;
        multiplier = Integer.parseInt(keyboard.readLine());
        int EQ = multiplier * 7 + 6;
        String EQout = Integer.toString(EQ);

        return EQout;
    }

    public String AnswerSolver() throws IOException {
        boolean valid = false; //indicates if the input has been retrieved
        String userInput = null;
        userInput = this.keyboard.readLine();

        int input;
        input = Integer.parseInt(keyboard.readLine());
        int ans = 8 * 7 + 34;
        String out = Integer.toString(ans);

        return out;
    }

    //Assign questions to locations.
    public void assignQuestionsToLocations(Map map) throws RiddleControlException, IOException {
        Tiles[][] locations = map.getLocations();

        locations[1][2].setRiddle(userVolume(), 223);
        locations[2][6].setRiddle(containerVolume(), 234);
        locations[5][0].setRiddle(EQSolver(), 48);
        locations[6][0].setRiddle(AnswerSolver(), 90);
        //locations[6][6].setRiddle();

        map.setLocations(locations);

    }
}
