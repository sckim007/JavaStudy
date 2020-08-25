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
	
	/** ���� �� Ŭ���̾�Ʈ�� �����۾��� �б��۾� ������ ����
	 *  - ���Ŀ� ������ ��ü Ŭ���̾�Ʈ���� ���� �۾��� �� �ʿ���
	 */
	private Map<Socket, Thread> sendThreadMap = new HashMap<Socket, Thread>();
	
	/** ���� ���α׷� ���� �Լ� */
	public void doServer() {
		ServerSocket socket = null;
		try {
			/** �������α׷� ���� �� �������� ��� */
			socket = new ServerSocket(12345);
			System.out.println("��������");
			System.out.println(socket.getLocalSocketAddress()); /* ���� IP, Port */
			System.out.println(socket.getInetAddress());		/* ���� IP */
			System.out.println(socket.getLocalPort());			/* ���� Port */
			System.out.println("---------------------------");
			
			while(true) {
				/** ���� Ŭ���̾�Ʈ ���� ������ */
				final Socket accept = socket.accept();
								
				/** Ŭ���̾�Ʈ ������ �ּ� ���� */
				InetAddress ia = accept.getInetAddress();
				System.out.println("\t[Ŭ���̾�Ʈ �ּ�]=" + ia.getHostAddress());
				System.out.println("\t[Ŭ���̾�Ʈ ��Ʈ]=" + ia.getHostName());
				
				/** �۽� ������ ��ü ���� */
				Thread sendThread = new ThreadSend(accept, "server"); /* ������ �и� */
				sendThreadMap.put(accept, sendThread);
				sendThread.start();
								
				/** ���ž����� ��ü ���� */
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
