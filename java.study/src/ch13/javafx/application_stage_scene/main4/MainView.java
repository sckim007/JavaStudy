package ch13.javafx.application_stage_scene.main4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainView extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		/** ��Ʈ��� ���� */
		BorderPane root = new BorderPane();
		
		/** �޴� ���� */
		MenuBar  menuBar = new MenuBar();
		menuBar.setPrefHeight(30);
		root.setTop(menuBar);
		Menu menu = new Menu("�޴�");
		menuBar.getMenus().add(menu);
		MenuItem menuItem = new MenuItem("�ٷΰ���");
		
		/** �޴� ������ Ŭ�� �̺�Ʈ ���� */
		menuItem.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				/** ȭ����ȭ - ����ȭ�� 2�� ���� */
				root.setCenter(DataContainer.getPane(MyPane2.class));
			}
		});
		menu.getItems().add(menuItem);
		
		/** ����ȭ�� �߰� */
		MyPane1 main1 = DataContainer.getPane(MyPane1.class);
		root.setCenter(main1);
		Scene scene = new Scene(root, 300, 200);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		/** ����ȭ��1, ����ȭ��2�� ��� */
		DataContainer.addPane(new MyPane1());
		DataContainer.addPane(new MyPane2());
		
		/** ������ ���� */
		launch(args);
	}
}
