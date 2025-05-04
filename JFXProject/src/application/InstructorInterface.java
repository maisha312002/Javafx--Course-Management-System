package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;


public class InstructorInterface extends Application {
	@Override
	public void start(Stage stage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("InstructorInterface.fxml"));
	Scene scene = new Scene(root);
	stage.setScene(scene);
	stage.setTitle("Instructor Interface");
	stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
