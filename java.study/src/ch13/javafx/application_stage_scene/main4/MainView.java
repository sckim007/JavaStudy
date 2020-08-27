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
		/** 루트노드 정의 */
		BorderPane root = new BorderPane();
		
		/** 메뉴 정의 */
		MenuBar  menuBar = new MenuBar();
		menuBar.setPrefHeight(30);
		root.setTop(menuBar);
		Menu menu = new Menu("메뉴");
		menuBar.getMenus().add(menu);
		MenuItem menuItem = new MenuItem("바로가기");
		
		/** 메뉴 아이템 클릭 이벤트 정의 */
		menuItem.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				/** 화면전화 - 메인화면 2로 가기 */
				root.setCenter(DataContainer.getPane(MyPane2.class));
			}
		});
		menu.getItems().add(menuItem);
		
		/** 메인화면 추가 */
		MyPane1 main1 = DataContainer.getPane(MyPane1.class);
		root.setCenter(main1);
		Scene scene = new Scene(root, 300, 200);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		/** 메인화면1, 메인화면2를 등록 */
		DataContainer.addPane(new MyPane1());
		DataContainer.addPane(new MyPane2());
		
		/** 윈도우 실행 */
		launch(args);
	}
}
