package Employee;

import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import Login.*;
import Login.LoginController;
import java.sql.PreparedStatement;
import java.text.ParseException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Employee_Reset_Password_Controller implements Initializable {

	@FXML
    private Button ResetButton;

    @FXML
    private TextField EIDTF;

    @FXML
    private PasswordField OldPass1;

    @FXML
    private PasswordField NewPass1;

    @FXML
    private PasswordField NewPass2;
    
    @FXML
    private Button CancelButton;

    @FXML
    void onClick_CancelButton(ActionEvent event) throws IOException {
    	 AnchorPane Employee_MyHR_Pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Profile.fxml"));
         Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
         window1.setTitle("GrowFast | Employee | Profile");
         window1.setScene(new Scene(Employee_MyHR_Pane));
         window1.show();
    }

    @FXML
    void onClick_ResetButton(ActionEvent event) throws IOException, ParseException {
        if (!validateFields()) {
       
            return;
      }
        else
        {
        
        LoginController obj = new LoginController();
    String username= obj.getID();
        
    	String e_id = EIDTF.getText().toString();
    	String oldpass1 = OldPass1.getText().toString();
    	String newpass1 = NewPass1.getText().toString();
    	String newpass2 = NewPass2.getText().toString();
        
    	String oldpassh=PasswordHasher.hashPassword(oldpass1);
        String newpassh=PasswordHasher.hashPassword(newpass2);
    
    			try 
    			{
    				Conn c1 = new Conn();

            String q = "select * from Employee_login where Eid='"+e_id+"' and password='"+oldpassh+"'";
            ResultSet rs =c1.s.executeQuery(q);
         if(rs.next()){ 
                    if(newpass1.compareTo(newpass2) !=0) {
                            JOptionPane.showMessageDialog(null, "Passwords do not match. Please try again.");
                        return;
                    }		                	
                    else{
                     Conn cc = new Conn();
                     String q1 = "UPDATE Employee_login SET password='"+newpassh+"' WHERE Eid='"+e_id+"' ";
                         cc.s.executeUpdate(q1);
                         JOptionPane.showMessageDialog(null,"Password Updated Successfully ");
                         AnchorPane Employee_MyHR_Pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Profile.fxml"));
                     Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
                     window1.setTitle("EMS | Employee | Profile");
                     window1.setScene(new Scene(Employee_MyHR_Pane));
                     window1.show();
                    }
         }
		            else{
	                 JOptionPane.showMessageDialog(null, "Invalid Username or password. Please try again.");
		             }
	            
                        }
		        catch(HeadlessException | SQLException e1){
		 	             e1.printStackTrace();
		      	}				
    	
    }
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Employee_profileController obj = new Employee_profileController();
                
		EIDTF.setText(obj.getID());
	}
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

        private boolean validateFields() throws ParseException {
    boolean isValid = true;
    
    if (OldPass1.getText() == null || NewPass1.getText().isEmpty()|| NewPass2.getText().isEmpty()) {
        NewPass1.setPromptText("*Enter Password");
        NewPass2.setPromptText("*Enter Password");
        isValid = false;
    }
    if(isValid==false)
    {
         JOptionPane.showMessageDialog(null, " please fill in all the fields");
    }
    else{
           boolean check=true;
    if(check)
    {
        check=NewPass1.getText().trim().matches(PASSWORD_REGEX);
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
        check=NewPass2.getText().trim().matches(PASSWORD_REGEX);
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
     isValid=check;
    }
    return isValid;
        }
        private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }	
        
}
