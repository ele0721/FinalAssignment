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
    private int endurance;
    private boolean canGallop;
    private int speedBoost;
    private Trainer trainer;
    
    public Horse() {
        super("Horse");
        this.baseSpeed = 6;
        this.endurance = 80;
        this.canGallop = true;
        this.specialAbilities = new String[] {"Quick Gallop", "Endurance Run", "Lucky Charge"};
        this.trainer = new Trainer("Alex");
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
    
    @Override
    public void specialMove() {
        if(canGallop) {
            gallop();
        } else {
            enduranceRun();
        }
    }
    
    public void gallop() {
        baseSpeed += 4;
        speedBoost = 10;
    }
    
    public void enduranceRun() {
        endurance += 15;
        baseSpeed += 1;
    }
    
    public int getSpeedBoost() {
        return speedBoost;
    }
    
    public int getEndurance() {
        return endurance;
    }
}
