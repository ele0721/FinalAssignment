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
public class Rooster extends ZodiacAnimal {
    private int confidence;
    private boolean canDefend;
    private int defenseBoost;
    private Trainer trainer;
    
    public Rooster() {
        super("Rooster");
        this.baseSpeed = 4;
        this.confidence = 50;
        this.canDefend = true;
        this.specialAbilities = new String[] {"Quick Defence", "Confidence Boost", "Dodge"};
        this.trainer = new Trainer("Jerry");
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
        if(canDefend) {
            defend();
        } else {
            confidenceBoost();
        }
    }
    
    public void defend() {
        baseSpeed += 4;
        defenseBoost = 8;
    }
    
    public void confidenceBoost() {
        confidence += 20;
    }
    
    public int getDefenseBoost() {
        return defenseBoost;
    }
    
    public int getConfidence() {
        return confidence;
    }
}
