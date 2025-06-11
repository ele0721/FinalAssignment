/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author elena
 */
public class Pig extends ZodiacAnimal {
    private int stamina;
    private boolean canRollAroundMud;
    
    public Pig() {
        super("Pig");
        this.stamina = 100;
        this.canRollAroundMud = true;
        this.specialAbilities[0] = "Mud Wallow";
        this.specialAbilities[1] = "Persistent Trot";
        this.specialAbilities[2] = "Lucky Charm";
    }
    
    public void initializeAbilities() {
        this.specialAbilities = new String[] {"Mud Wallow", "Lucky Charm"};
    }
    
    @Override
    public void specialMove() {
        if (canRollAroundMud) {
            RollInMud();
        } else {
            persistentTrot();
        }
    }
    
    public void RollInMud() {
        stamina += 20;
    }
    
    public void persistentTrot() {
        baseSpeed += 2;
    }
    

}
