package ch08.method.dynamicandgenerics.main1;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		B b = new B();
		
		/** ���Ÿ� �̿��� ���� �Ķ������ �̿� */
		System.out.println("<with Dynamic parameter>");
		a.print("aaa", "bbb", "ccc", "ddd", "eee");
		
		/** �迭�� �̿��� �Լ��� �̿� */
		System.out.println("<with Array parameter>");
		String[] array = {"aaa", "bbb", "ccc", "ddd", "eee"};
		a.print(array);
		b.print(array);
	}

}
