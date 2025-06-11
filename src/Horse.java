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
    
    public Horse() {
        super("Horse");
        this.baseSpeed = 6;
        this.endurance = 80;
        this.canGallop = true;
        this.specialAbilities[0] = "Quick Jump";
        this.specialAbilities[1] = "Gallop";
        this.specialAbilities[2] = "Lucky Charm";
    }
    
    @Override
    public void specialMove() {
        if(canGallop) {
            baseSpeed += 4;
        }
    }
}
