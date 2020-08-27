package ch13.javafx.control.main3;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainView extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		/** AnchorPane 기본 컨테이너 객체생성 */
		AnchorPane pane = new AnchorPane();
		pane.setPrefSize(300, 150);
		
		/** 콤보박스 객체 생성 */
		ComboBox<String> c1 = new ComboBox<String>();
		//ChoiceBox<String> c1 = new ChoiceBox<String>();
		
		c1.setPrefSize(150, 20);
		c1.relocate(10, 10);
		pane.getChildren().add(c1);
		
		/** 콤보박스 자료구성 및 추가 */
		String[] codes = {"상", "중", "하"};
		c1.getItems().setAll(codes);
		
		/** 콤보박스 초기자료 선택 */
		c1.getSelectionModel().select(2);
		
		/** 콤보작스 자료선택 이벤트 정의 */
		c1.getSelectionModel().selectedItemProperty().addListener(
						(ObservableValue<? extends String> observ,
						String oldVal,
						String newVal)->{

        	/** 선택된 자료처리 - 콘솔화면에 자료 출력 */
			System.out.println("[자료선택]" + newVal);
        });
		
		/** 콤보작스 인덱스선택 이벤트 정의 */
		c1.getSelectionModel().selectedIndexProperty().addListener(
				(ObservableValue<? extends Number> observ,
				Number oldVal,
				Number newVal)->{

			/** 선택된 자료처리 - 콘솔화면에 자료 출력 */
			System.out.println("[자료선택인덱스]" + newVal);
		});

		/** 화면 출력 */
		stage.setScene(new Scene(pane));
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
