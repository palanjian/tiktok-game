package org.example;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotHandler {

    public Robot robot;
    public RobotHandler(){
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void handleInput(String string){
        switch(string){
            case "up" -> robot.keyPress(KeyEvent.VK_W);
            case "down" -> robot.keyPress(KeyEvent.VK_S);
            case "left" -> robot.keyPress(KeyEvent.VK_A);
            case "right" -> robot.keyPress(KeyEvent.VK_D);

        }
    }

}
