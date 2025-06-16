package javaapplication19;


import javaapplication19.ZodiacAnimal;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author elena
 */
public class Horse extends ZodiacAnimal {
    private int endurance; //horse's endurance value
    private boolean canGallop; //to determine if horse can gallop
    private int speedBoost; //speed
    private Trainer trainer; //horse's trainer
    
    public Horse() {
        super("Horse"); //calls superclass constructor
        this.baseSpeed = 6; //sets base speed
        this.endurance = 80; //sets endurance value
        this.canGallop = true; //sets canGallop to default value
        //list of special abilities
        this.specialAbilities = new String[] {"Quick Gallop", "Endurance Run", "Lucky Charge"};
        this.trainer = new Trainer("Alex"); //assigns trainer as a default value
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
     * executes horse's special move
     */
    @Override
    public void specialMove() {
        if(canGallop) {
            gallop(); //perform gallop move to boost speed
        } else {
            enduranceRun(); //perform endurance run to increase speed
        }
    }
    
    /**
     * increases speed temporarily
     */
    public void gallop() {
        baseSpeed += 4;
        speedBoost = 10;
    }
    
    /**
     * increases speed and endurance
     */
    public void enduranceRun() {
        endurance += 15;
        baseSpeed += 1;
    }
    
    /**
     * 
     * @return returns speed boost
     */
    public int getSpeedBoost() {
        return speedBoost;
    }
    
    /**
     * 
     * @return returns endurance value
     */
    public int getEndurance() {
        return endurance;
    }
}
