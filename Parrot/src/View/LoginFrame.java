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

import javax.swing.*; //import necessary packages

public class LoginFrame extends JFrame { //extend the JFrame class
    
    private LoginPanel lp; //lp is the panel for the LoginScreen
    
    public LoginFrame() {
        
        super("Parrot Login");
        lp = new LoginPanel();
        this.getContentPane().add(lp);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 150);
        setVisible(true);
    }
    
    public LoginPanel getLoginPanel() {
        
        return lp;
    }
}
