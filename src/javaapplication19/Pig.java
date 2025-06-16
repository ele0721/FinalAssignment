package javaapplication19;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author elena
 */
public class Pig extends ZodiacAnimal {
    private int stamina; //pig stmina
    private boolean canRollAroundMud; //to check if it can be used
    private static int speedBoost; //speed
    private Trainer trainer; //pig's trainer
    

    public Pig() {
        super("Pig"); //call the superclass constructor
        this.stamina = 55; //inital stamina value
        this.canRollAroundMud = true; //set to true by defualt
        this.specialAbilities = new String [] {"Mud Wallow", "Persistence Trot", "Lucky Charm"}; //set ability names
        this.trainer = new Trainer("Joe"); //assigning default trainer
    }
    
    /**
     * 
     * @return returns the assigned trainer
     */
    public Trainer getTrainer() {
        return trainer;
    }
    
    /**
     * 
     * @param trainer the new trainer object
     */
    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
    
    /**
     * the special move for the pig
     */
    @Override
    public void specialMove() {
        if (canRollAroundMud) {
            RollInMud(); //use mud ability to increase stamina and speed
        } else {
            persistentTrot(); //reduce base speed 
        }
    }
    
    /**
     * activates the roll in mud
     */
    public void RollInMud() {
        stamina += 20; //increases stamina
        speedBoost = 4; //speed boost
    }
    
    /**
     * 
     * @return the current speed boost
     */
    public int getSpeedBoost() {
        return speedBoost;
    }
    
    /**
     * activates the persistent trot move
     */
    public void persistentTrot() {
        baseSpeed = 2;
    }
   
    /**
     * 
     * @return the current stamina
     */
    public int getStamina() {
        return stamina;
    }
    

}
