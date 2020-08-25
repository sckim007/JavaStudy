package ch07.classes.generics.main5.sub3;

public class ProductVo {
	/** 속성 정의 */
	private String productNo;
	private String productName;
	private int price;
	
	/** 생성자 함수 정의 */
	public ProductVo(String productNo, String productName, int price) {
		this.productNo = productNo;
		this.productName = productName;
		this.price = price;
	}
	/** 자료의 정보를 반환하는 함수 정의 */
	public Object[] getData() {
		return new Object[] {productNo, productName, price};
	}
	
	/** 테이블의 헤더정보를 반환하는 함수 정의 */
	public static String[] getHeaderInfo() {
		return new String[] {"품목번호", "품목명", "단가"};
	}
}

