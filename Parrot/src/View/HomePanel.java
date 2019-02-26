/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Group 2
 */
import java.awt.*; 
import javax.swing.*; //import the necessary packages


public class HomePanel extends JPanel {
    
    private JLabel label;
    
    public HomePanel() {
        
        label = new JLabel("This Is The HomeScreen");
        
        add(label);
    }
    
}
