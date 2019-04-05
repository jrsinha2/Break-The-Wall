/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakthewall;

import java.awt.Color;



/**
 *
 * @author Aditya Sinha
 */
public class Paddle implements GameConfig{
    public static boolean movement = false;  // false- horizontal true-horizontal-vertical
    public int playerX;
    public int playerY;
    public int minlimitposY;
    public int maxlimitposY;
    public final int width;
    public final int height;
    public static int speed = 10;
    public Color color; 
    public Paddle() {
        this.color = Color.red;
        this.width = 100;
        this.height = 15;
        this.minlimitposY = (GameConfig.height/2) + 2*this.height;
        this.maxlimitposY = 550;
        
        int maxposX = GameConfig.width - borderwidth;
        int minposX = borderwidth;
        this.playerX = GameConfig.width/2 - width/2;
        this.playerY = 550;     //final variable can be initialized in constructor
        
    }
    public static void setSpeed(int s) {
        speed = s;
    }
    public static void setMovement(boolean b) {
        movement = b;
    }
    public static int getSpeed() {
        return speed;
    }
    public static boolean getMovement() {
        return movement;
    }
    
}
