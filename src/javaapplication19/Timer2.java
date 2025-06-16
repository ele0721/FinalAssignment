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
    private int initialTime;
    private int timeLeft;
    private boolean isRunning;
    private long lastUpdateTime;
    private boolean finished;
    
    public Timer2(int seconds) {
        this.initialTime = seconds;
        this.timeLeft = seconds;
        this.isRunning = false;
        this.finished = false;
    }
    
    public void start() {
        isRunning = true;
        lastUpdateTime = System.currentTimeMillis();
    }
    
    public void stop() {
        isRunning = false;
    }
    
    public void reset() {
        timeLeft = initialTime;
        finished = false;
        isRunning = false;
    }
    
    public void update() {
        if(isRunning && !finished) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - lastUpdateTime;        
            if (elapsedTime >= 1000) {
                timeLeft--;
                lastUpdateTime = currentTime;
            
                if(timeLeft <= 0) {
                    finished = true;
                    isRunning = false;
                }
            }
        }
               
    }
    
    public int getTimeLeft() {
        return timeLeft;
    }
    
    public boolean isFinished() {
        return finished;
    }
    
    public boolean isRunning() {
        return isRunning;
    }
    
    public String getTimeString() {
        if(finished) {
            return "Time's up!";
        }
        return "Time: " + timeLeft;
    }

}
    