package ch13.javafx.control.main2;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainUI extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		try {
			
			/** fxml 파일 로딩 */
			//Pane load = (Pane)FXMLLoader.load(MainUI.class.getResource("ch13.javafx.control.main2.MainLayout.fxml"));
			//Pane load = (Pane)FXMLLoader.load(URL.class.getResource.("MainLayout.fxml"));
			//Pane load = (Pane)FXMLLoader.load(URL.class.getClassLoader().getResource("ch13.javafx.control.main2.MainLayout.fxml"));
			Pane load = (Pane)FXMLLoader.load(getClass().getResource("MainLayout.fxml"));
			
			/** Scene 색체 생성 및 Stage에 Scene 객체 등록 */
			stage.setScene(new Scene(load));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/** 반드시 show()를 해야 화면에 나타난다. */
		stage.setTitle("테스트");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
