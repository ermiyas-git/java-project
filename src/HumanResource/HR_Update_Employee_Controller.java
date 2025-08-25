package HumanResource;

import java.io.*;
import java.sql.*;
import javax.swing.JOptionPane;
import Login.Conn;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
//import HumanResource.HR_Add_Employee_Controller.*;

public class HR_Update_Employee_Controller implements Initializable{

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
	    private Label L1;

	    @FXML
	    private TextField FName;

	    @FXML
	    private Label L2;

	    @FXML
	    private TextField LName;

	    @FXML
	    private Label L3;

	    @FXML
	    private Label L4;

	    @FXML
	    private Label L5;

	    @FXML
	    private TextField email;

	    @FXML
	    private Label L6;

	    @FXML
	    private TextField phone;

	    @FXML
	    private Label L7;

	    @FXML
	    private TextField AddL1;

	   
	    
	    @FXML
	    private Label L9;

	    @FXML
	    private TextField City;

	    @FXML
	    private Label L10;

	    @FXML
	    private TextField State;

	    @FXML
	    private Label L11;

	    @FXML
	    private TextField Pin;

	    @FXML
	    private Label L12;

	    @FXML
	    private Label L14;

	    @FXML
	    private TextField Eid;

	    @FXML
	    private Label L15;

	    @FXML
	    private Label L16;

	    @FXML
	    private Label L17;

	    @FXML
	    private TextField DeptName;

	    @FXML
	    private Label L18;

	    @FXML
	    private TextField ProName;
   
	    @FXML
	    private Label L20;
	    
	    @FXML
	    private Label L21;

	    @FXML
	    private TextField Password;

	    @FXML
	    private Button Save_Update;

	    @FXML
	    private Label L13;

	    @FXML
	    private TextField e_phone;

	    @FXML
	    private TextField SearchButton;

	    @FXML
	    private Button GoButton;

	    @FXML
	    private TextField DOB;

	    @FXML
	    private TextField Gender;

	    @FXML
	    private TextField BG;

	    @FXML
	    private TextField ELevel;

	    @FXML
	    private TextField DOJ;
   
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
		primaryStage.setTitle("EMPLOYEEE MANAGEMENT SYSTEM | Login");
		primaryStage.show();
    }

    @FXML
    void onAction_ManageSalaryButton(ActionEvent event) throws IOException {
    	AnchorPane HR_Homepage = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Payroll.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("EMPLOYEEE MANAGEMENT SYSTEM | HR | Manage Payroll");
        window1.setScene(new Scene(HR_Homepage));
        window1.show();
    }

    @FXML
    void onAction_Manage_GrievancesButton(ActionEvent event) throws IOException {
    	AnchorPane mainPane = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Grievances.fxml"));
        Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(new Scene(mainPane));
		primaryStage.setTitle("EMPLOYEEE MANAGEMENT SYSTEM | HR | Grievance Portal");
		primaryStage.show();
    }

    @FXML
    void onAction_NewButton(ActionEvent event) throws IOException {
    	AnchorPane mainPane = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Company_Reports.fxml"));
        Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(new Scene(mainPane));
		primaryStage.setTitle("EMPLOYEEE MANAGEMENT SYSTEM | HR | Company Reports");
		primaryStage.show();
    }

    @FXML
    void onAction_UpdatePerformanceButton(ActionEvent event) throws IOException {
    	AnchorPane HR_Homepage = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Evaluate_Performance.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("EMPLOYEEE MANAGEMENT SYSTEM | HR | Employee Performance");
        window1.setScene(new Scene(HR_Homepage));
        window1.show();   
    }
	@Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        setFieldsVisibility(false);
           }
         
    
    @FXML
