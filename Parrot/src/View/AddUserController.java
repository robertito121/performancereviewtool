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
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    private String currentUserID;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //add items to combobox
        roles.getItems().addAll("Employee", "Manager", "Administrator");

        list = new UserList();
        
        
    }

    @FXML
    public void submit() throws IOException {

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
        
        if(newUser.getUserId().isEmpty()){
            exit();
            return;
        }

        //add User to list
        list.getUserList().add(newUser);
        list.writeUserListFile();

        //Close Add View
        Stage addStage = (Stage) departmentText.getScene().getWindow();
        addStage.close();
        
        //Open Home View
        openHomeView();
    }

    @FXML
    public void exit() throws IOException {
        Stage addStage = (Stage) cancelButton.getScene().getWindow();
        addStage.close();
        
        openHomeView();
    }

    public void passUserList(UserList passedList) {
        list = passedList;
    }
    
    public void openHomeView() throws IOException {
        //Re-Open HomeView
        FXMLLoader homeViewLoader = new FXMLLoader(getClass().getResource("HomeView.fxml"));
        Parent homeView = (Parent) homeViewLoader.load();
        Stage homeViewStage = new Stage();
        homeViewStage.setTitle("Performance Review Tool (Parrot) ");
        homeViewStage.setScene(new Scene(homeView));
        homeViewStage.show();

        User authenticatedUser = getUser();
        String firstName = authenticatedUser.getFirstName();
        String lastName = authenticatedUser.getLastName();
        String userId = authenticatedUser.getUserId();
        String Role = authenticatedUser.getRole();
        HomeController homeController = homeViewLoader.getController();
        homeController.populateMyProfilePane(firstName, lastName, userId, Role);
    }
    
    //Get current user with ID from HomeController
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

}
