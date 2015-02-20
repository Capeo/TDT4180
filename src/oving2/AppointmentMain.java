package oving2;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppointmentMain extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		Parent parent = FXMLLoader.load(this.getClass().getResource("Avtaleskjema.fxml"));
		URL url = this.getClass().getResource("Avtaleskjema.css");
		parent.getStylesheets().add(url.toString());
		stage.setScene(new Scene(parent));
		stage.show();
		
	}

	public static void main(String[] args){
		launch(args);
	}
	
}
