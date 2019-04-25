/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.PerformanceData;
import Model.PerformanceDataList;
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
public class ViewPerformanceDataController implements Initializable {

    @FXML
    private Label nameLabel;

    @FXML
    private Label dateLabel;
    
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
    private Button closeButton;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setReport(String firstName, String lastName, PerformanceData performanceData) {
        
        nameLabel.setText(firstName + " " + lastName);
        dateLabel.setText(performanceData.getDate());
        measure1Slider.setValue(performanceData.getMeasure1Rating());
        measure1Text.setText(performanceData.getMeasure1Comment());
        measure2Slider.setValue(performanceData.getMeasure2Rating());
        measure2Text.setText(performanceData.getMeasure2Comment());
        measure3Slider.setValue(performanceData.getMeasure3Rating());
        measure3Text.setText(performanceData.getMeasure3Comment());
        additionalCommentsText.setText(performanceData.getAdditionalComments());

    }
    
}
