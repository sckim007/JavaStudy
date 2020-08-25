package ch18.network.tcp.main3;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ThreadSend extends Thread {
	private Socket socket = null;
	private String owner = null;
	private OutputStreamWriter osw = null;
	
	/** 생성자 함수 */
	public ThreadSend(Socket socket, String owner) {
		this.socket = socket;
		this.owner = owner;
	}
	
	/** 쓰레드 실행 함수 */
	public void run() {
		try {
			/** 쓰기 작업 객체 생성 */
			osw = new OutputStreamWriter(socket.getOutputStream(), "euc-kr");
		} catch (IOException e) {
			e.printStackTrace();
			close();
		}
	}
	
	/** UI 객체 TcpClient 쓰기 작업 -> SendThread 쓰기 작업 */
	public void sendMessage(String msg) {
		
		/** 소켓이 정상일 때 쓰기작업 시작 : 쓰기 --> flush() */
		if(socket != null && !socket.isClosed() && osw != null) {
			try {
				osw.write(msg+"\r\n");
				osw.flush();
				System.out.println("자료전송");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/** 소켓 종료하기 */
	public void close() {
		try {
			if(osw != null) osw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			if(socket != null) socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
