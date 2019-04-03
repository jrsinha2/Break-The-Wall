/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakthewall;



/**
 *
 * @author Aditya Sinha
 */
public class Paddle implements GameConfig{
    private int playerX;
    private final int playerY;
    private int speed;
    public Paddle() {
        int maxposX = width - borderwidth;
        int minposX = borderwidth;
        this.playerX = (int) (Math.random()*(maxposX - minposX));
        this.playerY = 550;     //final variable can be initialized in constructor
        speed = 20;
    }
    void changespeed(int s) {
        this.speed = s;
    }
}
