package HumanResource;
import Login.Conn;

import java.io.IOException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HR_Evaluate_Performance_Controller {
	static String u;

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
    private Button UpdateButton;
    
    @FXML
    private ImageView ImageLabel;
    
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
    	AnchorPane HR_Homepage = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Homepage.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("EMS | HR | Dashboard");
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
    	
    	u= SearchButton.getText();
      	 
      	 try{
             Conn con = new Conn();
             String str = "select e.FName,e.LName,e.EmployeeID,e.EmployeeLevel,d.dept_name FROM employee_details e "
                     + "join departements d on e.dept_id=d.dept_id WHERE EmployeeID ='"+u+"' ";
             ResultSet rs = con.s.executeQuery(str);

             int i=0;
             if(rs.next()){
            	  
                 i=1;
                 String FName = rs.getString(1);
                 String LName = rs.getString(2);
                 String EmployeeID=rs.getString(3);
                 String EmployeeLevel=rs.getString(4);
                 String DeptName=rs.getString(5);
                 
                 ImageLabel.setOpacity(0);
                 Label0.setOpacity(1);
                 Label1.setOpacity(1);
                 Label2.setOpacity(1);
                 Label3.setOpacity(1);
                 Label4.setOpacity(1);
                 UpdateButton.setOpacity(1);
                 UpdateButton.setDisable(false);
                 BackLabel.setOpacity(1); 
                 Name_Label.setOpacity(1);                 
                 ID_Label.setOpacity(1);;
                 Level_Label.setOpacity(1);
                 Dep_Label.setOpacity(1);
                 
                 Name_Label.setText(FName + " " + LName);                 
                 ID_Label.setText(EmployeeID);
                 Level_Label.setText(EmployeeLevel);
                 Dep_Label.setText(DeptName);
                
             }
             if(i==0)
                 JOptionPane.showMessageDialog(null,"Employee Record Not Found");
         }catch(Exception ex){
        	 JOptionPane.showMessageDialog(null,"Error Occurred.  " + ex);
         }
      	 
 }
    
    @FXML
    void onClick_UpdateButton(ActionEvent event) throws IOException {
    	AnchorPane HR_Homepage = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Evaluate_Performance_Update.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("EMS | HR | Update Employee Performance");
        window1.setScene(new Scene(HR_Homepage));
        window1.show();    	
    	
    }
    public String getEid() {
    	return u;
    }
    
    
 }
