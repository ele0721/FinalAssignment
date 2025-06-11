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
  public int x, y; //position of the person
  public int positionx, positiony;
  private String name; // name of the person
  private int age; // age of the person
  private PImage image; //image of the person
  private PApplet app; // the canvas used to display graphical elements
  private int width, height;
  private int speed;
  private static int currentSpeed;
 
  
  public Person(PApplet p, int x, int y,String name, String imagePath) {
    this.app = p;
    this.x = x;
    this.y = y;
    this.name = name;
    this.age = age;
    this.image = app.loadImage(imagePath);
    this.width = width;
    this.height = height;
    this.speed = speed;
    this.currentSpeed = 0;
    
  }
  
  public void move(int dx, int dy) {     
      x += dx;
      y += dy;
  }
  
  public void draw() {
      app.image(image, x, y);
  }
  
  public boolean isClicked(int mouseX, int mouseY) {
      int centerX = x+(image.pixelWidth/2);
      int centerY = y+(image.pixelHeight/2);
      float d = PApplet.dist(mouseX, mouseY, centerX, centerY);
      
      return d < 30;
     
  }
  
   public boolean isCollidingWith(Person other) {
      boolean isLeftOfOtherRight = x < other.x + other.width;
      boolean isRightOfOtherLeft = x + width > other.x;
      boolean isAboveOtherBottom = y < other.y + other.height;
      boolean isBelowOtherTop = y + height > other.y;
      return isLeftOfOtherRight && isRightOfOtherLeft && isAboveOtherBottom && isBelowOtherTop;
    }  
   
    
    
  public void displayInfo() {  
       app.fill(0); //text color
       positionx = 50;
       positiony = 50;
       app.text("Speed: " + speed, positionx, positiony);
  }
  
}


