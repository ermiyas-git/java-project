package HumanResource;
import Login.*;
import java.sql.*;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HR_Add_Employee_Controller implements Initializable{

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
    
    //-------------------------------------------------------------------------------------------------------------------------------
    
    @FXML
    private TextField FName;

    @FXML
    private TextField LName;

    @FXML
    private ChoiceBox<String> Gender;

    @FXML
    private DatePicker DOB;

    @FXML
    private TextField email;

    @FXML
    private TextField phone;

    @FXML
    private TextField AddL1;

    @FXML
    private TextField proj_con;;

    @FXML
    private TextField City;

    @FXML
    private TextField State;

    @FXML
    private TextField Pin;

    @FXML
    private ChoiceBox<String> BG;

    @FXML
    private TextField Eid;

    @FXML
    private ChoiceBox<String> ELevel;

    @FXML
    private TextField DeptName;

    @FXML
    private DatePicker DOJ;

    @FXML
    private TextField ProName;

    @FXML
    private TextField Password;
    
    @FXML
    private TextField username;

    @FXML
    private TextField phone1;

    @FXML
    private Button Submit;

    
    ObservableList<String> Gender_list = FXCollections.observableArrayList();
    ObservableList<String> ELevel_list = FXCollections.observableArrayList();
    ObservableList<String> BG_list = FXCollections.observableArrayList();
    
    private void loadData() {
    	Gender_list.removeAll(Gender_list);
    	String a = "Male";
    	String b = "Female";
    	String c = "Rather Not Say";
    	Gender_list.addAll(a,b,c);
    	Gender.getItems().addAll(Gender_list);
    	
    	BG_list.removeAll(BG_list);
     	BG_list.addAll("A+","B+","O+","AB+","A-","B-","O-","AB-");
    	BG.getItems().addAll(BG_list);
    	
     	ELevel_list.removeAll(ELevel_list);
     	ELevel_list.addAll("Executive (L1)", "Assistant Manager (L2)", "Manager (L3)", "Senior Manager (L4)", "Department Head (L5)","Human Resource");
     	ELevel.getItems().addAll(ELevel_list);
    }
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		loadData();
		
	}   
    //------------------------------------------------------------------------------------------------------------------------------------
  // Regular expressions for validation
    private static final String USERNAME_REGEX = "^[a-zA-Z0-9._-]{3,20}$";
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final String ETHIOPIAN_PHONE_REGEX = "^(\\+251|0)[79][0-9]{8}$";
        @FXML
void onClick_Submit(ActionEvent event) throws ParseException {
    // Validate all fields first
    if (!validateFields()) {
       
        return;
    }

    Conn cc = null;
    try {
        cc = new Conn();
        
        // Start transaction by disabling auto-commit
        cc.getConnection().setAutoCommit(false);

        // Get department ID (insert if new)
        int deptId = getOrCreateDepartment(cc);
        
        // Get project ID (insert if new)
        int projectId = getOrCreateProject(cc);
        
        // Insert location if needed
        insertLocation(cc);
        
        
        
        // Insert employee details
        insertEmployeeDetails(cc, deptId, projectId);
        
        insertEmployeePhone(cc);
        
        // Insert login credentials
        insertLoginCredentials(cc);
        
        // Initialize performance data
        initializePerformanceData(cc);
        
       
        
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
        System.err.println("Database error: " + e);
    } finally {
        // Reset auto-commit and close connection
        if (cc != null) {
            try {
                cc.getConnection().setAutoCommit(true);
            } catch (SQLException ex) {
                System.err.println("Error resetting auto-commit: " + ex);
            }
            cc.close();
        }
    }
}

