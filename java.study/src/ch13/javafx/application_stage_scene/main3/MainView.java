package ch13.javafx.application_stage_scene.main3;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainView extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		/** 위도우의 아이콘 이미지를 추가하기 */
		
		/** 윈도우 타이틀 설정 */
		stage.setTitle("타이틀");
				
		/** 항상 화면 위에 나타나도록 설정 */
		stage.setAlwaysOnTop(true);
		
		/** 윈도우 최대 너비, 높이 설정 */
		stage.setMaxWidth(400);
		stage.setMaxHeight(400);
		
		/** 윈도우가 스크린에 보일지 여부 설정 */
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
