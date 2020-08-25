package ch08.method.arraylist.main2;

import java.util.ArrayList;

/** ���
 * 
 * @author sckim007@gmail.com
 *
 * ArrayList<String> Ÿ�԰�ü�� �̿��� ���ڿ� �߰� �Լ�  �� 
 * ArrayList<T> Ÿ�԰�ü�� �̿��� ���ڿ� �߰� �Լ� (���׸���) ���� Ŭ������ �̿��� �� �߰� �� ��� ����
 */

public class TestMain {

	public static void main(String[] args) {
		/** 1. public static void add(ArrayList<String> list, String... strings) �Լ���� */
		/** ��ü���� */
		ArrayList<String> list1 = new ArrayList<String>();
		
		/** �ڷ��߰� */
		list1.add("a");
		list1.add("b");
		System.out.println(list1);
		
		/** ����� �̿��� �ڷ��߰� */
		ArrayListUtil.add(list1, "c", "d", "e", "f");
		System.out.println(list1);
		
		/** 2. public static <T> void add(ArrayList<T> list, T... strings) �Լ���� */
		/** ��ü���� */
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		/** �ڷ��߰� */
		list2.add(1);
		list2.add(2);
		System.out.println(list2);
		
		/** ����� �̿��� �ڷ��߰� */
		ArrayListUtil.add(list2, 3, 4, 5, 6);
		System.out.println(list2);
		
		/* ��� 
		[a, b]
				 <<< add(ArrayList<String> list, String... strings) ���� >>>
		[a, b, c, d, e, f]
		[1, 2]
				 <<< add(ArrayList<T> list, T... strings) ���� >>>
		[1, 2, 3, 4, 5, 6]
		*/

	}

}
