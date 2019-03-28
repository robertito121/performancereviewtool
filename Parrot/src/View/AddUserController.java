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
    
    private String firstname, lastname, userID, password, department, role;
    
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

        //get user information and make sure no empty fields
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

        //Make sure no duplicate IDs
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

        //add User to list
        list.getUserList().add(newUser);
        list.writeUserListFile();

        //Close Add View
        Stage addStage = (Stage) departmentText.getScene().getWindow();
        addStage.close();

        //Re-open Updated HomeView
        openHomeView();
    }
    
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
