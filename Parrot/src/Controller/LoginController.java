/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Group 2
 */

import Model.UserList;
import Model.User;
import Model.UserCredentials;
import View.LoginScreen;
// import View.LoginUI;
// import javax.swing.JFrame;

public class LoginController {
    
    private LoginScreen loginScreen;
    private UserList userList;    
    private User activeUser;
    private UserCredentials activeCredentials;
    
    // private LoginUI view;
    // private JFrame frame;
    // private String userName;
    // private String password;
    
    public LoginController() {
        
        loginScreen = new LoginScreen();
        
        // view = new LoginUI();
        // Display
        // frame = new JFrame();
        // frame.add(view);
        // frame.setVisible(true);
        // frame.setSize(740, 520);
        // frame.setLocationRelativeTo(null);
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
