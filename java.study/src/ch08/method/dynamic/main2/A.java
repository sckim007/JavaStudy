package ch08.method.dynamic.main2;

/** ���
 * 
 * @author sckim007@gmail.com
 *
 * ��׸��� ����� ��ü�� �Է¹޾� �迭�� �����Ͽ� ��ȯ�ϴ� �Լ��� ������ Ŭ����
 */
public class A {
	
	/** ���� ��ȯ Ÿ���� ���� ���׸��� ��� */
	public <T> T[] method(T... var) {
		
		T[] array = var;
		return array;
	}
}
