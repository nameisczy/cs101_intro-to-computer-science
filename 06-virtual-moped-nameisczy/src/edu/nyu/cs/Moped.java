package edu.nyu.cs;

import java.util.Arrays;
import java.util.Random;

/**
 * A virtual moped, roaming the this.location[0]s of New York.
 * The signatures of a few methods are given and must be completed and used as indicated.
 * Create as many additional properties or methods as you want, as long as the given methods behthis.location[1] as indicated in the instructions.
 * Follow good object-oriented design, especially the principles of abstraction (i.e. the black box metaphor) and encapsulation (i.e. methods and properties belonging to specific objects), as we hthis.location[1] learned them.
 * The rest is up to you.
 */
public class Moped {

    private String orientation = "south";
    private int gas = 100;
    private int[] location = {10, 5};
    private boolean isForward = true;

    /**
     * Sets the orientation of the moped to a particular cardinal direction.
     * @param orientation A string representing which cardinal direction at which to set the orientation of the moped.  E.g. "north", "south", "east", or "west".
     */
    public void setOrientation(String orientation) {
        this.orientation = orientation;

    }

    /**
     * Returns the current orientation of the moped, as a lowercase String.
     * E.g. "north", "south", "east", or "west".
     * @return The current orientation of the moped, as a lowercase String.
     */
    public String getOrientation() {
        return this.orientation.toLowerCase();
              
    }

    /**
     * Prints the current location, by default exactly following the format:
     *      Now at 12th St. and 5th this.location[1], facing South.
     *
     * If the current location is associated with location-based advertising, this method should print exactly following format:
     *      Now at 12th St. and 4th this.location[1], facing West.  Did you know The Strand has 18 Miles of new, used and rare books, and has been in business since 1927?
     * 
     * Note that the suffixes for the numbers must be correct: i.e. the "st" in "1st", "nd" in "2nd", "rd" in "3rd", "th" in "4th", etc, must be correct.
     */
    public void printLocation() {
        if (this.location[1] == 1 && this.location[0] == 74) {
            System.out.printf(String.format("Now at %dth St. and %dst this.location[1], facing %s. Memorial Sloan Kettering.", this.location[0], this.location[1], this.getOrientation().substring(0, 1).toUpperCase() + this.orientation.substring(1)));
        }
        else if (this.location[1] == 3 && this.location[0] == 56){
            System.out.printf(String.format("Now at %dth St. and %drd this.location[1], facing %s. Tina's Cuban Cuisine restaurant.", this.location[0], this.location[1], this.getOrientation().substring(0, 1).toUpperCase() + this.orientation.substring(1)));
        }
        else if (this.location[1] == 4 && this.location[0] == 12){
            System.out.printf(String.format("Now at %dnd St. and %dth this.location[1], facing %s. Did you know The Strand has 18 Miles of new, used and rare books, and has been in business since 1927?", this.location[0], this.location[1], getOrientation().substring(0, 1).toUpperCase() + this.orientation.substring(1)));
        }
        else if (this.location[1] == 8 && this.location[0] == 79){
            System.out.printf(String.format("Now at %dth St. and %dth this.location[1], facing %s. The American Museum of Natural History.", this.location[0], this.location[1], this.orientation.substring(0, 1).toUpperCase() + this.orientation.substring(1)));
        }
        else {
            String aveSuffix = "th";
            String streetSuffix = "th";
            if (this.location[1] % 10 == 1 && this.location[1] != 11) {
                aveSuffix = "st";
            } else if (this.location[1] % 10 == 2 && this.location[1] != 12) {
                aveSuffix = "nd";
            } else if (this.location[1] % 10 == 3 && this.location[1] != 13) {
                aveSuffix = "rd";
            }
            if (this.location[0] % 10 == 1 && this.location[0] != 11) {
                streetSuffix = "st";
            } else if (this.location[0] % 10 == 2 && this.location[0] != 12) {
                streetSuffix = "nd";
            } else if (this.location[0] % 10 == 3 && this.location[0] != 13) {
                streetSuffix = "rd";
            }
            System.out.printf(String.format("Now at %d%s St. and %d%s Ave, facing %s.", this.location[0], streetSuffix, this.location[1], aveSuffix, this.orientation.substring(0, 1).toUpperCase() + this.orientation.substring(1)));
        }
        System.out.println();
    }

