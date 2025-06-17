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
import java.io.*;
import java.util.*;

public class MySketch extends PApplet {
//2D array for storing animal names and their trainers    
private String[][] animalTrainerData = {
    {"Pig", "Joe"},
    {"Rabbit", "Lin"},
    {"Horse", "Alex"},
    {"Rooster", "Jerry"},
    {"Monkey", "Maya"},
    {"Tiger", "Liam"}
};
    //array to hold 6 trainer objects.
    private Trainer[] trainers = new Trainer[6];
    
    private boolean scoreSaved = false; //to prevent saving score multiple times
    private String scoresFile = "scores.txt"; //file to store the scores
    private ArrayList<String> highScores = new ArrayList<String>(); //list to store high scores;
    private int [] racerLaps = new int[6]; //to track lap count for each of the 6 racers
    private boolean raceFinished = false; //to indicate if race was finished
    private String winner = ""; //store the name of the winner
  
    private Person person; //declare a person object
    private Person person2; //declare second person object
    private Person[] allRacers; //array containing all racing characters
    private int playerCharacterIndex; //index representing which characters the user chose
    private int stage = 0; //to represent current game stage
    private int selectedcharacter = 0; //index of currently selected character
    PImage[] zodiacImageObjects = new PImage[6]; //array to hold loaded images
    PImage backgroundImage; //background image
    PImage backgroundImage2; //welcome screen background image
    PImage raceTrackImage; //racing track background image
    PImage finishLineImage; //finish lime image for race ending
    
    private String storyText = "Welcome"; //text display on the welcome screen
    
    private Timer2 raceTimer, storyTimer; //timer durations for race and story display
    private boolean storyDisplayed = false; //ensure story timer starts only once
    private boolean timerDisplayed = false; //ensures race timer start only once
     
    private float backgroundY1 = 0; //y position of the first scrolling background image
    private float backgroundY2 = -771; //y position of the second scrolling background image
    private float scrollSpeed = 3.0f; //speed at which background scrolls downwards
    
    private float finishLineY = -200; //y position of the finish line image
    private boolean showFinishLine = false; //y position of the second scrolling background
    private int finishLineTimer = 0; //timer for finish lime
    
    private String userInput = ""; //String to store the player's name
   
    //Store all zodiac animal images
    String [] zodiacImages = {"images/pig.png","images/rabbit.png", "images/horse.png", "images/rooster.png", "images/monkey.png", "images/tiger.png"};

    public void settings(){
	//sets the size of the window
            size (600, 771);
    }
    
