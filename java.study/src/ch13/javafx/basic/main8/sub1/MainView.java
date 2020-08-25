package ch13.javafx.basic.main8.sub1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MainView extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		/** �ֻ��� �����̳� ��ü ���� */
		FlowPane flowPane = new FlowPane();
		/** FlowPane ���ο� �߰��Ǵ� ��Ʈ���� ȭ�� �߾����� �߰� */
		flowPane.setAlignment(Pos.CENTER);
		/** �����̳� �����¿� ������ 10px�� ���� */
		flowPane.setPadding(new Insets(10));
		/** �����̳� ���ο� �߰��Ǵ� ��Ʈ�� ������ 20px�� ���� */
		flowPane.setHgap(20);
		
		
		/** TextField ��ü���� �� �⺻���� */
		TextField textField = new TextField();
		textField.prefWidth(200);
		flowPane.getChildren().add(textField);
		
		/** Label ��ü���� �� �⺻ ���� */
		Label label = new Label();
		label.setPrefWidth(200);
		flowPane.getChildren().add(label);
		
		/** �ؽ�Ʈ ���� �󺧷� ���ε� */
		label.textProperty().bind(textField.textProperty());
		
		/** ȭ�� �⺻ ���� �� ��� */
		stage.setScene(new Scene(flowPane, 450, 100));
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
