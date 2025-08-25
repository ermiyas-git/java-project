package HumanResource;
import static HumanResource.HR_Payroll_Controller.Eid;
import Login.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HR_Grievances_Controller implements Initializable {
	
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
    private Button AddEmployee_Button;

    @FXML
    private TextField GPTextField;

    @FXML
    private ChoiceBox<String> StatusChoiceBox;

    @FXML
    private Button SubmitButton;
	
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
        window1.show();;
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
    //-----------------------------------------------------------------------------------------------------
    ObservableList<String> GP_list = FXCollections.observableArrayList();
    private void loadData() {
    	StatusChoiceBox.setDisable(false);
    	GP_list.removeAll(GP_list);    
    	GP_list.addAll("Pending","Under Review","Closed");
    	StatusChoiceBox.getItems().addAll(GP_list);
   }
    @FXML
    void onACtion_GPTextField(ActionEvent event) {
    	loadData(); 
    	SubmitButton.setDisable(false);
    }
    
    @FXML
    void onAction_SubmitButton(ActionEvent event) throws IOException, SQLException {
    	LoginController obj = new LoginController();
    	
    	try {
            Conn c1 = new Conn();
        
             String q2 = "select * from grievancestable where GRIEVEID='"+GPTextField.getText().trim()+"'";  
                ResultSet rs2 =c1.s.executeQuery(q2);
                        if(!rs2.next()) {
                            JOptionPane.showMessageDialog(null, "There is no Emplyeee with the given Grievance ID");
                          
                        }
                        else
                        {
                
    		
    		String q = "UPDATE grievancestable SET GStatus='"+
                        (String) StatusChoiceBox.getValue() +"',Processed_by='"+obj.getID()+"'  "
                        + "WHERE GRIEVEID='"+GPTextField.getText().toString()+"' ";
    	    c1.s.executeUpdate(q);
    	    JOptionPane.showMessageDialog(null,"Greivance Status Updated Successfully "); 
    	}
        }	
    	catch(Exception ex) {
    		JOptionPane.showMessageDialog(null,"Error occurred while processing request. Grievance ID Not Found."+ex);    		
    	}
    	
    	AnchorPane mainPane = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Grievances.fxml"));
        Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(new Scene(mainPane));
		primaryStage.setTitle("EMS | HR | Grievance Portal");
		primaryStage.show();

    }
    //----------------------------------------------------------------------------------------------------------------------------------------    //----------------------------------------------------------------------------------------------------------------------------------------
    public class Grievances{
    	
   	    private final SimpleStringProperty GID;    
        private final SimpleStringProperty EID;
        private final SimpleStringProperty EName;
        private final SimpleStringProperty GDes;
        private final SimpleStringProperty Status;
        private final SimpleStringProperty HRID;
       
        public Grievances(String gid, String eid, String name, String des, String status, String hrid){
       	this.GID = new SimpleStringProperty(gid);    
       	this.EID = new SimpleStringProperty(eid);
       	this.EName = new SimpleStringProperty(name);
       	this.GDes = new SimpleStringProperty(des);
       	this.Status = new SimpleStringProperty(status);
       	this.HRID = new SimpleStringProperty(hrid);      	        
       	        
         }

        public String getGID() {
            return GID.get();
        }

        public String getEID() {
            return EID.get();
        }

        public String getEName() {
            return EName.get();
        }

        public String getGDes() {
            return GDes.get();
        }

        public String getStatus() {
            return Status.get();
        }

        public String getHRID() {
            return HRID.get();
        } 
  	
   	
   }
         
    @FXML
    private TableView<Grievances> GTable;

    @FXML
    private TableColumn<Grievances, String> GIDCol;

    @FXML
    private TableColumn<Grievances, String> EIDCol;

    @FXML
    private TableColumn<Grievances, String> ENameCol;

    @FXML
    private TableColumn<Grievances, String> GDesCol;

    @FXML
    private TableColumn<Grievances, String> StatusCol;

    @FXML
    private TableColumn<Grievances, String> HRIDCol;
//---------------------------------------------------------------------
   
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		GIDCol.setCellValueFactory(new PropertyValueFactory<Grievances,String>("GID"));   
		EIDCol.setCellValueFactory(new PropertyValueFactory<Grievances,String>("EID"));
		ENameCol.setCellValueFactory(new PropertyValueFactory<Grievances,String>("EName"));
		GDesCol.setCellValueFactory(new PropertyValueFactory<Grievances,String>("GDes"));
		StatusCol.setCellValueFactory(new PropertyValueFactory<Grievances,String>("Status"));
		HRIDCol.setCellValueFactory(new PropertyValueFactory<Grievances,String>("HRID"));
		
		ObservableList<Grievances> data = FXCollections.observableArrayList();
		
		try{
           Conn con = new Conn();
           String str = "SELECT * FROM grievancestable";
           ResultSet rs = con.s.executeQuery(str);
           
           while(rs.next()){
               String gid = rs.getString(1);
               String eid = rs.getString(2);
               String des = rs.getString(3);
               String status=rs.getString(4);
               String hrid =rs.getString(5);
               String date = rs.getString(6);
               String query="select FName,Lname from employee_details where EmployeeID='"+eid+"'";
               String fname="fname";
               String lname="lname";
               PreparedStatement ps= con.getConnection().prepareStatement(query);
               ResultSet rss=ps.executeQuery();
               if(rss.next())
               {
                   fname=rss.getString(1);
                   lname=rss.getString(2);
               }
               String name=fname+" "+lname;
               data.add(new  Grievances(gid,eid,name ,des,status,hrid));
            }                 
           
           GTable.setItems(data);
       }           	  
	    catch(SQLException ee){
	    	JOptionPane.showMessageDialog(null,ee);
   	    ee.printStackTrace();
	    }
	}

}


