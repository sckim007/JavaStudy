package ch13.javafx.node_parent_region.main3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainView2 extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		/** ��Ʈ��� ���� */
		BorderPane pane = new BorderPane();
		
		/** background ���� */
		pane.setBackground(new Background(new BackgroundFill(Color.BISQUE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		/** padding ���� */
		pane.setPadding(new Insets(10));
		pane.setPrefSize(300, 300);
		
		/** �ڽĳ�� ���� */
		BorderPane pane1 = new BorderPane();
		
		/** CSS�� �̿��� ������, Padding ���� */
		pane1.setStyle("-fx-background-color:yellow; -fx-padding:10px;");
		pane1.setPrefSize(200, 200);
		
		/** ��輱 ���� */
		pane1.setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
		
		pane.setCenter(pane1);
		Scene scene = new Scene(pane, 400, 400);
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
