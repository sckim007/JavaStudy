package ch08.method.dynamic.main2;

/** ���
 * 
 * @author sckim007@gmail.com
 *
 * ��׸��� ������� ���ڿ� ���ſ� ���� ���Ÿ� �̿��Ͽ� ���� ��ȯ�� ������ ����ϴ� ���� ����
 */
public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		
		/** �Է¹�� 1 */
		String[] array1 = a.method("aaa", "bbb", "ccc");
		for(String s : array1) {
			System.out.println(s);
		}
		
		/** �Է¹�� 2 */
		Integer[] array2 = a.method(1,2,3,4);
		for(Integer i : array2) {
			System.out.println(i);
		}
	}

}
