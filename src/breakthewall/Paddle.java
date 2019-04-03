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
    public int playerX;
    public final int playerY;
    public final int width;
    public final int height;
    public int speed;
    public Color color; 
    public Paddle() {
        
        this.speed = 20;
        this.color = Color.red;
        this.width = 100;
        this.height = 8;
        
        int maxposX = GameConfig.width - borderwidth;
        int minposX = borderwidth;
        this.playerX = GameConfig.width/2 - width/2;
        this.playerY = 550;     //final variable can be initialized in constructor
        
    }
    void changespeed(int s) {
        this.speed = s;
    }
    
}
