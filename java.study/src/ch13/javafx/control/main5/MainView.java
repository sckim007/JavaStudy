package ch13.javafx.control.main5;

import ch13.javafx.control.main4.ProductVo;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MainView extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		/** 루트노드 정의 */
		BorderPane root = new BorderPane();
		
		/** Table View 정의 */
		TableView<ProductVo> tableView = new TableView<ProductVo>();
		root.setCenter(tableView);
		
		/** Table Column 정의 */
		TableColumn<ProductVo, String> tc1 = new TableColumn<ProductVo, String>();
		TableColumn<ProductVo, String> tc2 = new TableColumn<ProductVo, String>();
		TableColumn<ProductVo, String> tc3 = new TableColumn<ProductVo, String>();
		
		/** 테이블 - 컬럼 추가 */
		tableView.getColumns().setAll(tc1, tc2, tc3);
		
		/** Column(컬럼) - TableVo(데이터타입) 매핑 정의 */
		tc1.setCellValueFactory(new PropertyValueFactory<ProductVo, String>("productNo"));
		tc2.setCellValueFactory(new PropertyValueFactory<ProductVo, String>("productName"));
		tc3.setCellValueFactory(new PropertyValueFactory<ProductVo, String>("price"));
		
		/** 컬럼 정렬 */
		tc1.setStyle("-fx-alignment:CENTER");;
		tc2.setStyle("-fx-alignment:CENTER-LEFT");
		tc3.setStyle("-fx-alignment:CENTER-RIGHT");
		
		/** 컬럼너비 비율 설정 */
		tc1.prefWidthProperty().bind(tableView.widthProperty().divide(100).multiply(0.2));
		tc2.prefWidthProperty().bind(tableView.widthProperty().divide(100).multiply(0.5));
		tc3.prefWidthProperty().bind(tableView.widthProperty().divide(100).multiply(0.3));
		
		/** 오른쪽 버튼을 수직으로 담기 위해 FlowPane 정의 */
		FlowPane pane = new FlowPane(Orientation.VERTICAL);
		pane.setPadding(new Insets(10));
		pane.setVgap(10);
		pane.setPrefSize(100, 100);
		pane.setMinWidth(150);
		root.setRight(pane);
		
		/** FlowPane에 담을 버튼 정의 */
		Button btn1 = new Button("자료등록");
		Button btn2 = new Button("자료추가");
		Button btn3 = new Button("자료삭제");
		Button btn4 = new Button("자료선택(셀선택)");
		Button btn5 = new Button("자료선택(행선택)");
		
		/** 버튼 너비지정 : pane의 너비보다 20px 작도록 지정 */
		btn1.prefWidthProperty().bind(pane.prefWidthProperty().subtract(20));
		btn2.prefWidthProperty().bind(pane.prefWidthProperty().subtract(20));
		btn3.prefWidthProperty().bind(pane.prefWidthProperty().subtract(20));
		btn4.prefWidthProperty().bind(pane.prefWidthProperty().subtract(20));
		btn5.prefWidthProperty().bind(pane.prefWidthProperty().subtract(20));
		
		/** 버튼을 FlowPane에 각 버튼을 추가 */
		pane.getChildren().addAll(btn1, btn2, btn3, btn4, btn5);
		
		/** 하단 BorderPane 정의 --> CENTER 부부 TextArea 객체 추가 */
		BorderPane pane2 = new BorderPane();
		pane2.setPadding(new Insets(10));
		root.setBottom(pane2);

		TextArea textArea = new TextArea();
		textArea.setPrefHeight(60);
		pane2.setCenter(textArea);
		
		/** 자료등록 버튼 이벤트 */
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				/** 자료등록 로직 처리 */
				ProductVo v1 = new ProductVo("a001", "아메리카노", 4000);
				ProductVo v2 = new ProductVo("a002", "까페라떼", 4300);
				ProductVo v3 = new ProductVo("a003", "까페모카", 4500);
				ObservableList<ProductVo> list = FXCollections.observableArrayList(v1, v2, v3);
				tableView.setItems(list);
			}
		});
		
		/** 자료추가 버튼 이벤트 */
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				/** 자료추가 로직 처리 */
				ProductVo v = new ProductVo("a004", "아이스티", 4000);
				tableView.getItems().add(v);
			}
		});
		
		/** 자료삭제 버튼 이벤트 */
		btn3.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				/** 자료삭제 로직 처리 */
				int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
				if (selectedIndex >= 0) {
					tableView.getItems().remove(selectedIndex);
				} else {
					/** 선택한 자료가 없을 경우 안내처리 */
					String msg = "삭제할 데이터를 선택 후 실행하시기 바랍니다.";
					Alert alert = new Alert(AlertType.INFORMATION, msg);
					alert.setHeaderText("자료안내삭제");
					alert.show();
				}
			}
		});
		
		/** 셀단위 선택 이벤트 */
		btn4.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				/** 셀단위 선택 로직 처리 */
				tableView.getSelectionModel().setCellSelectionEnabled(true);
				ObservableList<TableColumn<ProductVo, ?>> columns = tableView.getColumns();
				
				/** 1행 1열의 데이터가 있을 경우 자료선택 */
				if (columns.size() > 0 && tableView.getItems().size() > 0) {
					TableColumn<ProductVo, ?> tableColumn = tableView.getColumns().get(0);
				}
				String msg = "테이블의 셀을 클릭해 보세요";
				Alert alert = new Alert(AlertType.INFORMATION, msg);
				alert.setHeaderText("테이블 셀 선택 기능");
				alert.show();
				
			}
		});
		
		/** 행단위 선택 이벤트 */
		btn5.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				/** 행단위 선택 로직 처리 */
				tableView.getSelectionModel().setCellSelectionEnabled(false);
				ObservableList<TableColumn<ProductVo, ?>> columns = tableView.getColumns();
				
				if (tableView.getItems().size() > 0) {
					tableView.getSelectionModel().select(0);
				}
				String msg = "테이블의 셀을 클릭해 보세요";
				Alert alert = new Alert(AlertType.INFORMATION, msg);
				alert.setHeaderText("테이블 행 선택 기능");
				alert.show();
			}
		});
		
		/** 테이블 클릭 선택 이벤트 - 리스너*/
		tableView.getSelectionModel().selectedItemProperty().addListener(
				(ObservableValue<? extends ProductVo> observ,
				ProductVo oldVal,
				ProductVo newVal)->{

			/** 선택 값을 TextArea에 나타내기 */
			String msg = "ProductNo[" + newVal.getProductNo() +"]";
			msg += ", ProductName[" + newVal.getProductName() + "]";
			msg += ", Price[" + newVal.getPrice();
			textArea.setText(msg);
		});
		
		/** Scene 객체 생성 및 Stage Scene 객체등록, show() */
		Scene scene = new Scene(root, 600, 400);
		//scene.getStylesheets().add("design.css");  /*ch13/part06/main1/scene.css*/
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
