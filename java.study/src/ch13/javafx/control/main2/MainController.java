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
	
	/** MainLayout 파일을 로딩 후 initialize() 함수를 구동한다. */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		/** ToggleGroup toggle 객체 생성 */
		ToggleGroup group = new ToggleGroup();
		String[][] data = {{"01","자료1"}, {"02","자료2"}, {"03","자료3"}, {"04","자료4"}};
		for (String[] arr : data) {
			/** 코드 4개를 이용하여 라디오 버튼 객체 생성 */
			RadioButton r = new RadioButton(arr[1]);
			
			/** flowPane 객체 추가 --> userData 코드 등록 --> toggle 그룹 추가 */
			flowPane.getChildren().add(r);
			r.setUserData(arr[0]);
			group.getToggles().add(r);
		}
		
		/** btn 클릭 이벤트 구현 */
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				/** 세 번째 코드를 선택하도록 구현 */
				group.selectToggle(group.getToggles().get(2));
			}
		});
		
		/** group 선택 변경 시 발생이벤트 구현 */  /* <-- 오류 --> */
		//group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
		//	@Override
		//	public void changed(ObservableValue<? extends Toogle> observable, Toggle oldValue, Toggle newValue) {
		//		/** 해당 라디오 버튼 객체 조회 및 코드번호 조회 */
		//		RadioButton r = (RadioButton)newValue;
		//		textField.setText("선택:" + r.getText() + ":" + r.getUserData());
		//	}
		//});
		
		/** group 선택 변경 시 발생이벤트 구현 */  /* <-- 성공 --> */
        group.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> 
            observ, Toggle oldVal, Toggle newVal)->{

            	/** 해당 라디오 버튼 객체 조회 및 코드번호 조회 */
			RadioButton r = (RadioButton)newVal;
			textField.setText("선택:" + r.getText() + ":" + r.getUserData());

        });
	}
}
