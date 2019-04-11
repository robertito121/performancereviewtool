/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.PerformanceData;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Group 2
 */
public class AddPerformanceDataController implements Initializable {

    @FXML
    private Label nameLabel;
    
    @FXML
    private TextField yearText;
    
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
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void setHomeController(HomeController homeController) {
        this.homeController = homeController;
    }
    
    public void setSelectedUser(String inf_userID, String inf_firstName, String inf_lastName) {
        
        userID = inf_userID;
        nameLabel.setText(inf_firstName + " " + inf_lastName);
    }
    
    public void Submit() {
        
        performanceData = new PerformanceData(userID, yearText.getText(), (int) measure1Slider.getValue(), measure1Text.getText(), (int) measure2Slider.getValue(), measure2Text.getText(), (int) measure3Slider.getValue(), measure3Text.getText(), additionalCommentsText.getText());
    }
    
}