void onClick_GoButton(ActionEvent event) {
    try {
        String employeeId = SearchButton.getText().trim();
        if (employeeId.isEmpty()) {
            showAlert("Input Error", "Please enter an Employee ID to search");
            return;
        }

        try {
            Conn cc = new Conn();
             PreparedStatement ps = cc.getConnection().prepareStatement(
                 "SELECT e.*, d.dept_name, p.project_name, l.city, l.state, " +
                 "ep.phone_number, ep.EmergencyContactNumber " +
                 "FROM employee_details e " +
                 "LEFT JOIN departements d ON e.dept_id = d.dept_id " +
                 "LEFT JOIN projects p ON e.project_id = p.project_id " +
                 "LEFT JOIN locations l ON e.pincode = l.pincode " +
                 "LEFT JOIN employee_phones ep ON e.EmployeeID = ep.employee_id " +
                 "WHERE e.EmployeeID = ?") ;
            
            ps.setString(1, employeeId);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Populate employee details
                    FName.setText(rs.getString("FName"));
                    LName.setText(rs.getString("LName"));
                    Gender.setText(rs.getString("Gender"));
                    DOB.setText(rs.getDate("DOB").toString());
                    email.setText(rs.getString("Email"));
                    AddL1.setText(rs.getString("Address"));
                    Pin.setText(rs.getString("pincode"));
                    BG.setText(rs.getString("BloodGroup"));
                    Eid.setText(rs.getString("EmployeeID"));
                    ELevel.setText(rs.getString("EmployeeLevel"));
                    DOJ.setText(rs.getDate("DOJ").toString());
                    
                    // Populate joined data
                    DeptName.setText(rs.getString("dept_name"));
                    ProName.setText(rs.getString("project_name"));
                    City.setText(rs.getString("city"));
                    State.setText(rs.getString("state"));
                    phone.setText(rs.getString("phone_number"));
                    e_phone.setText(rs.getString("EmergencyContactNumber"));
                    
                    setFieldsVisibility(true);
                    setFieldsEditable(true);
                } else {
                    showAlert("Not Found", "Employee Record Not Found");
                }
            }
        }
        catch (SQLException e) {
        handleDatabaseError( e);
    }
    } catch (Exception e) {
        System.out.println(e);
    }
}

@FXML
void onClick_Save_Update(ActionEvent event) {
    // Validate required fields before update
    if (!validateUpdateFields()) {
        return;
    }

    Conn cc = null;
    try {
        cc = new Conn();
        cc.getConnection().setAutoCommit(false); // Start transaction

        // Update location if changed
        updateLocationIfChanged(cc);
        // First update employee details
        updateEmployeeDetails(cc.getConnection());
        
        // If department changed, update department reference
        updateDepartmentIfChanged(cc);
        
        // Update phone numbers
        updateEmployeePhones(cc); 
        
        // If project changed, update project reference
        updateProjectIfChanged(cc);
        
        
        
        // Commit transaction
        cc.getConnection().commit();
        
        showSuccessAndRedirect(event);
        
    } catch (Exception e) {
        // Rollback transaction if there was an error
        if (cc != null) {
            try {
                cc.getConnection().rollback();
            } catch (SQLException ex) {
                e.addSuppressed(ex);
            }
        }
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        e.printStackTrace();
    } finally {
        // Reset auto-commit and close connection
        if (cc != null) {
            try {
                cc.getConnection().setAutoCommit(true);
                cc.close();
            } catch (SQLException ex) {
                System.err.println("Error resetting auto-commit: " + ex);
            }
        }
    }
}

  private static final String ETHIOPIAN_PHONE_REGEX = "^(\\+251|0)[79][0-9]{8}$";
  private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

