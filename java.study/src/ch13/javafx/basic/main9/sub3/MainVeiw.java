package ch13.javafx.basic.main9.sub3;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainVeiw extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		URL resource = getClass().getResource("RootLayout.fxml");
		AnchorPane root = (AnchorPane)FXMLLoader.load(resource);
		Scene scene = new Scene(root);
		
		String urlString = getClass().getResource("design.css").toExternalForm();
		scene.getStylesheets().add(urlString);
		
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
