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
public class BreakTheWall {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /**
         * Creating Frame for Game
         */
        JFrame obj = new JFrame();
        obj.setBounds(10,10,700,600);
        obj.setTitle("Break-The-Wall");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Gameplay gameplay = new Gameplay();
        obj.add(gameplay);
    }
    
}
