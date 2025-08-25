package Employee;
import Login.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Employee_profileController implements Initializable {
private static String e_id = "null"; // Make it static
    
    
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
    private Button HRButton;

    @FXML
    private Button BackButton;

    @FXML
    private Button LogoutButton;
    
    @FXML
    private Label t1;

    @FXML
    private Label t2;

    @FXML
    private Label t7;

    @FXML
    private Label t8;

    @FXML
    private Label t5;

    @FXML
    private Label t6;

    @FXML
    private Label t3;

    @FXML
    private Label t4;

    @FXML
    private Label t9;

    @FXML
    private Label t10;

    @FXML
    private Label t11;

    @FXML
    private Label t12;

    @FXML
    private Label t13;

    @FXML
    private Label t14;

    @FXML
    private Label t15;

    @FXML
    private Label t16;
    
     @FXML
    private Label t17;
   
    @FXML
    private Button ViewButton;

    @FXML
    private Button EditButton;

    @FXML
    private Button ResetPassword;

    @FXML
    void onAction_ResetPassword(ActionEvent event) throws IOException {
    	AnchorPane Employee_MyHR_Pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Reset_Password.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("EMS | Employee | Reset Password");
        window1.setScene(new Scene(Employee_MyHR_Pane));
        window1.setResizable(false);
        window1.show();
    }
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
         window1.setTitle("EMS | Employee | Self Assessment");
         window1.setScene(new Scene(Employee_MyHR_Pane));
         window1.show();
    }

    @FXML
    void onAction_ProfileButton(ActionEvent event) throws IOException {
    	 AnchorPane Employee_MyHR_Pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Profile.fxml"));
         Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
         window1.setTitle("EMS | Employee | Profile");
         window1.setScene(new Scene(Employee_MyHR_Pane));
         window1.show();
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
    
	//@SuppressWarnings("unused")
	@Override
public void initialize(URL arg0, ResourceBundle arg1) {
    LoginController obj = new LoginController();
    String username= obj.getID();
     
    // Debug: Print the employee ID being used for the query
    
    
    // Initialize variables with default values
    String FName = "Full_Name";
    String LName = "Last_Name";
    String Gender = "Gender";
    String DOB = "Date_of_Birth";
    String Email = "Email_ID";
    String PhoneNo = "Phone_No.";
    String AddL1 = "Address_Line_1";
    String City = "City";
    String State = "State";
    String Pincode = "Pincode";
    String BloodGroup = "BloodGroup";
    String EmployeeID = "EmployeeID";
    String EmployeeLevel = "EmployeeLevel";
    String DeptName = "Department_Name";
    String DOJ = "Date_of_Joining";
    String ProjectName = "Project_Name";
    String EmergencyPhone = "Emergency_Contact";
    String Password = "password";

    try  {
        Conn con = new Conn();
        
        String query0="select Eid from Employee_login where username='"+username+"'";
        PreparedStatement p = con.prepareStatement(query0);
          ResultSet r = p.executeQuery();
          if (r.next()) {
         e_id = r.getString(1);
          }
        // Using JOINs to get data from related tables
        String query = "SELECT e.FName, e.LName, e.Gender, e.DOB, e.Email, " +
                      "el.password, ep.phone_number, ep.EmergencyContactNumber, e.Address, " +
                      "l.city, l.state, e.pincode, e.BloodGroup, e.EmployeeID, " +
                      "e.EmployeeLevel, d.dept_name, e.DOJ, p.project_name " +
                      "FROM employee_details e " +
                      "LEFT JOIN Employee_login el ON e.EmployeeID = el.Eid " +
                      "LEFT JOIN employee_phones ep ON e.EmployeeID = ep.employee_id " +
                      "LEFT JOIN locations l ON e.pincode = l.pincode " +
                      "LEFT JOIN departements d ON e.dept_id = d.dept_id " +
                      "LEFT JOIN projects p ON e.project_id = p.project_id " +
                      "WHERE e.EmployeeID = ?";
        
        try (PreparedStatement ps = con.getConnection().prepareStatement(query)) {
            ps.setString(1, e_id);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Get employee details
                    FName = rs.getString("FName");
                    LName = rs.getString("LName");
                    Gender = rs.getString("Gender");
                    DOB = rs.getString("DOB");
                    Email = rs.getString("Email");
                    Password = rs.getString("password");
                    PhoneNo = rs.getString("phone_number");
                    EmergencyPhone = rs.getString("EmergencyContactNumber");
                    AddL1 = rs.getString("Address");
                    City = rs.getString("city");
                    State = rs.getString("state");
                    Pincode = rs.getString("pincode");
                    BloodGroup = rs.getString("BloodGroup");
                    EmployeeID = rs.getString("EmployeeID");
                    EmployeeLevel = rs.getString("EmployeeLevel");
                    DeptName = rs.getString("dept_name");
                    DOJ = rs.getString("DOJ");
                    ProjectName = rs.getString("project_name");
                    
                    
                } else {
                    System.out.println("No records found for employee ID: " + e_id);
                    JOptionPane.showMessageDialog(null, "No employee record found for ID: " + e_id);
                }
            }
        }
    } catch (SQLException ex) {
        System.err.println("Database error:");
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
    }

    // Update UI components
    t1.setText(FName);  
    t2.setText(LName);  
    t3.setText(Gender); 
    t5.setText(DOB); 
    t4.setText(Email);  
    t6.setText(PhoneNo); 
    t7.setText(AddL1);
    t8.setText(EmergencyPhone);
    t9.setText(City);
    t10.setText(State);
    t11.setText(Pincode);
    t12.setText(BloodGroup);
    t13.setText(EmployeeID);
    t14.setText(EmployeeLevel);
    t16.setText(DeptName);
    t15.setText(ProjectName);
    t17.setText(Password);
    
   
    
}	
        public String getID() {
            
            return e_id;
}
      
}




