/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author elena
 */
public class Rabbit extends ZodiacAnimal {
    private int agility;
    private boolean canHop;
    
    public Rabbit() {
        super("Rabbit");
        this.agility = 90;
        this.canHop = true;
        this.baseSpeed = 70;
        this.specialAbilities[0] = "Quick Hop";
        this.specialAbilities[1] = "Dodge";
        this.specialAbilities[2] = "Lucky Leap";
 
    }
    
    @Override
    public void specialMove() {
        if(canHop) {
            hop();
        }
    }
    
    public void hop() {
        baseSpeed += 5;
    }
}
