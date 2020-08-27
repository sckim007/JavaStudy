package ch13.javafx.application_stage_scene.main4;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class MyPane2 extends Pane {
	public MyPane2() {
		/** Text 객체생성 및 위치설정 후 메인 컨테이너에 추가 */
		Text text = new Text("메인화면2");
		text.relocate(10, 10);
		getChildren().add(text);
		
		/** 버튼 객체생성 및 메인 컨테이너에 추가 */
		Button btn = new Button("메인화면1 이동");
		btn.relocate(10, 40);
		btn.setRotate(45);
		getChildren().add(btn);
				
		/** 버튼클릭 이벤트 함수 정의 */
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				/** 이벤트 구현 : 화면전환 - 메인화면 1로 가기 */
				BorderPane root = (BorderPane)getScene().getRoot();
				root.setCenter(DataContainer.getPane(MyPane1.class));
			}
		});
	}
}
