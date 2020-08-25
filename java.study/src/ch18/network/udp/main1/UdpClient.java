package ch18.network.udp.main1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpClient {
	
	static DatagramSocket ds;
	
	public static void main(String[] args) {
		new UdpClient().doClient();
	}
	
	public void doClient() {
		try {
			/** Ŭ���̾�Ʈ ���� ���� */
			ds = new DatagramSocket();
						
			/** ���� �۾� ������ ��ü ���� �� ������� */
			new Thread() {
				public void run() {
					/** ���� ���� */
					byte[] buff = new byte[65535];
					
					/** ������ ���� ��Ŷ ���� */
					DatagramPacket dp = new DatagramPacket(buff, buff.length);
					
					while(true) {
						try {
							
							/** �������� ������ �ڷḦ �����Ͽ�, ������ ������ ��� */
							ds.receive(dp);
							
							/** ���ڿ� ��ȯ */
							String data = new String(dp.getData(), 0, dp.getLength());
							
							/** ��� */
							System.out.println(data);
							
						} catch (IOException e) {
							
							e.printStackTrace();
							
						}
					}
				}
			}.start();
			

			/** �۽� �۾� ������ ��ü ���� �� ���� ���� */
			new Thread() {
				public void run() {
					while(true) {
						/** 3�� ������ ���� sleep */
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
						String msg = "data";
						try {
							/** �ܺη� ������ ��Ŷ ���� - ������ ���� �ʿ� */
							DatagramPacket dp = new DatagramPacket(msg.getBytes(),
												msg.getBytes().length,
												InetAddress.getByName("localhost"),
												12345);
							
							/** ������ �ڷ����� */
							ds.send(dp);	
						} catch (UnknownHostException e){
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}.start();

		} catch (SocketException e2) {
			e2.printStackTrace();
			
			/** DatagramSocket ���� */
			ds.close();
		}
	}
}
