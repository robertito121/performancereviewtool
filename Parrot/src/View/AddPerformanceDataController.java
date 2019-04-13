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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    
    public void setHomeController(HomeController homeController) {
        this.homeController = homeController;
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

        performanceDataList.addPerformanceDatatoHashMap(userID, performanceData);
    }
    
}
