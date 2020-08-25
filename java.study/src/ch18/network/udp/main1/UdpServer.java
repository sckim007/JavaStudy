package ch18.network.udp.main1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Date;

public class UdpServer {

	static DatagramSocket socket;
	
	public static void main(String[] args) throws IOException{
		/** �������� */
		new UdpServer().doServer();
	}
	
	public void doServer(){
		try {
			/** ������ ��Ʈ�� 12345�� ������ */
			socket = new DatagramSocket(12345);
			
			/** ���� �۾� ������ ��ü ���� �� ���� ���� */
			new Thread() {
				public void run() {

					/** ���� ���� ���� */
					byte[] buff = new byte[65535];
					
					/* �ڷ������ ���� ��Ŷ ���� */
					DatagramPacket dp = new DatagramPacket(buff, buff.length);
					while(true) {
						try {
							/** �������� ������ �ڷ�����ϸ�, ������ ������ ��� */
							socket.receive(dp);
							
							/** �ܺη� ������ �ڷᱸ�� */
							String data = new String(dp.getData(),0,dp.getLength());
							Date date = new Date(System.currentTimeMillis());
							String msg = data + "\t" + date;
							
							/** �ܺη� ������ ��Ŷ ���� - ������ ���� �ʿ� */
							DatagramPacket dp2 = new DatagramPacket(msg.getBytes(),
																	msg.getBytes().length,
																	dp.getSocketAddress());
							
							/** �ܺη� �ڷ� ���� */
							socket.send(dp2);
									
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}.start();
			
		} catch (SocketException e1) {
			e1.printStackTrace();
			
			/** Datagram socket close */
			socket.close();
		}
	}

}
