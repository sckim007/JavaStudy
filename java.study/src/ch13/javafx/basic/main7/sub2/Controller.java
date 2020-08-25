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
	
	/** FXML�� ��ϵ� ���̵� ���������� ���� */
	@FXML
	private Button btn1;
	/** FXML�� ��ϵ� ���̵� ���������� ���� */
	@FXML
	private TextArea textArea1;
	
	private static int gcounter;
	
	/* ���α׷� ���� �� �����Ǵ� �ʱ�ȭ �Լ� */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		/** textArea�� ���ڿ� ��� */
		textArea1.setText("textArea1");

		/* textArea1 Ű�̺�Ʈ ���� */
		
		textArea1.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				System.out.println(event.getCode());
			}
		});
		
		textArea1.setText("��ư Ŭ�� �̺�Ʈ");
	}

	/** ��ưŬ�� �̺�Ʈ �Լ� ���� - FXML�� �̿��� ���� */
	@FXML
	public void clickButton(ActionEvent event){
		
		String msg = "��ư Ŭ�� �̺�Ʈ" + gcounter++;
		textArea1.setText(msg);
	}
}
