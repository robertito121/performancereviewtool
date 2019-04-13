/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.PerformanceData;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import Model.PerformanceDataList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddPerformanceDataController implements Initializable {

    @FXML
    private Label nameLabel;

    @FXML
    private Slider measure1Slider;
    
    @FXML
    private TextField measure1Text;
    
    @FXML
    private Slider measure2Slider;
    
    @FXML
    private TextField measure2Text;
    
    @FXML
    private Slider measure3Slider;
    
    @FXML
    private TextField measure3Text;
    
    @FXML
    private TextArea additionalCommentsText;
    
    @FXML
    private Button submitButton;
    
    @FXML
    private Button cancelButton;
    
    private HomeController homeController;
    private String userID;
    private PerformanceData performanceData;
    private PerformanceDataList performanceDataList;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        performanceDataList = new PerformanceDataList();

    }

    public void setSelectedUser(String userID, String firstName, String lastName) {
        
        this.userID = userID;
        nameLabel.setText(firstName + " " + lastName);
    }

    /**
     * submit the Form
     */
    public void Submit() {

        //build date
        String datePattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
        String date = simpleDateFormat.format(new Date());

        //build reportId
        String reportId = userID + PerformanceData.getInstanceCounter();

        //build total rating for each report
        double totalRating = PerformanceData.calculateTotalRating(measure1Slider.getValue(),measure2Slider.getValue(),measure3Slider.getValue());

        //construct report object
        performanceData = new PerformanceData(userID, reportId, date, (int) measure1Slider.getValue(),
                                              measure1Text.getText(), (int) measure2Slider.getValue(), measure2Text.getText(),
                                             (int) measure3Slider.getValue(), measure3Text.getText(), additionalCommentsText.getText(),
                                              totalRating
                                             );

        //add performanceData Object to List and tableView
        performanceDataList.addPerformanceDatatoHashMap(userID, performanceData);
        homeController.getPerformanceDataTableView().getItems().add(performanceData);
        homeController.getPerformanceDataTableView().refresh();

        //close the Add performanceData Stage
        Stage stage = (Stage) nameLabel.getScene().getWindow();
        stage.close();

    }

    public Label getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(Label nameLabel) {
        this.nameLabel = nameLabel;
    }

    public Slider getMeasure1Slider() {
        return measure1Slider;
    }

    public void setMeasure1Slider(Slider measure1Slider) {
        this.measure1Slider = measure1Slider;
    }

    public TextField getMeasure1Text() {
        return measure1Text;
    }

    public void setMeasure1Text(TextField measure1Text) {
        this.measure1Text = measure1Text;
    }

    public Slider getMeasure2Slider() {
        return measure2Slider;
    }

    public void setMeasure2Slider(Slider measure2Slider) {
        this.measure2Slider = measure2Slider;
    }

    public TextField getMeasure2Text() {
        return measure2Text;
    }

    public void setMeasure2Text(TextField measure2Text) {
        this.measure2Text = measure2Text;
    }

    public Slider getMeasure3Slider() {
        return measure3Slider;
    }

    public void setMeasure3Slider(Slider measure3Slider) {
        this.measure3Slider = measure3Slider;
    }

    public TextField getMeasure3Text() {
        return measure3Text;
    }

    public void setMeasure3Text(TextField measure3Text) {
        this.measure3Text = measure3Text;
    }

    public TextArea getAdditionalCommentsText() {
        return additionalCommentsText;
    }

    public void setAdditionalCommentsText(TextArea additionalCommentsText) {
        this.additionalCommentsText = additionalCommentsText;
    }

    public Button getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(Button submitButton) {
        this.submitButton = submitButton;
    }

    public Button getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(Button cancelButton) {
        this.cancelButton = cancelButton;
    }

    public HomeController getHomeController() {
        return homeController;
    }

    public void setHomeController(HomeController homeController) {
        this.homeController = homeController;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public PerformanceData getPerformanceData() {
        return performanceData;
    }

    public void setPerformanceData(PerformanceData performanceData) {
        this.performanceData = performanceData;
    }

    public PerformanceDataList getPerformanceDataList() {
        return performanceDataList;
    }

    public void setPerformanceDataList(PerformanceDataList performanceDataList) {
        this.performanceDataList = performanceDataList;
    }
}
