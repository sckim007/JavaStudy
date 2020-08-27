package ch13.javafx.application_stage_scene.main4;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class MyPane2 extends Pane {
	public MyPane2() {
		/** Text ��ü���� �� ��ġ���� �� ���� �����̳ʿ� �߰� */
		Text text = new Text("����ȭ��2");
		text.relocate(10, 10);
		getChildren().add(text);
		
		/** ��ư ��ü���� �� ���� �����̳ʿ� �߰� */
		Button btn = new Button("����ȭ��1 �̵�");
		btn.relocate(10, 40);
		btn.setRotate(45);
		getChildren().add(btn);
				
		/** ��ưŬ�� �̺�Ʈ �Լ� ���� */
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				/** �̺�Ʈ ���� : ȭ����ȯ - ����ȭ�� 1�� ���� */
				BorderPane root = (BorderPane)getScene().getRoot();
				root.setCenter(DataContainer.getPane(MyPane1.class));
			}
		});
	}
}
