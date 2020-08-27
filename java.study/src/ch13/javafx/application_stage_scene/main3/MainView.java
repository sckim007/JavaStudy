package ch13.javafx.application_stage_scene.main3;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainView extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		/** �������� ������ �̹����� �߰��ϱ� */
		
		/** ������ Ÿ��Ʋ ���� */
		stage.setTitle("Ÿ��Ʋ");
				
		/** �׻� ȭ�� ���� ��Ÿ������ ���� */
		stage.setAlwaysOnTop(true);
		
		/** ������ �ִ� �ʺ�, ���� ���� */
		stage.setMaxWidth(400);
		stage.setMaxHeight(400);
		
		/** �����찡 ��ũ���� ������ ���� ���� */
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
