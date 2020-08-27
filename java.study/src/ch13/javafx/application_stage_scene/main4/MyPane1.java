package ch13.javafx.application_stage_scene.main4;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class MyPane1 extends Pane {
	public MyPane1() {
		/** Text 객체생성 및 위치설정 후 메인 컨테이너에 추가 */
		Text text = new Text("메인화면1");
		text.relocate(10, 10);
		getChildren().add(text);
	}
}
