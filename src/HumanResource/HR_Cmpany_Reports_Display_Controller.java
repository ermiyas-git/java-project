/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package HumanResource;

import Login.Conn;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class HR_Cmpany_Reports_Display_Controller implements Initializable {
    
   @FXML
   private Button cancelButton;
    
     @FXML
    void onAction_CancelButton(ActionEvent event) throws IOException {
    	AnchorPane mainPane = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Company_Reports.fxml"));
        Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(new Scene(mainPane));
		primaryStage.setTitle("EMS | HR | Company Reports");
		primaryStage.show();
    }
    
    public class User{
    	
    	 private final SimpleStringProperty EmployeeID;    
         private final SimpleStringProperty Name;
         private final SimpleStringProperty ELevel;
        private final SimpleStringProperty Property;
        private final SimpleStringProperty Star;
        
        public User(String eid, String nam, String ele,  String pro, String exp){
        	this.EmployeeID = new SimpleStringProperty(eid);    
        	this.Name = new SimpleStringProperty(nam);
        	this.ELevel = new SimpleStringProperty(ele);
        	this.Property = new SimpleStringProperty(pro);
        	this.Star = new SimpleStringProperty(exp);        	        
        	        
          }
        public String getEmployeeID() {
            return EmployeeID.get();
        }

        public String getName() {
            return Name.get();
        }

        public String getELevel() {
            return ELevel.get();
        }
         public String getProperty() {
            return Property.get();
        }
         public String getStar() {
                 return Star.get();
              }
    }
    
    @FXML
    private TableView<User> EmployeeDataTable;

    @FXML
    private TableColumn<User, String> EmployeeIDColoumn;
    
    @FXML
    private TableColumn<User, String> NameColoumn;

    @FXML
    private TableColumn<User, String> ELevelColoumn;
    @FXML
    private TableColumn<User, String> PropertyColoumn;
    
     @FXML
    private TableColumn<User, String> StarColoumn;
     
     
     
   @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        EmployeeIDColoumn.setCellValueFactory(new PropertyValueFactory<User,String>("EmployeeID"));   
        NameColoumn.setCellValueFactory(new PropertyValueFactory<User,String>("Name"));
	ELevelColoumn.setCellValueFactory(new PropertyValueFactory<User,String>("ELevel"));
        PropertyColoumn.setCellValueFactory(new PropertyValueFactory<User,String>("Property"));
        StarColoumn.setCellValueFactory(new PropertyValueFactory<User,String>("Star"));
        
        ObservableList<User> data = FXCollections.observableArrayList();
        
                // Simple array with the exact display names from your image
         String[] displayProperties = {
             "Most Sincere Employee",
             "Best Leader", 
             "Best Integrity",
             "Most Reliable Employee",
             "Best Teamplayer",
             "Best Soft Skills"
         };

         // Corresponding database column names
         String[] dbColumns = {
             "SinciertyHR",
             "LeadHR",
             "IntegrityHR",
             "ReliabilityHR",
             "TeamHR",
             "SoftSkillsHR"
         };

    try {
        Conn con1 = new Conn();

        // Loop through each property
        for (int i = 0; i < displayProperties.length; i++) {
            String displayName = displayProperties[i];
            String dbColumn = dbColumns[i];
            

        String query = "SELECT e.EmployeeID, e.FName, e.LName, e.EmployeeLevel, ep." + dbColumn + 
                " FROM employee_details e JOIN employee_performance ep ON e.EmployeeID = ep.Eid" +
                      " WHERE ep." + dbColumn + " = (SELECT MAX(" + dbColumn + ") FROM employee_performance)";
        
        ResultSet rs = con1.s.executeQuery(query);
        
        if (rs.next()) {
            // Found top performer
            String eid = rs.getString("EmployeeID");
            String name = rs.getString("FName") + "  " + rs.getString("LName");
            String elevel = rs.getString("EmployeeLevel");
            String stars = "★".repeat(rs.getInt(dbColumn));
            
            data.add(new User(eid, name, elevel, displayName, stars));
        } else {
            // No top performer - add "To be Decided"
            data.add(new User("", "To be Decided", "", displayName, ""));
        }
    }
    
    EmployeeDataTable.setItems(data);
    
}catch (SQLException e) {
            e.printStackTrace();
            // Handle database errors appropriately
        }
            } 

        }
