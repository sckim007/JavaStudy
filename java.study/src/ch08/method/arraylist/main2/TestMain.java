package ch08.method.arraylist.main2;

import java.util.ArrayList;

/** 요약
 * 
 * @author sckim007@gmail.com
 *
 * ArrayList<String> 타입객체를 이용한 문자열 추가 함수  및 
 * ArrayList<T> 타입객체를 이용한 문자열 추가 함수 (제네릭스) 구현 클래스를 이용한 값 추가 및 출력 연습
 */

public class TestMain {

	public static void main(String[] args) {
		/** 1. public static void add(ArrayList<String> list, String... strings) 함수사용 */
		/** 객체생성 */
		ArrayList<String> list1 = new ArrayList<String>();
		
		/** 자료추가 */
		list1.add("a");
		list1.add("b");
		System.out.println(list1);
		
		/** 모듈을 이용한 자료추가 */
		ArrayListUtil.add(list1, "c", "d", "e", "f");
		System.out.println(list1);
		
		/** 2. public static <T> void add(ArrayList<T> list, T... strings) 함수사용 */
		/** 객체생성 */
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		/** 자료추가 */
		list2.add(1);
		list2.add(2);
		System.out.println(list2);
		
		/** 모듈을 이용한 자료추가 */
		ArrayListUtil.add(list2, 3, 4, 5, 6);
		System.out.println(list2);
		
		/* 결과 
		[a, b]
				 <<< add(ArrayList<String> list, String... strings) 실행 >>>
		[a, b, c, d, e, f]
		[1, 2]
				 <<< add(ArrayList<T> list, T... strings) 실행 >>>
		[1, 2, 3, 4, 5, 6]
		*/

	}

}
