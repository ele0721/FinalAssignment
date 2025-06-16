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
    public String zodiacType;
    public int baseSpeed;
    public String [] specialAbilities;
    
    public ZodiacAnimal(String type) {
        this.zodiacType = type;
        this.baseSpeed = 3;
        this.specialAbilities = new String[3];
    }
    
    public void specialMove() {
        System.out.println(zodiacType + "special move");
    }
    
    public int getBaseSpeed() {
        return baseSpeed;
    }
    
    public String [] getAbilities() {
        return specialAbilities;
    }
    
    public String getZodiacType() {
        return zodiacType;
    }
    
}
