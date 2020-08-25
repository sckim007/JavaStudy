package ch18.network.tcp.main3;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ThreadSend extends Thread {
	private Socket socket = null;
	private String owner = null;
	private OutputStreamWriter osw = null;
	
	/** ������ �Լ� */
	public ThreadSend(Socket socket, String owner) {
		this.socket = socket;
		this.owner = owner;
	}
	
	/** ������ ���� �Լ� */
	public void run() {
		try {
			/** ���� �۾� ��ü ���� */
			osw = new OutputStreamWriter(socket.getOutputStream(), "euc-kr");
		} catch (IOException e) {
			e.printStackTrace();
			close();
		}
	}
	
	/** UI ��ü TcpClient ���� �۾� -> SendThread ���� �۾� */
	public void sendMessage(String msg) {
		
		/** ������ ������ �� �����۾� ���� : ���� --> flush() */
		if(socket != null && !socket.isClosed() && osw != null) {
			try {
				osw.write(msg+"\r\n");
				osw.flush();
				System.out.println("�ڷ�����");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/** ���� �����ϱ� */
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
