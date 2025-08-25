package HumanResource;
import Login.Conn;

import java.io.IOException;
import java.sql.*;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HR_Delete_Employee_Controller {

    @FXML
    private Button DashboardButton;

    @FXML
    private Button AddEmployee;

    @FXML
    private Button ApproveApplicationButton;

    @FXML
    private Button ManageSalaryButton;

    @FXML
    private Button UpdatePerformanceButton;

    @FXML
    private Button NewButton;

    @FXML
    private Button Manage_GrievancesButton;

    @FXML
    private Button LogoutButton;

    @FXML
    private Button BackButton;

    @FXML
    private TextField SearchButton;

    @FXML
    private Button GoButton;
    
    @FXML
    private Label BackLabel;

    @FXML
    private Label Label0;

    @FXML
    private Label Label1;

    @FXML
    private Label Label2;

    @FXML
    private Label Label3;

    @FXML
    private Label Label4;

    @FXML
    private Label Name_Label;

    @FXML
    private Label ID_Label;

    @FXML
    private Label Level_Label;

    @FXML
    private Label Dep_Label;
    
    @FXML
    private Button DeleteButton;
    
    @FXML
    void onAction_AddEmployee(ActionEvent event) throws IOException {
    	AnchorPane HR_Add_Employee = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Manage_Employee.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("EMS | HR | Manage Employee");
        window1.setScene(new Scene(HR_Add_Employee));
        window1.show();   
   }

    @FXML
    void onAction_ApproveApplicationButton(ActionEvent event) throws IOException {
    	AnchorPane HR_Homepage = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Approve_Applications.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("EMS | HR | Manage Employee Applications");
        window1.setScene(new Scene(HR_Homepage));
        window1.show();
    }

    @FXML
    void onAction_BackButton(ActionEvent event) throws IOException {
    	AnchorPane HR_Homepage = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Manage_Employee.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("EMS | HR | Manage Employee");
        window1.setScene(new Scene(HR_Homepage));
        window1.show();
    }

    @FXML
    void onAction_DashboardButton(ActionEvent event) throws IOException {
    	AnchorPane HR_Homepage = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Homepage.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("EMS | HR | Dashboard");
        window1.setScene(new Scene(HR_Homepage));
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
    void onAction_ManageSalaryButton(ActionEvent event) throws IOException {
    	AnchorPane HR_Homepage = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Payroll.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("EMS | HR | Manage Payroll");
        window1.setScene(new Scene(HR_Homepage));
        window1.show();
    }

    @FXML
    void onAction_Manage_GrievancesButton(ActionEvent event) throws IOException {
    	AnchorPane mainPane = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Grievances.fxml"));
        Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(new Scene(mainPane));
		primaryStage.setTitle("EMS | HR | Grievance Portal");
		primaryStage.show();
    }

    @FXML
    void onAction_NewButton(ActionEvent event) throws IOException {
    	AnchorPane mainPane = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Company_Reports.fxml"));
        Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(new Scene(mainPane));
		primaryStage.setTitle("EMS | HR | Company Reports");
		primaryStage.show();
    }

    @FXML
    void onAction_UpdatePerformanceButton(ActionEvent event) throws IOException {
    	AnchorPane HR_Homepage = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Evaluate_Performance.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("EMS | HR | Employee Performance");
        window1.setScene(new Scene(HR_Homepage));
        window1.show();   
    }


    @FXML
void onClick_Go(ActionEvent event) {
    try {
        Conn con = new Conn();
        // Using prepared statement with JOIN to departments table
        String query = "SELECT e.FName, e.LName, e.EmployeeID, e.EmployeeLevel, d.dept_name " +
                      "FROM employee_details e " +
                      "JOIN departements d ON e.dept_id = d.dept_id " +
                      "WHERE e.EmployeeID = ?";
        
        try (PreparedStatement ps = con.getConnection().prepareStatement(query)) {
            ps.setString(1, SearchButton.getText().trim());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String FName = rs.getString(1);
                    String LName = rs.getString(2);
                    String EmployeeID = rs.getString(3);
                    String EmployeeLevel = rs.getString(4);
                    String DeptName = rs.getString(5);
                    
                    // Show UI elements
                    Label0.setOpacity(1);
                    Label1.setOpacity(1);
                    Label2.setOpacity(1);
                    Label3.setOpacity(1);
                    Label4.setOpacity(1);
                    DeleteButton.setOpacity(1);
                    DeleteButton.setDisable(false);
                    BackLabel.setOpacity(1); 
                    Name_Label.setOpacity(1);                 
                    ID_Label.setOpacity(1);
                    Level_Label.setOpacity(1);
                    Dep_Label.setOpacity(1);
                    
                    // Set values
                    Name_Label.setText(FName + " " + LName);                 
                    ID_Label.setText(EmployeeID);
                    Level_Label.setText(EmployeeLevel);
                    Dep_Label.setText(DeptName);
                } else {
                    JOptionPane.showMessageDialog(null, "Employee Record Not Found");
                }
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error Occurred: " + ex.getMessage());
    }
}

@FXML
void onClick_DeleteButton(ActionEvent event) {
    int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this employee?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
    
    if (n == JOptionPane.YES_OPTION) {
        try {
            Conn con = new Conn();
            Connection connection = con.getConnection();
            
            // Start transaction
            connection.setAutoCommit(false);
            
            try {
                // Delete from all related tables
                String[] deleteQueries = {
                    "DELETE FROM employee_phones WHERE employee_id = ?",
                    "DELETE FROM grievancestable WHERE EmployeeID = ?",
                    "DELETE FROM payroll4 WHERE EID = ?",
                    "DELETE FROM leave_applications WHERE employee_id = ?",
                    "DELETE FROM reimbursements WHERE employee_id = ?",
                    "DELETE FROM Employee_login WHERE Eid = ?",
                    "DELETE FROM hr_login WHERE Eid = ?",
                    "DELETE FROM employee_performance WHERE Eid = ?",
                    "DELETE FROM employee_details WHERE EmployeeID = ?"
                };
                
                for (String query : deleteQueries) {
                    try (PreparedStatement ps = connection.prepareStatement(query)) {
                        ps.setString(1, SearchButton.getText().trim());
                        ps.executeUpdate();
                    }
                }
                
                // Commit transaction if all deletes succeeded
                connection.commit();
                
                // Hide UI elements
                Label0.setOpacity(0);
                Label1.setOpacity(0);
                Label2.setOpacity(0);
                Label3.setOpacity(0);
                Label4.setOpacity(0);
                DeleteButton.setOpacity(0);
                DeleteButton.setDisable(true);
                BackLabel.setOpacity(0); 
                Name_Label.setOpacity(0);                 
                ID_Label.setOpacity(0);
                Level_Label.setOpacity(0);
                Dep_Label.setOpacity(0);
                
                JOptionPane.showMessageDialog(null, "Employee Record Deleted Successfully");
               
                AnchorPane HR_Add_Employee = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Delete_Employee.fxml"));
                Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
                window1.setTitle("EMS | HR | Update Employee");
                window1.setScene(new Scene(HR_Add_Employee));
                window1.show();
            } catch (SQLException ex) {
                // Rollback if any error occurs
                connection.rollback();
                JOptionPane.showMessageDialog(null, "Error deleting employee: " + ex.getMessage());
            } finally {
                connection.setAutoCommit(true);
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Exception occurred: " + ex.getMessage());
        }
    }
}

 }
