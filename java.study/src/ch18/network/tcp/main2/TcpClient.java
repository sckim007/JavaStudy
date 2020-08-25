package ch18.network.tcp.main2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.util.Date;

public class TcpClient {

	public static void main(String[] args) {
		new TcpClient().doClient();
	}
	
	public void doClient() {
		try {
			/** Ŭ���̾�Ʈ ���� ���� */
			Socket socket = new Socket("localhost", 12225);
			
			/** ����� ���� InputStream, OuputStream ��ü ������ */
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			/** Ŭ���̾�Ʈ �����۾� ������ �и� �� ���� */
			new Thread() {
				public void run() {
					/** InputStream -> InputStreamReader -> BufferedReader ��ü ���� */
					BufferedReader br = new BufferedReader(new InputStreamReader(is));
					try {
						while(true) {
							/** ������ �۽��� �ڷḦ �����Ѵ�. */
							String readLine = br.readLine();
							if (readLine==null) break;
							System.out.println("[Ŭ���̾�Ʈȭ��]" + readLine);
						}
					} catch (IOException e) {
						e.printStackTrace();
						try {
							socket.close();
						} catch (IOException e1){
							e1.printStackTrace();
						}
					}
				}
			}.start();
			
			/** Ŭ���̾�Ʈ �۽��۾� ������ �и� �� ���� */
			new Thread() {
				public void run() {
					/** OutputStream -> OutputStreamWriter -> BufferedWriter */
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
					try {
						/** 3�ʸ��� �ð� ���� ���� ** �ݵ�� ���� �� "\r\n"�� ���� �� */
						while (true) {
							try {
								Thread.sleep(3000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							
							Date date = new Date(System.currentTimeMillis());
							/** ������ �ڷḦ �۽��Ѵ�. */
							bw.write("[2] C->S:" + date + "\r\n");
							bw.flush();
						}
					} catch (IOException e) {
						e.printStackTrace();
						/** �۽ſ��� �߻� �� Ŭ���̾�Ʈ ��� ���� ���� */
						try {
							socket.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}.start();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
