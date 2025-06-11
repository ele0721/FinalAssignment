
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author elena
 */
public class Timer2 {
   private Timer timer;
   private int timeLeft;
   private JLabel targetLabel;
   
   public Timer2(int seconds, JLabel label) {
       this.timeLeft = seconds;
       this.targetLabel = label;
       
       timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeLeft >= 0) {
                    targetLabel.setText("" + timeLeft);
                    timeLeft--;
                } if(timeLeft <= 0) {
                    targetLabel.setText("Time's up");
                    timer.stop();
                }
            }
        });
   }

   
   public void start() {
       timer.start();
   }
   
   public void stop() {
       timer.stop();
   }
   
   public int getTime() {
       return timeLeft;
   }
   
    public void transitionTimer(JFrame currentFrame, JFrame nextFrame){
        Timer transitionTime = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextFrame.setVisible(true);
                currentFrame.setVisible(false);
            }
        });
        transitionTime.setRepeats(false);
        transitionTime.start();
   }
   
}
