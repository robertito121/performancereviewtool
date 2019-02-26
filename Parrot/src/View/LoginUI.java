/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Tommee
 */
public class LoginUI extends JPanel{
    
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    private JPanel loginPanel;
    private JTextField userNameField;
    private JPasswordField passwordField;
    private JLabel userNameLabel;
    private JLabel passwordLabel;
    private JLabel errorLabel;
    private JLabel logo;
    private JButton loginButton;
    private ImageIcon logoPic;
    private BufferedImage bg;
    
    
    public LoginUI(){
        
         // Set Layout
        gbl = new GridBagLayout();
        this.setLayout(gbl);
        gbc = new GridBagConstraints();
        
        
        
         // Generate Text Fields
        userNameField = new JTextField("user");
        userNameField.setPreferredSize(new Dimension(100, 25));
        userNameLabel = new JLabel("UserName:");
        passwordField = new JPasswordField("password");
        passwordField.setPreferredSize(new Dimension(100, 25));
        passwordLabel = new JLabel("Password:");
        
        gbc.gridy = 1;
        this.add(userNameLabel, gbc);
        gbc.gridy = 2;
        this.add(userNameField, gbc);
        gbc.gridy = 3;
        this.add(passwordLabel, gbc);
        gbc.gridy = 4;
        this.add(passwordField, gbc);
        
         //Display Text Fields
        gbc.gridy = 1;
        this.add(userNameLabel, gbc);
        gbc.gridy = 2;
        this.add(userNameField, gbc);
        gbc.gridy = 3;
        this.add(passwordLabel, gbc);
        gbc.gridy = 4;
        this.add(passwordField, gbc);
        
         // Filler Space
        JLabel empty = new JLabel(" ");
        gbc.gridy = 5;
        this.add(empty, gbc);
        
         // Displays Login Button
        loginButton = new JButton("Login");
        gbc.gridy = 6;
        add(loginButton, gbc);
    
}
    
    public JPanel getLoginPanel()
    {
        return loginPanel;
    }

    /**
     */
    public void setLoginPanel(JPanel loginPanel)
    {
        this.loginPanel = loginPanel;
    }
     /**
     * @return the userNameField
     */
    public JTextField getUserNameField()
    {
        return userNameField;
    }
    /**
     * @param userNameField the userNameField to set
     */
    public void setUserNameField(JTextField userNameField)
    {
        this.userNameField = userNameField;
    }
    /**
     * @return the passwordField
     */
    public JPasswordField getPasswordField()
    {
        return passwordField;
    }
     /**
     * @param passwordField the passwordField to set
     */
    public void setPasswordField(JPasswordField passwordField)
    {
        this.passwordField = passwordField;
    }

    /**
     * @return the userNameLabel
     */
    public JLabel getUserNameLabel()
    {
        return userNameLabel;
    }
    /**
     * @param userNameLabel the userNameLabel to set
     */
    public void setUserNameLabel(JLabel userNameLabel)
    {
        this.userNameLabel = userNameLabel;
    }
     /**
     * @param passwordLabel the passwordLabel to set
     */
    public void setPasswordLabel(JLabel passwordLabel)
    {
        this.passwordLabel = passwordLabel;
    }
    
    /**
     * @return the errorLabel
     */
    public JLabel getErrorLabel()
    {
        return errorLabel;
    }
    
    /**
     * @param errorLabel the errorLabel to set
     */
    public void setErrorLabel(JLabel errorLabel)
    {
        this.errorLabel = errorLabel;
    }
    /**
     * @return the loginButton
     */
    public JButton getLoginButton()
    {
        return loginButton;
    }
     /**
     * @param loginButton the loginButton to set
     */
    public void setLoginButton(JButton loginButton)
    {
        this.loginButton = loginButton;
    }

}
