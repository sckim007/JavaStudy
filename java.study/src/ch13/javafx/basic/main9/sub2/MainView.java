package ch13.javafx.basic.main9.sub2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainView extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		/** Root Node ��ü ���� */
		BorderPane pane = new BorderPane();
		
		/** TextField ��ü���� �� �⺻���� */
		TextField textField = new TextField();
		pane.setBottom(textField);
		textField.setText("CSS���� : �۾�ũ�� 14pt, ���� : ����");
		
		/** TestField CSS ���� - ��Ʈũ��, ���� */
		//textField.setStyle("-fx-font-size:14pt; -fx-text-fill:red;");
		
		Scene scene =new Scene(pane,400,100);
		
		/** design.css CSS ������ URL ��θ� �̿��Ͽ� CSS ��� */
		String urlStr = getClass().getResource("design.css").toExternalForm();
		scene.getStylesheets().add(urlStr);
		
		/** ȭ�� �⺻ ���� �� ��� */
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
