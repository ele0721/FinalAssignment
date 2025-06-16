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
public class Monkey extends ZodiacAnimal {
    private boolean canSwing; //to determine if swing ability is available
    private int stamina; //stamina value
    private int speedBoost; //speed boost from special ability
    private Trainer trainer; //monkey's trainer
    
    public Monkey() {
        super("Monkey"); //calls superclass constructor
        this.baseSpeed = 6; //sets base soeed
        this.stamina = 88; //inital stamina value
        this.canSwing = true; //sets swing move by default
        //list of special abilities
        this.specialAbilities = new String[] {"Quick Swing", "Quick Run", "Dodge"};
        this.trainer = new Trainer("Maya"); //default trainer
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
     * executes the monkey's special move
     */
    @Override
    public void specialMove() {
        if(canSwing) {
            swing(); //perform swing move to boost speed
        } else {
            dodge(); //perform dodge mmove to increase stamina
        }
    }
    
    /**
     * increases speed temporarily
     */
    public void swing() {
        baseSpeed += 2; //boost base speed
        speedBoost = 8; //set speed boost value
    }
    
    /**
     * increases stamina
     */
    public void dodge() {
        stamina += 10;
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
     * @return returns stamina 
     */
    public int getStamina() {
        return stamina;
    }
}
