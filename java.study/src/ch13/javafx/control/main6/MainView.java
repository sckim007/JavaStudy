package ch13.javafx.control.main6;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;


public class MainView extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		/** ��Ʈ��� ���� */
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10));
		
		/** Table View ���� */
		TableView<ProductVo> tableView = new TableView<ProductVo>();
		root.setCenter(tableView);
		
		/** Table Column ���� */
		TableColumn<ProductVo, String> tc1 = new TableColumn<ProductVo, String>("ǰ���ȣ");
		TableColumn<ProductVo, String> tc2 = new TableColumn<ProductVo, String>("ǰ���");
		TableColumn<ProductVo, Integer> tc3 = new TableColumn<ProductVo, Integer>("�ܰ�");
		TableColumn<ProductVo, Boolean> tc4 = new TableColumn<ProductVo, Boolean>("��ư");
		TableColumn<ProductVo, Boolean> tc5 = new TableColumn<ProductVo, Boolean>("����");
		TableColumn<ProductVo, String> tc6 = new TableColumn<ProductVo, String>("�޺�");
		tableView.getColumns().setAll(tc1, tc2, tc3, tc4, tc5, tc6);/* ���̺� - �÷� �߰� */
		
		/** Column(�÷�) - TableVo(������Ÿ��) ���� ���� */
		tc1.setCellValueFactory(new PropertyValueFactory<ProductVo, String>("productNo"));
		tc2.setCellValueFactory(new PropertyValueFactory<ProductVo, String>("productName"));
		tc3.setCellValueFactory(new PropertyValueFactory<ProductVo, Integer>("price"));
		tc4.setCellValueFactory(new PropertyValueFactory<ProductVo, Boolean>("checkYn"));
		tc5.setCellValueFactory(new PropertyValueFactory<ProductVo, Boolean>("checkYn"));
		tc6.setCellValueFactory(new PropertyValueFactory<ProductVo, String>("productCode"));
		
		/** tc4���̺� ���� TableCell�� Button ��Ʈ���� �ֱ� ���� �۾� */
		tc4.setCellFactory(new Callback<TableColumn<ProductVo,Boolean>, TableCell<ProductVo,Boolean>>() {
			
			@Override
			public TableCell<ProductVo, Boolean> call(TableColumn<ProductVo, Boolean> param) {
				/** Table Cell Ÿ�� ��ü���� 
				 *  TableCell(S,T> tableCell = new TableCell<S,T>(){};
				 *  - S : ������Ÿ�� : ProductVo
				 *  - T : ������ �׸� Ÿ�� : checkYn 
				 */
				TableCell<ProductVo, Boolean> tableCell = new TableCell<ProductVo, Boolean>(){
					/** [1] Button ��ü ���� */
					private Button btn = new Button("��ư");
					{
						/** [2] Button �⺻ ���� */
						btn.setStyle("-fx-font-size:12px;-fx-padding:0");
						btn.setMaxHeight(20);
						btn.setMaxWidth(20);
						btn.setPrefSize(100, 20);
						
						/** [3] Button Ŭ�� �̺�Ʈ �Լ� ���� */
						btn.setOnAction(new EventHandler<ActionEvent>() {
							
							@Override
							public void handle(ActionEvent event) {
								/** �ش� ���̺��� ���ε����� ������ ��ȸ */
								int index = getTableRow().getIndex();
								ProductVo productVo2 = tableView.getItems().get(index);
								
								/** [4] ��Ʈ�� �� --> ������ �׸� ���� */
								productVo2.setProductCode("B");
								
								/** tableView ����ݿ� �� �� ���� */
								tableView.refresh();
								tableView.getSelectionModel().select(index);
							}
						});
					}
					
					/** [5] ������ --> ��Ʈ�� ������ ���� updateItem() ������  */
					@Override
					protected void updateItem(Boolean item, boolean empty) {
						/** ������ �� --> ��Ʈ�� �� �ݿ� �� Button ��ü TableCell �߰� */
						if (item != null && item == true && !empty) {
							this.setGraphic(btn);
						} else {
							this.setGraphic(null);
						}
					}
				};
				 
				return tableCell;
			}
		});
		
		/** tc5���̺� ���� TableCell�� CheckBox ��Ʈ���� �ֱ� ���� �۾� */
		tc5.setCellFactory(new Callback<TableColumn<ProductVo,Boolean>, TableCell<ProductVo,Boolean>>() {
			
			@Override
			public TableCell<ProductVo, Boolean> call(TableColumn<ProductVo, Boolean> param) {
				/** Table Cell Ÿ�� ��ü���� 
				 *  TableCell(S,T> tableCell = new TableCell<S,T>(){};
				 *  - S : ������Ÿ�� : ProductVo
				 *  - T : ������ �׸� Ÿ�� : checkYn
				 *  checkYn�� ���� true �� ���� üũǥ�� �ǵ��� ���� 
				 */
				TableCell<ProductVo, Boolean> tableCell = new TableCell<ProductVo, Boolean>(){
					/** [1] CheckBox ��ü ���� */
					private CheckBox check = new CheckBox();
					{
						/** [2] CheckBox �⺻ ���� */
						check.setAlignment(Pos.CENTER);
						
						/** [3] CheckBox �̺�Ʈ �Լ� ���� */
						check.setOnAction(new EventHandler<ActionEvent>() {
							
							@Override
							public void handle(ActionEvent event) {
								/** �ش� ���̺��� �� �ε����� ������ ��ȸ */
								int index = getTableRow().getIndex();
								ProductVo productVo = tableView.getItems().get(index);
								
								/** [4] ��Ʈ�� �� --> ������ �׸� ���� */
								if (productVo != null) {
									productVo.setCheckYn(check.isSelected());
								}
								
								/** tableView ���� �ݿ� �� �� ���� */
								tableView.refresh();
								tableView.getSelectionModel().select(index);
							}
						});
						check.setCenterShape(true);
					}
					
					/** [5] ������ --> ��Ʈ�� ������ ���� updateItem() ������  */
					@Override
					protected void updateItem(Boolean item, boolean empty) {
						/** ������ �� --> ��Ʈ�� �� �ݿ� �� Button ��ü TableCell �߰� */
						if (item != null && !empty) {
							check.setSelected(item);
							this.setGraphic(check);
						} else {
							this.setGraphic(null);
						}
					}
				};
				 
				return tableCell;
			}
		});
		
		/** tc6���̺� ���� TableCell�� Button ��Ʈ���� �ֱ� ���� �۾� */
		tc6.setCellFactory(new Callback<TableColumn<ProductVo,String>, TableCell<ProductVo,String>>() {
			
			@Override
			public TableCell<ProductVo, String> call(TableColumn<ProductVo, String> param) {
				/** Table Cell Ÿ�� ��ü���� 
				 *  TableCell(S,T> tableCell = new TableCell<S,T>(){};
				 *  - S : ������Ÿ�� : ProductVo
				 *  - T : ������ �׸� Ÿ�� : checkYn
				 *  productCode ���� ���� �޺��ڽ��� ���� ���� 
				 */
				TableCell<ProductVo, String> tableCell = new TableCell<ProductVo, String>(){
					/** [1] ComboBox ��ü ���� */
					private ComboBox<String> combo = new ComboBox<String>();
					{
						/** [2] ComboBox �⺻ ���� */
						combo.setPrefWidth(100);
						combo.getItems().addAll("A", "B", "C");
						
						/** [3] ComboBox �̺�Ʈ �Լ� ���� */
						combo.setOnAction(new EventHandler<ActionEvent>() {
							
							@Override
							public void handle(ActionEvent event) {
								/** �ش� ���̺��� �� �ε����� ������ ��ȸ */
								String value = combo.getValue();
								int index = getTableRow().getIndex();
								ProductVo productVo = tableView.getItems().get(index);
								
								/** [4] ��Ʈ�� �� --> ������ �׸� ���� */
								if (productVo != null) {
									productVo.setProductCode(value);
								}
								
								/** tableView ���� �ݿ� �� �� ���� */
								tableView.refresh();
								tableView.getSelectionModel().select(index);
							}
						});
					}
					
					/** [5] ������ --> ��Ʈ�� ������ ���� updateItem() ������  */
					@Override
					protected void updateItem(String item, boolean empty) {
						/** ������ �� --> ��Ʈ�� �� �ݿ� �� Button ��ü TableCell �߰� */
						if (item != null && !empty) {
							combo.setValue(item);
							this.setGraphic(combo);
						}
					}
				};
				 
				return tableCell;
			}
		});		

		/** �÷� ���� */
		tc1.setStyle("-fx-alignment:CENTER");;
		tc2.setStyle("-fx-alignment:CENTER-LEFT");
		tc3.setStyle("-fx-alignment:CENTER-RIGHT");
		tc4.setStyle("-fx-alignment:CENTER;-fx-padding:5px");
		tc5.setStyle("-fx-alignment:CENTER;");
		tc6.setStyle("-fx-padding:2px;-fx-alignment:CENTER");

		/** �÷��ʺ� ���� ���� */
		tc1.prefWidthProperty().bind(tableView.widthProperty().divide(100).multiply(0.15));
		tc2.prefWidthProperty().bind(tableView.widthProperty().divide(100).multiply(0.20));
		tc3.prefWidthProperty().bind(tableView.widthProperty().divide(100).multiply(0.20));
		tc4.prefWidthProperty().bind(tableView.widthProperty().divide(100).multiply(0.20));
		tc5.prefWidthProperty().bind(tableView.widthProperty().divide(100).multiply(0.10));
		tc6.prefWidthProperty().bind(tableView.widthProperty().divide(100).multiply(0.15));
		
		/** �ڷ��� ���� ó�� */
		ProductVo v1 = new ProductVo("a001", "�Ƹ޸�ī��", 4000, true, "A");
		ProductVo v2 = new ProductVo("a002", "�����", 4300, false, "B");
		ProductVo v3 = new ProductVo("a003", "�����ī", 4500, true, "C");
		ObservableList<ProductVo> list = FXCollections.observableArrayList(v1, v2, v3);
		tableView.setItems(list);
		
		/** ���̺� �ڷắ�� �̺�Ʈ - ������*/
		tableView.getSelectionModel().selectedItemProperty().addListener(
				(ObservableValue<? extends ProductVo> observ,
				ProductVo oldVal,
				ProductVo newVal)->{

			/** �ű� ���õ� �ڷ��� ���� �ܼ�ȭ�� ��� */
			String msg = "ProductNo[" + newVal.getProductNo() +"]";
			msg += ", ProductName[" + newVal.getProductName() + "]";
			msg += ", Price[" + newVal.getPrice();
			System.out.println(msg);
		});

		/** Scene ��ü ���� �� Stage Scene ��ü���, show() */
		Scene scene = new Scene(root, 500, 300);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
