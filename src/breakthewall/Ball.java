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
public class Ball implements GameConfig{
    public int ballposX;
    public int ballposY; 
    public static int ballXdir = -2;
    public static int ballYdir = -4;
    public int radius;
    public Color color;
    public static int noBalls = 1;
    
    public Ball() {
        //graphics
        this.radius = 20;
        this.color = Color.white;
        
        //config
        int maxposX = GameConfig.width - borderwidth - 2*this.radius;
        int minposX = borderwidth + 2*this.radius;
        int minposY = (GameConfig.height/2) + 2*this.radius;
        final int maxposY = 500 - 2*radius;
        
        
        this.ballposX = (int) (Math.random()*(maxposX-minposX) + minposX);
        this.ballposY = (int) (Math.random()*(maxposY - minposY) + minposY);
        
    }
    public static int getNoBalls() {
        return noBalls;
    }
    public static void setNoBalls(int b) {
        noBalls = b;
    }
    public static void resetSpeed() {
        ballXdir = -2;
        ballYdir = -4;
    }
    public static void setSpeed(int x,int y) {
        ballXdir = x;
        ballYdir = y;
    }
    public static int[] getSpeed() {
        int speed[] = new int[2];
        speed[0] = ballXdir;
        speed[1] = ballYdir;
        return speed;
    } 
    public static void changeLevel(int l) {
        ballXdir *= l;
        ballYdir *= l;
    }
    public void reverseY() {
        ballYdir *= -1;
    }
    public void reverseX() {
        ballXdir *= -1;
    }
}
