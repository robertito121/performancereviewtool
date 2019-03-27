package View;

import Model.User;
import Model.UserList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class HomeController implements Initializable {

    @FXML
    private AnchorPane homeScreen;

    @FXML
    private Label myProfileFirstName;

    @FXML
    private Label myProfileLastName;

    @FXML
    private Label myProfileUserID;

    @FXML
    private Label myProfileRole;

    @FXML
    private Label userProfileFirstName;

    @FXML
    private Label userProfileLastName;

    @FXML
    private Label userProfileUserID;

    @FXML
    private Label userProfileRole;

    @FXML
    private TableView<User> tableView;

    @FXML
    private TableColumn<User, String> UserId;

    @FXML
    private TableColumn<User, String> UserName;

    private UserList userList;

    public HomeController() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userList = new UserList();

        UserId.setCellValueFactory(new PropertyValueFactory<>("userId"));
        UserName.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        fillTable();
    }

    /**
     * Populates the "My Profile" section with authenticated user information
     *
     * @param firstName
     * @param lastName
     * @param userID
     * @param role
     */
    public void populateMyProfilePane(String firstName, String lastName, String userID, String role) {
        myProfileFirstName.setText(firstName);
        myProfileLastName.setText(lastName);
        myProfileUserID.setText(userID);
        myProfileRole.setText(role);
    }

    /**
     * exits the application by hitting the cancel button
     */
    @FXML
    public void exit() {

        System.exit(0);
    }

    @FXML
    public void showManageUsersView() throws IOException {

        // set ManageUsersView
        FXMLLoader manageUsersViewLoader = new FXMLLoader(getClass().getResource("ManageUsersView.fxml"));
        Parent manageUsersView = (Parent) manageUsersViewLoader.load();
        Stage manageUsersViewStage = new Stage();
        manageUsersViewStage.setTitle("Manage Users");
        manageUsersViewStage.setScene(new Scene(manageUsersView));
        manageUsersViewStage.show();
    }

    @FXML
    public void openAddUserView() throws IOException {

        // close current homeview
        Stage homeStage = (Stage) homeScreen.getScene().getWindow();
        homeStage.close();

        // set addUserView
        FXMLLoader addUserViewLoader = new FXMLLoader(getClass().getResource("AddUserView.fxml"));
        Parent addUserView = (Parent) addUserViewLoader.load();
        Stage addUserViewStage = new Stage();
        addUserViewStage.setTitle("Manage Users");
        addUserViewStage.setScene(new Scene(addUserView));
        addUserViewStage.show();
        
        // pass currentID value to add user controller
        AddUserController addController = addUserViewLoader.getController();
        addController.setCurrentUserID(getMyProfileUserID().getText());
    }
    
    public void RemoveUser() {
        User removeUser = tableView.getSelectionModel().getSelectedItem();
        userList.getUserList().remove(removeUser);
        userList.writeUserListFile();
        fillTable();
    }
    

    public AnchorPane getHomeScreen() {
        return homeScreen;
    }

    public void setHomeScreen(AnchorPane homeScreen) {
        this.homeScreen = homeScreen;
    }

    public Label getMyProfileFirstName() {
        return myProfileFirstName;
    }

    public void setMyProfileFirstName(Label myProfileFirstName) {
        this.myProfileFirstName = myProfileFirstName;
    }

    public Label getMyProfileLastName() {
        return myProfileLastName;
    }

    public void setMyProfileLastName(Label myProfileLastName) {
        this.myProfileLastName = myProfileLastName;
    }

    public Label getMyProfileUserID() {
        return myProfileUserID;
    }

    public void setMyProfileUserID(Label myProfileUserID) {
        this.myProfileUserID = myProfileUserID;
    }

    public Label getMyProfileRole() {
        return myProfileRole;
    }

    public void setMyProfileRole(Label myProfileRole) {
        this.myProfileRole = myProfileRole;
    }

    public Label getUserProfileFirstName() {
        return userProfileFirstName;
    }

    public void setUserProfileFirstName(Label userProfileFirstName) {
        this.userProfileFirstName = userProfileFirstName;
    }

    public Label getUserProfileLastName() {
        return userProfileLastName;
    }

    public void setUserProfileLastName(Label userProfileLastName) {
        this.userProfileLastName = userProfileLastName;
    }

    public Label getUserProfileUserID() {
        return userProfileUserID;
    }

    public void setUserProfileUserID(Label userProfileUserID) {
        this.userProfileUserID = userProfileUserID;
    }

    public Label getUserProfileRole() {
        return userProfileRole;
    }

    public void setUserProfileRole(Label userProfileRole) {
        this.userProfileRole = userProfileRole;
    }

    public void fillTable() {
        tableView.setItems(getUsers());
    }

    //Creates list to populate table
    private ObservableList<User> getUsers() {
        ObservableList<User> users = FXCollections.observableArrayList();

        for (int i = 0; i < userList.getUserList().size(); i++) {
            users.add(userList.getUserList().get(i));
        }
        return users;
    }

}
