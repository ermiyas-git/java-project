
package Employee;

import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.Date;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;

import javax.swing.JOptionPane;
import Login.LoginController;
import Login.Conn;
import java.time.format.DateTimeFormatter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Employee_LeaveApplicationController {

    @FXML
    private DatePicker StartDateButton;

    @FXML
    private DatePicker EndDateButton;

    @FXML
    private TextArea ReasonTextArea;

    @FXML
    private Button Submit;
    
    @FXML
    private Button CancelButton;
   
    @FXML
    void onClick_CancelButton(ActionEvent event) throws IOException {
    	AnchorPane Employee_MyHR_Pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Applications.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("EMS | Employee | Leave Application");
        window1.setScene(new Scene(Employee_MyHR_Pane));
        window1.centerOnScreen();
        window1.setResizable(false);
        window1.show(); 
    }
    @FXML
void onClick_Submit(ActionEvent event) throws IOException {
    String e_id ="Employeeid";
    // Validate inputs
    if (StartDateButton.getValue() == null || EndDateButton.getValue() == null) {
        JOptionPane.showMessageDialog(null, "Please select both dates.");
        return;
    }
    if (ReasonTextArea.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Reason cannot be empty.");
        return;
    }

    // Check date validity
    if (checkDate(StartDateButton.getValue(), EndDateButton.getValue()) <= 0) {
        JOptionPane.showMessageDialog(null, "End date must be after start date.");
        return;
    }

    // Fetch user name
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

    // Insert leave application
    try {
        Conn c2 = new Conn();
        
         PreparedStatement pstmt = c2.prepareStatement(
             "INSERT INTO leave_applications (employee_id,  LStartDate, LEndDate, Reason, LStatus, processed_by ) " +
             "VALUES (?, ?, ?, ?, ?, ?)"); 
        pstmt.setString(1, e_id);     
        pstmt.setDate(2, Date.valueOf(StartDateButton.getValue()));
        pstmt.setDate(3, Date.valueOf(EndDateButton.getValue()));
        pstmt.setString(4, ReasonTextArea.getText());
        pstmt.setString(5, "Pending");
        pstmt.setString(6, "Not Processed");
         
        pstmt.executeUpdate();
        JOptionPane.showMessageDialog(null, "Application submitted successfully!");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error submitting application: " + e.getMessage());
        return;
    }

    // Navigate back
    AnchorPane pane = FXMLLoader.load(getClass().getResource("Employee_Applications.fxml"));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(new Scene(pane));
    stage.show();
}

public int checkDate(LocalDate startDate, LocalDate endDate) {
    return Period.between(startDate, endDate).getDays();
}

}


