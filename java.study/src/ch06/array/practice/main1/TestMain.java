/**
 * ������Ʈ���� ����
 * 0. ������ġ : C:\Users\Admin\Documents\workspace-spring-tool-suite-4-4.7.1.RELEASE\java.study.project\src\ch06\part05\main1
 * 1. �� �� �� : >javac -d . TestMain.java
 * 2. ��     �� : >java ch06.part05.main1.TestMain
 * 3. ��     �� :
 * �ڷ����        [1, 2, 3, 4, 5]
 * �ڷ��߰�        [1, 2, 3, 4, 5, 6]
 * �߰����� 7  [1, 2, 7, 3, 4, 5, 6]
 * �ڷ���� 2 :[1, 7, 3, 4, 5, 6]
 * �ڷ�����        [1, 3, 4, 5, 6, 7]
 */
package ch06.array.practice.main1;

import java.util.Arrays;

public class TestMain {

	public static void main(String[] args) {

		/* ������ �ڷ��߰� */
		int[] array = {1,2,3,4,5};
		int[] array2 = new int[array.length + 1];
		for (int i=0;i<array.length;i++) {
			array2[i] = array[i]; /* ���� �߰� �� array�� �ε����� ���� ������Ų�� */
		}
		
		array2[array2.length -1] = 6;
		System.out.println("�ڷ����\t" + Arrays.toString(array));
		System.out.println("�ڷ��߰�\t" + Arrays.toString(array2));
		
		/** �ڷ� �氣 ���� */
		int[] array3 = new int[array2.length + 1];
		int index = 2;	/* �Է��� �ε��� ��ġ */
		int value = 7;	/* �Է��� �ε����� �Է��� �ڷ� */
		int row = 0;	/* ������ array�� �ε��� */
		for (int i=0;i<array3.length;i++) {
			if (i == index) {
				array3[i] = value;
			} else {
				array3[i] = array2[row]; /* array�� �ε��� row�� ������Ű�鼭 ���� */
				row++;
			}
		}
		System.out.println("�߰����� 7\t" + Arrays.toString(array3));
		
		/** �ε��� 1�� �ڷ���� */
		int[] array4 = new int[array3.length -1];
		int index2 = 1;
		int row2 = 0; /* ������ array�� �ε��� */
		for (int i=0;i<array3.length;i++) {
			if (i != index2) {
				array4[row2] = array3[i]; /* array�� �ε��� row�� ������Ű�鼭 ���� */
				row2++;
			}
		}
		System.out.println("�ڷ���� 2\t:" + Arrays.toString(array4));
		
		/* �迭 �������� ���� */
		Arrays.sort(array4);
		System.out.println("�ڷ����� \t" + Arrays.toString(array4));
	}
}
