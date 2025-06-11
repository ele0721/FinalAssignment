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
    
    public Monkey() {
        super("Monkey");
        this.baseSpeed = 6;
        this.stamina = 88;
        this.canSwing = true;
        this.specialAbilities[0] = "Quick Swing";
    }
    
    @Override
    public void specialMove() {
        if(canSwing) {
            this.baseSpeed = 8;
        }
    }
}
