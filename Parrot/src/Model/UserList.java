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

import java.util.ArrayList;

public class UserList {
    
    private ArrayList userList;
    
    public UserList() {
    
        userList = new ArrayList();
        
    }
    
    //This class initilizes the userlist with some default data
    public void initializeList() {
        
        UserCredentials newCredentials = new UserCredentials("rgonzales", "password1");
        Administrator newUser = new Administrator("Roberto Gonzales", 1, newCredentials, "Admin");
        userList.add(newUser);
        
        newCredentials = new UserCredentials("jgill", "password2");
        newUser = new Administrator("Joey Gill", 2, newCredentials, "Admin");
        userList.add(newUser);
        
        newCredentials = new UserCredentials("shandelong", "password3");
        newUser = new Administrator("Stephen Handelong", 3, newCredentials, "Admin");
        userList.add(newUser);
        
       newCredentials = new UserCredentials("tgordon", "password4");
        newUser = new Administrator("Tommee Gordon", 4, newCredentials, "Admin");
        userList.add(newUser);
        
        newCredentials = new UserCredentials("sgill", "password5");
        newUser = new Administrator("Shane Gill", 5, newCredentials, "Admin");
        userList.add(newUser);
    
    }
    
    public ArrayList getUserList() {
        
        return userList;
    }
}
