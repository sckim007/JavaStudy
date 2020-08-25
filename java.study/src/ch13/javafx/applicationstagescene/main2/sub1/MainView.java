package ch13.javafx.applicationstagescene.main2.sub1;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainView extends Application {

	@Override
	public void init() throws Exception{
		System.out.println("init() \t JavaFx �ʱ�ȭ  ���� ���� ����");
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		System.out.println("start() \t ȭ�� ������ ���� ���� ����");
		primaryStage.show();
	}
	
	@Override
	public void stop() throws Exception{
		System.out.println("stop() \t JavaFx ����� ȣ��Ǵ� ����");
	}

	public static void main(String[] args) {

		launch(args);
	}

}
