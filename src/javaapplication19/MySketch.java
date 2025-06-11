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
    private Person person2;
    private Person[] allRacers;
    private int playerCharacterIndex;
    int stage = 0;
    int selectedcharacter = 0; //User's choice of character
    PImage[] zodiacImageObjects = new PImage[6]; //Create array to hold loaded images
    PImage backgroundImage;
    PImage backgroundImage2;
    
    private int startTime;
    private boolean storyDisplayed = false;
    private int storyDuration = 5000;
    private String storyText = "Welcome";

    private boolean timerDisplayed = false;
    private int raceDuration = 20000;
    
    PImage[] raceTrackImages = new PImage[2];
    int currentTrackIndex = 0;
    int trackChangeTimer;
    int trackChangeDuration = 1500;
    
    String[] raceTrackFiles =  {
        "images/raceTrack1.png",
        "images/raceTrack2.png",
        "images/raceTrack3.png",
        "images/raceTrack4.png",
        "images/raceTrack5.png",
        "images/raceTrack6.png",
        "images/raceTrack7.png",
        "images/raceTrack8.png",
        "images/raceTrack9.png",
        "images/raceTrack10.png",
        "images/raceTrack11.png",
        "images/raceTrack12.png" 
    };

    String [] zodiacNames = {"Pig", "Rabbit", "Horse", "Rooster", "Monkey", "Tiger"};
    
    String [] zodiacImages = {"images/pig.png","images/rabbit.png", "images/horse.png", "images/rooster.png", "images/monkey.png", "images/tiger.png"};
    
    public void settings(){
	//sets the size of the window
        if (stage == 0) {
            size (600, 771);
        }
    }
    
    public void setup(){
	//sets the background colour using R,G,B 
        background(255);
        textSize(20); //sets text size
        textAlign(CENTER); //aligns text to the center
        
        zodiacImageObjects = new PImage[zodiacNames.length];
        //loop through each zodiac sign
        for(int i = 0; i < zodiacNames.length; i++) {
            //load the image for the current zodiac sing and store it into the zodiacImageObjects array
            zodiacImageObjects[i] = loadImage(zodiacImages[i]);
        }
        
        for (int i = 0; i < raceTrackImages.length; i++) {
            raceTrackImages[i] = loadImage(raceTrackFiles[i]);
        }
            //initialize images
//            backgroundImage = loadImage("images/raceGif.gif");
            backgroundImage2 = loadImage("images/backgroundImage2.png");
    }
    
    public void draw(){
        background(173, 216, 230); //set background color
        if (stage == 0) {        
            if(backgroundImage2 != null) {
               image(backgroundImage2, 0, 0, width, height);
                
            }
            
            if(!storyDisplayed) {
                startTime = millis();
                storyDisplayed = true;
            }
            
            fill(0, 0, 0, 150);
            textAlign(CENTER);
            text(storyText, width/2, height/2 - 300);
            
            int timeLeft = (storyDuration - (millis() - startTime)) / 1000 + 1;
            if(timeLeft > 0) {
                textSize(16);
                text("Game starting in: " + timeLeft + " seconds", width/2, height/2 + 300);
            }
            
            if(millis() - startTime >= storyDuration) {
                stage = 1;
            }
        }
        else if (stage == 1) { //check if user is in stage 0
            text("Chinese Zodiac Race", width/2,30); //Display main title at the center
            text("Choose Your Character!", width/2, 80); //Display instruction below the title
            text("Press SPACE to use special ability", width/2, 120);
        //Loop through all zodiac characters to display them in a  grid
        for (int i = 0; i < zodiacNames.length; i++) {
            int x = (i % 3) * 150 + 100; //calculate x position, creates 3 columns
            int y = (i / 3) * 140 + 220; //calculate y position, creates rows
            //check if the image is null before displaying
            if (zodiacImageObjects[i] != null) {
                //display image
                image(zodiacImageObjects[i], x + 15, y - 40, 60, 60);
            }
            textAlign(CENTER);
            //display character name below image
            text(zodiacNames[i], x + 45, y + 35);    
        }
        
        } else if (stage == 2) {
            if(!timerDisplayed) {
                startTime = millis();
                timerDisplayed = true;
            }
            
            //calcualtes time left
            int timeLeft = (raceDuration - (millis() - startTime))/ 1000+1;
            
            //displays time
            if(timeLeft > 0) {
                text("Time: " + timeLeft, width -300, height -300);
                fill(0);
            }            
            
            //Change race track image every few seconds
            if(millis() - trackChangeTimer >= trackChangeDuration) {
                currentTrackIndex = (currentTrackIndex + 1) % raceTrackImages.length;
                trackChangeTimer = millis();
            }
            
            //Display current race track background
            if(raceTrackImages[currentTrackIndex] != null)  {
                image(raceTrackImages[currentTrackIndex],0,0, width, height);
            }
                           
            for (int i = 0; i <allRacers.length; i++) {
                if (allRacers[i] != null) {
                    allRacers[i].draw();
                    
                    if(i != playerCharacterIndex) {
                        float speed = 1 + (i * 0.3f);
                        allRacers[i].move(0, (int)-speed);
                    }
                }
            }
            
            if(person != null) {
                person.displayInfo();
            }
          
           if (keyPressed) {
               if (keyCode == LEFT) {
                person.move(-5, 0);
              } else if (keyCode == RIGHT) {
                person.move(5, 0);
              } else if (keyCode == UP) {
                person.move(0, -5);
              } else if (keyCode == DOWN) {
                person.move(0, 5);
              }
            }
           
        } else if (raceDuration >= 20000) {
            stage = 3;
            text("You've finished the race", width, height);
        } 
    }
    
    public void mousePressed() {
        if(stage == 1) {
            for (int i = 0; i < zodiacNames.length; i++) {
                int x = (i % 3) * 180 + 90;
                int y = (i / 3) * 140 + 180;

                if (mouseX >= x && mouseX <= x + 120 && mouseY >= y - 40 && mouseY <= y + 40) {
                    int playerCharacterIndex = i;
                    allRacers = new Person[zodiacNames.length];
                    int startY = height - 100;
                    
                    for (int j = 0; j < zodiacNames.length; j++) {
                        int startX = 50 + (j * 80);
                        allRacers[j] = new Person(this, startX, startY, zodiacNames[j], zodiacImages[j]);
                    }
                    
                    person = allRacers[playerCharacterIndex];
                    stage = 2;
                    break;
                    
                }
            }

        }
    }

}

