/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.User;
import Model.UserList;
import Model.UserCredentials;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
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

    private String currentUserID;

    private HomeController homeController;

    private ManageUsersController manageUsersController;
    
    private String firstname;
    private String lastname;
    private String userID;
    private String password;
    private String department;
    private String role;
    
    /**
     * Initializes the controller class and all of its elements
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //add items to combobox
        roles.getItems().addAll("Employee", "Manager", "Administrator");
        list = new UserList();
    }

    /**
     * Submits a new User into the TableViews and Database
     * @throws IOException
     */
    @FXML
    public void submit() throws IOException {

        //get user information and make sure there are no empty fields
        if (!firstNameText.getText().equals("")) {
            firstname = firstNameText.getText();
        } else {
            Warning();
            return;
        }
        if (!lastNameText.getText().equals("")) {
            lastname = lastNameText.getText();
        } else {
            Warning();
            return;
        }
        if (!userIDText.getText().equals("")) {
            userID = userIDText.getText();
        } else {
            Warning();
            return;
        }
        if (!passwordText.getText().equals("")) {
            password = passwordText.getText();
        } else {
            Warning();
            return;
        }
        if (!departmentText.getText().equals("")) {
            department = departmentText.getText();
        } else {
            Warning();
            return;
        }
        if (roles.getSelectionModel().getSelectedIndex() != -1) {
            role = roles.getValue();
        } else {
            Warning();
            return;
        }

        //build User Object
        UserCredentials newCredentials = new UserCredentials(userID, password);
        User newUser = new User(firstname, lastname, userID, role, department, newCredentials);

        //Make sure no duplicate UserIDs exist
        for (int i = 0; i < list.getUserList().size(); i++) {
            if (newUser.getUserId().equals(list.getUserList().get(i).getUserId())) {
                Alert alert = new Alert(AlertType.ERROR,
                        "UserID already exists.",
                        ButtonType.OK);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    return;
                }
            }
        }

        //add User to database and TableViews
        list.getUserList().add(newUser);
        list.writeUserListFile();
        homeController.addUser(newUser);
        manageUsersController.addUser(newUser);

    }

    /**
     * Helper method to show a Warning if all the User information
     * has not been entered into the AddUser Form
     * @throws IOException
     */
    public void Warning() throws IOException {
        Alert alert = new Alert(AlertType.WARNING,
                    "Not all fields entered. Re-try?",
                    ButtonType.YES, ButtonType.NO);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.YES) {
            } else {
                exit();
            }
    }

    /**
     * Exits the AddUserView by hitting the cancel button
     * @throws IOException
     */
    @FXML
    public void exit() throws IOException {
        Stage addStage = (Stage) cancelButton.getScene().getWindow();
        addStage.close();
    }

    public void passUserList(UserList passedList) {
        list = passedList;
    }

    /**
     * Get current user with ID from HomeController
     * @return User
     */
    public User getUser() {
        String username = currentUserID;
        User user = null;

        for (int i = 0; i < list.getUserList().size(); i++) {
            if (username.equals(list.getUserList().get(i).getUserCredentials().getUserName())) {
                user = list.getUserList().get(i);
                break;
            }
            else {
                user = null;
            }
        }
        return user;
    }

    /**
     * Sets the HomeController field
     * @param homeController
     */
    public void setHomeController(HomeController homeController) {
        this.homeController = homeController;
    }

    /**
     * @return the currentUserID
     */
    public String getCurrentUserID() {
        return currentUserID;
    }

    /**
     * @param currentUserID the currentUserID to set
     */
    public void setCurrentUserID(String currentUserID) {
        this.currentUserID = currentUserID;
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

    public HomeController getHomeController() {
        return homeController;
    }

    public ManageUsersController getManageUsersController() {
        return manageUsersController;
    }

    public void setManageUsersController(ManageUsersController manageUsersController) {
        this.manageUsersController = manageUsersController;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
