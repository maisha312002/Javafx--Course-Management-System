package application;
import uap.DataHandler;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import Uap.*;


public class StudentInterfaceController {
	
	@FXML
	private TextField text;
	
	@FXML
	private ListView<String> view;
	
	public static CourseManagementSystem CMS = new CourseManagementSystem("uap management");
	
	private String studentId; 
	
	public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
		
	
	public void searchButton(ActionEvent event) {
		
		String title = text.getText();
        try {
            ArrayList<CourseRecord> courseRecords = CMS.getOfferedCoursesWithTitle(title);
            view.getItems().clear();
            for (CourseRecord record : courseRecords) {
                view.getItems().add(record.getCourseId());
            }
        } catch (NotAvailableException e) {
        	view.getItems().clear();
            view.getItems().add(e.getMessage());
        }
        
	}
	
    public void enrollButton(ActionEvent event) {
    	
    	try {
            Student student = (Student) CMS.findUser(studentId);
            ArrayList<CourseRecord> enrolledCourses = CMS.getRegisteredCourses(student);
            
            view.getItems().clear();
            for (CourseRecord record : enrolledCourses) {
                view.getItems().add(record.getCourseId());
            }
        } catch (InvalidUserException | NotAvailableException e) {
            view.getItems().clear();
            view.getItems().add(e.getMessage());
        }
	}
    
    public void registerButton(ActionEvent event) throws InvalidUserException {
    	
    	String selectedCourseId = view.getSelectionModel().getSelectedItem();
        if (selectedCourseId != null) {
            try {
                Student student = (Student) CMS.findUser(studentId);
                CMS.registerStudent(student, selectedCourseId);
                view.getItems().add("Successfully registered for course: " + selectedCourseId);
            } catch (InvalidCourseException e) {
            	view.getItems().clear();
                view.getItems().add(e.getMessage());
            }
        } else {
            view.getItems().add("No courses selected");
        }
        
	}
    
    public void attendButton(ActionEvent event) throws InvalidUserException {
    	
    	 String selectedCourseId = view.getSelectionModel().getSelectedItem();
         if (selectedCourseId != null) {
             try {
                 Student student = (Student) CMS.findUser(studentId);
                 CMS.attendClass(student, selectedCourseId);
                 view.getItems().add("Successfully attended a class: " + selectedCourseId);
             } catch (InvalidCourseException e) {
             	view.getItems().clear();
                 view.getItems().add(e.getMessage());;
             }
         } else {
             view.getItems().add("No courses selected");
         }
	}
    
    public void completeButton(ActionEvent event) throws InvalidUserException {
    	
    	String selectedCourseId = view.getSelectionModel().getSelectedItem();
        if (selectedCourseId != null) {
            try {
                Student student = (Student) CMS.findUser(studentId);
                CMS.completeCourse(student, selectedCourseId);
                view.getItems().add("Successfully completed course: " + selectedCourseId);
            } catch (InvalidCourseException e) {
            	view.getItems().clear();
                view.getItems().add(e.getMessage());
            }
        } else {
            view.getItems().add("No courses selected");
        }
	}

}
