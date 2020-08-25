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
		/** 서버소켓 구동 */
		ServerSocket server = new ServerSocket(80);
		System.out.println();
		try {
			while(true) {
				/** 클라이언트 요청이 올때가지 대기 */
				Socket socket = server.accept();
				System.out.println("<< Connect Data Socket >>");
				try {
					BufferedReader readRequest = 
							new BufferedReader(new InputStreamReader(socket.getInputStream()));
					
					String request = "";
					while (true) {
						String readLine = readRequest.readLine();
						if (readLine == null || readLine.equals("")) {break;}
						/** 클라이언트 요청저보 콘솔화면에 나타내기 */
						System.out.println(readLine);
						/** GET으로 시작할 때 request에 담기 - 클라이언트 요청 URI */
						if(readLine.startsWith("GET")) { request = readLine; }
					}
					
					/** 응답자료 전송하기 위한 송신 작업 */
					DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
					
					/** 본문구성 
					 *  - 본문의 바이트 길이를 헤더에 보내기 위해 우선 구성한다.
					 */
					String msg = "<html><body>";
					msg += "<span style='font-size:30pt;color:red;font-weight:bold;'>";
					msg += "HTTP 서비스";
					msg += "</span>";
					msg += "<br><br><span style='font-weight:bold;font-size:15pt'>";
					Date date = new Date(System.currentTimeMillis());
					msg += date.toString();
					msg += "<br><br>요청내용=" + request;
					msg += "</span>";
					
					/** 본문을 바이트 배열로 구성 */
					byte[] body = msg.getBytes("UTF-8");
										
					/** 응답헤더 쓰기 - 마지막에는 반드시 \r\n\r\n 으로 입력 */
					dos.writeBytes("HTTP/1.1 200 OK \r\n");
					dos.writeBytes("Server:MyServerName\r\n");
					dos.writeBytes("Cache-Control:private\r\n");
					dos.writeBytes("Content-Length:" + body.length + "\r\n");
					dos.writeBytes("Content-Type: text/html;charset=utf-8\r\n");
					dos.writeBytes("\r\n");
					
					/** 본문 쓰기 */
					dos.write(body,0,body.length);
					
					/** flush()를 이용하여 자료 강제송신 */
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
