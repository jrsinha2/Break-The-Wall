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
    private int ballposX;
    private int ballposY; 
    private int ballXdir;
    private int ballYdir;
    private int radius;
    Color color;
    
    public Ball() {
        int maxposX = width - borderwidth;
        int minposX = borderwidth;
        int maxposY = (height/2);
        final int minposY = 550;
        this.ballYdir = -2;
        this.ballXdir = -1;
        
        this.ballposX = (int) (Math.random()*(maxposX-minposX) + 1);
        this.ballposY = (int) (Math.random()*(maxposY - minposY) + 1);
        
    
        //graphics
        this.radius = 20;
        color = Color.yellow;
        
    }
    
    
}
