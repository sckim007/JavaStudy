package ch07.classes.element.main1;

import java.util.Arrays;

public class TestMain {

	public static void main(String[] args) {
		/** ArrayUtil Ŭ������ �̿��Ͽ� �迭�� �������� CRUD */
		String[] arr1 = {"a","b","c"};
		System.out.println("arr1 ���� -" + Arrays.toString(arr1));

		String[] arr12 = ArrayUtil.add(arr1, "ddd");
		System.out.println("arr12 �߰� -" + Arrays.toString(arr12));
		
		String[] arr13 = ArrayUtil.remove(arr12, 0);
		System.out.println("arr13 ����-" + Arrays.toString(arr13));
		
		/** ���ϰ�ü �����ľ� */
		boolean isSame1 = (arr1 == arr12);
		boolean isSame2 = (arr12 == arr13);
		String msg = "���ϰ�ü���� isSame1["+isSame1+"]"+"isSame2["+isSame2+"]";
		System.out.println(msg);
		
		/** ArrayUtil Ŭ������ �̿��Ͽ� �迭�� �������� CRUD */
		int[] arr2 = {1,2,3};
		System.out.println("arr2 ���� -" + Arrays.toString(arr2));
		
		arr2 = ArrayUtil.add(arr2, 23);
		System.out.println("arr2 �߰� -" + Arrays.toString(arr2));
		
		arr2 = ArrayUtil.remove(arr2, 0);
		System.out.println("arr2 ���� -" + Arrays.toString(arr2));
		System.out.println();
		
		/** ProductVo ��ü ���� */
		ProductVo v1 = new ProductVo("�Ƹ޸�ī��", 3500);
		ProductVo v2 = new ProductVo("ī���", 4000);
		ProductVo[] productList = {v1,v2};
		
		/** ǰ���ڵ� Ȯ�� */
		System.out.println();
		for (ProductVo v : productList) {
			System.out.println("�߰� �� ProductVo:"+v);
		}
		System.out.println();
		
		/** ProductList�� ��ü �߰� */
		ProductVo v3 = new ProductVo("�����ī", 5000);
		System.out.println();
		productList = ArrayUtil.add(productList, v3);
		for (ProductVo v : productList) {
			System.out.println("�߰� �� ProductVo:"+v);
		}
		System.out.println();
		
		/**
		 * ǰ�������� ȭ�鿡 ��Ÿ���� ���� ������ ���� Ÿ�� �迭�� ����
		 * 	1.�׸����� : String[]
		 * 		2. ��ǰ��� : String[][]
		 */
		/** 1. �׸����� --> String[] headerNames ��ȯ */
		String[] headerNames = ProductVo.TableInfo.HEADER_NAME_INFO;
		System.out.println("ProductVo �Ӹ��� - " + Arrays.toString(headerNames));
		
		/** 2. ProductVo[] productList --> String[][] dataList ��ȯ */
		String[][] dataList = new String[productList.length][];
		for (int i=0;i<dataList.length;i++) {
			dataList[i] = productList[i].getData();
		}
		
		/** 3. �ʺ����� --> int[] widthinfo ��ȯ */
		int[] widthinfo = ProductVo.TableInfo.WIDTH_INFO;
		System.out.println("ProductVo �ʺ� - " + Arrays.toString(widthinfo));
	}

}
