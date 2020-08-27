package ch13.javafx.application_stage_scene.main2.sub2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MainView extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		/** ���� �����̳� ���� */
		FlowPane pane = new FlowPane();
		pane.setHgap(10);
		pane.setPadding(new Insets(10));
				
		/** ��ư ��ü ���� */
		Button btn1 = new Button("����1");
		Button btn2 = new Button("����2");
		Button btn3 = new Button("����3");
				
		/** [1] ��ư Ŭ�� �̺�Ʈ ���� */
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				/** stage �����Լ� ȣ�� */
				stage.close();
			}
		});
		
		/** [2] ��ư Ŭ�� �̺�Ʈ ���� */
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				/** Platform �����Լ� ȣ�� */
				Platform.exit();
			}
		});
		
		/** [3] ��ư Ŭ�� �̺�Ʈ ���� */
		btn3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				/** �ý��� ���������Լ� ȣ�� */
				System.exit(0);
			}
		});
		
		/** ����ȭ�� ���� �� �⺻���� */
		pane.getChildren().addAll(btn1, btn2, btn3);
		Scene scene = new Scene(pane,400,200);
		stage.setScene(scene);
		stage.show();
	}
	
	@Override
	public void stop() throws Exception {
		System.out.println("stop() \t JavaFx ����� ȣ��Ǵ� ����");
	}

	public static void main(String[] args) {
		launch(args);

	}

}
