/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication19;
import processing.core.PApplet;
import processing.core.PImage;

/**
 *
 * @author elena
 */
public class Person {
  private ZodiacAnimal zodiacAnimal; //the zodiac animal 
  private boolean abilityActive = false; //to indicate if special ability is active
  private int abilityDuration = 0; //the time ability remains active
  private int maxAbilityDuration = 120; //maximum time ability stays active
  private int abilityCooldown = 0; //countdown timer until ability can be used again
  private int maxAbilityCooldown = 300; //cooldown timer after ability use
  
  public int x, y; //position of the person
  private String name; // name of the person
  private PImage image; //image of the person
  private PApplet app; // the canvas used to display graphical elements
  private int width, height; //width and height of screen

  /**
   * constructor for person
   * @param p the PApplet canvas
   * @param x initial x position
   * @param y initial y position
   * @param name name of the person
   * @param imagePath path to the image file
   */ 
  public Person(PApplet p, int x, int y,String name, String imagePath) {
    this.app = p; 
    this.x = x;
    this.y = y;
    this.name = name;
    this.image = app.loadImage(imagePath); //load image from file

    //create zodiac animal based on the name
    if(name.equals("Pig")) {
        this.zodiacAnimal = new Pig();
    } else if(name.equals("Rabbit")) {
        this.zodiacAnimal = new Rabbit();
    } else if(name.equals("Tiger")) {
        this.zodiacAnimal = new Tiger();
    } else if(name.equals("Monkey")) {
        this.zodiacAnimal = new Monkey();
    } else if(name.equals("Horse")) {
        this.zodiacAnimal = new Horse();
    } else {
        this.zodiacAnimal = new Rooster(); //default
    }
    
  }
  
  /**
   * Moves the person
   * @param dx change in x
   * @param dy change in y
   */
  public void move(int dx, int dy) {     
      x += dx; //updates x position
      y += dy; //updates y position
    }
    
  /**
   * moves the person based on screen boundaries
   * @param positionX movement in x 
   * @param positionY movement in y
   * @param screenWidth width of the screen
   * @param screenHeight height of the screen
   */
    public void move(int positionX, int positionY, int screenWidth, int screenHeight) {
        int newX = x + positionX; //calculates new x
        int newY = y + positionY; //calculates new y
        
        //if within horizontal bounds
        if(newX >= 0 && newX <= screenWidth - width) {
            x = newX; //updates x
        }
        //if withing vertical bounds
        if(newY >= 0 && newY <= screenHeight - height) {
            y = newY; //update y
        }
    }
  
    /**
     * draw person's image on the screen
     */
  public void draw() {
      app.image(image, x, y); //draws image at current position
  }
  
  /**
   * 
   * @return the x position of the person
   */
  public int getX() {
      return x;
  }
  
  /**
   * 
   * @return the y position of the person
   */
  public int getY() {
      return y;
  }
  
  /**
   * 
   * @return the width of the image
   */
  public int getWidth() {
      return width;
  }
  
  /**
   * 
   * @return the height of the image
   */
  public int getHeight() {
      return height;
  }
  
  /**
   * sets x position of the person
   * @param newX  the new x value
   */
  public void setX(int newX) {
      x = newX;
  }
  
  /**
   * sets y position of the person
   * @param newY the new y position
   */
  public void setY(int newY) {
      y = newY;
  }
   
  
  /**
   * activates the person's special abilities if not on cooldown
   */
  public void activateSpecialAbility() {
      //acive if not active and cooldown is over
      if(abilityCooldown <= 0 && !abilityActive && zodiacAnimal != null) {
          abilityActive = true; //set ability to true
          abilityDuration = maxAbilityDuration; //set how long it lasts
          abilityCooldown = maxAbilityCooldown; //starts cooldown
      }
      
  }
  
  /**
   * update the ability timers
   */
  public void updateAbilities() {
      if(abilityActive) { //if abilities is active
          abilityDuration--; //decrease its duration
          if(abilityDuration <= 0) { //when time is 0
              abilityActive = false; //set to false
          }
      }
      
      //if ability is on cooldwon
      if(abilityCooldown > 0) {
          abilityCooldown--; //decrease duration
      }
      
  }
  
  /**
   * 
   * @return the special ability if active
   */
  public boolean isAbilityActive() {
      return abilityActive;
  }
  
  /**
   * 
   * @return remaining cooldown time before ability can be used again
   */
  public int getAbilityCooldown() {
      return abilityCooldown;
  }
  
  /**
   * 
   * @return the person's zodiac animal
   */
  public ZodiacAnimal getZodiacAnimal() {
      return zodiacAnimal;
  }
 
 
 
}


