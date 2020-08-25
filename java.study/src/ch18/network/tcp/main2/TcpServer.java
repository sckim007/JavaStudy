package ch18.network.tcp.main2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TcpServer {

	static ServerSocket socket;
	
	public static void main(String[] args) {
		
		/** TcpServer ��ü���� �� doServer() �Լ� ���� */
		new TcpServer().doServer();
	}
	
	public void doServer() {
		try {
			/** �������� ��ü ���� */
			socket = new ServerSocket(12225);
			
			System.out.println("��������");
			System.out.println("---------------------------");
			System.out.println(socket.getLocalSocketAddress());
			System.out.println(socket.getInetAddress());
			System.out.println(socket.getLocalPort());
			System.out.println("---------------------------");
			
			while (true) {
				/** ���ѷ����� �̿��� ������ */
				final Socket accept = socket.accept();
				
				/** Ŭ���̾�Ʈ �������� ��ȸ */
				synchronized(accept) {
					InetAddress inetAddress = accept.getInetAddress();
					System.out.println("Ŭ���̾�Ʈ ���� --------------------");
					System.out.println("getHostAddress="+inetAddress.getHostAddress());
					System.out.println("getHostName="+inetAddress.getHostName());
					//System.out.println("getLocalHost="+inetAddress.getLocalHost());
				}
				
				/** ����� ���� InputStream, OutputStream ��ü ������ */
				InputStream is = accept.getInputStream();
				OutputStream os = accept.getOutputStream();
				
				/** ���� �����۾� ������ �и� �� ���� */
				new Thread() {
					public void run() {
						/** InputStream -> InputStreamReader -> BufferedReader ��ü ���� */
						BufferedReader br = new BufferedReader(new InputStreamReader(is));
						
						try {
							while(true) {
								/** Ŭ���̾�Ʈ�� �۽��� �ڷḦ �����Ѵ� */
								String readLine = br.readLine();
								if(readLine==null) break;
								System.out.println("[����ȭ��]"+readLine);
							}
						}catch(IOException e) {
							e.printStackTrace();
							/** ���ſ��� �߻� �� Ŭ���̾�Ʈ ��� �������� */
							try {
								accept.close();
							} catch(IOException e1) {
								e1.printStackTrace();
							}
						}
					}
				}.start();
				
				/** ���� �۽��۾� ������ �и� �� ���� */
				new Thread() {
					public void run() {
						/** OutputStream -> OutputStreamWriter -> BufferedWriter ��ü ���� */
						BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
						
						try {
							/** 3�ʸ��� �ð� ���� ���� ** �ݵ�� ������ \r\n�� ���� �� */
							while(true) {
								try {
									Thread.sleep(3000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								
								Date date = new Date(System.currentTimeMillis());
								/** Ŭ���̾�Ʈ�� �ڷḦ �۽��Ѵ�. */
								bw.write("[1] S -> C : " + date + "\r\n");
								bw.flush();
							}
						} catch (IOException e) {
							e.printStackTrace();
							
							/** �۽ſ��� �߻��� Ŭ���̾�Ʈ ��� �������� */
							try {
								accept.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
				}.start();
			}
		} catch(IOException e) {
			e.printStackTrace();
			try  {
			socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
