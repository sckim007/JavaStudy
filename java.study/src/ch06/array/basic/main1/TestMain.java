package ch06.array.basic.main1;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/** �迭 ���� �� ��� ��� 1 */
		System.out.println("----- �迭 ���� �� ��� ��� 1 -----");
		String[] array1 = new String[] {"�ڷ�1","�ڷ�2", "�ڷ�3", "�ڷ�4", "�ڷ�5"};
		String data11 = array1[0];	/** �迭 ���� ù ��° ��ҿ� ���� */
		String data12 = array1[1];	/** �迭 ���� �� ��° ��ҿ� ���� */
		String data13 = array1[2];	/** �迭 ���� �� ��° ��ҿ� ���� */
		String data14 = array1[3];	/** �迭 ���� �� ��° ��ҿ� ���� */
		String data15 = array1[4];	/** �迭 ���� �ټ� ��° ��ҿ� ���� */
		if (array1 != null) {
			for (int i = 0;i <array1.length;i++) {
				System.out.println((i+1) + "��° �迭 �� = " + array1[i]);
			}
		}

		/** �迭 ���� �� ��� ��� 2 */
		System.out.println("----- �迭 ���� �� ��� ��� 2 -----");
		String[] array2 = {"�ڷ�1","�ڷ�2", "�ڷ�3", "�ڷ�4", "�ڷ�5"};
		String data21 = array2[0];	/** �迭 ���� ù ��° ��ҿ� ���� */
		String data22 = array2[1];	/** �迭 ���� �� ��° ��ҿ� ���� */
		String data23 = array2[2];	/** �迭 ���� �� ��° ��ҿ� ���� */
		String data24 = array2[3];	/** �迭 ���� �� ��° ��ҿ� ���� */
		String data25 = array2[4];	/** �迭 ���� �ټ� ��° ��ҿ� ���� */
		if (array2 != null) {
			for (int i = 0;i <array2.length;i++) {
				System.out.println((i+1) + "��° �迭 �� = " + array2[i]);
			}
		}

		/** �迭 ���� �� ��� ��� 3 */
		System.out.println("----- �迭 ���� �� ��� ��� 3 -----");
		String[] array3 = new String[5];
		array3[0] = "�ڷ�1";
		array3[1] = "�ڷ�2";
		array3[2] = "�ڷ�3";
		array3[3] = "�ڷ�4";
		array3[4] = "�ڷ�5";
		if (array3 != null) {
			for (int i = 0;i <array3.length;i++) {
				System.out.println((i+1) + "��° �迭 �� = " + array3[i]);
			}
		}
	}

}
