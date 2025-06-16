package javaapplication19;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author elena
 */
public class Timer2 {
    private int initialTime; //the initial time
    private int timeLeft; //the seconds remaining
    private boolean isRunning; //if timer is currently running
    private long lastUpdateTime; //the last update of time
    private boolean finished; //if timer has finished
    
    /**
     * Constructor
     * @param seconds the duration of the timer in seconds
     */
    public Timer2(int seconds) {
        this.initialTime = seconds; 
        this.timeLeft = seconds;
        this.isRunning = false;
        this.finished = false;
    }
    
    /**
     * starts the timer and records the current time
     */
    public void start() {
        isRunning = true; //sets running to true
        lastUpdateTime = System.currentTimeMillis(); //read the current time
    }
    
    /**
     * stops the timer
     */
    public void stop() {
        isRunning = false; //sets running to false
    }
    
    /**
     * resets the timer back to 0
     */
    public void reset() {
        timeLeft = initialTime; //restore full time
        finished = false; //set to false
        isRunning = false; //stop the timer
    }
    
    /**
     * updates the timer and decreases time every seconds if it's running
     */
    public void update() {
        if(isRunning && !finished) { //if timer is running and not finished
            long currentTime = System.currentTimeMillis(); //get current time
            long elapsedTime = currentTime - lastUpdateTime;  //calculate time    
            if (elapsedTime >= 1000) { //if 1 second has passed
                timeLeft--; //decrease time by 1 second
                lastUpdateTime = currentTime; //reset time
                
                if(timeLeft <= 0) { //it time has run out
                    finished = true; //mark time as finished
                    isRunning = false; //stop the timer
                }
            }
        }
               
    }
    /**
     * returns the amount of time left
     * @return returns time remaining in seconds
     */
    public int getTimeLeft() {
        return timeLeft;
    }
    
    /**
     * 
     * @return returns if timer has finished
     */
    public boolean isFinished() {
        return finished;
    }
    /**
     * 
     * @return returns true if running, otherwise false
     */
    public boolean isRunning() {
        return isRunning;
    }
    /**
     * 
     * @return returns a message if timer has finished
     */
    public String getTimeString() {
        if(finished) {
            return "Time's up!"; //message when finished
        }
        return "Time: " + timeLeft; //show remaining time
    }

}
    