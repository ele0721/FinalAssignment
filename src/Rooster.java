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
    
    public Rooster() {
        super("Rooster");
        this.baseSpeed = 4;
        this.confidence = 50;
        this.canDefend = true;
        this.specialAbilities[0] = "Quick Jump";
        this.specialAbilities[1] = "Quick Jump";
        this.specialAbilities[3] = "Lucky charm";

    }
    
    @Override
    public void specialMove() {
        if(canDefend) {
            baseSpeed += 4;
        }
    }
}
