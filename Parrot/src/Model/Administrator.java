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
public class Administrator extends User {
    
    private String userName;
    private int userID;
    private UserCredentials userCredentials;
    private String department; //THIS IS GOING TO NEED TO BE CHANGED TO A DEPARTMENT OBJECT INSTEAD OF A STRING
    
    public Administrator(String inf_userName, int inf_userID, UserCredentials inf_userCredentials, String inf_department) {
        
        super(inf_userName, inf_userID, inf_userCredentials, inf_department);
    }
}
