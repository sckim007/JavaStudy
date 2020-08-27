package ch13.javafx.control.main1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainView extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		/** 루트노드 정의 */
		AnchorPane root = new AnchorPane();
		
		/** 텍스트필드 객체 생성 및 기본 설정 */
		TextField textField = new TextField();
		textField.setLayoutX(10);
		textField.setLayoutY(10);
		textField.setPrefSize(200, 30);
		
		/** 버튼 객체생성 및 기본설정 */
		Button btn = new Button("버튼");
		btn.setLayoutX(10);
		btn.setLayoutY(50);
		btn.setPrefSize(100, 30);
		
		/** 루트노드에 컨트롤 추가 */
		root.getChildren().addAll(textField, btn);
		
		stage.setScene(new Scene(root, 300, 300));
		stage.show();
		
		/** 버튼클릭 이벤트 함수 정의 */
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				/** <Case 1> 포커스 설정 --> 전체 선택 --> 선택 값 콘솔 출력  */
				textField.requestFocus();
				textField.selectAll();
				String text = textField.getSelectedText();
				System.out.println("선택한 텍스트 :" + text);
				
				/** <Case 2>포커스 설정 --> 커서를 맨앞으로 이동	*/
				/*
				textField.requestFocus();
				textField.home();
				*/
			}
		});
		
		/** <Case 3> 키(Key) 이벤트 */
		textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				/** 엔터키를 입력 시 처리하기 위한 분기 로직 */
				if(KeyCode.ENTER == event.getCode())
				{
					System.out.println("Enter key pressed !!!");
				}
			}
		});
	}

	public static void main(String[] args) {
		launch(args);
	}
}
