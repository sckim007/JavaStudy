package ch08.method.arraylist.main1;

import java.util.ArrayList;

/** ���
 * 
 * @author sckim007@gmail.com
 *
 * Ÿ���� ������ ArrayList�� �ڷ� �߰� �� ���
 */

public class TestMain2 {

	public static void main(String[] args) {
		/** ArrayList ��ü ���� */
		ArrayList<String> list = new ArrayList<String>();
		
		/** �ڷ��߰� */
		list.add("a");
		list.add("b");
		System.out.println(list);
		
		/** ���� for ���� �̿��� ���� �ڷ����� */
		for (String s : list) {
				System.out.println(s);
		}
		
		/** ���
		 * 	[a, b]
		 * 	a
		 * 	b
		 */

	}

}
