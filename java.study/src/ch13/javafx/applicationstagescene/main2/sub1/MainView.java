package ch13.javafx.applicationstagescene.main2.sub1;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainView extends Application {

	@Override
	public void init() throws Exception{
		System.out.println("init() \t JavaFx 초기화  로직 구현 구간");
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		System.out.println("start() \t 화면 구성을 위한 로직 구간");
		primaryStage.show();
	}
	
	@Override
	public void stop() throws Exception{
		System.out.println("stop() \t JavaFx 종료시 호출되는 구간");
	}

	public static void main(String[] args) {

		launch(args);
	}

}
