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

/** ClientController와 TcpClient 클래스의 결합력을 낮추기 위해 IClientUser 인터페이스 사용 */
public class ClientController implements Initializable, IClientUser{
	/** fxml에 "fx:id"로 명시된 속성 */
	@FXML	private TextArea textArea;
	@FXML	private TextField textField;
	@FXML	private	TextField userId;
	@FXML	private Button	sendBtn;
	@FXML	private Button	serverBtn;
	@FXML	private Button	closeBtn;
	
	/** 클라이언트 객체 */
	AbstractClientSocket client = null;
	
	/** Initialize 구현 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		/** 채팅창 폰트설정 */
		textArea.setFont(Font.font("맑은고딕", 15));
		
		/** 화면 초기화 */
		init("ready");
		
		/** 메시지 입력시 엔트키를 치면 전송버튼 실행 */
		textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if(KeyCode.ENTER == event.getCode()) {
					sendBtn.fire();
				}
			}
		});
		
		/** 서버 접속 버튼 클릭 이벤트 */
		serverBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				/** 아이디 입력확인 및 입력 안 될 경우 경고창 생성 */
				String userIdStr = userId.getText().trim();
				String errorMessage = null;
				if (userIdStr.equals("")) {
					errorMessage = "아이디를 입력하세요.";
				} else if (userIdStr.equals("server")) {
					errorMessage = "아이디명으로 'server'를 입력할 수 없습니다.";
				}
				if (errorMessage != null) {
					Alert alert = new Alert(AlertType.WARNING, errorMessage);
					alert.setHeaderText("아이디 입력오류");
					alert.show();
					return;
				}
				
				init("ready");
				
				/** ???????
				 * 클라이언트 객체생성 및 서버접속
				 * - IClientUser 타입으로  ClientController 자신 객체를 전달
				 * - 서버에 들어오는 내용을 전체 클라이언트에게 메시지 전달 목적
				 * >> 아래에 있는 writeMessage() 함수를 사용하기 위함
				 */
				client = new UdpClient(userIdStr, (IClientUser)ClientController.this);
				client.connect();
				init("start");
			}
		});
		
		/** 전송 버튼 클릭 이벤트 */
		sendBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				/** textArea 이미 입력된 글이 있을 경우 개행하여 텍스트 입력 */
				String firstCarrigerReturn = "";
				String text = textArea.getText();
				if(text.equals("") == false) {
					firstCarrigerReturn = "\r\n";
				}
				String msg = "["+userId.getText()+"]\t"+textField.getText();
				textArea.setText(text+firstCarrigerReturn+msg);
				
				/** 서버로 전송 - ClientUser : UdpClient 쓰기 --> sendThread 쓰기 */
				client.sendMessage(msg);
				textField.setText("");
			}
		});
		
		/** 종료 버튼 클릭 이벤트 */
		closeBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				/** 클라이언트 종료 */
				client.close();
								
				/** 접속 종료 화면 처리 */
				init("ready");
			}
		});
	}

	/** 외부에서 채팅창에 글을 쓰기 위한 함수 - 클라이언트 서버 입력자료 */
	public void writeMessage(String message) {
		/** JavaFx 화면을 쓰기 위해서는 Platform.runLater()를 이용한다. */
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
	
	/** 상태에 따른 화면 컨트롤 제어 함수 */
	public void init(String type) {
		/** 채팅 대기상태 및 서버종료상태 화면처리 */
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
		/** 서버 접속상태 화면처리 */
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
