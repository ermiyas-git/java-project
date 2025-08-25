package HumanResource;
import Login.*;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HR_Company_Reports_Controller implements Initializable{
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
    private Button DisplayButton;

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
    void onAction_DisplayButton(ActionEvent event) throws IOException {
    	AnchorPane mainPane = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Cmpany_Reports_Display.fxml"));
        Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(new Scene(mainPane));
		primaryStage.setTitle("EMS | HR | Company Reports Display");
		primaryStage.show();
    }

    @FXML
    private BarChart<String, Number> Chart1;

    @FXML
    private CategoryAxis X1;

    @FXML
    private NumberAxis Y1;

    @FXML
    private Label Sincere;

    @FXML
    private Label Leader;

    @FXML
    private Label Integrity;

    @FXML
    private Label Reliable;

    @FXML
    private Label Team;

    @FXML
    private Label Soft;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
            
		// TODO Auto-generated method stub
		
		int a1=0,a2=0,a3=0,a4=0,a5=0,a6=0;
    	
	   	 try{		   	
		   		Conn con = new Conn();
	            String str = "SELECT Avg(SinciertyHR) , AVG(ReliabilityHR), AVG(LeadHR), AVG(TeamHR),AVG(IntegrityHR),AVG(SoftSkillsHR) FROM employee_performance;";
	         
	            ResultSet rs= con.s.executeQuery(str);
	            
	            while(rs.next())
	            {            	
	                a1 = rs.getInt(1);
	                a2 = rs.getInt(2);
                    a3 = rs.getInt(3);
                    a4 = rs.getInt(4);
                    a5 = rs.getInt(5);
                    a6 = rs.getInt(6);
	            }
	   	 }
	   	 catch(Exception e){
	       	 JOptionPane.showMessageDialog(null,e);
	        }  	 
	  //XYChart.Series<String, Number> set1 = new XYChart.Series<>();
         BarChart.Series<String, Number> set1 = new BarChart.Series<>(); 
    	set1.getData().add(new XYChart.Data("Sincierity",a1));
    	set1.getData().add(new XYChart.Data("Reliability",a2));
    	set1.getData().add(new XYChart.Data("Leadership",a3));
    	set1.getData().add(new XYChart.Data("Team Spirit",a4));
    	set1.getData().add(new XYChart.Data("Integrity",a5));
    	set1.getData().add(new XYChart.Data("Soft Skills",a6)); 	
    	Chart1.getData().addAll(set1);
    	Chart1.lookupAll(".default-color0.chart-bar")
        .forEach(x -> x.setStyle("-fx-bar-fill: blue;"));
        
          
    }
       
		
}