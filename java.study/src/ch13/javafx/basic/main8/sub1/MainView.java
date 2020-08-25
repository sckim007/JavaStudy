package ch13.javafx.basic.main8.sub1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MainView extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		/** 최상위 컨테이너 객체 생성 */
		FlowPane flowPane = new FlowPane();
		/** FlowPane 내부에 추가되는 컨트롤을 화면 중앙으로 추가 */
		flowPane.setAlignment(Pos.CENTER);
		/** 컨테이너 상하좌우 여백을 10px로 설정 */
		flowPane.setPadding(new Insets(10));
		/** 컨테이너 내부에 추가되는 컨트롤 간격을 20px로 설정 */
		flowPane.setHgap(20);
		
		
		/** TextField 객체생성 및 기본설정 */
		TextField textField = new TextField();
		textField.prefWidth(200);
		flowPane.getChildren().add(textField);
		
		/** Label 객체생성 및 기본 설정 */
		Label label = new Label();
		label.setPrefWidth(200);
		flowPane.getChildren().add(label);
		
		/** 텍스트 값을 라벨로 바인드 */
		label.textProperty().bind(textField.textProperty());
		
		/** 화면 기본 설정 및 출력 */
		stage.setScene(new Scene(flowPane, 450, 100));
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
