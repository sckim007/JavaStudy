package ch13.javafx.application_stage_scene.main4;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class MyPane1 extends Pane {
	public MyPane1() {
		/** Text ��ü���� �� ��ġ���� �� ���� �����̳ʿ� �߰� */
		Text text = new Text("����ȭ��1");
		text.relocate(10, 10);
		getChildren().add(text);
	}
}
