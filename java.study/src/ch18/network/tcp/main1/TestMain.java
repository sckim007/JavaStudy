package ch18.network.tcp.main1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;

public class TestMain {

	public static void main(String[] args) throws Exception{
		
		System.out.println("<< Server Start >>");
		/** �������� ���� */
		ServerSocket server = new ServerSocket(80);
		System.out.println();
		try {
			while(true) {
				/** Ŭ���̾�Ʈ ��û�� �ö����� ��� */
				Socket socket = server.accept();
				System.out.println("<< Connect Data Socket >>");
				try {
					BufferedReader readRequest = 
							new BufferedReader(new InputStreamReader(socket.getInputStream()));
					
					String request = "";
					while (true) {
						String readLine = readRequest.readLine();
						if (readLine == null || readLine.equals("")) {break;}
						/** Ŭ���̾�Ʈ ��û���� �ܼ�ȭ�鿡 ��Ÿ���� */
						System.out.println(readLine);
						/** GET���� ������ �� request�� ��� - Ŭ���̾�Ʈ ��û URI */
						if(readLine.startsWith("GET")) { request = readLine; }
					}
					
					/** �����ڷ� �����ϱ� ���� �۽� �۾� */
					DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
					
					/** �������� 
					 *  - ������ ����Ʈ ���̸� ����� ������ ���� �켱 �����Ѵ�.
					 */
					String msg = "<html><body>";
					msg += "<span style='font-size:30pt;color:red;font-weight:bold;'>";
					msg += "HTTP ����";
					msg += "</span>";
					msg += "<br><br><span style='font-weight:bold;font-size:15pt'>";
					Date date = new Date(System.currentTimeMillis());
					msg += date.toString();
					msg += "<br><br>��û����=" + request;
					msg += "</span>";
					
					/** ������ ����Ʈ �迭�� ���� */
					byte[] body = msg.getBytes("UTF-8");
										
					/** ������� ���� - ���������� �ݵ�� \r\n\r\n ���� �Է� */
					dos.writeBytes("HTTP/1.1 200 OK \r\n");
					dos.writeBytes("Server:MyServerName\r\n");
					dos.writeBytes("Cache-Control:private\r\n");
					dos.writeBytes("Content-Length:" + body.length + "\r\n");
					dos.writeBytes("Content-Type: text/html;charset=utf-8\r\n");
					dos.writeBytes("\r\n");
					
					/** ���� ���� */
					dos.write(body,0,body.length);
					
					/** flush()�� �̿��Ͽ� �ڷ� �����۽� */
					dos.writeBytes("\r\n");
					dos.flush();
					
				} finally {
					System.out.println("<< Close Data Socket >>");
					socket.close();	
				}
			}
		} finally {
			System.out.println("<< Close Server Socket >>");
			server.close();
		}
	}

}
