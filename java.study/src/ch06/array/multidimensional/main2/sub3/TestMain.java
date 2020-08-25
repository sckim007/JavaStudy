package ch06.array.multidimensional.main2.sub3;

public class TestMain {

	public static void main(String[] args) {
		/** 2���� �迭 ���� */
		System.out.println("----- 2���� : 1��° ��� -----");
		/** ù��° ��� �Ҵ� */
		String[] arr1 = {"�ڷ�00", "�ڷ�01", "�ڷ�02"};
		String[] arr2 = {"�ڷ�10", "�ڷ�11", "�ڷ�12"};
		String[][] array1 = new String[][] {arr1, arr2};
		
		int[] arrInt = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int   total = 0;
		for (int i=0;i < arrInt.length ; i++) {
			total += arrInt[i];
		}
		System.out.println("����  : " + total);	
		
		float ave = total/arrInt.length;
		System.out.println("���  : " + ave);	
		
		double dev = 0;
		for (int val : arrInt) {
			dev += Math.pow((val - ave), 2);
		}
		System.out.println("�л�  : " + dev);	
		
		double sdev = Math.sqrt(dev);
		System.out.println("����  : " + sdev);	
				
		/** �ε����� �̿��� for������ �����ϱ� */
		for (int i = 0;i<array1.length;i++) {
			for (int j = 0;j<array1[i].length;j++) {
				String data = array1[i][j];
				System.out.println("array1["+ i +"]["+ j +"] = " + data);
			}
		}
		
		/** ���� for������ �����ϱ� */
		for (String[] arr : array1) {
			for (String s : arr) {
				System.out.println("arr �ڷ����� = " + s);
			}
		}
		
		/** �ι�° ����� ���� �Ҵ� */
		System.out.println("----- 2���� : 2��° ��� -----");
		String[][] array2 = {arr1, arr2};
		/** ���� for������ �����ϱ� */
		for (String[] arr : array2) {
			for (String s : arr) {
				System.out.println("arr �ڷ����� = " + s);
			}
		}
		/** ����° ����� ���� �Ҵ� : 2���� ������ ���� �� ���߿� ���� ä��� ��� */
		System.out.println("----- 2���� : 3��° ��� -----");
		String[][] array3 = new String[2][3];
		array3[0] = arr1;
		array3[1] = arr2;
		/** ���� for������ �����ϱ� */
		for (String[] arr : array3) {
			for (String s : arr) {
				System.out.println("arr �ڷ����� = " + s);
			}
		}
	}
}
