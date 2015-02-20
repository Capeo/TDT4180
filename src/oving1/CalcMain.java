package oving1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalcMain extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		Parent root = FXMLLoader.load(this.getClass().getResource("Calculator.fxml"));
		arg0.setScene(new Scene(root));
		arg0.show();
	}
	
	public static void main(String[] args){
		launch(args);
	}

}
