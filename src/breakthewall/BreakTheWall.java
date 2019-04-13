/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakthewall;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
        
        System.out.println("New GameWindow Created");
        JFrame obj = new JFrame();
        Gameplay gameplay = new Gameplay();
        obj.setBounds(windowX,windowY,width,height);
        obj.setLocation(250, 50);
        obj.setTitle(gameTitle);
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        obj.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Gameplay.noGameWindow--;
                System.out.println("Game Window Destroyed");
                obj.dispose();
            }
        });
        obj.add(gameplay);
        
        /*if(!gameplay.getStatus())
            obj.setVisible(false);
        else
            obj.setVisible(true);
        */
    }
    
    
}
