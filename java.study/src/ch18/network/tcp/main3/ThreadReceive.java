package ch18.network.tcp.main3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Map;
import java.util.Set;

public class ThreadReceive extends Thread {
	
	private Socket socket;
	private String owner;
	private Map<Socket, Thread> sendThreadMap;
	private IClientUser clientUser;
	
	/** 클라이언트가 읽기 작업을 위해 사용하는 생성자 함수
	 *    - clientUser : 통신을 통해 들어오는 자료를 화면 UI에 쓰기작업하기 위한 객체 
	 */
	public ThreadReceive(Socket socket, String owner, IClientUser clientUser){
		this.socket = socket;
		this.owner = owner;
		this.clientUser = clientUser;
	}
	
	/** 서버가 읽기작업을 위해 사용하는 생성자 함수 */
	public ThreadReceive(Socket socket, String owner, Map<Socket,Thread> sendThreadMap){
		this.socket = socket;
		this.owner = owner;
		this.sendThreadMap = sendThreadMap;
	}
	
	/** 쓰레드 실행 함수 */
	public void run() {
		BufferedReader br = null;
		
		try {
			/** 읽기 객체 생성 */
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "euc-kr"));
			System.out.println("서버 대기 중");
			
			while(true) {
				String readLine = br.readLine();
				if(readLine == null) break;
				System.out.println(owner+"\t:->"+readLine);
				
				/** 서버의 경우 자신을 제외한 모든 클라이언트에게 전송 */
				if("server".equals(owner)) {
					if(sendThreadMap != null) {
						
						/** sendThreadMap에 담겨있는 모든 소켓에 쓰기 작업 */
						Set<Socket> keySet = sendThreadMap.keySet();
						for(Socket s: keySet) {
							if(s != socket && s.isClosed() == false) {
								ThreadSend thread = (ThreadSend)sendThreadMap.get(s);
								thread.sendMessage(readLine);
							}
						}
					}
				}
				/** 클라이언트의 경우 자신의 UI 창에 쓰기 작업을 한다. */
				else {
					System.out.println("들어옴" + readLine);
					if(clientUser != null)
						clientUser.writeMessage(readLine);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/** 종료작업 */
		try {
			if (br!=null) br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
