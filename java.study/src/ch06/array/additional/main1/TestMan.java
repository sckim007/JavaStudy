package ch06.array.additional.main1;

import java.util.Arrays;

public class TestMan {

	public static void main(String[] args) {
		/** �迭��ü �����ϱ� */
		int[] arr1 = new int[] {1,5,2,3,4};
		
		/** �迭�����ϱ� */
		int[] arr2 = new int[5];
		/** System.arraycopy(src, srcPos, dest, destPos, length); */
		System.arraycopy(arr1, 1, arr2, 0, 2);
				
		/** for ���� �̿��Ͽ� ����� �迭 ��ȸ */
		System.out.println("----- �ε����� �̿��� for �� -----");
		for (int i=0;i<arr2.length;i++) {
			System.out.println(i + "th = " + arr2[i]);
		}
			
		/** ���� for ���� �̿��Ͽ� ����� �迭 ��ȸ */
		System.out.println("----- ���� for �� -----");
		int pos = 0;
		for (int a : arr2) {
			System.out.println(pos++ + "th =" + a);
		}
		
		/** Arrays.toString()�� �̿��Ͽ� �迭 ��ȸ �ϱ� */
		System.out.println("----- Arrays.toString -----");
		String toString = Arrays.toString(arr2);
		System.out.println (toString);
		
		/** Arrays.sort()�� �̿��Ͽ� �迭 �����ϱ� */
		Arrays.sort(arr1);

		/** Arrays.toString�� �̿��Ͽ� ���ĵ� �迭 ��ȸ�ϱ� */
		System.out.println("----- Arrays.toString after sort-----");
		String toString1 = Arrays.toString(arr1);
		System.out.println (toString1);
		
		/** ���ڿ� �迭�� ���� sort �� toString Ȯ�� */
		String[] strArr = {"aaa","ccc", "bbb"};
		Arrays.sort(strArr);
		String toStrArr = Arrays.toString(strArr);
		System.out.println (toStrArr);
	}
}
