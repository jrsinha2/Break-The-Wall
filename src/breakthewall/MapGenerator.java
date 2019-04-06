/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakthewall;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Aditya Sinha
 */
public class MapGenerator implements GameConfig{
    public int map[][];
    public int brickWidth;
    public int brickHeight;
    public int row,col; 
    public MapGenerator() {
        row = 8;
        col = 12;
        map = new int[row][col];
        for(int i =0;i<map.length;i++)
        {
            for(int j =0;j<map[0].length;j++)
            {
                map[i][j] = 1;
            }
        }
        brickWidth = (width - 2*borderwidth)/col;  //540 has to be changed to config value
        brickHeight = (height/4)/row;
        
    }
    public void draw(Graphics2D g) {
        for(int i =0;i<map.length;i++)
        {
            for(int j =0;j<map[0].length;j++)
            {   if(map[i][j]>0) {
                    g.setColor(Color.orange);
                    g.fillRoundRect(j*brickWidth + 3,i*brickHeight + 40 , brickWidth, brickHeight,4,brickHeight);
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRoundRect(j*brickWidth + 3,i*brickHeight + 40 , brickWidth, brickHeight,4,brickHeight); 
                }                
            }
        }
    }
    public void setBrickValue(int value,int row,int col) {
        map[row][col] = value;
    }
    public int getTotalBricks() {
        return row*col;
    }
}