    public void setup(){
        loadScoresFromFile(); //call method to load existing high scores from file
        background(255); //sets the background colour using R,G,B 
        textSize(20); //sets text size
        textAlign(CENTER); //aligns text to the center
        
        //Set timer for both welcome page and race timer
        storyTimer = new Timer2(5);
        raceTimer = new Timer2(20);
        //initialize image array with size based on nuer of zodiac names
        zodiacImageObjects = new PImage[getZodiacNames().length];
        //loop through each zodiac sign
        for(int i = 0; i < getZodiacNames().length; i++) {
            //load the image for the current zodiac sing and store it into the zodiacImageObjects array
            zodiacImageObjects[i] = loadImage(zodiacImages[i]);
        }
        //loop through all trainer names
        for (int i = 0; i < getTrainerNames().length; i++) {
            trainers[i] = new Trainer(getTrainerNames()[i]); //new trainer object with name to store in array
        }
       
        raceTrackImage = loadImage("images/raceTrack1.png"); //load the main racing track bacground image
        finishLineImage = loadImage("images/raceTrack13.png"); //load the finish line image
        backgroundImage2 = loadImage("images/backgroundImage2.png"); //load the welcome screen background
    }
    
    
    public void draw(){
        background(173, 216, 230); //set background color
        
        if (stage == 0) { //check if user is in stage 0        
            if(backgroundImage2 != null) { //check if background image loaded successfully
               image(backgroundImage2, 0, 0, width, height); //draw background image scaled to window size
                
            }
            //Start story timer when stage is 0
            if(!storyDisplayed) {
                storyTimer.start(); //start the countdown timer
                storyDisplayed = true; //set the start story to true
            }
            fill(0); //set color text 
            text("Enter your name: ", width/2, height/2 - 350); //dislay name input prompt
            text(userInput, width/2, height/2 - 320); //display currently typed name

            //Update the story timer
            storyTimer.update();

            fill(0); //set color text
            textAlign(CENTER); //center text
            text(storyText, width/2, height/2 - 300); //display welcome text

            //advances when timer has finished
            if(storyTimer.isFinished()) {
                stage = 1; //move to next stage
            } 

            if(!storyTimer.isFinished()) { //if timer is still running
                textSize(16); //change text size to 16
                //show countdown
                text("Game starting in: " + storyTimer.getTimeLeft() + " seconds", width/2, height/2 + 300);
                textSize(14); // Reset text size
            }
        }
        else if (stage == 1) { //check if user is in stage 0
            text("Chinese Zodiac Race", width/2,30); //Display main title at the center
            text("Choose Your Character!", width/2, 80); //Display instruction below the title
            text("Press SPACE to use special ability", width/2, 120);
            //Loop through all zodiac characters to display them in a grid
            for (int i = 0; i < getZodiacNames().length; i++) {
                int x = (i % 3) * 150 + 100; //calculate x position, creates 3 columns
                int y = (i / 3) * 140 + 220; //calculate y position, creates rows
                //check if the image is null before displaying
                if (zodiacImageObjects[i] != null) { //check if image was loaded successfully
                    image(zodiacImageObjects[i], x + 15, y - 40, 60, 60); //display image
                }
                textAlign(CENTER); //align text
                text(getZodiacNames()[i], x + 45, y + 35); //display character name below image

                fill(100, 100, 255); //set color text to light blue
                textSize(14); //set text size
                text("Trainer: " + getTrainerNames()[i], x + 45, y + 50); //dispay trainer name below character name

                fill(0); //reset color text to black
            }   
        //check if user is in stage 2
        } else if (stage == 2) {
            if(!timerDisplayed) { //check if timer hasn't been started yet
                raceTimer.start(); //start the 20 second timer
                timerDisplayed = true; //set the timer displayed to true
            }
            //update the race timer
            raceTimer.update();
            
            textAlign(LEFT); //set text alignment to the left
            int leftYPosition = 30; //start y position for left side text
            int leftLineSpacing = 25; //spacing between lines of text
            
            if(person != null) { //check if character exists
                person.updateAbilities(); //update special ability cooldowns
            }

            
            fill(0); // Black text
            text("Time: " + raceTimer.getTimeString(), 10, leftYPosition); //diplsya race timers
            leftYPosition += leftLineSpacing; //move y position down for next element
            
            // Show finish line when race is almost over 
            if(raceTimer.getTimeLeft() <= 3 && !showFinishLine) { //if 3 or fewer seconds left and finish line now shown yet
                showFinishLine = true; //set finish line display
                finishLineTimer = millis(); //record current time in seconds
            }
            
              
            //Move both background images down
            backgroundY1 += scrollSpeed; //move first background image down
            backgroundY2 += scrollSpeed; //move seconds background image down
            
            //Reset position when images scroll off screen
            if(backgroundY1 >= height) { ///if first background has moved down completely
                backgroundY1 = backgroundY2 - height; //reset first background image to the top
            }
            
            if(backgroundY2 >= height) { //if second background image has move down completely
                backgroundY2 = backgroundY1 - height; //reset second backgorund image to the top
            }
            
            if(raceTrackImage != null) {
                image(raceTrackImage, 0, backgroundY1, width, height);
                image(raceTrackImage, 0, backgroundY2, width, height);
            }
            
            if(showFinishLine) { //checks if finish line should be displayed
                finishLineY += scrollSpeed * 0.5f; //move linish line down
                
                // Draw your raceTrack13 finish line image
                if(finishLineImage != null) { //check if finish line image has loaded successfully
                    image(finishLineImage, 0, finishLineY, width, height); //draw finish line image
                } 
            }
            
            fill(0); //set color text to black
            textAlign(LEFT); //align text to the left
            text(raceTimer.getTimeString(), 70, 70); //display timer
                        
            for (int i = 0; i < allRacers.length; i++) { //loops through all racing characters
                if (allRacers[i] != null) { //check if racer object exists
                    allRacers[i].draw(); //draw the racer on screen
                        if (i != playerCharacterIndex) { //skip the player's character
                        float baseSpeed = getAnimalSpeed(getZodiacNames()[i]); //get base speed for specific animal 
                        float speed = baseSpeed + (i * 0.4f); //change speed variation based on racer index
                        allRacers[i].move(0, (int)-speed); //move racer upward
                    }
                    // Keep the boundary checking and lap counting for all racers
                    if(allRacers[i].getX() < 0) { //check if racer has moved to the left
                        allRacers[i].setX(0); //reset their x position to 0 
                    //check if racer x position is beyond the right edge of the screen
                    } else if(allRacers[i].getX() > width - allRacers[i].getWidth()) { 
                        allRacers[i].setX(width - allRacers[i].getWidth()); //reset their x position
                    }
                    //if racer has moved above the screen
                    if(allRacers[i].getY() < -100) {
                        racerLaps[i]++; //increment lap counter
                        allRacers[i].setY(height + 50); //reset racer to the bottom of the screen
                        allRacers[i].setX(50 + (i * 80)); //reset racer to starting x position
                    }
                }
            }
            
            
            
            
            int baseSpeed = 3; //base speed for player
            int moveSpeed = baseSpeed; //current movement speed            
           
            if (keyPressed) { //check if any key is currently being pressed
                ///check if player's special ability is active and animal exists
                if(person.isAbilityActive() && person.getZodiacAnimal() != null) { 
                    //get player's zodiac animal
                    ZodiacAnimal animal = person.getZodiacAnimal();
                    
                    if(animal instanceof Pig) { //check if animal is a pig
                    Pig pig = (Pig) animal; //cast to pig type
                    moveSpeed += pig.getSpeedBoost(); //add pig's speed boost to normal speed
                    } else if(animal instanceof Rabbit) { //check if animal is a rabbit
                        Rabbit rabbit = (Rabbit) animal; //cast to rabbit type
                        moveSpeed += rabbit.getSpeedBoost(); //add rabit's speed boost to normal speed
                    } else if(animal instanceof Tiger) { //check if animal is a tiger
                        Tiger tiger = (Tiger) animal; //cast to tiger type 
                        moveSpeed += tiger.getSpeedBoost(); //add tiger's speed boost to normal speed
                    } else if(animal instanceof Monkey) { //check if animal is a monkey
                        Monkey monkey = (Monkey) animal; //cast to monkey type
                        moveSpeed += monkey.getSpeedBoost(); //add monkey's speed boost to normal speed
                    } else if(animal instanceof Horse) { //check if animal is a horse
                        Horse horse = (Horse) animal; //cast to horse type
                        moveSpeed += horse.getSpeedBoost(); //add horse's speed boost to normal speed
                    } else if(animal instanceof Rooster) { //check if animal is a rooster
                        Rooster rooster = (Rooster) animal; //cast to rooster type
                        moveSpeed += rooster.getDefenseBoost(); //add rooster's speed boost to normal speed
                    }
                }
            }
            //if left arrow is pressed and player is not at left edge    
            if (keyPressed && keyCode == LEFT && person.getX() > 0) {
                person.move(-moveSpeed, 0); ///move player left
            //if right arrow is pressed and player is not at right edge
            } else if (keyPressed && keyCode == RIGHT && person.getX() < width - person.getWidth()) {
                person.move(moveSpeed, 0); //move player right
            //if up arrow is pressed and player is not at the top
            } else if (keyPressed &&keyCode == UP) {
                person.move(0, -moveSpeed); //move player up
            //if down arrow is pessed and player is not at the bottom
            } else if (keyPressed && keyCode == DOWN && person.getY() < height - person.getHeight()) {
                person.move(0, moveSpeed); //move player down
            }                
            

            
            if(person != null && person.getY() <-100) {
                racerLaps[playerCharacterIndex]++;
                person.setY(height + 50);
                person.setX(50 + (playerCharacterIndex * 80));
            }
                
           textAlign(RIGHT); //set text alignment to the right
           int yPosition = 30; //y position for right side text
           int lineSpacing = 20; //spacing betweeen lines of text
           
            if(person.getZodiacAnimal() != null) { //if player zodiac animal exists
                fill(255); // White text
                //display character name
                text("Character: " + person.getZodiacAnimal().getZodiacType(), width - 10, yPosition);
                yPosition += lineSpacing; //move y position donw
            }
            //if player's special ability is active
            if (person.isAbilityActive()) {
                fill(0, 255, 0); // set color text to green when actice
                textAlign(RIGHT); //align text to the right
                text("ABILITY ACTIVE!", width - 10, yPosition); //set text to the top right corner
                yPosition += lineSpacing; //move y position down for next line
                
                ZodiacAnimal animal = person.getZodiacAnimal(); //get player's zdiac animal
                if (person.getZodiacAnimal() instanceof Pig) { // if player is using pig
                    text("Pig Power: Speed Boost!", width - 10, yPosition); //display pig ability message
                } else if(person.getZodiacAnimal() instanceof Rabbit) { //if player is using rabbit
                    text("Rabit Power: Quick Hop!", width - 10, yPosition); //display rabbit ability message
                } else if(person.getZodiacAnimal() instanceof Horse) { //if player is using hrose
                    text("Horse Power: Quick Gallop!", width - 10, yPosition); //display horse ability message
                } else if(person.getZodiacAnimal() instanceof Rooster) { //if player is using rooster
                    text("Rooster Power: Confidence boost!", width - 10, yPosition); //display rooster ability message
                } else if(person.getZodiacAnimal() instanceof Monkey) { //if player is using monkey
                    text("Monkey Power: Quick Swing", width - 10, yPosition); //display monkey ability message 
                } else if(person.getZodiacAnimal() instanceof Tiger) { //if player is using tiger
                    text("Tiger POwer: Quick Jump", width - 10, yPosition); //display tiger ability message
                } 
                yPosition += lineSpacing; //move y position down 
            //if ability is on cooldown
            } else if (person.getAbilityCooldown() > 0) {
                fill(255, 0, 0); // red text during cooldown
                textAlign(RIGHT); //align text to the right
                //display ability message
                text("Ability Cooldown: " + (person.getAbilityCooldown() / 60 + 1), width - 10, yPosition);
                yPosition += lineSpacing; //move y position down
            } else {
                fill(0); // white text
                //display how to use special ability
                text("Press SPACE for Special Ability", width - 10, yPosition);
                yPosition += lineSpacing; //move y position down
            }           
            //if race timer has finished
           if(raceTimer.isFinished()) {
               int maxLaps = 0; //variable to track highest lap count
               int winnerIndex = 0; //variable to track index of winner
               //loop through all racer's lap counts
               for(int i = 0; i < racerLaps.length; i++) {
               if(racerLaps[i] > maxLaps) { //if racer has more laps than the max
                   maxLaps = racerLaps[i]; //update max lap count
                   winnerIndex = i; //update winner index
               }
           }
               winner = getZodiacNames()[winnerIndex]; //set winner name based on winning racer's index
               raceFinished = true; //set race finished to true
               stage = 3; //move to the results stage
           }
        
           //if user is on stage 3
        } else if(stage == 3) {     
        String playerName; ///variable to store players name for scoreboard
        if (userInput.isEmpty()) { //if player didn't enter a name
            playerName = "Anonymous"; //use anonymous as default name
        } else {
            playerName = userInput; // use player's entered name
        }
        
        if(!scoreSaved) { //if score hasn't been saved yet
            int finalTime = 20; //time for scoreboard
            if (userInput.isEmpty()) { //if player didn't enter a name
                playerName = "Anonymous"; // use default name
            } else {
                playerName = userInput; // use player's entered name
            }
            
        //add player's score to high scores    
        addNewScore(playerName, racerLaps[playerCharacterIndex], finalTime);

            scoreSaved = true; //set score saved to tre
        }    
        
        textAlign(CENTER); //align text to center
        
        //if the winner is the player's character
        if(winner.equals(getZodiacNames()[playerCharacterIndex])) {
            //display winning message
            text("CONGRATULATIONS!", width/2, height/2 - 100);
            //display the victory with the chosen character
            text("You WON with " + winner + "!", width/2, height/2 - 50);
            fill(0); //set color text 
            text("VICTORY!", width/2, height/2); //display victory text
        } else {
            //if payer didn't win, display message that race was finished
            text("Race Finished!", width/2, height/2 - 100); 
            text("Winner: " + winner, width/2, height/2 - 50); //display winner
            fill(255, 0, 0); //set colro text
        }
            textAlign(LEFT); //set text alignment to the left
               fill(0); //set color text
               text("High Scores:", 20, height/2 + 50); //display high scores message
            
               //create copy of high scores list
            ArrayList<String> sortedScores = new ArrayList<String>(highScores);
            sortedScores.sort((a, b) -> { //sort score usign lambda function
                String[] partsA = a.split(","); //split first score string by commas
                String[] partsB = b.split(","); //split seconc score string by commans
                if(partsA.length >= 2 && partsB.length >= 2) { //if both scores have at least 2 parts, name and laps
                    int lapsA = Integer.parseInt(partsA[1]); //parse first score's lap count
                    int lapsB = Integer.parseInt(partsB[1]); //partse second score's lap count
                    return Integer.compare(lapsB, lapsA);  //compare lap counts in descending order
                }
                return 0; //return  if scores are invalid
            });
            //loop through first 5 scores
               for(int i = 0; i < Math.min(5, highScores.size()); i++) {
                   //split score string into parts
                   String[] parts = highScores.get(i).split(","); 
                   if(parts.length >= 3) { //if score has all required parts
                    //display score in a formatted way
                    text((i+1) + ". " + parts[0] + " - " + parts[1] + " laps in 20s", 20, height/2 + 80 + (i * 20));
                   }
               }               
            }
        
        }

    
    public void mousePressed() {
        if(stage == 1) { //if user is in stage one
            for (int i = 0; i < getZodiacNames().length; i++) { //loop through all zodiac characters
                int x = (i % 3) * 180 + 90; //calculate x position of character when choosing player
                int y = (i / 3) * 140 + 180; //calculate y position of character when choosing player
                //check if mouse click is withing character's area
                if (mouseX >= x && mouseX <= x + 120 && mouseY >= y - 40 && mouseY <= y + 40) {
                    playerCharacterIndex = i; //character index
                    allRacers = new Person[getZodiacNames().length]; //array to hold all racer objcts
                    int startY = height - 100; // y position for all racers
                    //loop through all zodiac characters to create racer objects
                    for (int j = 0; j < getZodiacNames().length; j++) {
                        int startX = 50 + (j * 80); //starting x position for each racer
                        //new person object with positon, name, and image
                        allRacers[j] = new Person(this, startX, startY, getZodiacNames()[j], zodiacImages[j]);
                    }
                    
                    person = allRacers[playerCharacterIndex]; //set player's character to their selected racer
                    stage = 2; //move to racing stage 
                    break;
                    
                }
            }

        }
    }
    
