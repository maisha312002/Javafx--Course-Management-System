package application;
import uap.CourseManagementSystem;
import uap.DataHandler;

import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class MainController {
	private Stage stage;
	private Scene scene;
	private Parent root;

    @FXML
    private Label textlabel;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button clickButton;

    @FXML
    private Button signInButton;
    
    public static CourseManagementSystem cmSystem = new CourseManagementSystem("uap management");


    @FXML
    public void LogIn(ActionEvent e) throws IOException {
    	String Password = passwordField.getText();
    	if(Password.equals("a123")) {
    	 root = FXMLLoader.load(getClass().getResource("AdminInterface.fxml"));
    	 stage=(Stage)((Node)e.getSource()).getScene().getWindow();
    	 scene= new Scene(root);
    	 stage.setScene(scene);
    	}
    	else if(Password.equals("s123")) {
    		root = FXMLLoader.load(getClass().getResource("StudentInterface.fxml"));
       	 stage=(Stage)((Node)e.getSource()).getScene().getWindow();
       	 scene= new Scene(root);
       	 stage.setScene(scene);
    		
    	}
    	else if(Password.equals("i123")) {
    		root = FXMLLoader.load(getClass().getResource("InstructorInterface.fxml"));
       	 stage=(Stage)((Node)e.getSource()).getScene().getWindow();
       	 scene= new Scene(root);
       	 stage.setScene(scene);
    		
    	}
    	else {
    		JOptionPane.showMessageDialog(null, "Incorrect Password");
    	}
    }

    @FXML
    public void SignIn(ActionEvent e) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
   	 stage=(Stage)((Node)e.getSource()).getScene().getWindow();
   	 scene= new Scene(root);
   	 stage.setScene(scene);
    }

    
}

