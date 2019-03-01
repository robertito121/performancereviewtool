/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.HomeScreen;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

/**
 *
 * @author Group 2
 */
public class HomeController {
    private HomeScreen screen;
    private JFrame frame;
    
    public HomeController(){
         screen = new HomeScreen();
        // Display
        frame = new JFrame();
        frame.add(screen);
        frame.setVisible(true);
        frame.setSize(740, 520);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
         this.screen.getLogoutButton().addActionListener((ActionEvent event) ->
        {
            logoutPressed();
        });
    }
     /**
     * Handles the button press to switch to the login view
     */
    private void logoutPressed()
    {
        LoginController loginController = new LoginController();
        screen.setVisible(false);
        frame.dispose();
    }
    
}
