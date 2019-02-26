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
import javax.swing.*;
import java.awt.event.*;

public class LoginController implements ActionListener {
   
    private LoginScreen loginScreen;
    private UserList userList;    
    private int activeUserID;
    private UserCredentials activeCredentials;
    private JTextField userText;
    private JPasswordField passwordText;
    private JButton loginButton;
    private JButton cancelButton;
    private JLabel loginErrorLabel;
    private String enteredUser;
    private String enteredPassword;
    
    /*
    private LoginUI view;
    private JFrame frame;
    private String userName;
    private String password;
    */
    
    public LoginController() {
        
        loginScreen = new LoginScreen();
       
        userText = loginScreen.getLoginFrame().getLoginPanel().getUserText();
        passwordText = loginScreen.getLoginFrame().getLoginPanel().getPwText();
        loginButton = loginScreen.getLoginFrame().getLoginPanel().getLoginButton();
        cancelButton = loginScreen.getLoginFrame().getLoginPanel().getCancelButton();
        loginErrorLabel = loginScreen.getLoginFrame().getLoginPanel().getLoginErrorLabel();
        
        loginButton.addActionListener(this);
        cancelButton.addActionListener(this);
        
        userList = new UserList();
        userList.initializeList(); //This initializes the userlist with some default data
        
        
        
        /*
        
        This was tommee's code for the LoginUI class. However, sticking with the LoginScreen class as that's what's in the UML
        view = new LoginUI();
        //Display
        frame = new JFrame();
        frame.add(view);
        frame.setVisible(true);
        frame.setSize(740, 520);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        */
        
    }
    /*
    All of the actions related to buttons and fields will go here
    */
    
    public void actionPerformed(ActionEvent event) {
        
        Object obj = event.getSource();
    
        //This is the cancel button on the login screen. Clicking cancel exits the application.
        if(obj == cancelButton) {
            
            System.exit(0);
                        
        }
        
        /*
        This is the login button on the login screen. Clicking login compares the entered username and password to
        the username and password to each user in the userlist. If it matches it closes the login screen and opens
        the home screen.
        */
        if(obj == loginButton) {
            
            activeUserID = this.Authenticate();
            if(activeUserID == 0) {
                
               loginErrorLabel.setText("Incorrect login info!"); 
            }
            
            else {
                
                loginErrorLabel.setText(Integer.toString(activeUserID));
            }
        }
    }
    
    /*
    The authenticate method compares the entered credentials to all of the credentials in the user list.
    If the entered credentials match the credentials of a user in the user list, the method returns
    the user ID of that user. Otherwise, the method returns 0.
    */
    public int Authenticate() {
        
        enteredUser = userText.getText();
        enteredPassword = passwordText.getText();
        
        int ulSize = userList.getUserList().size();
        int i;
        User testUser;
        for(i = 0; i < ulSize; i++) {
            
            testUser = (User) userList.getUserList().get(i);
            if (enteredUser.equals(testUser.getUserCredentials().getUserName())) {
                
                if(enteredPassword.equals(testUser.getUserCredentials().getPassword())) {
                    
                    return testUser.getUserID();
                }
                
            }
        }
        return 0;
    }
    
    
}
