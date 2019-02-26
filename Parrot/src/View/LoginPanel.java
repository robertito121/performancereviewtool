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
import java.util.ArrayList;
import javax.swing.*; //import the necessary packages

public class LoginPanel extends JPanel {
    
    private JLabel userLabel;
    private JLabel pwLabel;
    private JLabel loginErrorLabel;
    private JTextField userText; //This is the field the user will enter their username in
    private JPasswordField pwText; //This is the field the user will enter their password in
    private JButton loginButton;
    private JButton cancelButton;
    
    public LoginPanel() {
    
        super();
        
        setLayout(new GridLayout(4,2,5,5));
        
        userLabel = new JLabel("Username: ");
        pwLabel = new JLabel("Password: ");
        loginErrorLabel = new JLabel();
        loginButton = new JButton("Login");
        cancelButton = new JButton("Cancel");
        userText = new JTextField();
        pwText = new JPasswordField();
        
        
        //Add each of the labels, fields, and buttons to the panel
        add(userLabel);
        add(userText);
        add(pwLabel);
        add(pwText);
        add(loginButton);
        add(cancelButton);
        add(loginErrorLabel);
        
        
        
    }
    
    public JTextField getUserText() {
        
        return userText;
    }
    
    public JPasswordField getPwText() {
        
        return pwText;
    }
    
    public JButton getLoginButton() {
        
        return loginButton;
    }
    
    public JButton getCancelButton() {
        
        return cancelButton;
    }
    
    public JLabel getLoginErrorLabel() {
        
        return loginErrorLabel;
    }
}
