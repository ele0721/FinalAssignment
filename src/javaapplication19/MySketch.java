package javaapplication19;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author elena
 */
import processing.core.PApplet;
import processing.core.PImage;

public class MySketch extends PApplet {
    private Person person; //declare a person object
    String userInput = "";
    int stage = 0;
    int selectedcharacter = 0;
    
    PImage[] zodiacImageObjects;
    
    String [] zodiacNames = {"Dragon", "Pig", "Rabbit", "Horse", "Rooster", "Monkey"};
    
    String [] zodiacImages = {"images/person.png", "images/pig.png","images/rabbit.png", "images/horse.png", "images/rooster.png", "images/monkey.png" };
    
    public void settings(){
	//sets the size of the window
        size (750,500);
    }
    
    public void setup(){
	//sets the background colour using R,G,B 
        background(255);
        textSize(20);
        zodiacImageObjects = new PImage[zodiacNames.length];
        for(int i = 0; i < zodiacNames.length; i++) {
            zodiacImageObjects[i] = loadImage(zodiacImages[i]);
        }
    }
    
    public void draw(){
        background(255, 0, 0);
        if (stage == 0) {
            text("Chinese Zodiac Race", width/2,50);
        text("Choose Your Character!", width/2, 90);
        
        for (int i = 0; i < zodiacNames.length; i++) {
            int x = (i % 3) * 200 +100;
            int y = (i / 3) * 100 + 200;
            
            text(zodiacNames[i], x + 90, y + 8);
            image(zodiacImageObjects[i], x + 10, y - 30, 60, 60);
        }
        
        } else if (stage == 1) {
            person.draw();
        }
        
    }
    
    public void keyPressed() {
        if (stage == 0) {
            if(keyCode == ENTER) {
                stage = 1;
            } else if (key != CODED) {
                userInput += key;
            }
        }
    }
    
    
    public void mousePressed() {
        for (int i = 0; i < zodiacNames.length; i++) {
            int x = (i % 3) * 220 + 100;
            int y = (i / 3) * 100 + 200;
            
            if (mouseX >= x && mouseX <= x + 180 && mouseY >= y - 40 && mouseY <= y + 40) {
                int selectedCharacter = i;
                person = new Person(this, 50, 200, zodiacNames[selectedCharacter], 99, zodiacImages[selectedCharacter]);
                stage = 1;
                break;
            }
        }
    }
}