    public void keyPressed() {
        if(stage == 0) { //if stage is 0
            if(keyCode == ENTER) { //if enter key is pressed
                if(userInput.trim().length() > 0) { //if player has entered at least one character
                    stage = 1; //move to character selection
                }
            } else if(keyCode == BACKSPACE) { //if backspace key is pressed
                //handle backspace to delete characters
                if(userInput.length() > 0) {
                    //allows to remove characters from input string
                    userInput = userInput.substring(0, userInput.length() - 1); 
                }
                //if input is a regular character
            } else if(keyCode != CODED && key != '\n' && key != '\r') {
                if(userInput.length() < 20) { //if name hasn't reached a maximum length
                userInput += key; //add key to input string
                } 
           }
        } else if(stage == 2) { //if in racing stage
            if (key == ' ') //space key
                if(person != null) { //check character exists
                    person.activateSpecialAbility(); //activae player's special ability
                    person.getZodiacAnimal().specialMove(); //trigger special move
                }
        }
    }
    /**
     * A method that stores each animal's different sped that controls how fast they move in the race
     * @param animalName the name of the animal
     * @return the movement speed based on the animal
     */
    private float getAnimalSpeed(String animalName) {
        switch(animalName) { //switch statement based on animal name
            case "Horse": //if animal is horse
                return 2.2f; //return speed
            case "Tiger": //if animal is tiger
                return 2.5f; //return speed
            case "Rabbit": //if animal is rabbit
                return 2.0f; //return speed
            case "Monkey": //if animal is monkey
                return 1.8f; //return speed
            case "Rooster": //if animal is rooster
                return 1.5f; //return speed
            case "Pig": //if animal is pig
                return 1.0f; //return speed
            default: return 1.5f; //default speed   
        }
    }
    
