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
public class User {
    
    private String userName;
    private int userID;
    private UserCredentials userCredentials;
    private String department; //THIS IS EVENTUALLY GOING TO NEED TO BE CHANGED TO A DEPARTMENT OBJECT INSTEAD OF A STRING
    
    public User(String inf_userName, int inf_userID, UserCredentials inf_userCredentials, String inf_department) {
        
        userName = inf_userName;
        userID = inf_userID;
        userCredentials = inf_userCredentials;
        department = inf_department;
    }
    
    public UserCredentials getUserCredentials() {
        
        return userCredentials;
    }
    
    public int getUserID() {
        
        return userID;
    }
}
