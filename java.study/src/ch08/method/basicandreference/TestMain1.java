package ch08.method.basicandreference;

/** 요약
 * 
 * @author sckim007@gmail.com
 *
 * 기본형 변수의 경우 CallByValue 특성에 따라 변수가 변하지 않는 내용을 연습
 */
public class TestMain1 {

	/** static method() 함수 정의 */
	public static int method(int count) {
		/** 값을 증가 */
		return count++;
	}
	
	public static void main(String[] args) {
		/** count 변수 생성 */
		int count = 0;
		System.out.println("count=" + count);
		
		/** count를 파라미터 전달하여 함수 내부에서 값을 증가 */
		method(count);
		System.out.println("count=" + count);
		
		/** 결과
		 * count=0
		 * count=0
		 */
	}
}
