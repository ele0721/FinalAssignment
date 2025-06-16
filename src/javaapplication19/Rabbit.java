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
public class Rabbit extends ZodiacAnimal {
    private int agility; //rabit's agility
    private boolean canHop; //to check if canHop is true
    private int speedBoost; //speed
    private Trainer trainer; //rabit's trainer
    
    public Rabbit() {
        super("Rabbit"); //call the superclass constructor
        this.agility = 77; //intiaal agility value
        this.canHop = true; //set to true by default
        this.specialAbilities = new String [] {"Quick Hop", "Dodge", "Lucky Leap"}; //set ability names
        this.trainer = new Trainer("Lin"); //assigning default trainer
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
     * activates the rabbit's special
     */
    @Override
    public void specialMove() {
        if(canHop) {
            hop(); //perform the hop abilty
        } else {
            dodge(); //perform the dodge ability
        }
    }
    
    /**
     * increase base speed and a speed boost
     */
    public void hop() {
        baseSpeed += 5; //boost speed temporarily
        speedBoost = 5; //set speed boost value
    }
    
    /**
     * 
     * @return returns the current speed boost value
     */
    public int getSpeedBoost() {
        return speedBoost;
    }
    
    /**
     * increases the rabbit's agility
     */
    public void dodge() {
        agility += 10;
    }
    
    /**
     * 
     * @return returns the current agility level of rabbit
     */
    public int getAgility() {
        return agility;
    }
}
