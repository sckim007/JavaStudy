package ch18.network.udp.main2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/** ClientController�� ���շ��� ���߱� ���� AbstractClientSocket ��� */
public class UdpClient extends AbstractClientSocket{
	DatagramSocket socket = null;
	
	/** �߻�ȭŬ�������� ������ ������ �Լ� ��� */
	public UdpClient(String name, IClientUser clientUser) {
		super(name, clientUser);
	}
	
	/** Ŭ���̾�Ʈ ���� �Լ� */
	@Override
	public void connect(){
		try {
			/** Ŭ���̾�Ʈ ���� ���� */
			socket = new DatagramSocket();
			System.out.println("socket="+socket);
					
			/** ���� ä���̸��� ������ ���� */
			sendMessage("connect://"+name);
			
			new Thread() {
				public void run() {
					byte[] by = new byte[65535];
					/** ������ ���� ��Ŷ ���� */
					DatagramPacket packet = new DatagramPacket(by, by.length);
					while(true) {
						try {
							
							System.out.println("data=");
							
							/** �������� ������ �ڷḦ �����ϸ� ������ ������ ��� */
							socket.receive(packet);
							byte[] data = packet.getData();
							
							/** clientUser�� �ڷḦ �۽� */
							clientUser.writeMessage(new String(data, 0, packet.getLength()));
							
						} catch (IOException e) {
							/** �����ư�� ������ ��� socket.close()�� ȣ���ϱ� ������ socket���� exception�� �߻���. 
							 *  break ���� ����Ͽ� �����带 �������� */
							e.printStackTrace();
							break;
						}
					}
				}
			}.start();
			return;
		} catch (SocketException e) {
			e.printStackTrace();
		}
		return;
	}

	/** UI ��ü TcpClient ���� �۾� --> SendThread ���� �۾� */
	@Override
	public void sendMessage(String msg) {
		try {
			System.out.println("before send...." + msg.getBytes().length+"bytes");
			/** �ܺ�(����)�� ������ ��Ŷ ���� - ���������� �ʿ� */
			DatagramPacket packet = new DatagramPacket(msg.getBytes(), 
													   msg.getBytes().length,
													   InetAddress.getByName("localhost"),
													   12345);
			System.out.println(packet + ":" + socket);
			
			/** ������ �ڷ� ���� */
			socket.send(packet);
			System.out.println("after send....");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** Ŭ���̾�Ʈ ��� ���� �Լ� */
	@Override
	public void close(){
		socket.close();
	}
}
