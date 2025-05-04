package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;


public class StudentInterface extends Application {
	@Override
	public void start(Stage stage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("StudentInterface.fxml"));
	Scene scene = new Scene(root);
	stage.setScene(scene);
	stage.setTitle("Course Management System");
	stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}

