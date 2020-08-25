package ch18.network.udp.main2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;

public class UdpServer{

	public static void main(String[] args) {
		new UdpServer().doServer();
	}
	
	/** ���� ���α׷� ���� �Լ� */
	public void doServer() {
		try {
			/** Datagram ���� ���� - ��Ʈ�ʿ� */
			DatagramSocket socket = new DatagramSocket(12345);
			
			/** �������� ��� */
			System.out.println("��������");
			System.out.println(socket.getLocalSocketAddress()); /* ���� IP, Port */
			System.out.println(socket.getInetAddress());		/* ���� IP */
			System.out.println(socket.getLocalPort());			/* ���� Port */
			System.out.println("---------------------------");
			
			/** ������ ����Ͽ� �����ڸ� ���� */
			Set<SocketAddress> list = new HashSet<SocketAddress>();
			
			/** �����۾� ������ ��ü���� �� ������� */
			new Thread() {
				public void run() {
					/** ���� ���� ���� */
					byte[] by = new byte[65535];
					
					/** �������� ������ �ڷḦ �ޱ����� ��Ŷ ���� */
					DatagramPacket packet = new DatagramPacket(by, by.length);
					
					while(true) {
						try {
							/** �������� ������ �ڷ�����ϸ� ������ ������ ��� */
							socket.receive(packet);
														
							/** ���ŵ� �������� ��ȸ �� ��� */
							String msg = new String(packet.getData(), 0, packet.getLength());
							
							/** �ű������� ��� Ŭ���̾�Ʈ �������� */
							if(msg.startsWith("connect://")) {
								
								InetAddress ia = packet.getAddress();
								
								/** Ŭ���̾�Ʈ ������ �ּ� ���� */
								System.out.println("\t[�ּ�]=" + ia.getHostAddress());
								System.out.println("\t[�̸�]=" + ia.getHostName());
								System.out.println("\t[��Ʈ]=" + packet.getPort());
								System.out.println("\t[����]=" + msg);
								
								/** �ش� Ŭ���̾�Ʈ ���� ���� ���� */
								list.add(packet.getSocketAddress());
								msg=msg.replace("connect://", "");
								msg += "���� �α����Ͽ����ϴ�.";
								System.out.println("----> packet receive...3");
							}
							
							/** ��� Ŭ���̾�Ʈ���� ������ �ڷ� ���� */
							for(SocketAddress s : list) {
								
								/** ���� ���ŵ� ��Ŷ Ŭ���̾�Ʈ �����ϰ� ��� Ŭ���̾�Ʈ���� ��Ŷ ���� */
								if(s.equals(packet.getSocketAddress())) continue;
								try {
									
									/** Ŭ���̾�Ʈ�� ������ ��Ŷ ���� - ������ ���� �ʿ� */
									DatagramPacket packet2 = new DatagramPacket(msg.getBytes(),
																				msg.getBytes().length,
																				s);
									
									/** Ŭ���̾�Ʈ�� ��Ŷ ���� */
									socket.send(packet2);
									
								} catch (UnknownHostException e) {
									list.remove(s);
									e.printStackTrace();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}.start();

		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
}
