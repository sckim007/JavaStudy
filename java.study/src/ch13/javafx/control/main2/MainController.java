package ch13.javafx.control.main2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;

public class MainController implements Initializable{
	
	@FXML	private FlowPane flowPane;
	@FXML	private Button btn;
	@FXML	private TextField textField;
	
	/** MainLayout ������ �ε� �� initialize() �Լ��� �����Ѵ�. */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		/** ToggleGroup toggle ��ü ���� */
		ToggleGroup group = new ToggleGroup();
		String[][] data = {{"01","�ڷ�1"}, {"02","�ڷ�2"}, {"03","�ڷ�3"}, {"04","�ڷ�4"}};
		for (String[] arr : data) {
			/** �ڵ� 4���� �̿��Ͽ� ���� ��ư ��ü ���� */
			RadioButton r = new RadioButton(arr[1]);
			
			/** flowPane ��ü �߰� --> userData �ڵ� ��� --> toggle �׷� �߰� */
			flowPane.getChildren().add(r);
			r.setUserData(arr[0]);
			group.getToggles().add(r);
		}
		
		/** btn Ŭ�� �̺�Ʈ ���� */
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				/** �� ��° �ڵ带 �����ϵ��� ���� */
				group.selectToggle(group.getToggles().get(2));
			}
		});
		
		/** group ���� ���� �� �߻��̺�Ʈ ���� */  /* <-- ���� --> */
		//group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
		//	@Override
		//	public void changed(ObservableValue<? extends Toogle> observable, Toggle oldValue, Toggle newValue) {
		//		/** �ش� ���� ��ư ��ü ��ȸ �� �ڵ��ȣ ��ȸ */
		//		RadioButton r = (RadioButton)newValue;
		//		textField.setText("����:" + r.getText() + ":" + r.getUserData());
		//	}
		//});
		
		/** group ���� ���� �� �߻��̺�Ʈ ���� */  /* <-- ���� --> */
        group.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> 
            observ, Toggle oldVal, Toggle newVal)->{

            	/** �ش� ���� ��ư ��ü ��ȸ �� �ڵ��ȣ ��ȸ */
			RadioButton r = (RadioButton)newVal;
			textField.setText("����:" + r.getText() + ":" + r.getUserData());

        });
	}
}
