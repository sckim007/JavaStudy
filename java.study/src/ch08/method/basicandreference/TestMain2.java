package ch08.method.basicandreference;

/** ���
 * 
 * @author sckim007@gmail.com
 *
 * ���������� ��ü�� ����ϴ� ��� ���� ������ �� ����
 */
public class TestMain2 {

	/** static method() �Լ� ���� */
	public static void method(TypeA a) {
		/** a�� �Ӽ����� ���� */
		a.setCount(a.getCount()+1);
	}
	
	public static void main(String[] args) {
		/** TypeA ��ü ���� */
		TypeA a =new TypeA();
		System.out.println("count=" + a.getCount());
		
		/** count�� �Ķ���� �����Ͽ� �Լ� ���ο��� ���� ���� */
		method(a);
		System.out.println("count=" + a.getCount());
		
		/** ���
		 * count=0
		 * count=1
		 */
	}

}
