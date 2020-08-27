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
			
			/** fxml ���� �ε� */
			//Pane load = (Pane)FXMLLoader.load(MainUI.class.getResource("ch13.javafx.control.main2.MainLayout.fxml"));
			//Pane load = (Pane)FXMLLoader.load(URL.class.getResource.("MainLayout.fxml"));
			//Pane load = (Pane)FXMLLoader.load(URL.class.getClassLoader().getResource("ch13.javafx.control.main2.MainLayout.fxml"));
			Pane load = (Pane)FXMLLoader.load(getClass().getResource("MainLayout.fxml"));
			
			/** Scene ��ü ���� �� Stage�� Scene ��ü ��� */
			stage.setScene(new Scene(load));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/** �ݵ�� show()�� �ؾ� ȭ�鿡 ��Ÿ����. */
		stage.setTitle("�׽�Ʈ");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
