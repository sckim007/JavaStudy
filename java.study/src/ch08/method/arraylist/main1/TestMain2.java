package ch08.method.arraylist.main1;

import java.util.ArrayList;

/** 요약
 * 
 * @author sckim007@gmail.com
 *
 * 타입을 지정한 ArrayList에 자료 추가 및 출력
 */

public class TestMain2 {

	public static void main(String[] args) {
		/** ArrayList 객체 생성 */
		ArrayList<String> list = new ArrayList<String>();
		
		/** 자료추가 */
		list.add("a");
		list.add("b");
		System.out.println(list);
		
		/** 향상된 for 문을 이용한 개별 자료접근 */
		for (String s : list) {
				System.out.println(s);
		}
		
		/** 결과
		 * 	[a, b]
		 * 	a
		 * 	b
		 */

	}

}
