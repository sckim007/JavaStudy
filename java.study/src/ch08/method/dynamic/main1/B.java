package ch08.method.dynamic.main1;

/** 요약
 * 
 * @author sckim007@gmail.com
 *
 * 문자열 배열을 입력받아 출력하는 함수를 구현한 클랙스
 */
public class B {
	/** 배열파라메터 사용 */
	public void print(String[] msg) {
		
		if(msg == null) return;
		
		for(String s : msg) {
			System.out.println(s);
		}
	}
}
