package ch13.javafx.basic.main7.sub2;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainView extends Application {

	/** Application 클래스를 상속하는 경우 반드시 구현해야 하는 함수 : Override */
	@Override
	public void start(Stage stage) throws Exception {

		/** FXML을 이용한 컨테이너 생성 */
		URL resource = getClass().getResource("RootLayout.fxml");
		AnchorPane root = (AnchorPane)FXMLLoader.load(resource);
		Scene scene = new Scene(root);
		
		/** scene 객체로부터 FXML 객체 접근 */
		Button btn1 = (Button)scene.lookup("#btn1");
		System.out.println("btn1="+btn1);
		
		/** stage에 scene를 설정 */
		stage.setScene(scene);
		/** stage를 출력 */
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