// The validateFields() method remains exactly the same as in your original code
private boolean validateFields() throws ParseException {
    boolean isValid = true;
    
    
    // Validate text fields
    if (FName.getText() == null || FName.getText().trim().isEmpty()) {
      
        FName.setPromptText("*Enter First Name");
        isValid = false;
    }
    
    if (LName.getText() == null || LName.getText().trim().isEmpty()) {
        LName.setPromptText("*Enter Last Name");
        isValid = false;
    }
    
    if (email.getText() == null || email.getText().trim().isEmpty()) {
        email.setPromptText("*Enter Email ");
        isValid = false;
    }
    
   
    
    if (phone.getText() == null || phone.getText().trim().isEmpty()) {
        phone.setPromptText("*Enter Contact Number");
        isValid = false;
    }
    
    
    if (AddL1.getText() == null || AddL1.getText().trim().isEmpty()) {
        AddL1.setPromptText("*Enter Address Line 1");
        isValid = false;
    }
    
    if (proj_con.getText() == null || proj_con.getText().trim().isEmpty()) {
        proj_con.setPromptText("*Enter Project Description");
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
    
    if (Eid.getText() == null || Eid.getText().trim().isEmpty()) {
        Eid.setPromptText("*Enter Employee ID");
        isValid = false;
    }
    
    if (DeptName.getText() == null || DeptName.getText().trim().isEmpty()) {
        DeptName.setPromptText("*Enter Department Name");
        isValid = false;
    }
    
    if (ProName.getText() == null || ProName.getText().trim().isEmpty()) {
        ProName.setPromptText("*Enter Project Name");
        isValid = false;
    }
    
    if (phone1.getText() == null || phone1.getText().trim().isEmpty()) {
        phone1.setPromptText("*Enter Emergency Contact");
        isValid = false;
    }
   
    
    if (Password.getText() == null || Password.getText().trim().isEmpty()) {
        Password.setPromptText("*Enter Password");
        isValid = false;
    }
    
    
    if (username.getText() == null || username.getText().trim().isEmpty()) {
        username.setPromptText("*Enter Username");
        isValid = false;
    }
     
    
    // Validate combo boxes
    if (Gender.getValue() == null) {
        isValid = false;
    }
    
    if (BG.getValue() == null) {
        isValid = false;
    }
    
    if (ELevel.getValue() == null) {
        isValid = false;
    }
    
    // Validate date pickers
    if (DOB.getValue() == null) {
        isValid = false;
    }
    
    if (DOJ.getValue() == null) {
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
        check=getDiff(DOB.getValue());
        if(!check)showAlert("you are under 18 ", "Age Requirements", 
                  "you are not old enthough to join the system");
            
            
    }
        
        
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
        check=username.getText().trim().matches(USERNAME_REGEX);
         if(!check)
        {
           showAlert("Invalid Username", "Username Requirements", 
                  "Username must be 3-20 characters long and can only contain letters, numbers, dots, underscores, or hyphens.");
            
        }
    }
         
         if(check)
    {
        check=phone1.getText().trim().matches(ETHIOPIAN_PHONE_REGEX);
         if(!check)
        {
            showAlert("Invalid phone number", "it is not ethiopian phone number", 
               "Please enter a valid phone number");
        }
    }
         
         if(check)
    {
        check=Password.getText().trim().matches(PASSWORD_REGEX);
         if(!check)
        {
            showAlert("Invalid Password", "Password Requirements", 
                    "Password must be at least 8 characters long and contain:\n" +
                    "- At least one digit\n" +
                    "- At least one lowercase letter\n" +
                    "- At least one uppercase letter\n" +
                    "- At least one special character (@#$%^&+=)\n" +
                    "- No whitespace allowed");
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
public int getOrCreateDepartment(Conn cc) throws SQLException {
    String deptName = DeptName.getText().trim();
    
    // First try to find existing department
    String query = "SELECT dept_id FROM departements WHERE dept_name = ?";
    PreparedStatement ps = cc.prepareStatement(query);
    ps.setString(1, deptName);
    ResultSet rs = ps.executeQuery();
    
    if (rs.next()) {
        int id = rs.getInt(1);
        rs.close();
        ps.close();
        return id;
    }
    rs.close();
    ps.close();
    
    // Department doesn't exist, insert it
    String insertQuery = "INSERT INTO departements (dept_name) VALUES (?)";
    ps = cc.prepareStatementWithGeneratedKeys(insertQuery);  // Using the new method
    ps.setString(1, deptName);
    ps.executeUpdate();
    
    rs = ps.getGeneratedKeys();
    if (rs.next()) {
        int id = rs.getInt(1);
        rs.close();
        ps.close();
        return id;
    }
    
    rs.close();
    ps.close();
    throw new SQLException("Failed to create department");
}

public int getOrCreateProject(Conn cc) throws SQLException {
    String projectName = ProName.getText().trim();
    String projectDesc = proj_con.getText().trim();
    
    // First try to find existing project
    String query = "SELECT project_id FROM projects WHERE project_name = ?";
    PreparedStatement ps = cc.prepareStatement(query);
    ps.setString(1, projectName);
    ResultSet rs = ps.executeQuery();
    
    if (rs.next()) {
        int id = rs.getInt(1);
        rs.close();
        ps.close();
        return id;
    }
    rs.close();
    ps.close();
    
    // Project doesn't exist, insert it
    String insertQuery = "INSERT INTO projects (project_name, description) VALUES (?, ?)";
    ps = cc.prepareStatementWithGeneratedKeys(insertQuery);  // Using the new method
    ps.setString(1, projectName);
    ps.setString(2, projectDesc);
    ps.executeUpdate();
    
    rs = ps.getGeneratedKeys();
    if (rs.next()) {
        int id = rs.getInt(1);
        rs.close();
        ps.close();
        return id;
    }
    
    rs.close();
    ps.close();
    throw new SQLException("Failed to create project");
}

private void insertLocation(Conn cc) throws SQLException {
    String pincode = Pin.getText().trim();
    String city = City.getText().trim();
    String state = State.getText().trim();
    
    // Check if location exists first
    String checkQuery = "SELECT 1 FROM locations WHERE pincode = ?";
    PreparedStatement ps = cc.prepareStatement(checkQuery);
    ps.setString(1, pincode);
    ResultSet rs = ps.executeQuery();
    
    if (!rs.next()) {
        rs.close();
        ps.close();
        
        String insertQuery = "INSERT INTO locations (pincode, city, state) VALUES (?, ?, ?)";
        ps = cc.prepareStatement(insertQuery);
        ps.setString(1, pincode);
        ps.setString(2, city);
        ps.setString(3, state);
        ps.executeUpdate();
    }
    
    rs.close();
    ps.close();
}

private void insertEmployeeDetails(Conn cc, int deptId, int projectId) throws SQLException {
    String query = "INSERT INTO employee_details "+
                   "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    PreparedStatement ps = cc.prepareStatement(query);
    ps.setString(1, Eid.getText().trim());
    ps.setString(2, FName.getText().trim());
    ps.setString(3, LName.getText().trim());
    ps.setString(4, Gender.getValue().toString());
    ps.setString(5, DOB.getValue().toString());
    ps.setString(6, email.getText().trim());
    ps.setString(7, AddL1.getText().trim());
    ps.setString(8, Pin.getText().trim());
    ps.setString(9, BG.getValue().toString());
    ps.setString(10, ELevel.getValue().toString());
    ps.setInt(11, deptId);
    ps.setString(12, DOJ.getValue().toString());
    ps.setInt(13, projectId);
    
    ps.executeUpdate();
    ps.close();
}

private void insertLoginCredentials(Conn cc) throws SQLException {
    String employeeId = Eid.getText().trim();
    String usernam = username.getText().trim();
    String password = Password.getText().trim();
    String emai = email.getText().trim();
    
    String tableName = "Human Resource".equals(ELevel.getValue().toString()) 
            ? "hr_login" : "Employee_login";
    
    String query = String.format("INSERT INTO %s  VALUES (?, ?, ?, ?)", tableName);
    
    PreparedStatement ps = cc.prepareStatement(query);
    ps.setString(1, employeeId);
    ps.setString(2, usernam);
    ps.setString(3, PasswordHasher.hashPassword(password));
    ps.setString(4, emai);
    ps.executeUpdate();
    ps.close();
}
private void insertEmployeePhone(Conn cc) throws SQLException {
    String employeeId = Eid.getText().trim();
    String phoneNumber = phone.getText().trim();
    String emergencyContact = phone1.getText().trim();
    
    String query = "INSERT INTO employee_phones (employee_id, phone_number, EmergencyContactNumber) " +
                  "VALUES (?, ?, ?)";
    
    try (PreparedStatement ps = cc.prepareStatement(query)) {
        ps.setString(1, employeeId);
        ps.setString(2, phoneNumber);
        ps.setString(3, emergencyContact);
        ps.executeUpdate();
    }
}

private void initializePerformanceData(Conn cc) throws SQLException {
    String employeeId = Eid.getText().trim();
    String query = "INSERT INTO employee_performance  " +
                   "VALUES (?, 0, 0, 0, 0, 0, 0, 'Not Assigned Yet', 0, 0, 0, 0, 0, 0, 'Not Assigned Yet')";
    
    PreparedStatement ps = cc.prepareStatement(query);
    ps.setString(1, employeeId);
    ps.executeUpdate();
    ps.close();
}


private void showSuccessAndRedirect(ActionEvent event) throws IOException {
    JOptionPane.showMessageDialog(null, "Employee data successfully added");
    
    AnchorPane hrAddEmployee = FXMLLoader.load(getClass().getResource("HR_Add_Employee.fxml"));
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    window.setTitle("EMS | HR | Add Employee");
    window.setScene(new Scene(hrAddEmployee));
    window.show();
}
public boolean getDiff(LocalDate date1) throws ParseException {
    boolean date=true;
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //Converts String to Date
//    	Date date1_new = new Date(sdf.parse(date1).getTime());
    	LocalDate d1=date1;
                //LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(date1_new));
		LocalDate d2 = LocalDate.now();								//Gets Current Date
		
		int d3 = Period.between(d1, d2).getYears();
		String D3 = Integer.toString(d3);  
         if(d3<=17)
         {
            date=false; 
         }
             
		return  date;
	}
private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }	

}
