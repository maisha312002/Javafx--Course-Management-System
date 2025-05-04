package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;


public class AdminInterface extends Application {
	@Override
	public void start(Stage stage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AdminInterface.fxml"));
	Scene scene = new Scene(root);
	stage.setScene(scene);
	stage.setTitle("Admin Interface");
	stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}

