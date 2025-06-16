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
    private boolean canSwing;
    private int stamina;
    private int speedBoost;
    private Trainer trainer;
    
    public Monkey() {
        super("Monkey");
        this.baseSpeed = 6;
        this.stamina = 88;
        this.canSwing = true;
        this.specialAbilities = new String[] {"Quick Swing", "Quick Run", "Dodge"};
        this.trainer = new Trainer("Maya");
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
        if(canSwing) {
            swing();
        } else {
            nimbleDodge();
        }
    }
    
    public void swing() {
        baseSpeed += 2;
        speedBoost = 8;
    }
    
    public void nimbleDodge() {
        stamina += 10;
    }
    
    public int getSpeedBoost() {
        return speedBoost;
    }
    
    public int getStamina() {
        return stamina;
    }
}
