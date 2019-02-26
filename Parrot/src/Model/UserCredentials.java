/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Group 2
 */
public class UserCredentials {
    
    private String userName;
    private String password;
    
    public UserCredentials(String inf_userName, String inf_password) {
        
        userName = inf_userName;
        password = inf_password;
    }
    
    public String getUserName() {
        
        return userName;
    }
    
    public String getPassword() {
        
        return password;
    }
}
