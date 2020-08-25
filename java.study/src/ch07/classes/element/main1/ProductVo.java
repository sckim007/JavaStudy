package ch07.classes.element.main1;

public class ProductVo {
	/** 정적(static)변수 - 객체수를 저장하기 위한 목적으로 정의 */
	private static int count;
	
	/** enum 타입 */
	public enum DataType{
		INSERT, UPDATE, DELETE, NORMAL
	};
	
	/** 전역변수 */
	private String productNo;	/* 품목번호 */
	private String productName;	/* 품목명 */
	private int price;
	
	/** 전역변수 - 자료구분: 기본값으로 NORMAL로 설정함 */
	private DataType dataType = DataType.NORMAL;
	
	/** 정적(static) 초기화 구간 */
	static {
		System.out.println("ProductVo - 정적 초기화 구간 실행");
		System.out.println("ProductVo - count = " + count);
	}
	
	/** 초기화 블록 */
	{
		/** 객체 생성 시 마다 호출이 일어나며 count의 값을 1씩 증가시킴 */
		count++;
		System.out.println("ProductVo - 초기화 구간 실행 count[" + count + "]");
		
		/** count를 이용하여 객체 품목번호를 정의함 */
		if (count < 10) {
			productNo = "a00" + count;
		} else if (count < 100) {
			productNo = "a0" + count;
		}  else if (count < 1000) {
			productNo = "a" + count;
		}
		System.out.println("ProductVo - productNo[" + productNo +"]");
	}
	
	/** 생성자 함수 (1)*/
	public ProductVo() {
		System.out.println("ProductNo - 생성자함수(1) 실행");
	}
	
	/** 생성자 함수 (2)*/
	public ProductVo(String productName, int price) {
		this.productName = productName;
		this.price = price;
		System.out.println("ProductNo - 생성자함수(2) 실행");
	}

	/** getter/setter 함수 */
	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	/** toString 함수 */
	public String toString() {
		return productNo + "\t" + productName + "\t" + price;
	}
	
	/** ProductVo의 항목을 String[]로 나타내기 위한 함수 */
	public String[] getData() {
		return new String[] {productNo, productName, Integer.toString(price)};
	}
	
	/** 내부 클래스 - 테이블 항목 정보 */
	public static class TableInfo{
		public static final String[] HEADER_NAME_INFO = new String[] {"품목번호", "품목명", "단가", "상태"};
		/** final static의 제한자는 바꾸어서 사용해도 상관없다 */
		public final static int[] WIDTH_INFO = {100, 400, 100, 80};
	}
}
