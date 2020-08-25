package ch03.method.accessibilit.main1;

import ch03.method.accessibilit.main1.vo.ProductVo1;

public class TestMain1 {

	public static void main(String[] args) {
		/** ProductVo1 타입의 객체 생성 */
		ProductVo1 prod1 = new ProductVo1();
		prod1.productNo = "a001";
		//prod1.productName = "아메리카노";	/** 접근불가능 */
		//prod1.price = 4000;			/** 접근불가능 */
		//prod1.type = 1;				/** 접근불가능 */

		/** ProductVo2 타입의 객체 생성 */
		ProductVo2 prod2 = new ProductVo2();
		prod2.productNo = "a002";
		prod2.productName = "아메리카노";
		//prod2.price = 4000;			/** 접근불가능 */
		prod2.type = 1;

	}

}
