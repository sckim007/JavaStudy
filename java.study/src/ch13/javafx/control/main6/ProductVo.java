package ch13.javafx.control.main6;

public class ProductVo {
	/** productNo, productName, price, checkYn, productCode 속성 정의 */
	private String productNo;
	private String productName;
	private int price;
	private boolean checkYn;
	private String productCode;
	
	/** 생성자 함수 */
	public ProductVo(String productNo, String productName, int price, boolean checkYn, String productCode) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.price = price;
		this.checkYn = checkYn;
		this.productCode = productCode;
	}
	
	/** setter getter 함수 */
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
	public boolean isCheckYn() {
		return checkYn;
	}
	public void setCheckYn(boolean checkYn) {
		this.checkYn = checkYn;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
}
