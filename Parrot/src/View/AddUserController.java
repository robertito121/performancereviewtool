/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.User;
import Model.UserList;
import Model.UserCredentials;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Group 2
 */
public class AddUserController implements Initializable {

    @FXML
    private TextField departmentText;
    
    @FXML
    private TextField userIDText;
    
    @FXML
    private PasswordField passwordText;    

    @FXML
    private TextField firstNameText;    
 
    @FXML
    private TextField lastNameText;     

    @FXML
    private Button submitButton;
    
    @FXML
    private Button cancelButton;

    @FXML
    private ComboBox<String> roles;

    private UserList list;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //add items to combobox
        roles.getItems().addAll("Employee", "Manager", "Administrator");
    }    
    
    
    @FXML
    public void submit() {

        //get user information
        String firstname = firstNameText.getText();
        String lastname = lastNameText.getText();
        String userID = userIDText.getText();
        String password = passwordText.getText();
        String department = departmentText.getText();
        String role = roles.getValue();

        //build User Object
        UserCredentials newCredentials = new UserCredentials(userID, password);
        User newUser = new User(firstname, lastname, userID, role, department, newCredentials);

        //add User to table




    }
    
    @FXML
    public void exit() {
            Stage addStage = (Stage) cancelButton.getScene().getWindow();
            addStage.close();
    }
    
    public void passUserList(UserList passedList) {
        list = passedList;
    }
}
