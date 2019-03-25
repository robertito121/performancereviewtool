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
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

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
    private TextField userNameText;

    @FXML
    private TextField firstNameText;    
 
    @FXML
    private TextField lastNameText;     
    
    @FXML
    private RadioButton employeeRadio;
    
    @FXML
    private RadioButton managerRadio;
    
    @FXML
    private RadioButton administratorRadio;
    
    @FXML
    private Button submitButton;
    
    @FXML
    private Button cancelButton;
    
    private ToggleGroup group;
    
    private UserList list;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        group = new ToggleGroup();
        employeeRadio.setToggleGroup(group);
        managerRadio.setToggleGroup(group);
        administratorRadio.setToggleGroup(group);
        employeeRadio.setSelected(true);
    }    
    
    
    @FXML
    public void submit() {
        String role = "";
        if (employeeRadio.isPressed()== true )
        {
            role = "Employee";
        }
        if (managerRadio.isPressed() == true)
        {
            role = "Manager";
        }
        if (administratorRadio.isPressed() == true)
        {
            role = "Administrator";
        }
        
        UserCredentials newCredentials = new UserCredentials(userNameText.getText(), passwordText.getText());
        User newUser = new User(firstNameText.getText(), lastNameText.getText(), userIDText.getText(), role, newCredentials);
        list.addUser(newUser);
        exit();
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
