package ch18.network.udp.main2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/** ClientController와 결합력을 낮추기 위해 AbstractClientSocket 사용 */
public class UdpClient extends AbstractClientSocket{
	DatagramSocket socket = null;
	
	/** 추상화클래스에서 정의한 생성자 함수 사용 */
	public UdpClient(String name, IClientUser clientUser) {
		super(name, clientUser);
	}
	
	/** 클라이언트 접속 함수 */
	@Override
	public void connect(){
		try {
			/** 클라이언트 소켓 생성 */
			socket = new DatagramSocket();
			System.out.println("socket="+socket);
					
			/** 최초 채팅이름을 서버로 전송 */
			sendMessage("connect://"+name);
			
			new Thread() {
				public void run() {
					byte[] by = new byte[65535];
					/** 수신을 위한 패킷 생성 */
					DatagramPacket packet = new DatagramPacket(by, by.length);
					while(true) {
						try {
							
							System.out.println("data=");
							
							/** 소켓으로 들어오는 자료를 수신하며 수신할 때까지 대기 */
							socket.receive(packet);
							byte[] data = packet.getData();
							
							/** clientUser로 자료를 송신 */
							clientUser.writeMessage(new String(data, 0, packet.getLength()));
							
						} catch (IOException e) {
							/** 종료버튼을 누르는 경우 socket.close()를 호출하기 때문에 socket에서 exception이 발생함. 
							 *  break 문을 사용하여 쓰레드를 빠져나감 */
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

	/** UI 객체 TcpClient 쓰기 작업 --> SendThread 쓰기 작업 */
	@Override
	public void sendMessage(String msg) {
		try {
			System.out.println("before send...." + msg.getBytes().length+"bytes");
			/** 외부(서버)로 전송할 패킷 생성 - 목적지정보 필요 */
			DatagramPacket packet = new DatagramPacket(msg.getBytes(), 
													   msg.getBytes().length,
													   InetAddress.getByName("localhost"),
													   12345);
			System.out.println(packet + ":" + socket);
			
			/** 서버로 자료 전송 */
			socket.send(packet);
			System.out.println("after send....");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** 클라이언트 통신 종료 함수 */
	@Override
	public void close(){
		socket.close();
	}
}
