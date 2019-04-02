/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakthewall;

import javax.swing.JFrame;

/**
 *
 * @author Aditya Sinha
 */
public class BreakTheWall implements GameConfig{

    /**
     * @param args the command line arguments
     */
    BreakTheWall() {
        JFrame obj = new JFrame();
        Gameplay gameplay = new Gameplay();
        obj.setBounds(windowX,windowY,width,height);
        obj.setTitle(gameTitle);
        obj.setResizable(false);
        obj.setVisible(true);
        //obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gameplay);
    }
    
}
