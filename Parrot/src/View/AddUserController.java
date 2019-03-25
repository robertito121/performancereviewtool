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
    private Button clearFormButton;
    
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

    /**
     * submits a new User into the application
     */
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

    /**
     * Clears the Form
     */
    @FXML
    public void clearForm() {
        firstNameText.clear();
        lastNameText.clear();
        userIDText.clear();
        passwordText.clear();
        departmentText.clear();
        roles.setValue(null);
    }

    /**
     * closes the AddUserView
     */
    @FXML
    public void exit() {
            Stage addStage = (Stage) cancelButton.getScene().getWindow();
            addStage.close();
    }
    
    public void passUserList(UserList passedList) {
        list = passedList;
    }

    public TextField getDepartmentText() {
        return departmentText;
    }

    public void setDepartmentText(TextField departmentText) {
        this.departmentText = departmentText;
    }

    public TextField getUserIDText() {
        return userIDText;
    }

    public void setUserIDText(TextField userIDText) {
        this.userIDText = userIDText;
    }

    public PasswordField getPasswordText() {
        return passwordText;
    }

    public void setPasswordText(PasswordField passwordText) {
        this.passwordText = passwordText;
    }

    public TextField getFirstNameText() {
        return firstNameText;
    }

    public void setFirstNameText(TextField firstNameText) {
        this.firstNameText = firstNameText;
    }

    public TextField getLastNameText() {
        return lastNameText;
    }

    public void setLastNameText(TextField lastNameText) {
        this.lastNameText = lastNameText;
    }

    public Button getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(Button submitButton) {
        this.submitButton = submitButton;
    }

    public Button getClearFormButton() {
        return clearFormButton;
    }

    public void setClearFormButton(Button clearFormButton) {
        this.clearFormButton = clearFormButton;
    }

    public Button getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(Button cancelButton) {
        this.cancelButton = cancelButton;
    }

    public ComboBox<String> getRoles() {
        return roles;
    }

    public void setRoles(ComboBox<String> roles) {
        this.roles = roles;
    }

    public UserList getList() {
        return list;
    }

    public void setList(UserList list) {
        this.list = list;
    }
}
