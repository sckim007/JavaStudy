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
		/** AnchorPane �⺻ �����̳� ��ü���� */
		AnchorPane pane = new AnchorPane();
		pane.setPrefSize(300, 150);
		
		/** �޺��ڽ� ��ü ���� */
		ComboBox<String> c1 = new ComboBox<String>();
		//ChoiceBox<String> c1 = new ChoiceBox<String>();
		
		c1.setPrefSize(150, 20);
		c1.relocate(10, 10);
		pane.getChildren().add(c1);
		
		/** �޺��ڽ� �ڷᱸ�� �� �߰� */
		String[] codes = {"��", "��", "��"};
		c1.getItems().setAll(codes);
		
		/** �޺��ڽ� �ʱ��ڷ� ���� */
		c1.getSelectionModel().select(2);
		
		/** �޺��۽� �ڷἱ�� �̺�Ʈ ���� */
		c1.getSelectionModel().selectedItemProperty().addListener(
						(ObservableValue<? extends String> observ,
						String oldVal,
						String newVal)->{

        	/** ���õ� �ڷ�ó�� - �ܼ�ȭ�鿡 �ڷ� ��� */
			System.out.println("[�ڷἱ��]" + newVal);
        });
		
		/** �޺��۽� �ε������� �̺�Ʈ ���� */
		c1.getSelectionModel().selectedIndexProperty().addListener(
				(ObservableValue<? extends Number> observ,
				Number oldVal,
				Number newVal)->{

			/** ���õ� �ڷ�ó�� - �ܼ�ȭ�鿡 �ڷ� ��� */
			System.out.println("[�ڷἱ���ε���]" + newVal);
		});

		/** ȭ�� ��� */
		stage.setScene(new Scene(pane));
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
