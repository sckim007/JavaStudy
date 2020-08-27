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

		/** 메인 컨테이너 정의 */
		FlowPane pane = new FlowPane();
		pane.setHgap(10);
		pane.setPadding(new Insets(10));
				
		/** 버튼 객체 생성 */
		Button btn1 = new Button("종료1");
		Button btn2 = new Button("종료2");
		Button btn3 = new Button("종료3");
				
		/** [1] 버튼 클릭 이벤트 정의 */
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				/** stage 종료함수 호출 */
				stage.close();
			}
		});
		
		/** [2] 버튼 클릭 이벤트 정의 */
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				/** Platform 종료함수 호출 */
				Platform.exit();
			}
		});
		
		/** [3] 버튼 클릭 이벤트 정의 */
		btn3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				/** 시스템 강제종료함수 호출 */
				System.exit(0);
			}
		});
		
		/** 메인화면 구성 및 기본설정 */
		pane.getChildren().addAll(btn1, btn2, btn3);
		Scene scene = new Scene(pane,400,200);
		stage.setScene(scene);
		stage.show();
	}
	
	@Override
	public void stop() throws Exception {
		System.out.println("stop() \t JavaFx 종료시 호출되는 구간");
	}

	public static void main(String[] args) {
		launch(args);

	}

}
