package ch08.method.dynamic.main1;

public class B {
	/** �迭�Ķ���� ��� */
	public void print(String[] msg) {
		
		if(msg == null) return;
		
		for(String s : msg) {
			System.out.println(s);
		}
	}
}
