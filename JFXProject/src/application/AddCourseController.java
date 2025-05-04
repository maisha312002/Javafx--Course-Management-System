package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Uap.Course;
import Uap.CourseManagementSystem;
import Uap.InvalidCourseException;
import Uap.InvalidUserException;

public class AddCourseController implements Initializable {
	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
    private TextField titleField;

    @FXML
    private TextField idField;

    @FXML
    private TextField durationField;

    @FXML
    private TextField instructorField;

    @FXML
    private ListView<String> courseListView;
    
    @FXML
    private DatePicker date;

    private CourseManagementSystem cms = new CourseManagementSystem("Your CMS Name");

    @FXML
    void addCourse(ActionEvent event) {
        String title = titleField.getText();
        String courseId = cms.addCourse(title);
        courseListView.getItems().add(courseId + " - " + title);
        titleField.clear();
    }

    @FXML
    void offerCourse(ActionEvent event) {
        String courseId = idField.getText();
        String instructorName = instructorField.getText();
        int duration = Integer.parseInt(durationField.getText());
        String startDate = date.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        try {
            
            cms.offerCourse(courseId, instructorName, startDate, duration);
            
            updateCourseListView(courseId);
        } catch (InvalidCourseException | InvalidUserException e) {
            e.printStackTrace(); 
        }
    }

  
    private void updateCourseListView(String courseId) {
        courseListView.getItems().add(courseId);
    }


    @FXML
    void viewCourseList(ActionEvent event) {
        courseListView.getItems().clear();
        ArrayList<String> coursesInfo = new ArrayList<>();
        
        for (Course course : cms.getCourses()) {
            coursesInfo.add(course.getId() + " - " + course.getTitle());
        }
        courseListView.getItems().addAll(coursesInfo);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialization logic goes here
    }
    

    @FXML
    public void Next(ActionEvent e) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("AdminInterface.fxml"));
   	 stage=(Stage)((Node)e.getSource()).getScene().getWindow();
   	 scene= new Scene(root);
   	 stage.setScene(scene);
    }

}

