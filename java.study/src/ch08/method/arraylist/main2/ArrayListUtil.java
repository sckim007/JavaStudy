package ch08.method.arraylist.main2;

import java.util.ArrayList;

/** 요약
 * 
 * @author sckim007@gmail.com
 *
 * ArrayList<String> 타입객체를 이용한 문자열 추가 함수 구현 클래스
 * ArrayList<T> 타입객체를 이용한 문자열 추가 함수 (제네릭스) 구현 클래스
 */

public class ArrayListUtil {
	/** String 타입의 자료를 ArrayList에 추가하기 위한 함수 */
	public static void add(ArrayList<String> list, String... strings) {
		System.out.println("\t <<< add(ArrayList<String> list, String... strings) 실행 >>>");
		if (list == null || strings == null)
			return;
		
		for (String s : strings) {
			list.add(s);
		}
	}
	
	/** 제네릭스를 이용하여 특정타입의 자료를 ArrayList에 추가하기 위한 함수 */
	public static <T> void add(ArrayList<T> list, T... strings) {
		System.out.println("\t <<< add(ArrayList<T> list, T... strings) 실행 >>>");
		
		if (list == null || strings == null)
			return;
		
		for (T s : strings) {
			list.add(s);
		}
	}
}
