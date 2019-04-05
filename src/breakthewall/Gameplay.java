/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakthewall;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
    private boolean pause = false;
    private int score = 0;
    private int totalBricks = 150;  //7x3
    private Timer timer;
    private int delay = 8;
    
    private Paddle paddle;
    private Ball ball;
    private MapGenerator map;
    
    public Gameplay() {
        map = new MapGenerator();
        totalBricks = map.getTotalBricks();
        paddle = new Paddle();
        ball = new Ball();
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
        g.fillRect(0, 0, width,height); //starting x, starting y, width, height
        
        
        //drawing map
        map.draw((Graphics2D)g);
        
        // borders
        g.setColor(Color.yellow);
        g.fillRect(leftborderX,leftborderY, borderwidth, height);   //width of border 3 left
        g.fillRect(topborderX,topborderY,width,borderwidth);   //top
        g.fillRect(rightborderX,rightborderY,borderwidth,height);  //right
        
        //scores
        g.setColor(Color.white);
        g.setFont(new Font("serif",Font.BOLD,25));
        g.drawString(""+score, 590, 30);  //x = 590 y  =30

        //paddle
        
        g.setColor(paddle.color);
        g.fillRoundRect(paddle.playerX,paddle.playerY,paddle.width,paddle.height,10,paddle.height);
        
        //ball
        g.setColor(ball.color);
        g.fillOval(ball.ballposX,ball.ballposY,ball.radius,ball.radius);
        
        if(totalBricks<=0) {
            play = false;
            ball.ballXdir = 0;
            ball.ballYdir = 0;
            
            g.setColor(Color.red);
            g.setFont(new Font("serif",Font.BOLD,30));
            g.drawString("You Won, Score: "+score, 190, 300);  //x = 590 y  =30
        
            g.setFont(new Font("serif",Font.BOLD,30));
            g.drawString("Press Enter to Restart",190,350);
        }
        if(ball.ballposY>paddle.playerY + paddle.height) {
            play = false;
            ball.ballXdir = 0;
            ball.ballYdir = 0;
            g.setColor(Color.red);
            g.setFont(new Font("serif",Font.BOLD,30));
            g.drawString("Game Over, Score: "+score, 190, 300);  //x = 590 y  =30
        
            g.setFont(new Font("serif",Font.BOLD,30));
            g.drawString("Press Enter to Restart",190,350);
        }
        if(pause)
        {   g.setColor(Color.red);
            g.setFont(new Font("sans",Font.BOLD,30));
            g.drawString("Press Esc key to Resume",190,350);
        }
        g.dispose();
    }
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT && !pause) {
            if(paddle.playerX>=width - 100) {
                paddle.playerX = width - 100;
            } 
            else {
                moveRight();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT && !pause) {
            if(paddle.playerX<=windowX)
                paddle.playerX = windowX;
            else
            {
                moveLeft();
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_UP) {
            if(Paddle.getMovement() == true && !pause) {
                if(paddle.playerY <= paddle.minlimitposY) {
                    paddle.playerY = paddle.minlimitposY;
                }
                else
                    moveUp();
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN && !pause) {
            if(Paddle.getMovement() == true) {
                if(paddle.playerY >= paddle.maxlimitposY) {
                    paddle.playerY = paddle.maxlimitposY;
                }
                else
                    moveDown();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            if(!play){
                play  =true;
                ball = new Ball();
                score = 0;
                paddle = new Paddle();
                map = new MapGenerator();
                totalBricks = map.getTotalBricks();  //7x3
                repaint();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if(!pause)
            {   pause = true;
                play = false;
            }
            else
            {   play = true;
                pause = false;
            }
        }
    
    }
        
    public void moveRight() {
        play = true;
        paddle.playerX+=paddle.speed; //move 20 pixels to right
    }
    
    public void moveLeft() {
        play = true;
        paddle.playerX-=paddle.speed; //move 20 pixels to right
    }
    
    public void moveUp() {
        play = true;
        paddle.playerY-=paddle.speed; //move 20 pixels to up
    }
    
    public void moveDown() {
        play = true;
        paddle.playerY+=paddle.speed; //move 20 pixels to up
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        
        if(play) {
            
            //detecting collision b/w ball and paddle
            Rectangle ballrect = new Rectangle(ball.ballposX,ball.ballposY,ball.radius,ball.radius);
            Rectangle paddlerect = new Rectangle(paddle.playerX,paddle.playerY,paddle.width,paddle.height);
            if(ballrect.intersects(paddlerect))
                ball.ballYdir = -ball.ballYdir;
            
            A: for(int i =0;i<map.map.length;i++)
            {
                for(int j =0 ;j<map.map[0].length;j++) {
                    if(map.map[i][j]>0){
                        int brickX = j*map.brickWidth + 3;
                        int brickY = i*map.brickHeight + 40;
                        int brickWidth = map.brickWidth;
                        int brickHeight = map.brickHeight;
                        Rectangle rect = new Rectangle(brickX,brickY,brickWidth,brickHeight);
                        Rectangle ballrecta  = new Rectangle(ball.ballposX,ball.ballposY,20,20);
                        Rectangle brickrect = rect;
                        if(ballrecta.intersects(brickrect)) {
                            map.setBrickValue(0, i, j);
                            totalBricks--;
                            score+=1;
                        
                            if(ball.ballposX + 19 <= brickrect.x || ball.ballposX+1>=brickrect.x+brickrect.width ){
                                ball.ballXdir*=-1; 
                            }
                            else
                                ball.ballYdir*=-1;
                            break A;
                        }
                    }
                }
            }
            
            ball.ballposX+=ball.ballXdir;
            ball.ballposY+=ball.ballYdir;
            
            //left border
            if(ball.ballposX < 0) 
                ball.ballXdir = -ball.ballXdir;
            
            //left border
            if(ball.ballposX > width - 20)  //20 is ball radius 
                ball.ballXdir = -ball.ballXdir;
            
            //top
            if(ball.ballposY < 0) 
                ball.ballYdir = -ball.ballYdir;
        }
        repaint();
    }
        
}
