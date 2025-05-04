package application;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Uap.*;

public class AdminInterfaceController implements Initializable {
	
	private CourseManagementSystem cms = new CourseManagementSystem("MyCourseManagementSystem");
	private Stage stage;
	private Scene scene;
	private Parent root;


    @FXML
    private TextField nameTextField;

    @FXML
    private TextField ageTextField;

    @FXML
    private TextField idTextField;

    @FXML
    private ListView<String> listView;


    @FXML
    private Button addCourseButton;

    @FXML
    private ChoiceBox<String> roleChoiceBox;
     private String[] role = {"student","instructor","admin"};

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		roleChoiceBox.getItems().addAll(role);
		
	}
	 @FXML
	    void AddCourse(ActionEvent e) throws IOException {
	    	root = FXMLLoader.load(getClass().getResource("AddCourse.fxml"));
	   	 stage=(Stage)((Node)e.getSource()).getScene().getWindow();
	   	 scene= new Scene(root);
	   	 stage.setScene(scene);
	    }
	 @FXML
	    void logOut(ActionEvent e) throws IOException {
	    	root = FXMLLoader.load(getClass().getResource("LogOut.fxml"));
	   	 stage=(Stage)((Node)e.getSource()).getScene().getWindow();
	   	 scene= new Scene(root);
	   	 stage.setScene(scene);
	    }
	 @FXML
	    void OfferCourse(ActionEvent e) throws IOException {
	    	root = FXMLLoader.load(getClass().getResource("AddCourse.fxml"));
	   	 stage=(Stage)((Node)e.getSource()).getScene().getWindow();
	   	 scene= new Scene(root);
	   	 stage.setScene(scene);
	    }
	 
	 @FXML
	 void addButtonClicked(ActionEvent event) throws FileNotFoundException, IOException {
	        String name = nameTextField.getText();
	        int age = Integer.parseInt(ageTextField.getText());
	        String role = roleChoiceBox.getValue();
	        
	        if (name != null && !name.isEmpty() && role != null && !role.isEmpty()) {
	            String id = cms.addUser(name, age, role);
	            
	            
	            listView.getItems().add(String.format("Added user: Name - %s, Age - %d, Role - %s, ID - %s", name, age, role, id));
	            
	        }
	    }
	 
	 @FXML
	    void searchButtonClicked(ActionEvent event) throws FileNotFoundException, IOException {
	        String id = idTextField.getText();
	        if (id != null && !id.isEmpty()) {
	            try {
	                User user = cms.findUser(id);
	                String userInfo = String.format("Name: %s, Age: %d, Role: %s", user.getName(), user.getAge(), user.getRole());
	                listView.getItems().add(userInfo);
	            } catch (InvalidUserException e) {
	                listView.getItems().add("User not found with ID: " + id);
	            }
	        }
	    }

	    @FXML
	    void viewButtonClicked(ActionEvent event) throws FileNotFoundException, IOException {
	        listView.getItems().clear();
	        for (User user : cms.getUsers()) {
	            String userInfo = String.format("Name: %s, Age: %d, Role: %s, ID: %s", user.getName(), user.getAge(), user.getRole(), user.getId());
	            listView.getItems().add(userInfo);
	            
	        }
	    }

    
}
