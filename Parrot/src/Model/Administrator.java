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
    
    public Administrator(String username, int userID, UserCredentials userCredentials, String department) {
        
        super(username, userID, userCredentials, department);
    }
}
