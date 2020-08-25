package ch08.method.arraylist.main1;

import java.util.ArrayList;

/** 요약
 * 
 * @author sckim007@gmail.com
 *
 * ArrayList에 자료 추가 및 출력
 */

public class TestMain1 {

	public static void main(String[] args) {
		/** ArrayList 객체 생성 */
		ArrayList list = new ArrayList();
		
		/** 자료추가 */
		list.add("1");
		list.add(2);
		System.out.println(list);
		
		/** for 문을 이용한 개별 자료접근 */
		for (int i=0;i<list.size();i++) {
			Object obj = list.get(i);
			System.out.println(obj);
			if (obj != null) {
				System.out.println(obj.getClass());
			}
		}
		
		/** 결과
		 * 	[1, 2]
		 *  1
		 *  class java.lang.String
		 *  2
		 *  class java.lang.Integer
		 */
	}

}
