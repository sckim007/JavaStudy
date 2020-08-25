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
			/** 클라이언트 소켓 생성 */
			ds = new DatagramSocket();
						
			/** 수신 작업 쓰레드 객체 생성 및 실행시작 */
			new Thread() {
				public void run() {
					/** 버퍼 생성 */
					byte[] buff = new byte[65535];
					
					/** 수신을 위한 패킷 생성 */
					DatagramPacket dp = new DatagramPacket(buff, buff.length);
					
					while(true) {
						try {
							
							/** 소켓으로 들어오는 자료를 수신하여, 수신할 때까지 대기 */
							ds.receive(dp);
							
							/** 문자열 변환 */
							String data = new String(dp.getData(), 0, dp.getLength());
							
							/** 출력 */
							System.out.println(data);
							
						} catch (IOException e) {
							
							e.printStackTrace();
							
						}
					}
				}
			}.start();
			

			/** 송시 작업 쓰레드 객체 생성 및 실행 시작 */
			new Thread() {
				public void run() {
					while(true) {
						/** 3초 간격을 위한 sleep */
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
						String msg = "data";
						try {
							/** 외부로 전송할 패킷 생성 - 목적지 정보 필요 */
							DatagramPacket dp = new DatagramPacket(msg.getBytes(),
												msg.getBytes().length,
												InetAddress.getByName("localhost"),
												12345);
							
							/** 서버로 자료전송 */
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
			
			/** DatagramSocket 종료 */
			ds.close();
		}
	}
}
