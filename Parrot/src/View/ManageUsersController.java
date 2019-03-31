
package View;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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

    private ObservableList<User> userObservableList;

    private HomeController homeController;


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
        userObservableList = getUsersObservableList(userList.getUserList());
        tableView.setItems(userObservableList);
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

        //pass Current Controller and HomeController to addUser Controller
        // to add items into both tableViews
        AddUserController addUserController = addUserViewLoader.getController();
        addUserController.setHomeController(getHomeController());
        addUserController.setManageUsersController(this);
    }

    /**
     * Add a User to the current TableView
     * @param newUser
     */
    public void addUser(User newUser) {
        tableView.getItems().add(newUser);
        tableView.refresh();
    }

    /**
     * Removes a User from the Database and TableView
     */
    @FXML
    public void removeUser() {

        String loggedInUserID = homeController.getMyProfileUserID().toString();

        User removeUser = tableView.getSelectionModel().getSelectedItem();

        if (removeUser == null) {

            Alert nulluser = new Alert(Alert.AlertType.ERROR, "Error! No User Selected!");
            nulluser.showAndWait();
        }
        else if (loggedInUserID.equals(removeUser.getUserId())) {

            Alert removeerror = new Alert(Alert.AlertType.ERROR, "Error! You cannot remove yourself!");
            removeerror.showAndWait();
        }
        else {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete user " + removeUser.getFirstName() + " " + removeUser.getLastName() + "?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {

                userList.getUserList().remove(removeUser);
                userList.writeUserListFile();
                tableView.getItems().remove(removeUser);
                homeController.removeUser(removeUser);

            }
        }

    }

    /**
     * Helper method used to convert an ArrayList of Users into an
     * ObservableList of Users to be displayed into the TableView
     * @return ObservableList<User>
     */
    public ObservableList<User> getUsersObservableList(ArrayList<User> userList) {
        ObservableList<User> users = FXCollections.observableArrayList();
        for (int i = 0; i < userList.size(); i++) {
            users.add(userList.get(i));
        }
        return users;
    }

    public AnchorPane getManageUsersView() {
        return manageUsersView;
    }

    public void setManageUsersView(AnchorPane manageUsersView) {
        this.manageUsersView = manageUsersView;
    }

    public TableColumn<User, String> getUserIdHeader() {
        return userIdHeader;
    }

    public void setUserIdHeader(TableColumn<User, String> userIdHeader) {
        this.userIdHeader = userIdHeader;
    }

    public TableColumn<User, String> getUserFirstNameHeader() {
        return userFirstNameHeader;
    }

    public void setUserFirstNameHeader(TableColumn<User, String> userFirstNameHeader) {
        this.userFirstNameHeader = userFirstNameHeader;
    }

    public TableColumn<User, String> getUserLastNameHeader() {
        return userLastNameHeader;
    }

    public void setUserLastNameHeader(TableColumn<User, String> userLastNameHeader) {
        this.userLastNameHeader = userLastNameHeader;
    }

    public TableColumn<User, String> getUserRoleHeader() {
        return userRoleHeader;
    }

    public void setUserRoleHeader(TableColumn<User, String> userRoleHeader) {
        this.userRoleHeader = userRoleHeader;
    }

    public TableColumn<User, String> getDepartmentRoleHeader() {
        return departmentRoleHeader;
    }

    public void setDepartmentRoleHeader(TableColumn<User, String> departmentRoleHeader) {
        this.departmentRoleHeader = departmentRoleHeader;
    }

    public TableView<User> getTableView() {
        return tableView;
    }

    public void setTableView(TableView<User> tableView) {
        this.tableView = tableView;
    }

    public UserList getUserList() {
        return userList;
    }

    public void setUserList(UserList userList) {
        this.userList = userList;
    }

    public ObservableList<User> getUserObservableList() {
        return userObservableList;
    }

    public void setUserObservableList(ObservableList<User> userObservableList) {
        this.userObservableList = userObservableList;
    }

    public HomeController getHomeController() {
        return homeController;
    }

    public void setHomeController(HomeController homeController) {
        this.homeController = homeController;
    }
}
