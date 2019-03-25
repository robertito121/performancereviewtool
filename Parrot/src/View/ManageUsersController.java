/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ManageUsersController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    /**
     * displays the AddUserView
     * @throws IOException
     */
    @FXML
    public void displayAddUserView() throws IOException {

        // set addUserView
        FXMLLoader addUserViewLoader = new FXMLLoader(getClass().getResource("AddUserView.fxml"));
        Parent addUserView = (Parent) addUserViewLoader.load();
        Stage addUserViewStage = new Stage();
        addUserViewStage.setTitle("Add User");
        addUserViewStage.setScene(new Scene(addUserView));
        addUserViewStage.show();
    }
}
