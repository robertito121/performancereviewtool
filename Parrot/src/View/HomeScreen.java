/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Group 2
 */
public class HomeScreen extends JPanel {
     private GridBagLayout gbl;
    private GridBagConstraints gbc;
    private JPanel mainPanel;
    private JPanel welcomePanel;
    private JPanel buttonPanel;
    private JButton employeeButton;
    private JButton managerButton;
    private JButton adminButton;
    private JButton logoutButton;
    
    public HomeScreen(){
        // Set Layout
        gbl = new GridBagLayout();
        this.setLayout(gbl);
        gbc = new GridBagConstraints();
        
         // Displays Employee Button
        employeeButton = new JButton("Employee Records");
        gbc.gridy = 1;
        add(employeeButton, gbc);
        
         // Filler Space
        JLabel empty = new JLabel(" ");
        gbc.gridy = 2;
        this.add(empty, gbc);
        
        // Displays Manager Button
        managerButton = new JButton("Manager Records");
       
        gbc.gridy = 3;
        add(managerButton, gbc);
        
         // Filler Space
        JLabel empty2 = new JLabel(" ");
        gbc.gridy = 4;
        this.add(empty2, gbc);
        
         // Displays Administrator Button
        adminButton = new JButton("Administrator Records");
        gbc.gridy = 5;
        add(adminButton, gbc);
        
        // Filler Space
        JLabel empty3 = new JLabel(" ");
        gbc.gridy = 6;
        this.add(empty3, gbc);
        
         // Displays Logout Button
        logoutButton = new JButton("Log Out");
        gbc.gridy = 7;
        add(logoutButton, gbc);
    
    }
     public JPanel getMainPanel()
    {
        return mainPanel;
    }
     /**
     * @param mainPanel the mainPanel to set
     */
    public void setMainPanel(JPanel mainPanel)
    {
        this.mainPanel = mainPanel;
    }
     /**
     * @return the welcomePanel
     */
    public JPanel getWelcomePanel()
    {
        return welcomePanel;
    }
     /**
     * @param welcomePanel the welcomePanel to set
     */
    public void setWelcomePanel(JPanel welcomePanel)
    {
        this.welcomePanel = welcomePanel;
    }
     public JPanel getButtonPanel()
    {
        return buttonPanel;
    }
      /**
     * @param buttonPanel the buttonPanel to set
     */
    public void setButtonPanel(JPanel buttonPanel)
    {
        this.buttonPanel = buttonPanel;
    }
     /**
     * @return the employeeButton
     */
    public JButton getEmployeeButton()
    {
        return employeeButton;
    }
    /**
     * @param employeeButton the employeeButton to set
     */
    public void setEmployeeButton(JButton employeeButton)
    {
        this.employeeButton = employeeButton;
    }
    /**
     * @return the managerButton
     */
    public JButton getManagerButton()
    {
        return managerButton;
    }
     /**
     * @param managerButton the managerButton to set
     */
    public void setManagerButton(JButton managerButton)
    {
        this.managerButton = managerButton;
    }
     /**
     * @return the adminButton
     */
    public JButton getAdminButton()
    {
        return adminButton;
    }
     /**
     * @param adminButton the adminButton to set
     */
    public void setAdminButton(JButton adminButton)
    {
        this.adminButton = adminButton;
    }
    /**
     * @return the logoutButton
     */
    public JButton getLogoutButton()
    {
        return logoutButton;
    }
     /**
     * @param logoutButton the logoutButton to set
     */
    public void setLogoutButton(JButton logoutButton)
    {
        this.logoutButton = logoutButton;
    }

}
