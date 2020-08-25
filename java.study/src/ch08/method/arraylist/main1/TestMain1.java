package ch08.method.arraylist.main1;

import java.util.ArrayList;

/** ���
 * 
 * @author sckim007@gmail.com
 *
 * ArrayList�� �ڷ� �߰� �� ���
 */

public class TestMain1 {

	public static void main(String[] args) {
		/** ArrayList ��ü ���� */
		ArrayList list = new ArrayList();
		
		/** �ڷ��߰� */
		list.add("1");
		list.add(2);
		System.out.println(list);
		
		/** for ���� �̿��� ���� �ڷ����� */
		for (int i=0;i<list.size();i++) {
			Object obj = list.get(i);
			System.out.println(obj);
			if (obj != null) {
				System.out.println(obj.getClass());
			}
		}
		
		/** ���
		 * 	[1, 2]
		 *  1
		 *  class java.lang.String
		 *  2
		 *  class java.lang.Integer
		 */
	}

}