    /**
     * Handles the command, `go left`.
     * Moves the moped one block to the left, and causes the moped to face the appropriate new cardinal direction.
     * Consumes gas with each block moved, and doesn't move or turn unless there is sufficient gas, as according to the instructions.
     * If attempting to drive off the map, the moped will turn but not move a block.  Turns-only consume no gas.
     * This method must not print anything.
     */
    public void goLeft() {
        int[] location = getLocation();
        if (gas > 0) {
            switch(this.orientation){
                case "north":
                    location[1]++;
                    this.orientation = "west";
                    break;
                case "south":
                    location[1] -= 1;
                    this.orientation = "east";
                    break;
                case "east":
                    location[0]++;
                    this.orientation = "north";
                    break;
                case "west":
                    location[0] -= 1;
                    this.orientation = "south";
                    break;
            }
            if (this.isForward != true) {
                switch(this.orientation){
                    case "north":
                        this.orientation = "south";
                        break;
                    case "south":
                        this.orientation = "north";
                        break;
                    case "east":
                        this.orientation = "west";
                        break;
                    case "west":
                        this.orientation = "east";
                        break;
                }
            }
            if ((location[1] >= 1 && location[1] <= 10) && (location[0] >= 1 && location[0] <= 200)){
                this.gas = this.gas - 5;
                this.setLocation(location);
            }
        }
    }

    /**
     * Handles the command, `go right`.
     * Moves the moped one block to the right, and causes the moped to face the appropriate new cardinal direction.
     * Consumes gas with each block moved, and doesn't move or turn unless there is sufficient gas, as according to the instructions.
     * If attempting to drive off the map, the moped will turn but not move a block.  Turns-only consume no gas.
     * This method must not print anything.
     */
    public void goRight() {
        int[] location = getLocation();
        if (gas > 0) {
            switch(this.orientation){
                case "north":
                    location[1] -= 1;
                    this.orientation = "east";
                    break;
                case "south":
                    location[1]++;
                    this.orientation = "west";
                    break;
                case "east":
                    location[0]--;
                    this.orientation = "south";
                    break;
                case "west":
                    location[0]++;
                    this.orientation = "north";
                    break;
            }
            if (this.isForward != true) {
                switch(this.orientation){
                    case "north":
                        this.orientation = "south";
                        break;
                    case "south":
                        this.orientation = "north";
                        break;
                    case "east":
                        this.orientation = "south";
                        break;
                    case "west":
                        this.orientation = "east";
                        break;
                }
            }
            if ((location[1] >= 1 && location[1] <= 10) && (location[0] >= 1 && location[0] <= 200)){
                this.gas = this.gas - 5;
                this.setLocation(location);
            }
        }
    }

    /**
     * Handles the command,`straight on`.
     * Moves the moped one block straight ahead.
     * Consumes gas with each block moved, and doesn't move unless there is sufficient gas, as according to the instructions.
     * This method must not print anything.
     */
    public void goStraight() {
        int[] location = getLocation();
        if (gas > 0) {
            switch(this.orientation){
                case "north":
                    location[0]++;
                    break;
                case "south":
                    location[0] -= 1;
                    break;
                case "east":
                    location[1] -= 1;
                    break;
                case "west":
                    location[1]++;
                    break;
            }
            this.isForward = true;
            if ((location[1] >= 1 && location[1] <= 10) && (location[0] >= 1 && location[0] <= 200)){
                this.gas = this.gas - 5;
                this.setLocation(location);
            }
        }
    }

