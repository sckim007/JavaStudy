package ch08.method.dynamic.main1;

public class A {
	/** �����Ķ���� ��� */
	public void print(String ... msg) {
		
		if(msg == null) return;
		
		String[] message = msg;
		for(String s : message) {
			System.out.println(s);
		}
	}
}
