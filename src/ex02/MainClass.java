package ex02;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainClass extends Application {

	//미디어플레이어를 사용할 때는 ${javafxCompControls},javafx.fxml,javafx.web를 추가해야한다.
	
	@Override
	public void start(Stage arg0) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("eventTest.fxml"));
		Parent root = loader.load();
		
		Scene sc = new Scene(root);
		
		Controller ctl = loader.getController();
		ctl.setRoot(root);
		
		arg0.setScene(sc);
		arg0.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
