package View;

import Model.User;
import Model.UserList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginController {

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
        userList = new UserList();
        userList.initializeList(); //This initializes the userList with some default data

    }

    @FXML
    public void authenticate(ActionEvent event ) throws IOException {

        boolean isAuthenticated = checkAuthentication();
        if (isAuthenticated == true) {

            //set homeView
            Parent homeView = FXMLLoader.load(getClass().getResource("HomeView.fxml"));
            Stage homeViewStage = new Stage();
            homeViewStage.setTitle("Performance Review Tool (Parrot) ");
            homeViewStage.setScene(new Scene(homeView));
            homeViewStage.show();

            //dispose login View
            Stage loginStage = (Stage) loginButton.getScene().getWindow();
            loginStage.close();


        }
        else {
            informationLabel.setTextFill(Color.RED);
            informationLabel.setText("The Username or Password combination is incorrect, please try again");
        }
     
    }
    
    @FXML
    public void exit() {
        
        System.exit(0);
    }

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


}




