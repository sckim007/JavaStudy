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
	
	/** PropertyVo Ŭ���� ���� */
	public class PropertyVo{
		private IntegerProperty value = new SimpleIntegerProperty();
		public int getValue() {return value.get();}
		public void setValue(int value) {this.value.set(value);}
		public IntegerProperty valueProperty() {return value;}
	}

	@Override
	public void start(Stage stage) throws Exception {
		/** �ֻ��� �����̳� ��ü ���� */
		FlowPane flowPane = new FlowPane();
		/** FlowPane ���ο� �߰��Ǵ� ��Ʈ���� ȭ�� �߾����� �߰� */
		flowPane.setAlignment(Pos.CENTER);
		/** �����̳� �����¿� ������ 10px�� ���� */
		flowPane.setPadding(new Insets(10));
		/** �����̳� ���ο� �߰��Ǵ� ��Ʈ�� ������ 20px�� ���� */
		flowPane.setHgap(20);
		
		/** Label ��ü���� �� �⺻ ���� */
		Label label = new Label("�ؽ�Ʈ ����");
		label.setPrefWidth(200);
		flowPane.getChildren().add(label);
		
		/** TextField ��ü���� �� �⺻���� */
		TextField textField = new TextField();
		textField.prefWidth(200);
		flowPane.getChildren().add(textField);
		
		/** Property ��ü ���� �� TextField text �Ӽ��� ���ε� */
		PropertyVo propertyVo = new PropertyVo();
		textField.textProperty().bind(propertyVo.valueProperty().asString());
		
		/** Button ��ü ���� �� Ŭ�� �̺�Ʈ ó�� */
		Button btn = new Button("1������");
		flowPane.getChildren().add(btn);
		btn.setPrefWidth(100);
		btn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				
				/** PropertyVo value �Ӽ��� �� ���� */
				propertyVo.setValue(propertyVo.getValue()+1);   
			}
		});
		
		/** ȭ�� �⺻ ���� �� ��� */
		stage.setScene(new Scene(flowPane, 250, 150));
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
