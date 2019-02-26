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

public class LoginController {
    
    private LoginScreen loginScreen;
    private UserList userList;    
    private User activeUser;
    private UserCredentials activeCredentials;
    
    public LoginController() {
        
        loginScreen = new LoginScreen();
        
    }
    
}
