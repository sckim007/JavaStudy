package ch13.javafx.basic.main7.sub2;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

public class Controller implements Initializable{
	
	/** FXML에 등록된 아이디를 전역변수로 정의 */
	@FXML
	private Button btn1;
	/** FXML에 등록된 아이디를 전역변수로 정의 */
	@FXML
	private TextArea textArea1;
	
	private static int gcounter;
	
	/* 프로그램 실행 시 구동되는 초기화 함수 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		/** textArea에 문자열 출력 */
		textArea1.setText("textArea1");

		/* textArea1 키이벤트 정의 */
		
		textArea1.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				System.out.println(event.getCode());
			}
		});
		
		textArea1.setText("버튼 클릭 이벤트");
	}

	/** 버튼클릭 이벤트 함수 정의 - FXML을 이용한 정의 */
	@FXML
	public void clickButton(ActionEvent event){
		
		String msg = "버튼 클릭 이벤트" + gcounter++;
		textArea1.setText(msg);
	}
}
