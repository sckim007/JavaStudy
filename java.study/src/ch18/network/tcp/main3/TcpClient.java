package ch18.network.tcp.main3;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {
	private Socket socket = null;
	private ThreadSend st = null;
	IClientUser clientUser = null;
	String name = null;
	
	/** ClientUI ȭ�鿡�� �������� Ŭ���� �ش� ������ �Լ� ȣ�� */
	public TcpClient(String name, IClientUser clientUser) {
		this.name = name;
		this.clientUser = clientUser;
	}
	
	/** Ŭ���̾�Ʈ ���� �Լ� */
	public void connect() throws UnknownHostException, IOException {
		/** Ŭ���̾�Ʈ ���� ���� */
		socket = new Socket("localhost", 12345);
				
		/** ���� �۾� ������ */
		st = new ThreadSend(socket, name);
		st.start();
		
		/** �б� �۾� ������ */
		ThreadReceive rt = new ThreadReceive(socket, name, clientUser);
		rt.start();
	}
	
	/** Ŭ���̾�Ʈ ��� ���� �Լ� */
	public void close() throws IOException {
		if (socket != null) socket.close();
	}
	
	/** UI ��ü TcpClient ���� �۾� --> SendThread ���� �۾� */
	public void sendMessage(String msg) {
		System.out.println("st=" + st + ":" + msg);
		if(st != null) st.sendMessage(msg);
	}
	
}
