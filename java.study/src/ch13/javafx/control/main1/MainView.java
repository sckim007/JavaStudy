package ch13.javafx.control.main1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainView extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		/** ��Ʈ��� ���� */
		AnchorPane root = new AnchorPane();
		
		/** �ؽ�Ʈ�ʵ� ��ü ���� �� �⺻ ���� */
		TextField textField = new TextField();
		textField.setLayoutX(10);
		textField.setLayoutY(10);
		textField.setPrefSize(200, 30);
		
		/** ��ư ��ü���� �� �⺻���� */
		Button btn = new Button("��ư");
		btn.setLayoutX(10);
		btn.setLayoutY(50);
		btn.setPrefSize(100, 30);
		
		/** ��Ʈ��忡 ��Ʈ�� �߰� */
		root.getChildren().addAll(textField, btn);
		
		stage.setScene(new Scene(root, 300, 300));
		stage.show();
		
		/** ��ưŬ�� �̺�Ʈ �Լ� ���� */
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				/** <Case 1> ��Ŀ�� ���� --> ��ü ���� --> ���� �� �ܼ� ���  */
				textField.requestFocus();
				textField.selectAll();
				String text = textField.getSelectedText();
				System.out.println("������ �ؽ�Ʈ :" + text);
				
				/** <Case 2>��Ŀ�� ���� --> Ŀ���� �Ǿ����� �̵�	*/
				/*
				textField.requestFocus();
				textField.home();
				*/
			}
		});
		
		/** <Case 3> Ű(Key) �̺�Ʈ */
		textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				/** ����Ű�� �Է� �� ó���ϱ� ���� �б� ���� */
				if(KeyCode.ENTER == event.getCode())
				{
					System.out.println("Enter key pressed !!!");
				}
			}
		});
	}

	public static void main(String[] args) {
		launch(args);
	}
}
