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
    private int confidence; //rooster's confidence value
    private boolean canDefend; //to determine if defence ability is available
    private int defenseBoost; //defense value
    private Trainer trainer; //rooster's trainer
    
    public Rooster() { 
        super("Rooster"); //calls superclass constructor
        this.baseSpeed = 4; //speed value
        this.confidence = 50; //confidence value
        this.canDefend = true; //sets to default value
        //list of special abilities
        this.specialAbilities = new String[] {"Quick Defence", "Confidence Boost", "Dodge"};
        this.trainer = new Trainer("Jerry"); //Rooster's default trainer
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
     * executes the rooster's special move
     */
    @Override
    public void specialMove() {
        if(canDefend) {
            defend(); //perform defend move to boost speed
        } else {
            confidenceBoost(); //perfomr confidence boost to increase value
        }
    }
    
    /**
     * increases speed and confidence
     */
    public void defend() {
        baseSpeed += 4; //boost base speed
        defenseBoost = 8; //confidence boots
    }
    
    /**
     * increases confidence value
     */
    public void confidenceBoost() {
        confidence += 20;
    }
    
    /**
     * 
     * @return returns defense boost value
     */
    public int getDefenseBoost() {
        return defenseBoost;
    }
    /**
     * 
     * @return returns confidence value
     */
    public int getConfidence() {
        return confidence;
    }
}
