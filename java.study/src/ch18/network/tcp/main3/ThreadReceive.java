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
	
	/** Ŭ���̾�Ʈ�� �б� �۾��� ���� ����ϴ� ������ �Լ�
	 *    - clientUser : ����� ���� ������ �ڷḦ ȭ�� UI�� �����۾��ϱ� ���� ��ü 
	 */
	public ThreadReceive(Socket socket, String owner, IClientUser clientUser){
		this.socket = socket;
		this.owner = owner;
		this.clientUser = clientUser;
	}
	
	/** ������ �б��۾��� ���� ����ϴ� ������ �Լ� */
	public ThreadReceive(Socket socket, String owner, Map<Socket,Thread> sendThreadMap){
		this.socket = socket;
		this.owner = owner;
		this.sendThreadMap = sendThreadMap;
	}
	
	/** ������ ���� �Լ� */
	public void run() {
		BufferedReader br = null;
		
		try {
			/** �б� ��ü ���� */
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "euc-kr"));
			System.out.println("���� ��� ��");
			
			while(true) {
				String readLine = br.readLine();
				if(readLine == null) break;
				System.out.println(owner+"\t:->"+readLine);
				
				/** ������ ��� �ڽ��� ������ ��� Ŭ���̾�Ʈ���� ���� */
				if("server".equals(owner)) {
					if(sendThreadMap != null) {
						
						/** sendThreadMap�� ����ִ� ��� ���Ͽ� ���� �۾� */
						Set<Socket> keySet = sendThreadMap.keySet();
						for(Socket s: keySet) {
							if(s != socket && s.isClosed() == false) {
								ThreadSend thread = (ThreadSend)sendThreadMap.get(s);
								thread.sendMessage(readLine);
							}
						}
					}
				}
				/** Ŭ���̾�Ʈ�� ��� �ڽ��� UI â�� ���� �۾��� �Ѵ�. */
				else {
					System.out.println("����" + readLine);
					if(clientUser != null)
						clientUser.writeMessage(readLine);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/** �����۾� */
		try {
			if (br!=null) br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
