package ch18.network.udp.main2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;

//import network.tcp.main3.TcpClient;

/** ClientController�� TcpClient Ŭ������ ���շ��� ���߱� ���� IClientUser �������̽� ��� */
public class ClientController implements Initializable, IClientUser{
	/** fxml�� "fx:id"�� ��õ� �Ӽ� */
	@FXML	private TextArea textArea;
	@FXML	private TextField textField;
	@FXML	private	TextField userId;
	@FXML	private Button	sendBtn;
	@FXML	private Button	serverBtn;
	@FXML	private Button	closeBtn;
	
	/** Ŭ���̾�Ʈ ��ü */
	AbstractClientSocket client = null;
	
	/** Initialize ���� */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		/** ä��â ��Ʈ���� */
		textArea.setFont(Font.font("�������", 15));
		
		/** ȭ�� �ʱ�ȭ */
		init("ready");
		
		/** �޽��� �Է½� ��ƮŰ�� ġ�� ���۹�ư ���� */
		textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if(KeyCode.ENTER == event.getCode()) {
					sendBtn.fire();
				}
			}
		});
		
		/** ���� ���� ��ư Ŭ�� �̺�Ʈ */
		serverBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				/** ���̵� �Է�Ȯ�� �� �Է� �� �� ��� ���â ���� */
				String userIdStr = userId.getText().trim();
				String errorMessage = null;
				if (userIdStr.equals("")) {
					errorMessage = "���̵� �Է��ϼ���.";
				} else if (userIdStr.equals("server")) {
					errorMessage = "���̵������ 'server'�� �Է��� �� �����ϴ�.";
				}
				if (errorMessage != null) {
					Alert alert = new Alert(AlertType.WARNING, errorMessage);
					alert.setHeaderText("���̵� �Է¿���");
					alert.show();
					return;
				}
				
				init("ready");
				
				/** ???????
				 * Ŭ���̾�Ʈ ��ü���� �� ��������
				 * - IClientUser Ÿ������  ClientController �ڽ� ��ü�� ����
				 * - ������ ������ ������ ��ü Ŭ���̾�Ʈ���� �޽��� ���� ����
				 * >> �Ʒ��� �ִ� writeMessage() �Լ��� ����ϱ� ����
				 */
				client = new UdpClient(userIdStr, (IClientUser)ClientController.this);
				client.connect();
				init("start");
			}
		});
		
		/** ���� ��ư Ŭ�� �̺�Ʈ */
		sendBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				/** textArea �̹� �Էµ� ���� ���� ��� �����Ͽ� �ؽ�Ʈ �Է� */
				String firstCarrigerReturn = "";
				String text = textArea.getText();
				if(text.equals("") == false) {
					firstCarrigerReturn = "\r\n";
				}
				String msg = "["+userId.getText()+"]\t"+textField.getText();
				textArea.setText(text+firstCarrigerReturn+msg);
				
				/** ������ ���� - ClientUser : UdpClient ���� --> sendThread ���� */
				client.sendMessage(msg);
				textField.setText("");
			}
		});
		
		/** ���� ��ư Ŭ�� �̺�Ʈ */
		closeBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				/** Ŭ���̾�Ʈ ���� */
				client.close();
								
				/** ���� ���� ȭ�� ó�� */
				init("ready");
			}
		});
	}

	/** �ܺο��� ä��â�� ���� ���� ���� �Լ� - Ŭ���̾�Ʈ ���� �Է��ڷ� */
	public void writeMessage(String message) {
		/** JavaFx ȭ���� ���� ���ؼ��� Platform.runLater()�� �̿��Ѵ�. */
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				String text = textArea.getText();
				String firstCarrigerReturn="";
				if(text.equals("")==false) {
					firstCarrigerReturn = "\r\n";
				}
				textArea.setText(text+firstCarrigerReturn+message);
			}
		});
	}
	
	/** ���¿� ���� ȭ�� ��Ʈ�� ���� �Լ� */
	public void init(String type) {
		/** ä�� ������ �� ����������� ȭ��ó�� */
		if("ready".equals(type)) {
			textArea.setText("");
			textArea.setDisable(true);
			textField.setText("");
			textField.setDisable(true);
			sendBtn.setDisable(true);
			serverBtn.setDisable(false);
			closeBtn.setDisable(true);
			userId.setDisable(false);
		}
		/** ���� ���ӻ��� ȭ��ó�� */
		else if("start".equals(type)){
			textField.setDisable(false);
			sendBtn.setDisable(false);
			serverBtn.setDisable(true);
			closeBtn.setDisable(false);
			userId.setDisable(true);
			textArea.setStyle("-fx-background-color:white; -fx-opacity: 1; -fx-text-inner-color: black;");
		}
	}
}
