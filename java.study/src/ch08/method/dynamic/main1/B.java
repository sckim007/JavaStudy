package ch08.method.dynamic.main1;

/** ���
 * 
 * @author sckim007@gmail.com
 *
 * ���ڿ� �迭�� �Է¹޾� ����ϴ� �Լ��� ������ Ŭ����
 */
public class B {
	/** �迭�Ķ���� ��� */
	public void print(String[] msg) {
		
		if(msg == null) return;
		
		for(String s : msg) {
			System.out.println(s);
		}
	}
}
