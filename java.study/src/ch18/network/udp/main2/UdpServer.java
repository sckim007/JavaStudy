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
	
	/** 서버 프로그램 구동 함수 */
	public void doServer() {
		try {
			/** Datagram 소켓 생성 - 포트필요 */
			DatagramSocket socket = new DatagramSocket(12345);
			
			/** 서버정보 출력 */
			System.out.println("서버시작");
			System.out.println(socket.getLocalSocketAddress()); /* 서버 IP, Port */
			System.out.println(socket.getInetAddress());		/* 서버 IP */
			System.out.println(socket.getLocalPort());			/* 서버 Port */
			System.out.println("---------------------------");
			
			/** 종묵을 고려하여 접속자를 저장 */
			Set<SocketAddress> list = new HashSet<SocketAddress>();
			
			/** 수신작업 쓰레드 객체생성 및 실행시작 */
			new Thread() {
				public void run() {
					/** 수신 버퍼 정의 */
					byte[] by = new byte[65535];
					
					/** 소켓으로 들어오는 자료를 받기위한 패킷 생성 */
					DatagramPacket packet = new DatagramPacket(by, by.length);
					
					while(true) {
						try {
							/** 소켓으로 들어오는 자료수신하며 수신할 때까지 대기 */
							socket.receive(packet);
														
							/** 수신된 접속정보 조회 및 출력 */
							String msg = new String(packet.getData(), 0, packet.getLength());
							
							/** 신규진입의 경우 클라이언트 정보저장 */
							if(msg.startsWith("connect://")) {
								
								InetAddress ia = packet.getAddress();
								
								/** 클라이언트 접속자 주소 정보 */
								System.out.println("\t[주소]=" + ia.getHostAddress());
								System.out.println("\t[이름]=" + ia.getHostName());
								System.out.println("\t[포트]=" + packet.getPort());
								System.out.println("\t[내용]=" + msg);
								
								/** 해당 클라이언트 소켓 정보 저장 */
								list.add(packet.getSocketAddress());
								msg=msg.replace("connect://", "");
								msg += "님이 로그인하였습니다.";
								System.out.println("----> packet receive...3");
							}
							
							/** 모든 클라이언트에게 들어오는 자료 전파 */
							for(SocketAddress s : list) {
								
								/** 현재 수신된 패킷 클라이언트 제외하고 모든 클라이언트에게 패킷 전송 */
								if(s.equals(packet.getSocketAddress())) continue;
								try {
									
									/** 클라이언트로 전송할 패킷 생성 - 목적지 정보 필요 */
									DatagramPacket packet2 = new DatagramPacket(msg.getBytes(),
																				msg.getBytes().length,
																				s);
									
									/** 클라이언트로 패킷 전송 */
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
