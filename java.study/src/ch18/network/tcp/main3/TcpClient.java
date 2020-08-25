package ch18.network.tcp.main3;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {
	private Socket socket = null;
	private ThreadSend st = null;
	IClientUser clientUser = null;
	String name = null;
	
	/** ClientUI 화면에서 서버접속 클릭시 해당 생성자 함수 호출 */
	public TcpClient(String name, IClientUser clientUser) {
		this.name = name;
		this.clientUser = clientUser;
	}
	
	/** 클라이언트 접속 함수 */
	public void connect() throws UnknownHostException, IOException {
		/** 클라이언트 소켓 생성 */
		socket = new Socket("localhost", 12345);
				
		/** 쓰기 작업 쓰레드 */
		st = new ThreadSend(socket, name);
		st.start();
		
		/** 읽기 작업 쓰레드 */
		ThreadReceive rt = new ThreadReceive(socket, name, clientUser);
		rt.start();
	}
	
	/** 클라이언트 통신 종료 함수 */
	public void close() throws IOException {
		if (socket != null) socket.close();
	}
	
	/** UI 객체 TcpClient 쓰기 작업 --> SendThread 쓰기 작업 */
	public void sendMessage(String msg) {
		System.out.println("st=" + st + ":" + msg);
		if(st != null) st.sendMessage(msg);
	}
	
}
