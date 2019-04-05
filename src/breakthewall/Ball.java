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
    public int ballXdir;
    public int ballYdir;
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
        this.ballYdir = -2;
        this.ballXdir = -1;
        
        this.ballposX = (int) (Math.random()*(maxposX-minposX) + minposX);
        this.ballposY = (int) (Math.random()*(maxposY - minposY) + minposY);
        
    }
    public static int getNoBalls() {
        return noBalls;
    }
    public static void setNoBalls(int b) {
        noBalls = b;
    }
    
    
}
