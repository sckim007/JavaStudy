package ch08.method.basicandreference;

/** ���
 * 
 * @author sckim007@gmail.com
 *
 * �⺻�� ������ ��� CallByValue Ư���� ���� ������ ������ �ʴ� ������ ����
 */
public class TestMain1 {

	/** static method() �Լ� ���� */
	public static int method(int count) {
		/** ���� ���� */
		return count++;
	}
	
	public static void main(String[] args) {
		/** count ���� ���� */
		int count = 0;
		System.out.println("count=" + count);
		
		/** count�� �Ķ���� �����Ͽ� �Լ� ���ο��� ���� ���� */
		method(count);
		System.out.println("count=" + count);
		
		/** ���
		 * count=0
		 * count=0
		 */
	}
}
