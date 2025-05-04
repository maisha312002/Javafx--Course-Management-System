package application;
import uap.DataHandler;
import uap.CourseManagementSystem;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import uap.DataHandler;

public class SignInController {
	private Stage stage;
	private Scene scene;
	private Parent root;

    @FXML
    private TextField name;

    @FXML
    private TextField age;

    @FXML
    private Button signInButton;
    
    

    @FXML
    void SignIn(ActionEvent e) throws IOException {
        String studentName = name.getText();
        String studentAge = age.getText();
        
        
        
        	 root = FXMLLoader.load(getClass().getResource("StudentInterface.fxml"));
        	 stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        	 scene= new Scene(root);
        	 stage.setScene(scene);
        	 stage.show();
        	}
        
       
    }