private boolean validateUpdateFields() {
    // Similar to your original validateFields but only checks editable fields
    boolean isValid = true;
    
    if (FName.getText() == null || FName.getText().trim().isEmpty()) {
        FName.setPromptText("*Enter name ");
        isValid = false;
    }
    if (LName.getText() == null || LName.getText().trim().isEmpty()) {
        LName.setPromptText("*Enter name ");
        isValid = false;
    }
    
    
    if (email.getText() == null || email.getText().trim().isEmpty()) {
        email.setPromptText("*Enter Email ID");
        isValid = false;
    }
    
    if (phone.getText() == null || phone.getText().trim().isEmpty()) {
        phone.setPromptText("*Enter Contact Number");
        isValid = false;
    }
    
    if (e_phone.getText() == null || e_phone.getText().trim().isEmpty()) {
        e_phone.setPromptText("*Enter Emergency Contact");
        isValid = false;
        System.out.println("emptyyyyyyyy");
    }
    
    if (AddL1.getText() == null || AddL1.getText().trim().isEmpty()) {
        AddL1.setPromptText("*Enter Address Line 1");
        isValid = false;
    }
    
    if (City.getText() == null || City.getText().trim().isEmpty()) {
        City.setPromptText("*Enter City Name");
        isValid = false;
    }
    
    if (State.getText() == null || State.getText().trim().isEmpty()) {
        State.setPromptText("*Enter State Name");
        isValid = false;
    }
    
    if (Pin.getText() == null || Pin.getText().trim().isEmpty()) {
        Pin.setPromptText("*Enter Pincode");
        isValid = false;
    }
    
    if(isValid==false)
     {
         JOptionPane.showMessageDialog(null, " please fill in all the fields");
     }
else 
 {
     boolean check=true;
     
     if(check)
    {
        check=email.getText().trim().matches(EMAIL_REGEX);
        if(!check)
        {
            showAlert("Invalid Email", "Email Requirements", 
               "Please enter a valid email address (e.g., user@example.com)");
        }
    }
     
       if(check)
    {
        check=e_phone.getText().trim().matches(ETHIOPIAN_PHONE_REGEX);
         if(!check)
        {
            showAlert("Invalid phone number", "it is not ethiopian phone number", 
               "Please enter a valid phone number");
        }
    } 
       
       if(check)
    {
        check=phone.getText().trim().matches(ETHIOPIAN_PHONE_REGEX);
         if(!check)
        {
            showAlert("Invalid phone number", "it is not ethiopian phone number", 
               "Please enter a valid phone number");
        }
    } 
       
   isValid=check;    
 }  
    return isValid;
}

private void updateEmployeeDetails(Connection conn) throws SQLException {
    String query = "UPDATE employee_details SET " +
                  "FName=?, LName=?, Email=?, Address=?, pincode=?, BloodGroup=?, EmployeeLevel=? " +
                  "WHERE EmployeeID=?";
    
    try (PreparedStatement ps = conn.prepareStatement(query)) {
        ps.setString(1, FName.getText().trim());
        ps.setString(2, LName.getText().trim());
        ps.setString(3, email.getText().trim());
        ps.setString(4, AddL1.getText().trim());
        ps.setString(5, Pin.getText().trim());
        ps.setString(6, BG.getText().trim());
        ps.setString(7, ELevel.getText().trim());
        ps.setString(8, Eid.getText().trim());
        ps.executeUpdate();
    }
}


private void updateDepartmentIfChanged(Conn cc) throws SQLException {
    String newDeptName = DeptName.getText().trim();
    if (newDeptName.isEmpty()) {
        return; // No department specified, don't update
    }

    // 1. Get current department ID from employee record
    int currentDeptId = -1;
    String getCurrentDeptQuery = "SELECT dept_id FROM employee_details WHERE EmployeeID = ?";
    try (PreparedStatement ps = cc.prepareStatement(getCurrentDeptQuery)) {
        ps.setString(1, Eid.getText().trim());
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                currentDeptId = rs.getInt("dept_id");
            }
        }
    }

    // 2. Get current department name (if any)
    String currentDeptName = "";
    if (currentDeptId != -1) {
        String getDeptNameQuery = "SELECT dept_name FROM departements WHERE dept_id = ?";
        try (PreparedStatement ps = cc.prepareStatement(getDeptNameQuery)) {
            ps.setInt(1, currentDeptId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    currentDeptName = rs.getString("dept_name");
                }
            }
        }
    }

    // 3. Only update if department name actually changed
    if (!newDeptName.equals(currentDeptName)) {
        // 4. Get or create the new department
        int newDeptId;
        String findDeptQuery = "SELECT dept_id FROM departments WHERE dept_name = ?";
        try (PreparedStatement ps = cc.prepareStatement(findDeptQuery)) {
            ps.setString(1, newDeptName);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    newDeptId = rs.getInt("dept_id");
                } else {
                    // Department doesn't exist, create it
                    String insertDeptQuery = "INSERT INTO departments (dept_name) VALUES (?)";
                    try (PreparedStatement insertPs = cc.prepareStatementWithGeneratedKeys(insertDeptQuery)) {
                        insertPs.setString(1, newDeptName);
                        insertPs.executeUpdate();
                        try (ResultSet generatedKeys = insertPs.getGeneratedKeys()) {
                            if (generatedKeys.next()) {
                                newDeptId = generatedKeys.getInt(1);
                            } else {
                                throw new SQLException("Failed to create department, no ID obtained");
                            }
                        }
                    }
                }
            }
        }

        // 5. Update employee's department reference
        String updateQuery = "UPDATE employee_details SET dept_id = ? WHERE EmployeeID = ?";
        try (PreparedStatement ps = cc.prepareStatement(updateQuery)) {
            ps.setInt(1, newDeptId);
            ps.setString(2, Eid.getText().trim());
            ps.executeUpdate();
        }
    }
}