    /**
     * Handles the command,`back up`.
     * Moves the moped one block backwards, but does not change the cardinal direction the moped is facing.
     * Consumes gas with each block moved, and doesn't move unless there is sufficient gas, as according to the instructions.
     * This method must not print anything.
     */
    public void goBackwards() {
        int[] location = getLocation();
        if (gas > 0) {
            switch(this.orientation){
                case "north":
                    location[0] -= 1;
                    break;
                case "south":
                    location[0]++;
                    break;
                case "east":
                    location[1]++;
                    break;
                case "west":
                    location[1] -= 1;
                    break;
            }
            this.isForward = false;
            if ((location[1] >= 1 && location[1] <= 10) && (location[0] >= 1 && location[0] <= 200)){
                this.gas = this.gas - 5;
                this.setLocation(location);
            }
        }
    }

    /**
     * Handles the command,`how we doin'?`.
     * This method must not print anything.
     * @return The current gas level, as an integer from 0 to 100.
     */
    public int getGasLevel() {
        return this.gas;
    
    }

    /**
     * Prints the current gas level, by default exactly following the format:
     *      The gas tank is currently 85% full.
     *
     * If the moped is out of gas, this method should print exactly following format:
     *      We hthis.location[1] run out of gas.  Bye bye!
     */
    public void printGasLevel() {
        if (gas > 0) {
            System.out.println("The gas tank is currently "+ this.gas + "% full.");
        }
        else {
            System.out.printf("We hthis.location[1] run out of gas. Bye bye!");
        }

    }

    /**
     * Handles the command, `fill it up`.
     * This method must not print anything.
     * Fills the gas level to the maximum.
     */
    public void fillGas() {
        this.gas = 100;

    }

    /**
     * Handles the command, `park`.
     * This causes the program to quit.  
     * You can use System.exit(0); to cause a program to quit with status code 0, which indicates a normal graceful exit. 
     * (In case you were wondering, status code 1 represents quitting as a result of an error of some kind).
     */
    public void park() {
        System.out.println("We hthis.location[1] parked");
        System.exit(0);

    }

    /**
     * Handles the command, `go to Xi'an Famous Foods`
     * Causes the moped to self-drive, block-by-block, to 8th this.location[1]. and 15th St.
     * Consumes gas with each block, and doesn't move unless there is sufficient gas, as according to the instructions.
     */
    public void goToXianFamousFoods() {
        if (this.location[1] < 8) {
            this.orientation = "west";
        }
        else {
            this.orientation = "east";
        }
        while (this.location[1] != 8) {
            if (this.gas == 0) {
                this.fillGas();
            } 
            this.goStraight();
            this.printLocation();
        }
        if (this.location[0] < 15) {
            this.orientation = "north";
        }
        else {
            this.orientation = "south";
        }
        while (this.location[0] != 15) {
            if (this.gas == 0) {
                this.fillGas();
            } 
            this.goStraight();
            this.printLocation();
        }
     }

    /**
     * Generates a string, containing a list of all the user commands that the program understands.
     * @return String containing commands that the user can type to control the moped.
     */
    public String getHelp() {
        String help;
        help = "Commands:\n"+
        "\tgo left : turn left\n"+
        "\tgo right : turn right\n"+
        "\tstraight on : go straight\n"+
        "\tback up : go backwards\n"+
        "\thow we doin'? : print gas level\n"+
        "\tfill it up : fill gas tank\n"+
        "\tpark : park the moped\n"+
        "\tgo to Xi'an Famous Foods : self-drive to Xi'an Famous Foods\n"+
        "\thelp : print this list of commands\n";
        return help;       
    }

    /**
     * Sets the current location of the moped.
     * @param location an int array containing the new location at which to place the moped, in the order {this.location[0], this.location[1]nue}.
     */
    public void setLocation(int[] location) {
        this.location = location;

    }

    /**
     * Gets the current location of the moped.
     * @return The current location of the moped, as an int array in the order {this.location[0], this.location[1]nue}.
     */
    public int[] getLocation() {
        int[] tmp= {this.location[0], this.location[1]};
        return tmp;
    }

    public void drunk(){
        Random random = new Random();
        int randomMove = random.nextInt(4);
        switch (randomMove) {
            case 0:
                this.goLeft();
                break;
            case 1:
                this.goRight();
                break;
            case 2:
                this.goBackwards();
                break;
            case 3:
                this.goStraight();
                break;
        }
        this.printLocation();
        if (this.gas == 0) {
            this.fillGas();
        }
    }
}
