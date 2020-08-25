package ch18.network.tcp.main3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class TcpServer {

	public static void main(String[] args) {
		new TcpServer().doServer();
	}
	
	/** 접속 시 클라이언트의 쓰기작업과 읽기작업 쓰레드 저장
	 *  - 향후에 서버가 전체 클라이언트에게 쓰기 작업할 때 필요함
	 */
	private Map<Socket, Thread> sendThreadMap = new HashMap<Socket, Thread>();
	
	/** 서버 프로그램 구동 함수 */
	public void doServer() {
		ServerSocket socket = null;
		try {
			/** 서버프로그램 구동 및 서버정보 출력 */
			socket = new ServerSocket(12345);
			System.out.println("서버시작");
			System.out.println(socket.getLocalSocketAddress()); /* 서버 IP, Port */
			System.out.println(socket.getInetAddress());		/* 서버 IP */
			System.out.println(socket.getLocalPort());			/* 서버 Port */
			System.out.println("---------------------------");
			
			while(true) {
				/** 서버 클라이언트 접속 응답대기 */
				final Socket accept = socket.accept();
								
				/** 클라이언트 접속자 주소 정보 */
				InetAddress ia = accept.getInetAddress();
				System.out.println("\t[클라이언트 주소]=" + ia.getHostAddress());
				System.out.println("\t[클라이언트 포트]=" + ia.getHostName());
				
				/** 송신 쓰레드 객체 생성 */
				Thread sendThread = new ThreadSend(accept, "server"); /* 쓰레드 분리 */
				sendThreadMap.put(accept, sendThread);
				sendThread.start();
								
				/** 수신쓰레드 객체 생성 */
				Thread receiveThread = new ThreadReceive(accept,"server", sendThreadMap);
				receiveThread.start();
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null) socket.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
