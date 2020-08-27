package ch13.javafx.control.main4;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
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
		
		/** Column(�÷�) - TableVo(������Ÿ��) ���� ���� */
		tc1.setCellValueFactory(new PropertyValueFactory<ProductVo, String>("productNo"));
		tc2.setCellValueFactory(new PropertyValueFactory<ProductVo, String>("productName"));
		tc3.setCellValueFactory(new PropertyValueFactory<ProductVo, String>("price"));
		
		/** �÷� ���� */
		tc1.setStyle("-fx-alignment:CENTER");;
		tc2.setStyle("-fx-alignment:CENTER-LEFT");
		tc3.setStyle("-fx-alignment:CENTER");
		
		/** �÷��ʺ� ���� */
		tc1.prefWidthProperty().bind(tableView.widthProperty().divide(100).multiply(20));
		tc2.prefWidthProperty().bind(tableView.widthProperty().divide(100).multiply(50));
		tc3.prefWidthProperty().bind(tableView.widthProperty().divide(100).multiply(30));
		
		/** ���̺� - �÷� �߰� */
		tableView.getColumns().setAll(tc1, tc2, tc3);
		
		/** ������ ��� ��� */
		ProductVo v1 = new ProductVo("a001", "�Ƹ޸�ī��", 4000);
		ProductVo v2 = new ProductVo("a002", "�����", 4300);
		ProductVo v3 = new ProductVo("a003", "�����ī", 4500);
		ObservableList<ProductVo> list = FXCollections.observableArrayList(v1, v2, v3);
		tableView.setItems(list);
		
		/** Scene ��ü ���� �� Stage Scene ��ü���, show() */
		Scene scene = new Scene(root, 400, 200);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
