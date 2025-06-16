/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication19;

/**
 *
 * @author elena
 */
public class Tiger extends ZodiacAnimal {
    private int strength; //tiger's strength
    private boolean canJump; //indicates it jump move is available
    private int speedBoost; //speed 
    private Trainer trainer; //tiger's trainer
    
    public Tiger() {
        super("Tiger"); //calls superclass constructor
        this.strength = 100; //intial strenght level
        this.canJump = true; //can jump by default
        //tiger's abilities
        this.specialAbilities = new String[] {"Quick Jump", "Fierce Pounce", "Tiger Roar"};
        this.trainer = new Trainer("Liam");//default trainer
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
     * executes the tiger's special move
     */
    @Override
    public void specialMove() {
        if(canJump) {
            jump();
        } else {
            fiercePounce();
        }
    }
    
    public void jump() {
        baseSpeed += 2;
        speedBoost = 8;
    }
    
    public int getSpeedBoost() {
        return speedBoost;
    }
    
    public void fiercePounce() {
        strength += 15;
    }
    
    public int getStrength() {
        return strength;
    }
      
}
