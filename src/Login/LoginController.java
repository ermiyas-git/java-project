package Login;

import java.awt.HeadlessException;
import java.net.URL;
import java.sql.*;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Node;
import javafx.scene.control.Alert;

public class LoginController implements Initializable {
    
    ObservableList<String> list = FXCollections.observableArrayList();
    static String u,v,e;
  
    @FXML
    private TextField UsernameTextfield;

    @FXML
    private PasswordField PasswordTextField;
        
    @FXML
    private TextField emailTextField;
    
    @FXML
    private ChoiceBox<String> LoginTypeChoice;
    
   
    @FXML
    void onAction_LoginTypeChoice(ActionEvent event) {
        String choice = LoginTypeChoice.getValue();
    }
    
    @FXML
    void LoginAction(ActionEvent event) throws IOException {    
         
        u = UsernameTextfield.getText().toString();
        v = PasswordTextField.getText().toString();
        e = emailTextField.getText().toString();
            
        try {
            Conn c1 = new Conn();	
            
            if (UsernameTextfield.getText().isEmpty() || PasswordTextField.getText().isEmpty() || emailTextField.getText().isEmpty()) {
                showAlert("Warning", "Missing Information", "Please fill in all fields");
                return;
            }
            

            
            if(LoginTypeChoice.getValue() == "Employee") {
                String Password=PasswordHasher.hashPassword(v);
                System.out.println("employee "+Password);
                String q = "select * from Employee_login where username='"+u+"' and password='"+Password+"' and email='"+e+"'";
                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()) {                
                    AnchorPane EmployeeHomePane = (AnchorPane) FXMLLoader.load(getClass().getResource(
                            "/Employee/Employee_Dashboard.fxml"));
                    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    window.setTitle(" Employee | Dashboard");
                    window.setScene(new Scene(EmployeeHomePane));
                    window.centerOnScreen();
                    window.setResizable(false);
                    window.show();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid Input. Please try again.");
                }
            }
            else if(LoginTypeChoice.getValue() == "HR Personnel") {
                String Password=PasswordHasher.hashPassword(v);
                System.out.println("admin "+Password);
                String q = "select * from hr_login where hr_username='"+u+"' and hr_password='"+Password+"' and hr_email='"+e+"'";
                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()) {
                    AnchorPane HRHomePane = (AnchorPane) FXMLLoader.load(getClass().getResource("/HumanResource/HR_Homepage.fxml"));
                    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    window.setTitle(" HR | Dashboard");
                    window.setScene(new Scene(HRHomePane));
                    window.centerOnScreen();
                    window.setResizable(false);
                    window.show();	 
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid Input. Please try again.");
                }
            }     
            else {
                JOptionPane.showMessageDialog(null, "Please Select Login Type");
            }
        }
        catch(HeadlessException | SQLException e1) {
            e1.printStackTrace();
        }	
    }
    
  
    

    
    public String getID() {
        return u;
    }
    
    private void loadData() {
        list.removeAll(list);
        String a = "Employee";
        String b = "HR Personnel";
        list.addAll(a,b);
        LoginTypeChoice.getItems().addAll(list);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        loadData();
    } 
    
//    private boolean userExists(String username, String email) throws SQLException {
//        Conn c = new Conn();
//        String query = "Employee".equals(LoginTypeChoice.getValue())
//            ? "SELECT 1 FROM log_in WHERE username = ? OR email = ?"
//            : "SELECT 1 FROM hr_login WHERE username = ? OR email = ?";
//        
//        try (PreparedStatement pstmt = c.c.prepareStatement(query)) {
//            pstmt.setString(1, username);
//            pstmt.setString(2, email);
//            try (ResultSet rs = pstmt.executeQuery()) {
//                return rs.next();
//            }
//        } finally {
//            c.c.close();
//        }
//    } 
    
    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }	
}

//Button button = (Button) root.lookup("#someButtonId"); // Requires fx:id in FXML
//if (button != null) {
//    AnchorPane.setTopAnchor(button, 50.0); // Only works if root is AnchorPane!
//}
//
//Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//window.setScene(new Scene(scrollPane));
//window.show();