    /**
     * Load high scores from a text file and stores them into the high scores list
     */
    public void loadScoresFromFile() {
        try {
            //Create a reader to read from the scores file
            BufferedReader reader = new BufferedReader(new FileReader(scoresFile));
            if(reader != null) { //if reader is sucessfully loaded
                String line; 
                while((line = reader.readLine()) != null) { //read each line from the file until the last line
                    highScores.add(line); //add each line to the list
                }
                reader.close(); 
                println("Scores loaded succesfully"); //print sucess message
            }
        } catch(IOException e) {
            println("Could not load scores from file"); //print error message
        }
    }
    
    /**
     * Writes each score to a new line in the file
     */    
    public void saveScoresToFile() {
        try {
            //Create a writer to wwrite to the file
            FileWriter writer = new FileWriter(scoresFile);
            for (String score : highScores) { //loop through all scores and write it to the file
                writer.write(score + "\n"); //write score in a newline
            }
            writer.close();
            println("Scores saved successfully!"); //print success message
        } catch (Exception e) {
            println("Error saving scores!"); //print error message
        }
    }
    
    /**
     * Adds a new score entry to the high score list
     * @param playerName the name of the player
     * @param lapsCompleted the number of laps the player completed
     * @param timeInSeconds the time scored by the player in seconds
     */
    public void addNewScore(String playerName, int lapsCompleted, int timeInSeconds) {
        //score variable to store a new score in a formatted way
        String newScore = playerName + "," + lapsCompleted + "," + timeInSeconds;
        highScores.add(newScore); //add the new score to the highscores list
        
        //Keep only top 10 scores
        if(highScores.size() > 10) {
            highScores.remove(highScores.size() - 1); //remove the lowest score
        }
        //Save score immediately after adding
        saveScoresToFile();
    }
    /**
     * retrieves an array of zodiac animal names from the animal trainer data
     * @return the array of zodiac animal names
     */
    private String[] getZodiacNames() {
        //array to store the names, with the same length as the animal trainer data
        String[] names = new String[animalTrainerData.length];
        for(int i = 0; i < animalTrainerData.length; i++) { //loop through each animal
            names[i] = animalTrainerData[i][0];  //first column is the zodiac animal name
        }
        //returns the array of zodiac names
        return names;
    }
    /**
     * retrieves an array of trainer names from the animalTrainer data
     * @return returns the array of trainer names
     */
    private String[] getTrainerNames() {
        //array to store trainer names
        String[] names = new String[animalTrainerData.length];
        //loop through each zodiac animal
        for(int i = 0; i < animalTrainerData.length; i++) {
            names[i] = animalTrainerData[i][1]; //second colum is the trainer name
        }
        //return the array of trainer names
        return names;
    }

}

