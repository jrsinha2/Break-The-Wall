/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakthewall;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Aditya Sinha
 */
public class Gameplay extends JPanel implements KeyListener,ActionListener,GameConfig{
    /**
     * Gameplay class extends JPanel class and implements interfaces
     * 1. KeyListener for pressing keys
     * 2. ActionListener for moving ball
      */
    
    /**
     * Private Properties
     * @param e 
     */
    
    private boolean play = false;
    private int score = 0;
    private int totalBricks = 21;  //7x3
    private Timer timer;
    private int delay = 8;
    
    private int playerX = 310;
    private final int playerY  = 550;
    
    
    private int ballposX = 120;
    private int ballposY = 350; 
    private int ballXdir = -1;
    private int ballYdir = -2;
    
    public Gameplay() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay,this);
        timer.start(); 
    }
    
    @Override
    public void paint(Graphics g) {
        //background
        g.setColor(Color.black);
        g.fillRect(1, 1, 692, 592); //starting x, starting y, width, height
        
        // borders
        g.setColor(Color.yellow);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0,0,692,3);
        g.fillRect(691,0,3,592);
        
        //paddle
        g.setColor(Color.green);
        g.fillRect(playerX,playerY,100,8);
        
        //ball
        g.setColor(Color.yellow);
        g.fillOval(ballposX,ballposY,20,20);
        
        g.dispose();
    }
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(playerX>=width - 100) {
                playerX = width - 100;
            } 
            else {
                moveRight();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(playerX<=windowX)
                playerX = windowX;
            else
            {
                moveLeft();
            }
        }    
    
    }
        
    public void moveRight() {
        play = true;
        playerX+=20; //move 20 pixels to right
    }
    
    public void moveLeft() {
        play = true;
        playerX-=20; //move 20 pixels to right
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        
        if(play) {
            //detecting collision b/w ball and paddle
            Rectangle ballrect = new Rectangle(ballposX,ballposY,20,20);
            Rectangle paddlerect = new Rectangle(playerX,playerY,100,8);
            if(ballrect.intersects(paddlerect))
                ballYdir = -ballYdir;
            
            
            ballposX+=ballXdir;
            ballposY+=ballYdir;
            
            //left border
            if(ballposX < 0) 
                ballXdir = -ballXdir;
            
            //left border
            if(ballposX > width - 20)  //20 is ball radius 
                ballXdir = -ballXdir;
            
            //top
            if(ballposY < 0) 
                ballYdir = -ballYdir;
        }
        repaint();
    }
        
}
