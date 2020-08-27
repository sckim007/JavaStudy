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

		/** ��Ʈ��� ���� */
		BorderPane root = new BorderPane();
		
		/** Table View ���� */
		TableView<ProductVo> tableView = new TableView<ProductVo>();
		root.setCenter(tableView);
		
		/** Table Column ���� */
		TableColumn<ProductVo, String> tc1 = new TableColumn<ProductVo, String>();
		TableColumn<ProductVo, String> tc2 = new TableColumn<ProductVo, String>();
		TableColumn<ProductVo, String> tc3 = new TableColumn<ProductVo, String>();
		
		/** ���̺� - �÷� �߰� */
		tableView.getColumns().setAll(tc1, tc2, tc3);
		
		/** Column(�÷�) - TableVo(������Ÿ��) ���� ���� */
		tc1.setCellValueFactory(new PropertyValueFactory<ProductVo, String>("productNo"));
		tc2.setCellValueFactory(new PropertyValueFactory<ProductVo, String>("productName"));
		tc3.setCellValueFactory(new PropertyValueFactory<ProductVo, String>("price"));
		
		/** �÷� ���� */
		tc1.setStyle("-fx-alignment:CENTER");;
		tc2.setStyle("-fx-alignment:CENTER-LEFT");
		tc3.setStyle("-fx-alignment:CENTER-RIGHT");
		
		/** �÷��ʺ� ���� ���� */
		tc1.prefWidthProperty().bind(tableView.widthProperty().divide(100).multiply(0.2));
		tc2.prefWidthProperty().bind(tableView.widthProperty().divide(100).multiply(0.5));
		tc3.prefWidthProperty().bind(tableView.widthProperty().divide(100).multiply(0.3));
		
		/** ������ ��ư�� �������� ��� ���� FlowPane ���� */
		FlowPane pane = new FlowPane(Orientation.VERTICAL);
		pane.setPadding(new Insets(10));
		pane.setVgap(10);
		pane.setPrefSize(100, 100);
		pane.setMinWidth(150);
		root.setRight(pane);
		
		/** FlowPane�� ���� ��ư ���� */
		Button btn1 = new Button("�ڷ���");
		Button btn2 = new Button("�ڷ��߰�");
		Button btn3 = new Button("�ڷ����");
		Button btn4 = new Button("�ڷἱ��(������)");
		Button btn5 = new Button("�ڷἱ��(�༱��)");
		
		/** ��ư �ʺ����� : pane�� �ʺ񺸴� 20px �۵��� ���� */
		btn1.prefWidthProperty().bind(pane.prefWidthProperty().subtract(20));
		btn2.prefWidthProperty().bind(pane.prefWidthProperty().subtract(20));
		btn3.prefWidthProperty().bind(pane.prefWidthProperty().subtract(20));
		btn4.prefWidthProperty().bind(pane.prefWidthProperty().subtract(20));
		btn5.prefWidthProperty().bind(pane.prefWidthProperty().subtract(20));
		
		/** ��ư�� FlowPane�� �� ��ư�� �߰� */
		pane.getChildren().addAll(btn1, btn2, btn3, btn4, btn5);
		
		/** �ϴ� BorderPane ���� --> CENTER �κ� TextArea ��ü �߰� */
		BorderPane pane2 = new BorderPane();
		pane2.setPadding(new Insets(10));
		root.setBottom(pane2);

		TextArea textArea = new TextArea();
		textArea.setPrefHeight(60);
		pane2.setCenter(textArea);
		
		/** �ڷ��� ��ư �̺�Ʈ */
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				/** �ڷ��� ���� ó�� */
				ProductVo v1 = new ProductVo("a001", "�Ƹ޸�ī��", 4000);
				ProductVo v2 = new ProductVo("a002", "�����", 4300);
				ProductVo v3 = new ProductVo("a003", "�����ī", 4500);
				ObservableList<ProductVo> list = FXCollections.observableArrayList(v1, v2, v3);
				tableView.setItems(list);
			}
		});
		
		/** �ڷ��߰� ��ư �̺�Ʈ */
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				/** �ڷ��߰� ���� ó�� */
				ProductVo v = new ProductVo("a004", "���̽�Ƽ", 4000);
				tableView.getItems().add(v);
			}
		});
		
		/** �ڷ���� ��ư �̺�Ʈ */
		btn3.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				/** �ڷ���� ���� ó�� */
				int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
				if (selectedIndex >= 0) {
					tableView.getItems().remove(selectedIndex);
				} else {
					/** ������ �ڷᰡ ���� ��� �ȳ�ó�� */
					String msg = "������ �����͸� ���� �� �����Ͻñ� �ٶ��ϴ�.";
					Alert alert = new Alert(AlertType.INFORMATION, msg);
					alert.setHeaderText("�ڷ�ȳ�����");
					alert.show();
				}
			}
		});
		
		/** ������ ���� �̺�Ʈ */
		btn4.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				/** ������ ���� ���� ó�� */
				tableView.getSelectionModel().setCellSelectionEnabled(true);
				ObservableList<TableColumn<ProductVo, ?>> columns = tableView.getColumns();
				
				/** 1�� 1���� �����Ͱ� ���� ��� �ڷἱ�� */
				if (columns.size() > 0 && tableView.getItems().size() > 0) {
					TableColumn<ProductVo, ?> tableColumn = tableView.getColumns().get(0);
				}
				String msg = "���̺��� ���� Ŭ���� ������";
				Alert alert = new Alert(AlertType.INFORMATION, msg);
				alert.setHeaderText("���̺� �� ���� ���");
				alert.show();
				
			}
		});
		
		/** ����� ���� �̺�Ʈ */
		btn5.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				/** ����� ���� ���� ó�� */
				tableView.getSelectionModel().setCellSelectionEnabled(false);
				ObservableList<TableColumn<ProductVo, ?>> columns = tableView.getColumns();
				
				if (tableView.getItems().size() > 0) {
					tableView.getSelectionModel().select(0);
				}
				String msg = "���̺��� ���� Ŭ���� ������";
				Alert alert = new Alert(AlertType.INFORMATION, msg);
				alert.setHeaderText("���̺� �� ���� ���");
				alert.show();
			}
		});
		
		/** ���̺� Ŭ�� ���� �̺�Ʈ - ������*/
		tableView.getSelectionModel().selectedItemProperty().addListener(
				(ObservableValue<? extends ProductVo> observ,
				ProductVo oldVal,
				ProductVo newVal)->{

			/** ���� ���� TextArea�� ��Ÿ���� */
			String msg = "ProductNo[" + newVal.getProductNo() +"]";
			msg += ", ProductName[" + newVal.getProductName() + "]";
			msg += ", Price[" + newVal.getPrice();
			textArea.setText(msg);
		});
		
		/** Scene ��ü ���� �� Stage Scene ��ü���, show() */
		Scene scene = new Scene(root, 600, 400);
		//scene.getStylesheets().add("design.css");  /*ch13/part06/main1/scene.css*/
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
