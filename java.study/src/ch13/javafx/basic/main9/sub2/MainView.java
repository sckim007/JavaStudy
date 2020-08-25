package ch13.javafx.basic.main9.sub2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainView extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		/** Root Node 객체 생성 */
		BorderPane pane = new BorderPane();
		
		/** TextField 객체생성 및 기본설정 */
		TextField textField = new TextField();
		pane.setBottom(textField);
		textField.setText("CSS설정 : 글씨크기 14pt, 색상 : 빨강");
		
		/** TestField CSS 설정 - 폰트크기, 색상 */
		//textField.setStyle("-fx-font-size:14pt; -fx-text-fill:red;");
		
		Scene scene =new Scene(pane,400,100);
		
		/** design.css CSS 파일을 URL 경로를 이용하여 CSS 등록 */
		String urlStr = getClass().getResource("design.css").toExternalForm();
		scene.getStylesheets().add(urlStr);
		
		/** 화면 기본 설정 및 출력 */
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
