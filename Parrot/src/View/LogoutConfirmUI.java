/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Shane
 */
public class LogoutConfirmUI extends JFrame{
    
    private JPanel buttonPanel;
    private JPanel labelPanel;
    
    private JLabel confirmLabel;
    
    private JButton yes, no;
    public LogoutConfirmUI(){
        setUpFrame();
    }
    
    public void setUpFrame() {
        
        setSize(300, 140);
        setLocationRelativeTo(null);  // center the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        buttonPanel = new JPanel();
        
        yes = new JButton("Yes");
        buttonPanel.add(getYes());
        no = new JButton("No");
        buttonPanel.add(getNo());
        
        labelPanel = new JPanel();
        confirmLabel = new JLabel("Are you sure you want to Logout?");
        labelPanel.add(confirmLabel);
        
        setContentPane(new JPanel(new BorderLayout()));
        getContentPane().add(labelPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * @return the yes
     */
    public JButton getYes() {
        return yes;
    }

    /**
     * @return the no
     */
    public JButton getNo() {
        return no;
    }
}
