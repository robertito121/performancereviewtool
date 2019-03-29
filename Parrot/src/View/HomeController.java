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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.*;
import javafx.scene.control.ButtonType;
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
    private TableColumn<User, String> userIdHeader;

    @FXML
    private TableColumn<User, String> userFirstNameHeader;

    @FXML
    private TableColumn<User, String> userLastNameHeader;

    @FXML
    private TableColumn<User, String> userRoleHeader;

    private UserList userList;

    public HomeController() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userList = new UserList();

        userIdHeader.setCellValueFactory(new PropertyValueFactory<>("userId"));
        userFirstNameHeader.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        userLastNameHeader.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        userRoleHeader.setCellValueFactory(new PropertyValueFactory<>("role"));

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

        // close current homeview
        Stage homeStage = (Stage) homeScreen.getScene().getWindow();
        homeStage.close();
        
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
        
        if (removeUser == null) {
            
            Alert nulluser = new Alert(AlertType.ERROR, "Error! No User Selected!");
            nulluser.showAndWait();
        }
        else if (this.getMyProfileUserID().getText().equals(removeUser.getUserId())) {
            
            Alert removeerror = new Alert(AlertType.ERROR, "Error! You cannot remove yourself!");
            removeerror.showAndWait();
        }
        else {
           
            Alert alert = new Alert(AlertType.CONFIRMATION, "Are you sure you want to delete user " + removeUser.getFirstName() + " " + removeUser.getLastName() + "?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait(); 
            
            if (alert.getResult() == ButtonType.YES) {
        
                userList.getUserList().remove(removeUser);
                userList.writeUserListFile();
                fillTable();
            }
        }
        
    }

    /**
     * Populates the UserProfile Section with the selected user
     * TODO: Retrieve performance data for each user and populate it on the report section
     */
    @FXML
    public void selectUser() {

        //get the User values of the selected user
        String firstName = tableView.getSelectionModel().getSelectedItem().getFirstName();
        String lastName = tableView.getSelectionModel().getSelectedItem().getLastName();
        String userId = tableView.getSelectionModel().getSelectedItem().getUserId();
        String role =  tableView.getSelectionModel().getSelectedItem().getRole();

        //populate the User Profile section
        userProfileFirstName.setText(firstName);
        userProfileLastName.setText(lastName);
        userProfileUserID.setText(userId);
        userProfileRole.setText(role);

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

    /**
     * logs out of the home View into the log in screen
     * @throws Exception
     */
    @FXML
    public void logout() throws Exception{
                
        //close homeview
        Stage homeStage = (Stage) homeScreen.getScene().getWindow();
        homeStage.close();
        
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/LoginView.fxml"));
        primaryStage.setTitle("Performance Review Tool");
        primaryStage.setScene(new Scene(root, 390, 374));
        primaryStage.show();
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

}
