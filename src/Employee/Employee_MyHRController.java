package Employee;
import Login.*;
import Login.Conn;
import Login.LoginController;
import java.awt.Desktop;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;


import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Employee_MyHRController {

    @FXML
    private Button DashboardButton;

    @FXML
    private Button ProfileButton;

    @FXML
    private Button ApplicationButton;

    @FXML
    private Button SalaryButton;

    @FXML
    private Button PerformanceButton;

    @FXML
    private Button WebButton;

    @FXML
    private Button HRButton;

    @FXML
    private Button BackButton;

    @FXML
    private Button LogoutButton;
    
    @FXML
    private Button SubmitButton;
    
    @FXML
    private TextArea GTextField;

    
    @FXML
    void onAction_ApplicationButton(ActionEvent event) throws IOException {
    	AnchorPane Employee_MyHR_Pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Applications.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("EMS | Employee | Manage Applications");
        window1.setScene(new Scene(Employee_MyHR_Pane));
        window1.show();
    }

    @FXML
    void onAction_BackButton(ActionEvent event) throws IOException {
    	AnchorPane EmployeeHomePane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Dashboard.fxml"));
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setTitle("EMS | Employee | Dashboard");
        window.setScene(new Scene(EmployeeHomePane));
        window.show();
    }

    @FXML
    void onAction_DashboardButton(ActionEvent event) throws IOException {
    	AnchorPane EmployeeHomePane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Dashboard.fxml"));
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setTitle("EMS | Employee | Dashboard");
        window.setScene(new Scene(EmployeeHomePane));
        window.show();
    }

    @FXML
    void onAction_HRButton(ActionEvent event) throws IOException {
    	AnchorPane Employee_MyHR_Pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_MyHR.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("EMS | Employee | My HR");
        window1.setScene(new Scene(Employee_MyHR_Pane));
        window1.show();
    }

    @FXML
    void onAction_PerformanceButton(ActionEvent event) throws IOException {
    	AnchorPane Employee_MyHR_Pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Performance.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("EMS | Employee |Self Assessment");
        window1.setScene(new Scene(Employee_MyHR_Pane));
        window1.show();
      }

    @FXML
    void onAction_ProfileButton(ActionEvent event) throws IOException {
    	AnchorPane EmployeeHomePane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Profile.fxml"));
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setTitle("EMS | Employee | Profile");
        window.setScene(new Scene(EmployeeHomePane));
        window.show();
    }

    @FXML
    void onAction_SalaryButton(ActionEvent event) throws IOException {
    	AnchorPane Employee_MyHR_Pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Salary.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("EMS | Employee | Salary Status");
        window1.setScene(new Scene(Employee_MyHR_Pane));
        window1.show();
    }

   

    @FXML
    void onAction_LogoutButton(ActionEvent event) throws IOException {
    	AnchorPane mainPane = (AnchorPane) FXMLLoader.load(getClass().getResource("/Login/Login.fxml"));
        Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(new Scene(mainPane));
		primaryStage.setTitle("EMS | Login");
		primaryStage.show();

    }
    @FXML
    void onClick_SubmitButton(ActionEvent event) {
    	
    	LoginController obj = new LoginController();
        String user_name = obj.getID();
        String Eid="employeeid";
    	
    	String GStatus="Pending";
    	String hr_name = "Not Assigned";
    			

    	try {
    		Conn c2 = new Conn();
                String query0="select Eid from Employee_login where username='"+user_name+"'";
                     PreparedStatement p = c2.prepareStatement(query0);
                     ResultSet r = p.executeQuery();
          if (r.next()) {
                 Eid = r.getString(1);
                        }
                LocalDate d2 = LocalDate.now();	
    	    String query = "INSERT INTO grievancestable (EmployeeID, GTEXT, GStatus, processed_by, submission_date) " +
               "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = c2.getConnection().prepareStatement(query);
                ps.setString(1, Eid);
                ps.setString(2, GTextField.getText());
                ps.setString(3, GStatus);
                ps.setString(4, hr_name);
                ps.setDate(5, java.sql.Date.valueOf(d2));  // Proper LocalDate conversion

                ps.executeUpdate();
	  	    JOptionPane.showMessageDialog(null, "Your Grievance has been submitted successfully.Please check your mailbox for Ticket No. Our HR Team will contact you soon.");            	
    	}
    	catch(Exception e){
	  	         JOptionPane.showMessageDialog(null, e);
	    }
   	}
    
    @FXML
    private Button website;
    
    @FXML
    void onAction_websiteButton(ActionEvent event) {
        try {
            URI uri = new URI("https://www.gesci.org/fileadmin/user_upload/HUMAN_RESOURCE_POLICIES_-_GESCI__June_2018.pdf"); // Replace with your desired URL
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(uri);
            } else {
                System.out.println("Desktop is not supported on this platform.");
            }
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
    
    
    	
 }

