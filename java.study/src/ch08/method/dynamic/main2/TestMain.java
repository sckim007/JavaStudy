package ch08.method.dynamic.main2;

/** 요약
 * 
 * @author sckim007@gmail.com
 *
 * 재네릭스 방식으로 문자열 열거와 정수 열거를 이용하여 각각 반환된 벼열을 출력하는 내용 연습
 */
public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		
		/** 입력방법 1 */
		String[] array1 = a.method("aaa", "bbb", "ccc");
		for(String s : array1) {
			System.out.println(s);
		}
		
		/** 입력방법 2 */
		Integer[] array2 = a.method(1,2,3,4);
		for(Integer i : array2) {
			System.out.println(i);
		}
	}

}
