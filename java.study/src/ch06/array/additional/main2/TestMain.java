package ch06.array.additional.main2;

import java.util.Arrays;

public class TestMain {

	public static void main(String[] args) {
		/** ������ ��� �迭 */
		int[] array1 = new int[] {11,12,13,14,15};
		
		/** ����� ��� �迭 */
		int[] array2 = new int[] {21,22,23,24,25};
		
		/** array1 �迭�� �ε��� 1���� �����ؼ� array2 �迭�� �ε��� 0���� ���� 3��ŭ ���� */
		System.arraycopy(array1, 1, array2, 0, 3);
		
		String toString = Arrays.toString(array2);
		System.out.println(toString);
	}
	
}
