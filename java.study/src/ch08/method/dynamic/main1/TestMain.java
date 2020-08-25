package ch08.method.dynamic.main1;

/** 요약
 * 
 * @author sckim007@gmail.com
 *
 * 문자열 열거를 이용한 동적 파라미터의 이용 연습
 * 문자열 배열을 이용한 함수의 이용
 */
public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		B b = new B();
		
		/** 열거를 이용한 동적 파라미터의 이용 */
		System.out.println("<with Dynamic parameter>");
		a.print("aaa", "bbb", "ccc", "ddd", "eee");
		
		/** 배열을 이용한 함수의 이용 */
		System.out.println("<with Array parameter>");
		String[] array = {"aaa", "bbb", "ccc", "ddd", "eee"};
		a.print(array);
		b.print(array);
	}

}
