package ch03.method.accessibilit.main1;

import ch03.method.accessibilit.main1.vo.ProductVo1;

public class TestMain1 {

	public static void main(String[] args) {
		/** ProductVo1 Ÿ���� ��ü ���� */
		ProductVo1 prod1 = new ProductVo1();
		prod1.productNo = "a001";
		//prod1.productName = "�Ƹ޸�ī��";	/** ���ٺҰ��� */
		//prod1.price = 4000;			/** ���ٺҰ��� */
		//prod1.type = 1;				/** ���ٺҰ��� */

		/** ProductVo2 Ÿ���� ��ü ���� */
		ProductVo2 prod2 = new ProductVo2();
		prod2.productNo = "a002";
		prod2.productName = "�Ƹ޸�ī��";
		//prod2.price = 4000;			/** ���ٺҰ��� */
		prod2.type = 1;

	}

}
