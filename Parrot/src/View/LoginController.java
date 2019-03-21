package View;

import Model.User;
import Model.UserList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;


public class LoginController {

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
    public void authenticate() {

        boolean isAuthenticated = checkAuthentication();
        if (isAuthenticated == true) {
            System.out.println("authenticated");
        }
        else {
            informationLabel.setTextFill(Color.RED);
            informationLabel.setText("The Username or Password combination is incorrect, please try again");


        }





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




