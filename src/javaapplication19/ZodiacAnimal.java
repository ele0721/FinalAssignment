package javaapplication19;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author elena
 */
public class ZodiacAnimal {
    public String zodiacType; //the type of zodiac animal
    public int baseSpeed; //the base speed
    public String [] specialAbilities; //array storing the names of the animals' special abilities
    
    /**
     * initializes a zodiac animal with a specific type
     * @param type the name of the zodiac animal
     */
    public ZodiacAnimal(String type) {
        this.zodiacType = type; //the animal type
        this.baseSpeed = 3; //default base speed of 3
        this.specialAbilities = new String[3]; //sets the 3 abilities
    }
    
    /**
     * defines the special move, subclasses override this method to define specific behaviours 
     */
    public void specialMove() {
        System.out.println(zodiacType + "special move");
    }
    
    /**
     * 
     * @return returns the base speed value
     */
    public int getBaseSpeed() {
        return baseSpeed;
    }
    /**
     * 
     * @return returns the array of special abilities
     */
    public String [] getAbilities() {
        return specialAbilities;
    }
    /**
     * 
     * @return returns the animal type
     */
    public String getZodiacType() {
        return zodiacType;
    }
    
}
