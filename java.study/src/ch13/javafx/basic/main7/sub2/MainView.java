package ch13.javafx.basic.main7.sub2;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainView extends Application {

	/** Application Ŭ������ ����ϴ� ��� �ݵ�� �����ؾ� �ϴ� �Լ� : Override */
	@Override
	public void start(Stage stage) throws Exception {

		/** FXML�� �̿��� �����̳� ���� */
		URL resource = getClass().getResource("RootLayout.fxml");
		AnchorPane root = (AnchorPane)FXMLLoader.load(resource);
		Scene scene = new Scene(root);
		
		/** scene ��ü�κ��� FXML ��ü ���� */
		Button btn1 = (Button)scene.lookup("#btn1");
		System.out.println("btn1="+btn1);
		
		/** stage�� scene�� ���� */
		stage.setScene(scene);
		/** stage�� ��� */
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
