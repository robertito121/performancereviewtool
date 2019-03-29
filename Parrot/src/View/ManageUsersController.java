/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.User;
import Model.UserList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ManageUsersController implements Initializable {

    @FXML
    private AnchorPane manageUsersView;
    
    @FXML
    private TableColumn<User, String> userIdHeader;

    @FXML
    private TableColumn<User, String> userFirstNameHeader;

    @FXML
    private TableColumn<User, String> userLastNameHeader;

    @FXML
    private TableColumn<User, String> userRoleHeader;

    @FXML
    private TableColumn<User, String> departmentRoleHeader;

    @FXML
    private TableView<User> tableView;

    private UserList userList;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        userList = new UserList();

        userIdHeader.setCellValueFactory(new PropertyValueFactory<>("userId"));
        userFirstNameHeader.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        userLastNameHeader.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        userRoleHeader.setCellValueFactory(new PropertyValueFactory<>("role"));
        departmentRoleHeader.setCellValueFactory(new PropertyValueFactory<>("department"));

        fillTable();
    }

    /**
     * displays the AddUserView
     * @throws IOException
     */
    @FXML
    public void displayAddUserView() throws IOException {

        Stage manageUsersStage = (Stage) manageUsersView.getScene().getWindow();
        manageUsersStage.close();
        
        // set addUserView
        FXMLLoader addUserViewLoader = new FXMLLoader(getClass().getResource("AddUserView.fxml"));
        Parent addUserView = (Parent) addUserViewLoader.load();
        Stage addUserViewStage = new Stage();
        addUserViewStage.setTitle("Add User");
        addUserViewStage.setScene(new Scene(addUserView));
        addUserViewStage.show();
    }

    /**
     * Fills the table with the ObservableList
     */
    public void fillTable() {
        tableView.setItems(getUsers());
    }

    /**
     * Creates ObservableList used to populate the Table
     * @return ObservableList<User>
     */
    private ObservableList<User> getUsers() {
        ObservableList<User> users = FXCollections.observableArrayList();

        for (int i = 0; i < userList.getUserList().size(); i++) {
            users.add(userList.getUserList().get(i));
        }
        return users;
    }
}
