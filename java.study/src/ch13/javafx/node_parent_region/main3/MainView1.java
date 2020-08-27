package ch13.javafx.node_parent_region.main3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainView1 extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		/** 루트노드 root 정의 */
		BorderPane root = new BorderPane();
		
		/** 부모 컨테이너 centerPane 정의 */
		Pane centerPane = new Pane();
		root.setCenter(centerPane);
		
		/** TextField 객체생성 및 기본 설정 */
		TextField tf = new TextField();
		tf.setPrefSize(200, 30);
		tf.relocate(10, 30);
		
		/** Button 객체생성 및 기본 설정 */
		Button btn1 = new Button("버튼");
		btn1.setPrefSize(100, 30);
		btn1.relocate(110,  70);
		
		/** 텍스트 버튼 --> 메인컨테이너로 추가 */
		centerPane.getChildren().addAll(tf, btn1);
		
		/** Scene 객체 생성 */
		Scene scene = new Scene(root, 220, 150);
		stage.setScene(scene);
		stage.show();
		
		/** 버튼 클릭 이벤트 함수 정의 */
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				/** 버튼과 텍스트필드의 위치 출력 */
				printLocateInfo(tf, 10, 10);
				printLocateInfo(btn1, 0, 0);
				
			}
		});
		
		
	}
	
	/** 해당 node를 기준으로 상대경로 x,y 의 거리를 반환하는 함수 */
	public static void printLocateInfo(Node node, double x, double y) {
		Point2D info1 = node.localToParent(x,y);
		Point2D info2 = node.localToScene(x,y);
		Point2D info3 = node.localToScreen(x,y);
		Point2D info4 = node.parentToLocal(x,y);
		Point2D info5 = node.sceneToLocal(x,y);
		Point2D info6 = node.screenToLocal(x,y);
		
		System.out.println("\t localToParent:" + info1);
		System.out.println("\t localToScene:" + info2);
		System.out.println("\t localToScreen:" + info3);
		System.out.println("\t parentToLocal:" + info4);
		System.out.println("\t sceneToLocal:" + info5);
		System.out.println("\t screenToLocal:" + info6);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
