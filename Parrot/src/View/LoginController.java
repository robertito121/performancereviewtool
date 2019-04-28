package View;

import Model.User;
import Model.UserList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {

    @FXML
    private AnchorPane loginPane;
    @FXML
    private javafx.scene.control.Label usernameLabel;
    @FXML
    private Label passwordLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Button loginButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Label informationLabel = new Label();

    private UserList userList;

    public LoginController() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userList = new UserList();

    }

    /**
     * Authenticates the user and populates the user data under the "My Profile" section
     * @param event
     * @throws IOException
     */
    @FXML
    public void authenticate(ActionEvent event) throws IOException {

        boolean isAuthenticated = checkAuthentication();
        if (isAuthenticated == true) {

            //set homeView
            FXMLLoader homeViewLoader = new FXMLLoader(getClass().getResource("HomeView.fxml"));
            Parent homeView = (Parent) homeViewLoader.load();
            Stage homeViewStage = new Stage();
            homeViewStage.setTitle("Performance Review Tool (Parrot) ");
            homeViewStage.setScene(new Scene(homeView));
            homeViewStage.show();

            //populate My Profile View with authenticated user info
            User authenticatedUser = getAuthenticatedUser();
            String firstName = authenticatedUser.getFirstName();
            String lastName = authenticatedUser.getLastName();
            String userID = authenticatedUser.getUserId();
            String role =  authenticatedUser.getRole();
            HomeController homeController = homeViewLoader.getController();
            homeController.populateMyProfilePane(firstName, lastName, userID, role);

            //populate My Reports table with logged in user reports
            homeController.populateMyReportsTable(userID);

            //dispose login View
            Stage loginStage = (Stage) loginButton.getScene().getWindow();
            loginStage.close();
        }
        else {
            informationLabel.setTextFill(Color.RED);
            informationLabel.setText("The Username or Password combination is incorrect, please try again");
        }
     
    }

    /**
     * exits the application by hitting the cancel button
     */
    @FXML
    public void exit() {
        
        System.exit(0);
    }

    /**
     * helper method to check for authentication of a user
     * @return boolean
     */
    public boolean checkAuthentication() {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        User testUser;

        for (int i = 0; i < userList.getUserList().size(); i++) {
            testUser = userList.getUserList().get(i);
            if (username.equals(testUser.getUserCredentials().getUserName())) {

                if(password.equals(testUser.getUserCredentials().getPassword())) {

                    return true;
                }

            }
        }
        return false;
    }

    /**
     * Helper method to get authenticated user
     * @return
     */
    public User getAuthenticatedUser() {
        String username = usernameTextField.getText();
        User user = null;

        for (int i = 0; i < userList.getUserList().size(); i++) {
            if (username.equals(userList.getUserList().get(i).getUserCredentials().getUserName())) {
                user = userList.getUserList().get(i);
                break;
            }
            else {
                user = null;
            }
        }
        return user;

    }

    public AnchorPane getLoginPane() {
        return loginPane;
    }

    public void setLoginPane(AnchorPane loginPane) {
        this.loginPane = loginPane;
    }

    public Label getUsernameLabel() {
        return usernameLabel;
    }

    public void setUsernameLabel(Label usernameLabel) {
        this.usernameLabel = usernameLabel;
    }

    public Label getPasswordLabel() {
        return passwordLabel;
    }

    public void setPasswordLabel(Label passwordLabel) {
        this.passwordLabel = passwordLabel;
    }

    public TextField getUsernameTextField() {
        return usernameTextField;
    }

    public void setUsernameTextField(TextField usernameTextField) {
        this.usernameTextField = usernameTextField;
    }

    public TextField getPasswordTextField() {
        return passwordTextField;
    }

    public void setPasswordTextField(TextField passwordTextField) {
        this.passwordTextField = passwordTextField;
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(Button loginButton) {
        this.loginButton = loginButton;
    }

    public Button getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(Button cancelButton) {
        this.cancelButton = cancelButton;
    }

    public Label getInformationLabel() {
        return informationLabel;
    }

    public void setInformationLabel(Label informationLabel) {
        this.informationLabel = informationLabel;
    }

    public UserList getUserList() {
        return userList;
    }

    public void setUserList(UserList userList) {
        this.userList = userList;
    }
}




