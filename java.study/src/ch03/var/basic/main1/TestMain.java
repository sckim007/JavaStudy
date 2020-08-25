package ch03.var.basic.main1;

import ch03.var.basic.main1.vo.ProductVo;

public class TestMain {
	public static void main(String[] args) {
		/** 기본형 변수 생성 */
		int a = 3;
		System.out.println(a);
		
		/** 참조형 변수 생성 */
		ProductVo product1 = new ProductVo();
		ProductVo product2 = new ProductVo();
		ProductVo product3 = new ProductVo();
		
		product1.productNo = "0001";
		product1.productName = "아메리카노";
		product1.price = 1000;

		product2.productNo = "0002";
		product2.productName = "카페라테";
		product2.price = 2000;

		product3.productNo = "0003";
		product3.productName = "카페모카";
		product3.price = 3000;
		
		System.out.println("-----------product1 정보-----------");
		System.out.println("품목번호 : " + product1.productNo);
		System.out.println("품목이름 : " + product1.productName);
		System.out.println("품목가격 : " + product1.price);

		System.out.println("-----------product2 정보-----------");
		System.out.println("품목번호 : " + product2.productNo);
		System.out.println("품목이름 : " + product2.productName);
		System.out.println("품목가격 : " + product2.price);
		
		System.out.println("-----------product3 정보-----------");
		System.out.println("품목번호 : " + product3.productNo);
		System.out.println("품목이름 : " + product3.productName);
		System.out.println("품목가격 : " + product3.price);
	}
}
