package View;

import Model.PerformanceData;
import Model.PerformanceDataList;
import Model.User;
import Model.UserList;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class HomeController implements Initializable {

    @FXML
    private AnchorPane homeScreen;

    @FXML
    private Button newReportButton;

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
    private TableView<User> userTableView;

    @FXML
    private TableView<PerformanceData> performanceDataTableView;

    @FXML
    private TableColumn<User, String> userIdHeader;

    @FXML
    private TableColumn<User, String> userFirstNameHeader;

    @FXML
    private TableColumn<User, String> userLastNameHeader;

    @FXML
    private TableColumn<User, String> userRoleHeader;

    @FXML
    private TableColumn<PerformanceData, String> performanceDataDateHeader;

    @FXML
    private TableColumn<PerformanceData, String> performanceDataReportIDHeader;

    @FXML
    private TableColumn<PerformanceData, Double> performanceDataTotalRatingHeader;

    private UserList userList;
    private PerformanceDataList performanceDataList;

    private ObservableList<User> userObservableList;
    private ObservableList<PerformanceData> performanceDataObservableList;

    /**
     * Constructor
     */
    public HomeController() {
        userList = new UserList();
    }

    /**
     * Initializes the HomeController class with all of its elements
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Display data into Users TableView
        userList = new UserList();
        userIdHeader.setCellValueFactory(new PropertyValueFactory<>("userId"));
        userFirstNameHeader.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        userLastNameHeader.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        userRoleHeader.setCellValueFactory(new PropertyValueFactory<>("role"));
        userObservableList = getUsersObservableList(userList.getUserList());
        userTableView.setItems(userObservableList);

        //displayItems into PerformanceData Report Table
        performanceDataList = new PerformanceDataList();
        //performanceDataObservableList = FXCollections.observableArrayList();
        performanceDataDateHeader.setCellValueFactory(new PropertyValueFactory<>("date"));
        performanceDataReportIDHeader.setCellValueFactory(new PropertyValueFactory<>("reportId"));
        performanceDataTotalRatingHeader.setCellValueFactory(new PropertyValueFactory<>("totalRating"));
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

    /**
     * Shows the Manage Users View
     * @throws IOException
     */
    @FXML
    public void showManageUsersView() throws IOException {

        // set ManageUsersView
        FXMLLoader manageUsersViewLoader = new FXMLLoader(getClass().getResource("ManageUsersView.fxml"));
        Parent manageUsersView = (Parent) manageUsersViewLoader.load();
        Stage manageUsersViewStage = new Stage();
        manageUsersViewStage.setTitle("Manage Users");
        manageUsersViewStage.setScene(new Scene(manageUsersView));
        manageUsersViewStage.show();

        //pass Current Controller to addUser Controller to add items
        //into the current tableView
        ManageUsersController manageUsersController = manageUsersViewLoader.getController();
        manageUsersController.setHomeController(this);

    }

    /**
     * Opens the AddUser View
     * @throws IOException
     */
    @FXML
    public void openAddUserView() throws IOException {

        // set addUserView
        FXMLLoader addUserViewLoader = new FXMLLoader(getClass().getResource("AddUserView.fxml"));
        Parent addUserView = (Parent) addUserViewLoader.load();
        Stage addUserViewStage = new Stage();
        addUserViewStage.setTitle("Manage Users");
        addUserViewStage.setScene(new Scene(addUserView));
        addUserViewStage.show();

        // pass currentID value to addUser controller
        AddUserController addController = addUserViewLoader.getController();
        addController.setCurrentUserID(getMyProfileUserID().getText());

        //pass Current Controller to addUser Controller to add items
        //into the current tableView
        addController.setHomeController(this);
    }

    /**
     * Add a User to the current TableView
     * @param newUser
     */
    public void addUser(User newUser) {
        userTableView.getItems().add(newUser);
        userTableView.refresh();
    }

    /**
     * removes a given user from the TableView
     * This method is called when removing a user from the
     * ManageUserController
     * @param selectedUser
     */
    public void removeUser(User selectedUser) {
        userTableView.getItems().remove(selectedUser);
        userTableView.refresh();
    }

    /**
     * Removes the selected User from the Database and TableView
     */
    public void RemoveUser() {
        
        User removeUser = userTableView.getSelectionModel().getSelectedItem();
        
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
                userTableView.getItems().remove(removeUser);
            }
        }

    }

    public void addReportToTable(PerformanceData data) {
        performanceDataTableView.getItems().add(data);
        performanceDataTableView.refresh();
    }

    /**
     * Populates the UserProfile Section with the selected user
     * TODO: Retrieve performance data for each user and populate it on the report section
     */
    @FXML
    public void selectUser() {

        try {
            //get the User values of the selected user
            String firstName = userTableView.getSelectionModel().getSelectedItem().getFirstName();
            String lastName = userTableView.getSelectionModel().getSelectedItem().getLastName();
            String userId = userTableView.getSelectionModel().getSelectedItem().getUserId();
            String role =  userTableView.getSelectionModel().getSelectedItem().getRole();

            //populate the User Profile section
            userProfileFirstName.setText(firstName);
            userProfileLastName.setText(lastName);
            userProfileUserID.setText(userId);
            userProfileRole.setText(role);

            //populate the Reports table with User Reports
            performanceDataObservableList = getPerformanceDataObservableList(performanceDataList.getPerformanceDataByUserId(userId));
            performanceDataTableView.setItems(performanceDataObservableList);

            //enable the New Report button
            newReportButton.setDisable(false);
        }
        catch (NullPointerException exception) {
            Alert alert = new Alert(AlertType.ERROR,
                        "No user has been selected, Please select a User on the table first before Selection",
                                    ButtonType.OK);
            alert.show();
            exception.printStackTrace();

        }
    }

    /**
     * Helper method used to convert an ArrayList of Users into an
     * ObservableList of Users to be displayed into the users TableView
      * @return ObservableList<User>
     */
    public ObservableList<User> getUsersObservableList(ArrayList<User> userList) {
        ObservableList<User> users = FXCollections.observableArrayList();
        for (int i = 0; i < userList.size(); i++) {
            users.add(userList.get(i));
        }
        return users;
    }

    /**
     * Helper method used to convert an ArrayList of PerformandeData reports into an
     * ObservableList of PerformanceData to be displayed into the reports TableView
     * @param data
     * @return
     */
    public ObservableList<PerformanceData> getPerformanceDataObservableList(ArrayList<PerformanceData> data) {
        ObservableList<PerformanceData> reportData = FXCollections.observableArrayList();
        for (int i = 0; i < data.size(); i++) {
            reportData.add(data.get(i));
        }
        return reportData;
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
    
        public void newReport() throws IOException {

        // set addPerformanceDataView
        FXMLLoader addPerformanceDataViewLoader = new FXMLLoader(getClass().getResource("AddPerformanceDataView.fxml"));
        Parent addPerformanceDataView = (Parent) addPerformanceDataViewLoader.load();
        Stage addPerformanceDataViewStage = new Stage();
        addPerformanceDataViewStage.setTitle("New Report");
        addPerformanceDataViewStage.setScene(new Scene(addPerformanceDataView));
        addPerformanceDataViewStage.show();

        
        // pass selected user to the addPerformanceData controller
        AddPerformanceDataController addPerformanceDataController = addPerformanceDataViewLoader.getController();
        String firstName = userProfileFirstName.getText();
        String lastName = userProfileLastName.getText();
        String userId = userProfileUserID.getText();
        addPerformanceDataController.setSelectedUser(userId, firstName, lastName);

        //pass Current Controller to addPerformanceData Controller to add items
        //into the current tableView
        addPerformanceDataController.setHomeController(this);
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

    public TableView<User> getTableView() {
        return userTableView;
    }

    public void setTableView(TableView<User> tableView) {
        this.userTableView = tableView;
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

    public UserList getUserList() {
        return userList;
    }

    public void setUserList(UserList userList) {
        this.userList = userList;
    }
}
