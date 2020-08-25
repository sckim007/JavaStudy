package ch08.method.basicandreference.main2;

/** ���
 * 
 * @author sckim007@gmail.com
 *
 * method() �Լ��� ���Ͽ� ���� �ִ� ���� a�� ���� ������ �� ���� ����.
 * method() �Լ��� ���Ͽ� ���� �ִ� ��ü typeA1 �ּҸ� ������ �� ������ ����.
 */

public class TestMain {

	public static void main(String[] args) {
		
		/** �⺻�� ���� */
		int a = 3;
		int b = a; /* a�� �����ϴ� ���� b �� ���� */
		
		/** method() �Լ��� ���Ͽ� ���� �ִ� ���� a�� ���� ������ �� ����. */
		int c = method(a);
		System.out.println("���Ϻ��� ��=" + (a==b));
		
		/** ������ ���� */
		TypeA typeA1 = new TypeA();
		TypeA typeA2 = typeA1;
		
		/** method() �Լ��� ���Ͽ� ���� �ִ� ��ü typeA1 �ּҸ� ������ �� ����. */
		TypeA typeA3 = method(typeA1);
		System.out.println("���Ϻ��� ��=" + (typeA1==typeA2));
	}
	
	/** ���� Ŭ���� */
	public static class TypeA{}
	
	/** �⺻�� int Ÿ���� ���� �����ϱ� ���� �Լ� */
	public static int method(int a) {
		a = a+1;
		return a;
	}

	/** TypeA ��ü�� �޾ƿ� ���ο��� ���ο� �޸� �ּҸ� ���� ��ü�� ���� */
	public static TypeA method(TypeA typeA) {
		typeA = new TypeA();
		return typeA;
	}
}
