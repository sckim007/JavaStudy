package ch18.network.tcp.main3;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ClientUI extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		try {
			/** ����ȭ�� �ε� */
			Pane load = (Pane)FXMLLoader.load(ClientUI.class.getResource("ClientLayout.fxml"));
			stage.setScene(new Scene(load));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		stage.setTitle("Ŭ���̾�Ʈ");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
