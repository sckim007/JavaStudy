package ch18.network.udp.main1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Date;

public class UdpServer {

	static DatagramSocket socket;
	
	public static void main(String[] args) throws IOException{
		/** 서버실행 */
		new UdpServer().doServer();
	}
	
	public void doServer(){
		try {
			/** 서버의 포트를 12345로 지정함 */
			socket = new DatagramSocket(12345);
			
			/** 수신 작업 쓰레드 객체 생성 및 실행 시작 */
			new Thread() {
				public void run() {

					/** 수신 버퍼 설정 */
					byte[] buff = new byte[65535];
					
					/* 자료수신을 위한 패킷 생성 */
					DatagramPacket dp = new DatagramPacket(buff, buff.length);
					while(true) {
						try {
							/** 소켓으로 들어오는 자료수신하며, 수신할 때까지 대기 */
							socket.receive(dp);
							
							/** 외부로 전송할 자료구성 */
							String data = new String(dp.getData(),0,dp.getLength());
							Date date = new Date(System.currentTimeMillis());
							String msg = data + "\t" + date;
							
							/** 외부로 전송할 패킷 생성 - 목적지 정보 필요 */
							DatagramPacket dp2 = new DatagramPacket(msg.getBytes(),
																	msg.getBytes().length,
																	dp.getSocketAddress());
							
							/** 외부로 자료 전송 */
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
