package ch13.javafx.basic.main8.sub2;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MainView extends Application {
	
	/** PropertyVo 클래스 정의 */
	public class PropertyVo{
		private IntegerProperty value = new SimpleIntegerProperty();
		public int getValue() {return value.get();}
		public void setValue(int value) {this.value.set(value);}
		public IntegerProperty valueProperty() {return value;}
	}

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
		
		/** Label 객체생성 및 기본 설정 */
		Label label = new Label("텍스트 변경");
		label.setPrefWidth(200);
		flowPane.getChildren().add(label);
		
		/** TextField 객체생성 및 기본설정 */
		TextField textField = new TextField();
		textField.prefWidth(200);
		flowPane.getChildren().add(textField);
		
		/** Property 객체 생성 및 TextField text 속성과 바인딩 */
		PropertyVo propertyVo = new PropertyVo();
		textField.textProperty().bind(propertyVo.valueProperty().asString());
		
		/** Button 객체 생성 및 클릭 이벤트 처ㅣ */
		Button btn = new Button("1씩증가");
		flowPane.getChildren().add(btn);
		btn.setPrefWidth(100);
		btn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				
				/** PropertyVo value 속성에 값 변경 */
				propertyVo.setValue(propertyVo.getValue()+1);   
			}
		});
		
		/** 화면 기본 설정 및 출력 */
		stage.setScene(new Scene(flowPane, 250, 150));
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