private void updateProjectIfChanged(Conn cc) throws SQLException {
    String newProjectName = ProName.getText().trim();
    if (newProjectName.isEmpty()) {
        return; // No project specified, don't update
    }

    // 1. Get current project ID from employee record
    int currentProjectId = -1;
    String getCurrentProjectQuery = "SELECT project_id FROM employee_details WHERE EmployeeID = ?";
    try (PreparedStatement ps = cc.prepareStatement(getCurrentProjectQuery)) {
        ps.setString(1, Eid.getText().trim());
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                currentProjectId = rs.getInt("project_id");
            }
        }
    }

    // 2. Get current project name (if any)
    String currentProjectName = "";
    if (currentProjectId != -1) {
        String getProjectNameQuery = "SELECT project_name FROM projects WHERE project_id = ?";
        try (PreparedStatement ps = cc.prepareStatement(getProjectNameQuery)) {
            ps.setInt(1, currentProjectId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    currentProjectName = rs.getString("project_name");
                }
            }
        }
    }

    // 3. Only update if project name actually changed
    if (!newProjectName.equals(currentProjectName)) {
        // 4. Get or create the new project
        int newProjectId;
        String findProjectQuery = "SELECT project_id FROM projects WHERE project_name = ?";
        try (PreparedStatement ps = cc.prepareStatement(findProjectQuery)) {
            ps.setString(1, newProjectName);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    newProjectId = rs.getInt("project_id");
                } else {
                    // Project doesn't exist, create it
                    String insertProjectQuery = "INSERT INTO projects (project_name) VALUES (?)";
                    try (PreparedStatement insertPs = cc.prepareStatementWithGeneratedKeys(insertProjectQuery)) {
                        insertPs.setString(1, newProjectName);
                        insertPs.executeUpdate();
                        try (ResultSet generatedKeys = insertPs.getGeneratedKeys()) {
                            if (generatedKeys.next()) {
                                newProjectId = generatedKeys.getInt(1);
                            } else {
                                throw new SQLException("Failed to create project, no ID obtained");
                            }
                        }
                    }
                }
            }
        }

        // 5. Update employee's project reference
        String updateQuery = "UPDATE employee_details SET project_id = ? WHERE EmployeeID = ?";
        try (PreparedStatement ps = cc.prepareStatement(updateQuery)) {
            ps.setInt(1, newProjectId);
            ps.setString(2, Eid.getText().trim());
            ps.executeUpdate();
        }
    }
}

