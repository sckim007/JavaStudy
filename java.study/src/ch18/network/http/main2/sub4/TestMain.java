package ch18.network.http.main2.sub4;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class TestMain {

	public static void main(String[] args) throws Exception {
		
		/** URL ��ü ���� */
		URL url = new URL("https://www.naver.com");
		
		/** openConnection -> URLConnection��ü  -> getInputStream()�Լ����*/
		URLConnection conn = url.openConnection();
		InputStream is = conn.getInputStream();
	
		/** ��Ʈ��ũ�κ��� ������ �ڷ��б�
		 * - InputStream
		 *   . InputStreamReader: UTF-8 ���ڵ�
		 *   . BufferedReader : readLine() �Լ��� �̿��ϱ� ����
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
		while(true) {
			String readLine = br.readLine();
			if (readLine == null) break;
			System.out.println(readLine);
		}
		br.close();
	}
}
