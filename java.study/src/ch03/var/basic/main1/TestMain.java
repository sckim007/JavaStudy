package ch03.var.basic.main1;

import ch03.var.basic.main1.vo.ProductVo;

public class TestMain {
	public static void main(String[] args) {
		/** �⺻�� ���� ���� */
		int a = 3;
		System.out.println(a);
		
		/** ������ ���� ���� */
		ProductVo product1 = new ProductVo();
		ProductVo product2 = new ProductVo();
		ProductVo product3 = new ProductVo();
		
		product1.productNo = "0001";
		product1.productName = "�Ƹ޸�ī��";
		product1.price = 1000;

		product2.productNo = "0002";
		product2.productName = "ī�����";
		product2.price = 2000;

		product3.productNo = "0003";
		product3.productName = "ī���ī";
		product3.price = 3000;
		
		System.out.println("-----------product1 ����-----------");
		System.out.println("ǰ���ȣ : " + product1.productNo);
		System.out.println("ǰ���̸� : " + product1.productName);
		System.out.println("ǰ�񰡰� : " + product1.price);

		System.out.println("-----------product2 ����-----------");
		System.out.println("ǰ���ȣ : " + product2.productNo);
		System.out.println("ǰ���̸� : " + product2.productName);
		System.out.println("ǰ�񰡰� : " + product2.price);
		
		System.out.println("-----------product3 ����-----------");
		System.out.println("ǰ���ȣ : " + product3.productNo);
		System.out.println("ǰ���̸� : " + product3.productName);
		System.out.println("ǰ�񰡰� : " + product3.price);
	}
}
