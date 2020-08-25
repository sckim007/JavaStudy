package ch06.array.practice.main3;

public class ArrayUtil {
	
	/**
	 * �迪(array)�� ������ �ڷḦ �����ϱ� ���� �Լ�
	 * @param array
	 * @param value
	 * @return
	 */
	public static int[] add(int[] array, int value) {
		/** NullPointerExecption�� ����ó�� - �����迭 �״�� ��ȯ */
		if (array == null) return array;
		
		int[] array2 = new int[array.length + 1];
		System.arraycopy(array, 0, array2, 0, array.length);
		array2[array2.length - 1] = value;
		return array2;
	}
	
	/**
	 * �迪(array)�� �ε���(index)�� �ڷḦ �߰� �����ϱ� ���� �Լ�
	 * @param array
	 * @param index
	 * @param value
	 * @return
	 */
	public static int[] add(int[] array, int index, int value) {
		/** NullPointerExecption�� ����ó�� - �����迭 �״�� ��ȯ */
		if (array == null) return array;

		/** ArrayIndexOutOfBoundsException ����ó�� - �����迭 �״�� ��ȯ */
		if (index < 0 || index > array.length) return array;
		
		int[] array2 = new int[array.length + 1];
		int row = 0; /* ������ array�� �μ� */
		for (int i=0;i<array2.length;i++) {
			if (i == index) {
				array2[i] = value;
			} else {
				array2[i] = array[row]; /* array�� �ε��� row�� ������Ű�鼭 ���� */
				row++;
			}
		}
		return array2;
	}
	
	/**
	 * �迪(array)�� �ε���(index)�� �ڷḦ �����ϱ� ���� �Լ�
	 * @param array
	 * @param index
	 * @return
	 */
	public static int[] remove(int[] array, int index) {

		/** NullPointerExecption�� ����ó�� - �����迭 �״�� ��ȯ */
		if (array == null) return array;

		/** ArrayIndexOutOfBoundsException ����ó�� - �����迭 �״�� ��ȯ */
		if (index < 0 || index > array.length) return array;
		
		int[] array2 = new int[array.length -1];
		int row = 0; /** ������ array�� �ε��� */
		for (int i=0;i<array.length;i++) {
			if (i != index) {
				array2[row] = array[i]; /** array�� �ε��� row�� ������Ű�鼭 ���� */
				row ++;
			}
		}
		return array2;
	}
}
