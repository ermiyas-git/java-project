package HumanResource;
import Login.*;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HR_Evaluate_Performance_Update_Controller implements Initializable {

    @FXML
    private ChoiceBox<String> Sincerity;

    @FXML
    private ChoiceBox<String> Reliability;

    @FXML
    private ChoiceBox<String> Leadership;

    @FXML
    private ChoiceBox<String> TeamSpirit;

    @FXML
    private ChoiceBox<String> Integrity;

    @FXML
    private ChoiceBox<String> SoftSkills;

    @FXML
    private TextArea CommentsTextField;

    @FXML
    private Button SaveButton;
    
    @FXML
    private Button CancelButton;
   
    @FXML
    void onClick_CancelButton(ActionEvent event) throws IOException {
    	AnchorPane HR_Homepage = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Evaluate_Performance.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("EMS | HR | Employee Performance");
        window1.setScene(new Scene(HR_Homepage));
        window1.show();        
	    	
    }
HR_Evaluate_Performance_Controller obj = new HR_Evaluate_Performance_Controller();

    @FXML
    void onClick_SaveButton(ActionEvent event) throws IOException, SQLException {
       
    	
         String E1 = Sincerity.getValue() != null ? Sincerity.getValue().toString() : null;
        String E2 = Reliability.getValue() != null ? Reliability.getValue().toString() : null;
        String E3 = Leadership.getValue() != null ? Leadership.getValue().toString() : null;
        String E4 = TeamSpirit.getValue() != null ? TeamSpirit.getValue().toString() : null;
        String E5 = Integrity.getValue() != null ? Integrity.getValue().toString() : null;
        String E6 = SoftSkills.getValue() != null ? SoftSkills.getValue().toString() : null;
        String E7 = CommentsTextField.getText().toString().isEmpty() || CommentsTextField.getText().toString()==null ? null:CommentsTextField.getText().toString();

        
         if (E1 == null || E2 == null || E3 == null || 
            E4 == null || E5 == null || E6 == null || E7==null) {
            JOptionPane.showMessageDialog(null, "Please rate all performance categories");
            return;
        }
    	
    	try{
	    Conn cc = new Conn();
            
            PreparedStatement ps = cc.prepareStatement(
                "UPDATE employee_performance SET " +
                "SinciertyHR=?, ReliabilityHR=?, LeadHR=?, " +
                "TeamHR=?, IntegrityHR=?, SoftSkillsHR=?, CommentsHR=? " +
                "WHERE Eid=?");
            
            ps.setString(1, E1);
            ps.setString(2, E2);
            ps.setString(3, E3);
            ps.setString(4, E4);
            ps.setString(5, E5);
            ps.setString(6, E6);
            ps.setString(7, E7);
            ps.setString(8, obj.getEid());
            
            int rowsUpdated = ps.executeUpdate();  // Only execute once
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Performance data updated successfully");
            } else {
                JOptionPane.showMessageDialog(null, "No employee performance record found with ID: " + obj.getEid());
            }
        
        }
        
    	catch(Exception ee){
	    	    JOptionPane.showMessageDialog(null,ee);
	    }
    	
    	AnchorPane HR_Homepage = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Evaluate_Performance.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("EMS | HR | Employee Performance");
        window1.setScene(new Scene(HR_Homepage));
        window1.show();        
	    	
    }
    
	    
	
	public void initialize(URL arg0, ResourceBundle arg1) {
	
             ObservableList<String> Ratings_list = FXCollections.observableArrayList("1","2","3","4","5");
            
          Sincerity.setItems(Ratings_list);
          Reliability.setItems(Ratings_list);
          Leadership.setItems(Ratings_list);
          TeamSpirit.setItems(Ratings_list);
          Integrity.setItems(Ratings_list);
          SoftSkills.setItems(Ratings_list);
//		    		
        }  
}