private void updateLocationIfChanged(Conn cc) throws SQLException {
    String pincode = Pin.getText().trim();
    String city = City.getText().trim();
    String state = State.getText().trim();
    
    // Check if location exists
    String checkQuery = "SELECT 1 FROM locations WHERE pincode = ?";
    PreparedStatement ps = cc.prepareStatement(checkQuery);
    ps.setString(1, pincode);
    ResultSet rs = ps.executeQuery();
    
    if (!rs.next()) {
        // Location doesn't exist, insert it
        String insertQuery = "INSERT INTO locations (pincode, city, state) VALUES (?, ?, ?)";
        PreparedStatement insertPs = cc.prepareStatement(insertQuery);
        insertPs.setString(1, pincode);
        insertPs.setString(2, city);
        insertPs.setString(3, state);
        insertPs.executeUpdate();
        insertPs.close();
    }
    
    rs.close();
    ps.close();
}
private void updateEmployeePhones(Conn cc) throws SQLException {
    String employeeId = Eid.getText().trim();
    String phoneNumber = phone.getText().trim();
    String emergencyPhone = e_phone.getText().trim();

    // Check if phone record exists
    boolean phoneExists = false;
    String checkQuery = "SELECT 1 FROM employee_phones WHERE employee_id = ?";
    try (PreparedStatement ps = cc.prepareStatement(checkQuery)) {
        ps.setString(1, employeeId);
        try (ResultSet rs = ps.executeQuery()) {
            phoneExists = rs.next();
        }
    }

    String updateQuery;
    if (phoneExists) {
        // Update existing phone record
        updateQuery = "UPDATE employee_phones SET phone_number = ?, EmergencyContactNumber = ? WHERE employee_id = ?";
    } else {
        // Insert new phone record
        updateQuery = "INSERT INTO employee_phones (phone_number, EmergencyContactNumber, employee_id) VALUES (?, ?, ?)";
    }

    try (PreparedStatement ps = cc.prepareStatement(updateQuery)) {
        ps.setString(1, phoneNumber);
        ps.setString(2, emergencyPhone);
        ps.setString(3, employeeId);
        ps.executeUpdate();
    }
}

private void setFieldsVisibility(boolean visible) {
    double opacity = visible ? 1.0 : 0.0;
    
    L20.setOpacity(opacity);
    L21.setOpacity(opacity);
    L1.setOpacity(opacity);
    L2.setOpacity(opacity);
    L3.setOpacity(opacity);
    L4.setOpacity(opacity);
    L5.setOpacity(opacity);
    L6.setOpacity(opacity);
    L7.setOpacity(opacity);
   
    L9.setOpacity(opacity);
    L10.setOpacity(opacity);
    L11.setOpacity(opacity);
    L12.setOpacity(opacity);
    L13.setOpacity(opacity);
    L14.setOpacity(opacity);
    L15.setOpacity(opacity);
    L16.setOpacity(opacity);
    L17.setOpacity(opacity);
    L18.setOpacity(opacity);
    
    FName.setOpacity(opacity);
    LName.setOpacity(opacity);
    Gender.setOpacity(opacity);
    DOB.setOpacity(opacity);
    email.setOpacity(opacity);
    phone.setOpacity(opacity);
    e_phone.setOpacity(opacity);
    AddL1.setOpacity(opacity);
    
    City.setOpacity(opacity);
    State.setOpacity(opacity);
    Pin.setOpacity(opacity);
    BG.setOpacity(opacity);
    Eid.setOpacity(opacity);
    ELevel.setOpacity(opacity);
    DeptName.setOpacity(opacity);
    ProName.setOpacity(opacity);
    DOJ.setOpacity(opacity);
    Save_Update.setOpacity(opacity);
}

private void setFieldsEditable(boolean editable) {
    email.setEditable(editable);
    phone.setEditable(editable);
    e_phone.setEditable(editable);
    AddL1.setEditable(editable);
    FName.setEditable(editable);
    LName.setEditable(editable);
    City.setEditable(editable);
    State.setEditable(editable);
    Pin.setEditable(editable);
    ELevel.setEditable(editable);
    ProName.setEditable(editable);
}
    
   private void showAlert(String title, String message) {
    JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
}

private void handleDatabaseError(SQLException e) {
    showAlert("Database Error", "Error: " + e.getMessage());
    e.printStackTrace();
} 

private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

private void showSuccessAndRedirect(ActionEvent event) throws IOException {
    JOptionPane.showMessageDialog(null, "Employee data successfully Updated");
    
    AnchorPane hrAddEmployee = FXMLLoader.load(getClass().getResource("HR_Update_Employee.fxml"));
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    window.setTitle("EMS | HR | Add Employee");
    window.setScene(new Scene(hrAddEmployee));
    window.show();
}
}