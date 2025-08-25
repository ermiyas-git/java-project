package Employee;

import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.Period;
import javax.swing.JOptionPane;
import Login.LoginController;
import Login.Conn;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Employee_Reimbursement_ApplicationController {

    @FXML
    private DatePicker DateButton;

    @FXML
    private TextArea ReasonTextArea;

    @FXML
    private Button Submit;

    @FXML
    private TextField AmountButton;
    
    @FXML
    private Button CancelButton;
    
    @FXML
    void onClick_DateButton(ActionEvent event) {
        if (DateButton.getValue() == null || checkDate(DateButton.getValue()) < 0) {
            JOptionPane.showMessageDialog(null, "Invalid Date.");
        }
    }

    @FXML
    void onClick_CancelButton(ActionEvent event) throws IOException {
        AnchorPane Employee_MyHR_Pane = FXMLLoader.load(getClass().getResource("Employee_Applications.fxml"));
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setTitle("EMS | Employee | Reimbursement Application");
        window.setScene(new Scene(Employee_MyHR_Pane));
        window.show();
    }

    @FXML
    void onClick_Submit(ActionEvent event) throws IOException {
        // Validate inputs
        String e_id ="Employeeid";
        if (DateButton.getValue() == null) {
            JOptionPane.showMessageDialog(null, "Please select a date.");
            return;
        }
        if (ReasonTextArea.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Reason cannot be empty.");
            return;
        }
        if (AmountButton.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Amount cannot be empty.");
            return;
        }

        // Check date validity
        if (checkDate(DateButton.getValue()) < 0) {
            JOptionPane.showMessageDialog(null, "Date cannot be in the future.");
            return;
        }

        // Fetch user details
        LoginController obj = new LoginController();
        String user_name = obj.getID();
        
        
        try {
            Conn c1 = new Conn();
        
             String query0="select Eid from Employee_login where username='"+user_name+"'";
        PreparedStatement p = c1.prepareStatement(query0);
          ResultSet r = p.executeQuery();
          if (r.next()) {
         e_id = r.getString(1);
          }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error fetching user details: " + e.getMessage());
            return;
        }

        // Insert reimbursement application
        try {Conn c2 = new Conn();
             PreparedStatement pstmt = c2.prepareStatement(
                 "INSERT INTO reimbursements (employee_id, RDOS, RAmount, Reason, RStatus, Processed_by) " +
                 "VALUES (?, ?, ?, ?, ?, ?)");
            
             pstmt.setString(1, e_id);
           
            pstmt.setDate(2, Date.valueOf(DateButton.getValue()));
            pstmt.setBigDecimal(3, new java.math.BigDecimal(AmountButton.getText()));
            pstmt.setString(4, ReasonTextArea.getText());
            pstmt.setString(5, "Pending");
            pstmt.setString(6, "Not Processed");
           
            pstmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Your application was submitted successfully.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error submitting application: " + e.getMessage());
            return;
        }

        // Navigate back
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Employee_Applications.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("EMS | Employee | Reimbursement Application");
        stage.setScene(new Scene(pane));
        stage.show();
    }

    public int checkDate(LocalDate selectedDate) {
        return Period.between(selectedDate, LocalDate.now()).getDays();
    }
}