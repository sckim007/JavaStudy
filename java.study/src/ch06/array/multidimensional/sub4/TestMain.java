package ch06.array.multidimensional.sub4;

public class TestMain {

	public static void main(String[] args) {
		/** 2���� �迭 ���� */
		String[][] array = {{"a001", "�輱ö", "010-1111-1111"},
							{"a002", "��̱�", "010-2222-2222"},
							{"a003", "������", "010-3333-3333"},
							{"a003", "�����", "010-4444-4444"}};
		
		/** �ε����� �̿��� for������ �����ϱ� */
		for (int i = 0;i<array.length;i++) {
			for (int j = 0;j<array[i].length;j++) {
				String data = array[i][j];
				System.out.println("arr[" + i + "[]" + j + "] = " + data);
			}
		}
		
		/** ���� for������ ��ȸ */
		System.out.println("���� for ������ ��ȸ�ϱ�");
		for (String[] array1 : array) {
			for (String s : array1) {
				System.out.println("arr �ڷ����� = " + s);
			}
		}
	}
}
