package ch18.network.http.main2.sub4;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class TestMain {

	public static void main(String[] args) throws Exception {
		
		/** URL 객체 생성 */
		URL url = new URL("https://www.naver.com");
		
		/** openConnection -> URLConnection객체  -> getInputStream()함수사용*/
		URLConnection conn = url.openConnection();
		InputStream is = conn.getInputStream();
	
		/** 네트워크로부터 들어오는 자료읽기
		 * - InputStream
		 *   . InputStreamReader: UTF-8 디코딩
		 *   . BufferedReader : readLine() 함수를 이용하기 위함
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
