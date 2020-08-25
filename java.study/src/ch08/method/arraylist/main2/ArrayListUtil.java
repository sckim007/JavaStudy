package ch08.method.arraylist.main2;

import java.util.ArrayList;

/** ���
 * 
 * @author sckim007@gmail.com
 *
 * ArrayList<String> Ÿ�԰�ü�� �̿��� ���ڿ� �߰� �Լ� ���� Ŭ����
 * ArrayList<T> Ÿ�԰�ü�� �̿��� ���ڿ� �߰� �Լ� (���׸���) ���� Ŭ����
 */

public class ArrayListUtil {
	/** String Ÿ���� �ڷḦ ArrayList�� �߰��ϱ� ���� �Լ� */
	public static void add(ArrayList<String> list, String... strings) {
		System.out.println("\t <<< add(ArrayList<String> list, String... strings) ���� >>>");
		if (list == null || strings == null)
			return;
		
		for (String s : strings) {
			list.add(s);
		}
	}
	
	/** ���׸����� �̿��Ͽ� Ư��Ÿ���� �ڷḦ ArrayList�� �߰��ϱ� ���� �Լ� */
	public static <T> void add(ArrayList<T> list, T... strings) {
		System.out.println("\t <<< add(ArrayList<T> list, T... strings) ���� >>>");
		
		if (list == null || strings == null)
			return;
		
		for (T s : strings) {
			list.add(s);
		}
	}
}
